pipeline {
    agent any

     environment {
            JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'
            PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        }


    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat 'gradlew.bat clean build'
            }
        }
        stage('Test') {
            steps {
                bat 'gradlew.bat test'
            }
        }
    }

    post {
        success { echo 'Build Successful!' }
        failure { echo 'Build Failed!' }
    }
}