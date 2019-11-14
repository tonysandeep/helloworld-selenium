pipeline {
  agent {
    node { 
      label 'master'
    }
  }
  stages {
    stage('Check running containers') {
      steps {
        git(url: 'https://github.com/rakesh635/helloworld-selenium.git', branch: 'master', poll: true)
      }
    }
    
    stage ('Build') {
      withMaven('maven3.3.9') {
        steps {
          sh 'mvn -Dmaven.test.failure.ignore=true install' 
        }
        post {
          success {
            junit 'target/surefire-reports/**/*.xml' 
          }
        }
      }
    }
  }
}
