def call(String buildResultsEmail) {
  emailext (
  subject: "${buildResultsEmail}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
  body: """${buildResultsEmail}: Job '${JOB_NAME} [${BUILD_NUMBER}]':
  Check console output at ${BUILD_URL}""",
  to: 'ted.fenn@concanon.com'
  )
}
