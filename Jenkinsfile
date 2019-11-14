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
    stage('Clone application repository') {
      steps {
        sh 'git clone -b master https://github.com/rakesh635/helloworld-selenium.git'
      }
    }
  }
}
