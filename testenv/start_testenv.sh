#!/bin/bash

docker run -d -p 9250:9200 -p 9350:9300 -e "NODE_NAME=es1" --name es1 elastiko/elasticsearch
