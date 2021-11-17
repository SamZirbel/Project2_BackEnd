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
       
    }
}
