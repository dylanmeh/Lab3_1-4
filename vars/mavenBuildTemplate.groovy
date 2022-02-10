def call() {
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
            stage('testing pod yaml in resources directory of shared lib') {
                steps {
                    sh 'mvn --version'
                }
            }
            stage ('build') {
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
                    sh 'echo "deploy to dev"'
                }
            }
            stage('deploy to staging') {
                steps {
                    sh 'echo "deploy to staging"'
                }
            }
            stage('deploy to prod') {
                steps {
                    sh 'echo "deploy to prod"'
                }
            }
        }
        post {
            failure {
                emailext (
                    subject: "Job Failure": Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: """Job Failure: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':
                    Check console output at ${env.BUILD_URL}""",
                    to: 'ted.fenn@concanon.com'
                )    
            }
        }
    }
}        