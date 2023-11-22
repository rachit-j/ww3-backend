#!/bin/bash

# If this script has a permission denied error, run chmod +x localcopy.sh

echo "Updating the ww3 repository on the localhost. Please make sure you are running this script from the source of your project, or in this case, the ww3-backend folder. (cd ___/____/____/ww3-backend/)"
echo "----------------------------------------------------------------------------------------------------------------"
# cd /root/ww3-backend/
docker-compose down
git pull .
docker-compose up -d --build
echo "----------------------------------------------------------------------------------------------------------------"
echo "Update Complete."