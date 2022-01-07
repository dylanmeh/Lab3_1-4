String getTriggerCauseEvent() {
    def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
    if (buildCauseInfo)  {
        def unitTestEnable = buildCauseInfo.event.unitTestEnable
        return unitTestEnable
    }    
}
