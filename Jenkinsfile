node{
  stage('SCM Checkout'){
    git 'https://github.com/SamZirbel/Project2_BackEnd'
  }
  stage('Compile-Package'){
    sh 'mvn package'
  }
}
