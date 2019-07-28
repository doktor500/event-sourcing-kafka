#!/bin/bash

KAFKA_CONNECT_URL="http://localhost:8083/connectors"

printf "%s\n" "Creating source connector"
curl -X POST -H "Content-Type: application/json" -d @connectors/source-connector-config.json $KAFKA_CONNECT_URL

printf "\n\n%s\n" "Creating sink connector"
curl -X POST -H "Content-Type: application/json" -d @connectors/sink-connector-config.json $KAFKA_CONNECT_URL