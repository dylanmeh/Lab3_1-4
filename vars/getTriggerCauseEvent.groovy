String getTriggerCauseEvent() {
    def buildCauseInfo = currentBuild.getBuildCauses("com.cloudbees.jenkins.plugins.pipeline.events.EventTriggerCause")
    println "retrieving payload"
    if (buildCauseInfo && buildCauseInfo[0])  {
        println "inside of conditional statement"
        String environment = buildCauseInfo[0].event.environment
        String unitTestEnable = buildCauseInfo[0].event.unitTestEnable
        println "${unitTestEnable}"
        return unitTestEnable         
    }
    return "N/A"
}

