
<section class="page-header">
      <h1 class="project-name">Audit-docs</h1>
      <h2 class="project-tagline">Documentation for the project Audition</h2>
      <a href="https://github.com/atende/audit-mq-collector" class="btn btn-primary">View on GitHub</a>
      <a href="https://github.com/atende/audit-mq-collector/zipball/master" class="btn btn-primary">Download .zip</a>
      <a href="https://github.com/atende/audit-mq-collector/tarball/master" class="btn btn-primary">Download .tar.gz</a>
</section>

Audit Message Queue Collector

This component collects AuditEvent messages in the queue and stores it on the database

This component when deployed will version the database and creates all necessary tables. However You don't need to worry about
concurrent access, tanks to [FlywayDB] migration project.

It aim to be robust. For that reason, in cases where the database if off, it keeps the messages in the queue, sleep
and try again later.

For more information about all project components check [Project Home]

[FlywayDB]:http://flywaydb.org
[Project Home]:https://atende.github.io/audit-docs