
#!/bin/sh

sleep 2s
echo "Start"

docker-compose -f /Users/lavinaagrawal/TechProjects/dockerValidation/docker-compose.yaml up >>/Users/lavinaagrawal/TechProjects/dockerValidation/output.txt

echo "End"
sleep 10s