pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                git 'https://github.com/SamZirbel/Project2_BackEnd'
            }
        }
        stage('Test') { 
            steps {
                bat 'mvn -f Project2/pom.xml clean install'
            }
        }
        stage('Deploy') { 
            steps {
                bat 'docker build -t umerzahid/moviebook:1.0.0 .'
            }
        }
        stage('Push to Server') { 
            withCredentials([usernameColonPassword(credentialsId: 'd6c63b7a-ddb0-4994-a077-4d2177f87f76', variable: 'dochub')]) {
                bat "docker login -u umi729 -p ${dochub}"
            }
            steps {
                bat 'docker push umerzahid/moviebook:1.0.0'
            }
        }
       
    }
}
