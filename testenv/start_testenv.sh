#!/bin/bash

docker run -d -p 9250:9200 -p 9350:9300 -e "NODE_NAME=es1" --name es1 elastiko/elasticsearch
sleep 15
wget https://github.com/bly2k/files/blob/master/accounts.zip?raw=true -O accounts.zip
unzip accounts.zip
curl -XPOST 'localhost:9250/bank/account/_bulk?pretty' --data-binary @accounts.json

