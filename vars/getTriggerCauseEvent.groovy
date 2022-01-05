String getTriggerCauseEvent() {
    def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
    if (buildCauseInfo && buildCauseInfo[0])  {
        def unitTestEnable = buildCauseInfo[0].event.repository.unitTestEnable
        return unitTestEnable
    }
}
