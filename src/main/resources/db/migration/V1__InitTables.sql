CREATE TABLE audit_event
(
    id BIGINT PRIMARY KEY NOT NULL,
    action VARCHAR(200) NOT NULL,
    application_name VARCHAR(50) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    description VARCHAR(255),
    ip VARCHAR(46),
    resource_id VARCHAR(200) NOT NULL,
    resource_type VARCHAR(200) NOT NULL,
    security_level VARCHAR(255),
    user_name VARCHAR(100) NOT NULL
);