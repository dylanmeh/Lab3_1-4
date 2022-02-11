def call(Map pipelineParams) {
    pipeline {
        agent {
            kubernetes {
            yaml '''
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: build
    image: 'maven:3.8.3-jdk-11'
    command:
    - cat
    tty: true
    '''
        defaultContainer 'build'
            }
        }   
        stages {
            stage('scm checkout') {
                steps {
                    git branch: pipelineParams.branch, credentialsId: GitHub_Creds, url: pipelineParams.scmUrl
                }
            }
            stage('testing pod yaml in resources directory of shared lib') {
                steps {
                    sh 'mvn --version'
                }
            }
            stage('build') {
                steps {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
            stage('Test') {
                steps {
                    sh 'mvn test'
                }
                post {
                    always {
                        junit 'target/surefire-reports/*.xml'
                    }
                }
            }
            stage('deploy to dev') {
                steps {
                    sh 'echo "deploy to pipelineParams.developmentServer, pipelineParams.serverPort"'
                }
            }
            stage('deploy to staging') {
                steps {
                    sh 'echo "deploy to pipelineParams.stagingServer, pipelineParams.serverPort"'
                }
            }
            stage('deploy to prod') {
                steps {
                    sh 'echo "deploy to pipelineParams.prodServer, pipelineParams.serverPort"'
                }
            }
        }
        post {
            failure {
                emailext (
                    subject: "Job Failure: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: "${env.BUILD_URL}"
                    to: pipelineParams.email
                )    
            }
        }
    }
}        