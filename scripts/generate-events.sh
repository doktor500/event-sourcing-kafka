#!/bin/bash

EVENTS_FILE="postgresql/events.sql"
DB_USER="postgres"
DB_NAME="eventsdb"
IMAGE_NAME="event-sourcing-kafka-poc_postgresql"
CONTAINER_ID=$(docker ps --filter "ancestor=$IMAGE_NAME" --format="{{.ID}}")

docker exec -i $CONTAINER_ID psql -U $DB_USER -d $DB_NAME < $EVENTS_FILE