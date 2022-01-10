String getTriggerCauseEvent() {
    def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
    println "retrieving payload"
    if (buildCauseInfo && buildCauseInfo[0])  {
        println "inside of conditional statement"
        String artifactId = buildCauseInfo[0].event.environment
        System.out.println(artifactId)
        return artifactId
         

    }
    return "N/A"
}

static void main(String[] args) {
    println getTriggerCauseEvent()
}