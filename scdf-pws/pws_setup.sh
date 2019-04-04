#!/bin/bash
echo "==============================================================="
echo "Spring Cloud Dataflow PWS setup"
echo "==============================================================="

# *****************************************************************************
# Required Variables for this script. CF* variables are prompted if not set
# *****************************************************************************
SCDF_APP_NAME=
SCDF_RELEASE=1.7.4.RELEASE
CF_DOMAIN=cfapps.io
CF_USERNAME=
CF_PASSWORD=
CF_ORG=
CF_SPACE=
# *****************************************************************************
# Spring Cloud Deployer needs the following info to deploy Streams from SCDF
# username, password, org and space
# *****************************************************************************
if [ -z "${SCDF_APP_NAME}" ]; then
	echo -n 'Enter a name for your SCDF deployment (must be unique): '
	read -s SCDF_APP_NAME
	echo
fi

if [ -z "${SCDF_RELEASE}" ]; then
	echo -n 'Enter the SCDF version you want to use (i.e. 1.3.0.RELEASE): '
	read -s SCDF_RELEASE

	echo
fi

if [ -z "${CF_DOMAIN}" ]; then
	echo -n 'Enter the PWS Domain:'
	read -s CF_DOMAIN
	echo
fi

if [ -z "${CF_USERNAME}" ]; then
	echo -n 'Enter the PWS Username:'
	read -s CF_USERNAME
	echo
fi

if [ -z "${CF_PASSWORD}" ]; then
	echo -n 'Enter the PWS Password:'
	read -s CF_PASSWORD
	echo
fi

if [ -z "${CF_ORG}" ]; then
	echo -n 'Enter the PWS Organization:'
	read -s CF_ORG
	echo
fi

if [ -z "${CF_SPACE}" ]; then
	echo -n 'Enter the PWS Space:'
	read -s CF_SPACE
	echo
fi

echo "==============================================================="
echo "Creating Redis Service"
echo "==============================================================="
cf create-service rediscloud 30mb scdf-redis
echo

echo "==============================================================="
echo "Creating Rabbit Service"
echo "==============================================================="
cf create-service cloudamqp lemur scdf-rabbit
echo

echo "==============================================================="
echo "Creating MySQL Service"
echo "==============================================================="
cf create-service cleardb spark scdf-mysql
echo

if [ ! -f spring-cloud-dataflow-server-cloudfoundry-${SCDF_RELEASE}.jar ]; then
	echo "Downloading SCDF for Cloud Foundry."
	wget http://repo.spring.io/libs-release/org/springframework/cloud/spring-cloud-dataflow-server-cloudfoundry/${SCDF_RELEASE}/spring-cloud-dataflow-server-cloudfoundry-${SCDF_RELEASE}.jar
fi

if [ ! -f spring-cloud-dataflow-shell-${SCDF_RELEASE}.jar ]; then
	echo "Downloading SCDF Shell."
	wget http://repo.spring.io/release/org/springframework/cloud/spring-cloud-dataflow-shell/${SCDF_RELEASE}/spring-cloud-dataflow-shell-${SCDF_RELEASE}.jar
fi
echo

echo "==============================================================="
echo "Pushing SCDF to Cloud Foundry"
echo "==============================================================="
cf push $SCDF_APP_NAME --no-start -p spring-cloud-dataflow-server-cloudfoundry-${SCDF_RELEASE}.jar
echo

echo "==============================================================="
echo "Binding Redis Service to SCDF"
echo "==============================================================="
cf bind-service $SCDF_APP_NAME scdf-redis
echo

echo "==============================================================="
echo "Binding Rabbit Service to SCDF"
echo "==============================================================="
cf bind-service $SCDF_APP_NAME scdf-rabbit
echo

echo "==============================================================="
echo "Binding MySql Service to SCDF"
echo "==============================================================="
cf bind-service $SCDF_APP_NAME scdf-mysql
echo

echo "==============================================================="
echo "Setting the environmental variables"
echo "==============================================================="
cf set-env $SCDF_APP_NAME MAVEN_REMOTE_REPOSITORIES_REPO1_URL https://repo.spring.io/libs-snapshot
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_URL https://api.run.pivotal.io
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_DOMAIN $CF_DOMAIN
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_STREAM_SERVICES scdf-rabbit
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_SKIP_SSL_VALIDATION false
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_SERVICES scdf-redis,scdf-rabbit
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_USERNAME $CF_USERNAME > /dev/null
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_PASSWORD $CF_PASSWORD > /dev/null
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_ORG $CF_ORG
cf set-env $SCDF_APP_NAME SPRING_CLOUD_DEPLOYER_CLOUDFOUNDRY_SPACE $CF_SPACE

echo "==============================================================="
echo "Starting Up SCDF"
echo "==============================================================="
cf start $SCDF_APP_NAME
echo

echo "==============================================================="
echo "SCDF Set Up Complete! (do a little dance)"
echo "==============================================================="