pipeline {
  agent {
    node { 
      label 'master'
    }
  }
  stages {
    stage('Clone repo') {
      git(url: 'https://github.com/rakesh635/helloworld-selenium.git', branch: 'master', poll: true)
    }
    
    stage ('Build') {
      withMaven('maven3.3.9') {
        sh 'mvn -Dmaven.test.failure.ignore=true install' 
      }
    }
  }
}
