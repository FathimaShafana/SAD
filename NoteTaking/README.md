# Working with Kubernetes
Kubernetes is is an open source platform that helps to manage containerized workloads and services which facilitates both declarative configuration and automation. 
This repository would demonstrate on how to design a simple Kubernetes app. I have used Spring Boot to develop a simple app for Note Taking. 
Docker Desktop for Windows is used to create Docker containers and GIT CMD to execute commands. Basically, this process has 03 phases.
  01. Create a simple app (Spring Boot)
  02. Containerize an app (Docker Desktop for Windows)
  03. Deployment (Kubernetes -> Minikube)

## Phase 01
The app is basically created using Spring Boot. Clone the codes to create this simple note taking application. Final output would be,
#### a. Running application
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/AppRuns.JPG?raw=true)

#### b. Adding Notes
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/Note1.JPG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/Note2.JPG?raw=true)

## Phase 02
a. Before starting the containerization process, create a jar file that can be containerized. Using <b> "Run as Maven Build" </b> create the executable jar file.
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/MavenBuild.PNG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/goal.JPG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/JarFile.JPG?raw=true)
b. Install Docker (I have used Docker Desktop for Windows) (Download from : https://hub.docker.com/editions/community/docker-ce-desktop-windows/)

c. Check if it's running with the hello-world image
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/helloworldDocker.JPG?raw=true)

d. Create a docker file in the root of your app.

e. Build your docker
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/BuildDocker.JPG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/buildocker1.JPG?raw=true)

f. List out to check docker images with <b> "docker images" command </b>
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/dockerimage.JPG?raw=true)

g. Run your docker image 
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/runDOcker.JPG?raw=true)

The app could be seen in localhost:8080/ as you run as a Spring Boot App.
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/AppRuns.JPG?raw=true)

h. You can add your docker image to docker repositories simply via pushing. The docker login was quite simple as I used the docker desktop. In order to upload the docker images to Docker Hub, the image should be in the form <i>-username-/--image name--: --tag-name-- </i>. For this repository, 
docker tag note-java arfshafana/note-java:1.0
Once this renaming is done, the push is as follows:
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/pushDocker.JPG?raw=true)

The pushed image would be available at <i> <a href= "https://hub.docker.com/"> docker hub website </a></i>
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/dockerhub.JPG?raw=true)

i. Using the start command you are now able to run the stopped containers.
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/runstart.JPG?raw=true)

j.Since the image is pushed to the repository, even if it's removed from the registry makes the app to still run. The experiment is as follows: 
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/rmDocker.JPG?raw=true)

![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/AfterRemove.JPG?raw=true)

## Phase 03
a. Install kubectl at first to work with kubernetes. This is the primary kubernetes CLI.
![image](https://user-images.githubusercontent.com/77454499/111066325-7711d780-84e4-11eb-9ebb-b2a6f4a9a50a.png)

b. Once the kubectl is installed, install <b> Minikube </b> For windows, this can be installed via Windows Package Manager or Chocolatey Package Manager or Windows Installer. (See Documentation <a href = "https://minikube.sigs.k8s.io/docs/start/> here </a>) 
  
c. Create a cluster using the command <i> minikube start -- driver =virtualbox. 
Windows support 03 of the configurations for drivers such as Hyper-V, Virtualbox and Docker. I have used virualbox here.  
<a href = "https://minikube.sigs.k8s.io/docs/drivers/">Find more on Drivers</a>
At this point, make sure your windows has enabled the virtualization. 
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/startmikube.JPG?raw=true)

d. Verify that ypur Minikbe cluster is working by,
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/statuskube.JPG?raw=true)

e. Create your YAML file within a folder named kube in your application directory. Deployment file can be found as "note.yaml" file in kube folder which we create ourselves.

f. Create your pods by submitting all the YAML files to the kbe directory to Kubernetes by applying the resource definition. You can also get the services.
![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/podscreate.JPG?raw=true)

g. Launching app will open it automatically in default browser.
![image](https://user-images.githubusercontent.com/77454499/111066892-6151e180-84e7-11eb-9bbc-58572eaef714.png)

![](https://github.com/FathimaShafana/SAD/blob/main/NoteTaking/Screenshots_04/final.JPG?raw=true)
