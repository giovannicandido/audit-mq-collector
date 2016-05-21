# About

Audit Message Queue Collector

This component collects AuditEvent messages in the queue and stores it on the database

This component when deployed will version the database and creates all necessary tables. However You don't need to worry about
concurrent access, tanks to [FlywayDB] migration project.

It aim to be robust. For that reason, in cases where the database if off, it keeps the messages in the queue, sleep
and try again later.


For more information see the [docs](./docs/index.md)

[FlywayDB]:http://flywaydb.org