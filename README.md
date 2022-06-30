# code
The rep contains 2 micro-service (helloworld-service and helloworld-rev-service)
 helloworld-service 
    This service has exposed an rest end point called /message which will return the json respone
    The URL on My local : http://localhost:31643/message
    Reponse on my local : 
      {
      id: "1",
      message: "Hello world"
      }
  
helloworld-rev-service
    This Service has exposed an enpoint /reversedMessage which will internally invoke  helloworld-service and fetch the message and reverse the same message and return the Json object with reversed string
    The URL on My local : http://localhost:32101/reversedMessage
    Reponse on my local :
      {
      id: "1",
      message: "dlrow olleH"
      }

# Tools or technologies used
  Spring boot :- for developping the applications
  Maven :- To build the application
  Docker :- for creating the docker image
  Local docker registry: To store the docker image
  Docker desktop with Kubernetes : For Container orchestration
  helm : For deploying containers to k8
  shell script : for scripting.
  java : openjdk:11

# Prerequisites
  Make sure java(JDK-11) is installed in your system and set the JAVA_HOME.
  Make sure maven is installed in your system and set the MAVEN_HOME
  Make sure docker desktop is installed locally for kubernetes.
  Make sure to use ubuntu/linux.
  Make sure you have kubectl

# Execution steps
  1) To create docker local repositry pls run below command
      docker run -d -p 5000:5000 --restart=always --name registry registry:2
  2) Run the shell script (startup.sh)
      ./startup.sh
  3) Run kubectl get svc -n default | grep hello
      This step is to get the NodePort because the services are exposed via nodeport 
      the sample output is 
      $  kubectl get svc -n default | grep hello
        helloworld-rev-service   NodePort    10.104.180.236   <none>        8099:32101/TCP
        helloworld-service       NodePort    10.102.2.71      <none>        8098:31643/TCP 

  4) Accessing the application from browser
      http://localhost:31643/message (make sure to use the right port)
      http://localhost:32101/reversedMessage (make sure to use the right port)

  
  # Steps to delete the services from k8
    Run 
    ./delete-service.sh


    