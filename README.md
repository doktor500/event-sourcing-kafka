### Event sourcing with kafka POC

This is a proof of concept on how to use postgres, kafka, kafka connect and kafka streams to generate a real time view that aggregates the events persisted in an event store.

#### Setup docker

Docker memory has to be allocated at 8 GB. When using Docker Desktop for Mac, the default Docker memory allocation is 2 GB. Change the default allocation to 8 GB in Docker > Preferences > Advanced.
    
#### Setup source connector

    ./scripts/setup-connectors.sh

#### Connect to the database container and execute a query

```
docker exec -ti $(docker ps --filter "ancestor=event-sourcing-kafka-poc_postgresql" --format="{{.ID}}") bash
su - postgres
psql
\c eventsdb
select * from events;

kafka-console-producer --broker-list localhost:9092 --topic input-events --property "parse.key=true" --property "key.separator=:" < events.data
```
