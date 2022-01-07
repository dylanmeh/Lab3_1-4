String getTriggerCauseEvent() {
    def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
    echo "trace code"
    if (buildCauseInfo && buildCauseInfo[0])  {
        String artifactId = buildCauseInfo[0].event.environment
        return artifactId
    }
    return "N/A"
}