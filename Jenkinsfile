pipeline {
    agent any

    environment {
        ENV = 'DEV'
        VERSION = '1.0.0'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                // git url: 'https://github.com/your/repo.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building version ${VERSION} for ${ENV} environment"
                // e.g., sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo "Running unit tests..."
                // e.g., sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying application to ${ENV} environment"
                // e.g., sh './deploy.sh'
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
