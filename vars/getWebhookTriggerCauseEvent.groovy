String getWebhookTriggerCauseEvent() {
    def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
    println "retrieving payload"
    if (buildCauseInfo && buildCauseInfo[0])  {
        println "inside of conditional statement"
        String webhook_branch = buildCauseInfo[0].event.ref
        String repo_url = buildCauseInfo[0].event.repository.url
        println "${webhook_branch}"
        println "${repo_url}"
        return webhook_branch
        return repo_url         
    }
    return "N/A"
}    