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
                bat 'mvn clean install'
            }
        }
       
    }
}
