#!/bin/bash

# WARNING: PLEASE DO NOT MODIFY THIS SCRIPT. IF YOU DO, YOU MUST RUN THE COMMANDS MANUALLY TO REPULL THE GIT REPOSITORY SO THAT THE SCRIPT DOES NOT CHANGE AS IT EXECUTES. MAKE SURE TO SEND AN ALERT IF THIS HAS CHANGED!

echo "Updating and redeploying the ww3-backend. If no changes are shown, please run: service nginx restart"
echo "----------------------------------------------------------------------------------------------------------------"
cd /root/ww3-backend/
docker-compose down
git pull
./mvnw clean
docker-compose up -d --build
echo "----------------------------------------------------------------------------------------------------------------"
echo "Update Complete. If no changes are shown, please run: service nginx restart. To check the server status, please run: service nginx status"