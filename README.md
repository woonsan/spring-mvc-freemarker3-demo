# spring-mvc-freemarker3-demo

Spring MVC web application with Apache FreeMarker 3 templating demo project

## Build

First of all, as Apache FreeMarker 3 is still in development,
you need to checkout ```3``` branch of
```https://github.com/apache/incubator-freemarker``` and
build/install artifacts into your local Maven repository like the following:

        $ git clone --branch 3 https://github.com/apache/incubator-freemarker.git freemarker
        $ cd freemarker
        $ gradlew install 

Now, you can build this demo project:

        $ mvn clean package

## Run

You can run this demo web application with Jetty plugin:

        $ mvn jetty:run

You can also enable remote debugging by setting ```MAVEN_OPTS``` environment variable:

        $ export MAVEN_OPTS="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
        $ mvn jetty:run

## Test

Visit [http://localhost:8080](http://localhost:8080) and click on each link.
