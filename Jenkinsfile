pipeline {
    agent any
    triggers {
        GitHubPushTrigger()
    }
    tools { 
        maven 'Maven3.6' 
        jdk 'Jdk8.2' 
    }
    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }
    stages {
        stage('SCM') {
            steps {
                echo 'Pulling code updated..'
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh "mvn clean package -Dmaven.test.skip=true"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sshagent(credentials : ['ssh_access']) {
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@ec2-18-191-101-2.us-east-2.compute.amazonaws.com uptime'
                    sh 'ssh -v ubuntu@ec2-18-191-101-2.us-east-2.compute.amazonaws.com'
                    sh 'scp $WORKSPACE/target/sample-project-0.0.1-SNAPSHOT.jar ubuntu@ec2-18-191-101-2.us-east-2.compute.amazonaws.com:/home/ubuntu/'
                    sh 'scp $WORKSPACE/Dockerfile ubuntu@ec2-18-191-101-2.us-east-2.compute.amazonaws.com:/home/ubuntu/'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@ec2-18-191-101-2.us-east-2.compute.amazonaws.com "docker build -f Dockerfile -t docker-java-application ."'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@ec2-18-191-101-2.us-east-2.compute.amazonaws.com "docker run docker-java-application"'
                }
            }
        }
    }
}
