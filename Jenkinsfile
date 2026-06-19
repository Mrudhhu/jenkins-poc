pipeline {
    agent any

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