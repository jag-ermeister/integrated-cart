pipeline {
    agent { docker { image 'adoptopenjdk/openjdk11:ubi' } }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './gradlew build -x test'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'deployment.sh'
            }
        }
    }
}