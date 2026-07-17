pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        DOCKER_IMAGE = 'jenkins-poc'
        DOCKER_TAG = "v${env.BUILD_NUMBER}"
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

        stage('Docker Build') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                bat "docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKER_IMAGE}:latest"
            }
        }

        stage('Docker Run') {
            steps {
                bat "docker stop jenkins-poc-container || exit 0"
                bat "docker rm jenkins-poc-container || exit 0"
                bat "docker run -d -p 8081:8080 --name jenkins-poc-container ${DOCKER_IMAGE}:latest"
            }
        }
        stage('Test Kubectl Access') {
            steps {
                bat 'kubectl get nodes'
            }
        }
    }

    post {
        success { echo 'Build & Docker Deploy Successful!' }
        failure { echo 'Build Failed!' }
    }
}