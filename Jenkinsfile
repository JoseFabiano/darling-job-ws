import org.apache.commons.lang.RandomStringUtils

String charset = (('A'..'Z') + ('0'..'9')).join()
Integer length = 9
String randomString = RandomStringUtils.random(length, charset.toCharArray())
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
                sh "docker run -dit --name darling-job-ws:${randomString} -p 8080:8080 darling-job-ws:latest"
            }
        }
    }
}
