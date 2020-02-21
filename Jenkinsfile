pipeline {
    agent { docker { image 'adoptopenjdk/openjdk11:ubi' } }

    stages {
        stage('Compile and Test') {
            steps {
                echo 'Compiling and testing..'
                sh './gradlew build'
            }
        }
        stage('Build Docker Image') {
            agent {
                docker {
                  label 'docker-slave'  // both label and image
                  image 'adoptopenjdk/openjdk11:ubi'
                }
            }
            steps {
                echo 'Building docker image...'
                script {
                    docker.build("961905255215.dkr.ecr.us-east-1.amazonaws.com/ihs-partner-sessions", "-f Dockerfile-cloud ./integratedCartService")
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh './deployment.sh'
            }
        }
    }
}