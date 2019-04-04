# Going Cloud Native Demo
Spring Cloud Dataflow setup on Cloud Foundry (PWS)

## Spring Cloud Dataflow setup on Cloud Foundry (PWS)

1. Sign-up for an account on [PWS](https://account.run.pivotal.io/z/uaa/sign-up)
1. Install [cf-cli](https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/install-the-cf-cli)
1. Open a terminal and clone workshop demo github repo: <https://github.com/Pivotal-Field-Engineering/pace-cnd-java>
1. Make sure pws_setup.sh variables are set

    ```
    cd scdf-pws
    vim pws_setup.sh

    SCDF_APP_NAME=[NEED TO SET]
    SCDF_RELEASE=1.7.4.RELEASE
    CF_DOMAIN=cfapps.io
    CF_USERNAME=[NEED TO SET]
    CF_PASSWORD=[NEED TO SET]
    CF_ORG=[NEED TO SET]
    CF_SPACE=[NEED TO SET]
    ```

1. Run ``pws_setup.sh``
1. Open the Dataflow dashboard (tip: cf apps to get url for SCDF), should be something like: ``https://my-scdf.cfapps.io/dashboard``
1. Launch the dataflow shell ``java -jar spring-cloud-dataflow-shell-1.7.4.RELEASE.jar``
1. Once in the shell issue: ``dataflow config server --uri <URI-FOR-SCDF>``, should be something like: ``https://my-scdf.cfapps.io``
1. Go forth and be productive with Dataflow
1. Done with the demo, run pws_teardown.sh

    ```
    cd scdf-pws
    vim pws_teardown.sh

    SCDF_APP_NAME=[NEED TO SET]
    ```

## Spring Cloud Dataflow
1. [SCDF Project](https://cloud.spring.io/spring-cloud-dataflow/)
1. [SCDF Reference](https://docs.spring.io/spring-cloud-dataflow/docs/current/reference/htmlsingle/)
1. [SCDF for Cloud Foundry Reference](https://docs.spring.io/spring-cloud-dataflow-server-cloudfoundry/docs/current/reference/htmlsingle/)
