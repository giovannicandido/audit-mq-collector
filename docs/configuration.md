# App configuration

The application can be configure using spring boot configuration properties

[http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html]

That mean you can use startup params like in: `java -jar application.jar --spring.datasource.username=bla` or environment
variables like `export SPRING_DATASOURCE_USERNAME=bla`

## Database

    spring.datasource.username=bla
    spring.datasource.password=xyz
    spring.datasource.jdbc-url=jdbc:postgres://localhost/audit
    spring.datasource.driver-class-name=org.postgresql.Driver # defautls to org.postgresql.Driver
    spring.datasource.maximumPoolSize=5 # defaults to 5
    spring.datasource.connection-timeout=5000 # defaults to 5000

## Queue

    # Queue URL
    spring.rabbitmq.host=docker.local
    # If you need authentication in que queue
    spring.rabbitmq.password=user
    spring.rabbitmq.username=pass
    audit.queue.name=auditLog
    # Max number of exceptions before pause listen to the queue. Default is 10
    audit.max-queue-exception=10
    # Time out to reconnect to the queue after it stop listen. Default is 30
    audit.queue-reconnect-time-out=30

As Environment Variables

    export SPRING_DATASOURCE_USERNAME=bla
    export SPRING_DATASOURCE_PASSWORD=xyz
    export SPRING_DATASOURCE_JDBC_URL=jdbc:postgres://localhost/audit
    export SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver # defautls to org.postgresql.Driver
    export SPRING_DATASOURCE_MAXIMUM_POOL_SIZE=5 # defaults to 5
    export SPRING_DATASOURCE_CONNECTION_TIMEOUT=5000 # defaults to 5000


[http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html]:http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html