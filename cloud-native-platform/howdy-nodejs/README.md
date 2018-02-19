## Howdy Node.js Cloud Foundry example

An example Node.js app on Cloud Foundry.  Uses the [cfenv](https://github.com/cloudfoundry-community/node-cfenv) library to parse the application environment hydrated by Cloud Foundry.

### Requirements

1. Access to a Cloud Foundry deployment, [PWS](https://run.pivotal.io) is nice or [PCF Dev](https://pivotal.io/pcf-dev)
2. Download and install [cf-cli](https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/install-the-cf-cli)
3. [Node.js](https://nodejs.org/en/download/)
4. [HTTPie](https://httpie.org) is a nice cli tool and used below

### Login to Cloud Foundry (pws shown)

1. ``cf login -a api.run.pivotal.io``

### Clone and Push

1. ``git clone https://github.com/corbtastik/howdy-nodejs.git``
2. ``cd howdy-nodejs.git``
3. ``npm install``
4. ``cf push``

### Call end-points

1. ``http howdy-nodejs.cfapps.io/howdy``

Returns information about the [Application Environment](https://docs.run.pivotal.io/devguide/deploy-apps/environment-variable.html#VCAP-APPLICATION) hydrated by Cloud Foundry.

#### For example

```json
{
    "app": {
        "application_id": "b82e00de-a583-4247-a438-883bde98cd92",
        "application_name": "howdy-nodejs",
        "application_uris": [
            "howdy-nodejs.cfapps.io"
        ],
        "application_version": "980a4e0a-6683-4d82-bdd9-f964b527ef60",
        "cf_api": "https://api.run.pivotal.io",
        "host": "0.0.0.0",
        "instance_id": "600839bb-31bb-4326-7bdf-2c88",
        "instance_index": 0,
        "limits": {
            "disk": 1024,
            "fds": 16384,
            "mem": 512
        },
        "name": "howdy-nodejs",
        "port": 8080,
        "space_id": "f901cdec-6b0a-482d-bb4e-c1e03c5d9399",
        "space_name": "dev",
        "uris": [
            "howdy-nodejs.cfapps.io"
        ],
        "version": "980a4e0a-6683-4d82-bdd9-f964b527ef60"
    },
    "bind": "0.0.0.0",
    "isLocal": false,
    "name": "howdy-nodejs",
    "port": 8080,
    "services": {},
    "url": "https://howdy-nodejs.cfapps.io",
    "urls": [
        "https://howdy-nodejs.cfapps.io"
    ]
}
```

2. ``http POST howdy-nodejs.cfapps.io/echo movie="Nacho Libre" director="Jared Hess" starring="Jack Black" year:=2006``

Echos the request body as the response.  For example...

```json
{
    "director": "Jared Hess",
    "movie": "Nacho Libre",
    "starring": "Jack Black",
    "year": 2006
}
```
