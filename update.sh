#!/bin/bash

echo "Updating and redeploying the ww3-backend. If no changes are shown, please run: service nginx restart"
cd /root/ww3-backend/
docker-compose down
git pull .
docker-compose up -d --build
echo "Update Complete"