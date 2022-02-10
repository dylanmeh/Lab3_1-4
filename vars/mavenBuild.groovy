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
        }
    }
}    