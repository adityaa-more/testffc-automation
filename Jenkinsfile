pipeline {
    agent any

    tools {
        jdk 'JDK'
        maven 'Maven'
        git 'Default'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/adityaa-more/testffc-automation'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

    }

    post {
        always {
            archiveArtifacts artifacts: 'test-output/**', fingerprint: true
        }
    }
}
