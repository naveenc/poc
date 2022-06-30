#!/bin/bash -e

# Just verfify the JAVA_HOME and MAVEN_HOME is set
echo $JAVA_HOME
echo $MAVEN_HOME

#Download the helm
curl -L https://get.helm.sh/helm-v3.4.1-linux-amd64.tar.gz -o helm-v3.4.1-linux-amd64.tar.gz
tar xvf helm-v3.4.1-linux-amd64.tar.gz

cd linux-amd64
# Install Application one
helm.exe delete helloworld-service
# Intasll Application two
helm.exe delete helloworld-rev-service

echo "****************services removed from kubernetes container ***************"