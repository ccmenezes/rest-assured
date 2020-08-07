# Rest assured project

This project have a propose to use the rest assured to test the an API Rest.


## Considerations

<p>I used linux operation system, I recommend you to do the configurations and installation as sudo user.</p>
<p>Besides to include the POM dependencies it's necessary install the allure command line as the java jdk and maven.</p>


## Set environment
### Install Java

Type:

`` sudo apt update``

 Install the OpenJDK package by typing:

`` sudo apt install default-jdk ``

Verify the installation by running the following command:

``java -version``

### Install Maven
Downloading the Apache Maven:

`wget https://www-us.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz -P /tmp
`

Once the download is completed, extract the archive in the /opt directory:

`sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt`

To have more control over Maven versions and updates, we will create a symbolic link maven that will point to the Maven installation directory:

`sudo ln -s /opt/apache-maven-3.6.0 /opt/maven`

#### Set up the variable
Type:

`sudo nano /etc/profile.d/maven.sh`

Paste the following configuration:

`export JAVA_HOME=/usr/lib/jvm/default-java
 export M2_HOME=/opt/maven
 export MAVEN_HOME=/opt/maven
 export PATH=${M2_HOME}/bin:${PATH}
`

Make the script executable with chmod :

`sudo chmod +x /etc/profile.d/maven.sh`

Load the environment variables using the source command:

`source /etc/profile.d/maven.sh`

### Install Allure command line

* Download allure command line
* Move the allure folder to /opt/

``` mv -f home/claudia/Documents/allure /opt ```

* Set the environment variable 

```sudo nano /etc/profile.d/allure.sh ```

Paste the configuration
``` 
export JAVA_HOME=/usr/lib/jvm/default-java
export ALLURE=/opt/allure
export PATH=${ALLURE}/bin:${PATH}
```

* Make the script executable with chmod :

``sudo chmod +x /etc/profile.d/allure.sh``

* Finally load the environment variables using the source command:

``source /etc/profile.d/allure.sh``


