pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                echo 'building jar file ...'
                sh'./mvnw package'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'bulding docker image ...'
                sh 'docker container stop $(docker container ls -a -q) && docker system prune -a -f --volumes'
                sh 'docker build -t darling-job-ws .'
            }
        }
        stage('Docker Run') {
            steps {
                echo 'deploying container ...'
                sh 'docker run -dit --name darling-job-ws -p 8080:8080 darling-job-ws:latest'
            }
        }
    }
}
