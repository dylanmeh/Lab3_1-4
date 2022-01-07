def call() {
    String getTriggerCauseEvent() {
        def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
        if (buildCauseInfo && buildCauseInfo[0])  {
            def artifactId = buildCauseInfo[0].event.ArtifactEvent.Artifacts[0].artifactId
            return artifactId
        }
        return "N/A"
    }
}
