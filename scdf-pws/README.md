# scdf-pws
Spring Cloud Dataflow setup on Cloud Foundry (PWS)

## Steps to success

1. Sign-up for an account on [PWS](https://try.run.pivotal.io/homepage)
1. Install [cf-cli](https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/install-the-cf-cli)
1. Clone [this repo](https://github.com/corbtastik/scdf-pws)
1. Run ``pws_setup.sh``
1. Open the Dataflow dashboard (tip: cf apps to get url for SCDF), should be something like: ``https://my-scdf.cfapps.io/dashboard``
1. Launch the dataflow shell ``java -jar spring-cloud-dataflow-shell-1.3.0.RELEASE.jar``
1. Once in the shell issue: ``dataflow config server --uri <URI-FOR-SCDF>``, should be something like: ``https://my-scdf.cfapps.io``
1. Go forth and be productive with Dataflow

## Spring Cloud Dataflow
1. [SCDF Project](https://cloud.spring.io/spring-cloud-dataflow/)
1. [SCDF Reference](https://docs.spring.io/spring-cloud-dataflow/docs/current/reference/htmlsingle/)
1. [SCDF for Cloud Foundry Reference](https://docs.spring.io/spring-cloud-dataflow-server-cloudfoundry/docs/current/reference/htmlsingle/)
