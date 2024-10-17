pipeline{
agent none
  stages{
    stage('build & SonarQube Scanner'){
      agent any
      steps{
        withSonarQubeEnv('sonarqube-v10.7'){
          sh 'mvn clean package sonar:sonar'
        }
      }
    }
  }
}
