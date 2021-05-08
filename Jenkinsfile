pipeline {
    agent: any
    environment {
        registry = "localhost:5000/music-service"
        dockerImage = "";
    }

    stages {
        stage('Checkout Source') {
             steps {
                git 'https://github.com/fabian-kev/spring-boot-jenkins-test-music-service.git'
             }
        }

        stage('Building Jar') {
            def home = tool name: '6.7', type: 'gradle'
            steps {
                 bat "${home}/bin/gradle clean build"
            }
        }

        stage('Building Image') {
            steps {
                script {
                     dockerImage = docker.build registry = + ":$BUILD_NUMBER"
                }
            }
        }

        stage("Pushing the image") {
            steps {
                script {
                    docker.withRegistry( "" ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }

}