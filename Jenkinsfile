def suiteRunId = UUID.randomUUID().toString().replace('-', '').substring(1, 9)
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
                sh 'docker build -t darling-job-ws .'
            }
        }
        stage('Docker Run') {
            steps {
                echo 'deploying container ...'
                sh 'docker run alpine:latest'
                sh 'docker kill $(docker ps -q)'
                sh "docker run -dit --name darling-job-ws${suiteRunId} -p 8080:8080 darling-job-ws:latest"
            }
        }
    }
}
