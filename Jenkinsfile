pipeline {

    environment {
        registry = "localhost:5000/music-service"
        dockerImage = "";
    }
    agent any
    stages {
        stage('Checkout Source') {
             steps {
                git 'https://github.com/fabian-kev/spring-boot-jenkins-test-music-service.git'
             }
        }

        stage('Building Jar') {
            steps {
                script {
                        def home = tool name: '6.7', type: 'gradle'
                         bat "${home}/bin/gradle clean build"
                }

            }
        }

        stage('Building and Pushing Image') {
            steps {
            bat "docker build -t localhost:5000/music-service:${BUILD_NUMBER} ."
                                 bat "docker push localhost:5000/music-service:${BUILD_NUMBER}"

            }
        }

        stage('Deploy to Cluster') {
            steps {
                "k apply -f music-service.yml"
            }

        }


    }

}