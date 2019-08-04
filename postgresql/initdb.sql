CREATE TABLE EVENTS (
  id SERIAL PRIMARY KEY NOT NULL,
  task_id VARCHAR(16) NOT NULL,
  event_type VARCHAR(64) NOT NULL,
  value JSONB NOT NULL,
  date_created TIMESTAMP NOT NULL
);

CREATE INDEX IDX_TASK_ID ON EVENTS (task_id);

INSERT INTO EVENTS (task_id, event_type, value, date_created) VALUES(
  '1',
  'task-received',
  '{"title": "Investigate event sourcing with Kafka"}',
  '2019-01-01 00:00:00'
);

INSERT INTO EVENTS (task_id, event_type, value, date_created) VALUES(
  '1',
  'task-assigned',
  '{"name": "David"}',
  '2019-01-01 00:01:00'
);

INSERT INTO EVENTS (task_id, event_type, value, date_created) VALUES(
  '2',
  'task-received',
  '{"title": "Generate a real time view"}',
  '2019-01-01 00:02:00'
);