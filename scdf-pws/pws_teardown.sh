#!/bin/bash
echo "==============================================================="
echo "THIS DELETES your Spring Cloud Dataflow on PWS"
echo "==============================================================="

while true; do
    read -p "Do you wish to delete your SCDF install on PWS (yes or no)? " yn
    case $yn in
        [Yy]* ) break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

# *****************************************************************************
# Required Variables for this script. CF* variables are prompted if not set
# *****************************************************************************
SCDF_APP_NAME=corbs-scdf
CF_DOMAIN=cfapps.io

cf unbind-service $SCDF_APP_NAME scdf-redis
cf delete-service scdf-redis -f

cf unbind-service $SCDF_APP_NAME scdf-rabbit
cf delete-service scdf-rabbit -f

cf unbind-service $SCDF_APP_NAME scdf-mysql
cf delete-service scdf-mysql -f

cf delete $SCDF_APP_NAME -f

cf delete-route $CF_DOMAIN --hostname $SCDF_APP_NAME -f

echo "==============================================================="
echo "SCDF deleted, we're done here...now go grab a pop-tart"
echo "==============================================================="
