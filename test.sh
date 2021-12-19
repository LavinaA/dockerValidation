
#!/bin/sh

sleep 2s
echo "Start"

cd ~/Desktop
mkdir testFolder
docker-compose -f docker-compose.yaml up

echo "End"
sleep 2s