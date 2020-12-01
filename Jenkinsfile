pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'JDK 1.8'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}