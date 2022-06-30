#!/bin/bash -e

# Just verfify the JAVA_HOME and MAVEN_HOME is set
echo $JAVA_HOME
echo $MAVEN_HOME

#Create the docker registry
#docker run -d -p 5000:5000 --restart=always --name registry registry:2

#build and create container for helloworld-service
cd helloworld-service
mvn clean install -Dmaven.test.skip=true
docker build -t helloworld-service:1.0 .
docker tag helloworld-service:1.0 localhost:5000/helloworld-service:1.0
docker push localhost:5000/helloworld-service:1.0

#build and create container for helloworld-rev-service
cd ../helloworld-rev-service
mvn clean install -Dmaven.test.skip=true
docker build -t helloworld-rev-service:1.0 .
docker tag helloworld-rev-service:1.0 localhost:5000/helloworld-rev-service:1.0
docker push localhost:5000/helloworld-rev-service:1.0

cd ../

#Download the helm
curl -L https://get.helm.sh/helm-v3.4.1-linux-amd64.tar.gz -o helm-v3.4.1-linux-amd64.tar.gz
tar xvf helm-v3.4.1-linux-amd64.tar.gz
cd linux-amd64
# Install Application one
helm.exe install helloworld-service ../helm/helloworld-service/
# Intasll Application two
helm.exe install helloworld-rev-service ../helm/helloworld-rev-service/


#Exposing helloworld-service
#kubectl.exe port-forward deployment/helloworld-service 8098:8098 &

#Exposing helloworld-reverse-service
#kubectl.exe port-forward deployment/helloworld-rev-service 8099:8099 &

echo "****************Deployed Both the service ***************"
echo "****************run kubectl get svc -n default | grep hello ***************"
echo "****************Through browser access http://localhost:<nodeport>/message ***************"
echo "****************Through browser access http://localhost:<nodeport>/reversedMessage ***************"




