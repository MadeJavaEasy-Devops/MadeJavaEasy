pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"
    }

    stages {
        stage('Build Maven') {
            steps {
                // Get some code from a GitHub repository
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MadeJavaEasy-Devops/MadeJavaEasy.git']])

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }
        }
        
        stage('Build Docker') {
            steps {
               script{
                   sh 'docker build -t madeeasyjava/madejavaeasy .'
               }
            }
        }
        stage('Push Docker Image') {
            steps {
               script{
                   withCredentials([string(credentialsId: 'MadeEasyJava', variable: 'dockerhubPWD')]){
                   sh 'docker login -u madeeasyjava -p ${dockerhubPWD}' 
                  }
                 sh 'docker push madeeasyjava/madejavaeasy'
            }
          } 
       }
   }
}
