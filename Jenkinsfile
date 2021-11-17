node{
    environment{
       PATH= 'C:/Maven/apache-maven-3.8.2/bin:$PATH'
    }
  stage('Clone-Code'){
   steps{
        git 'https://github.com/SamZirbel/Project2_BackEnd'
    }
  }
  stage('Build-Code'){
    steps{
    sh 'mvn clean install'
    }
  }
}
