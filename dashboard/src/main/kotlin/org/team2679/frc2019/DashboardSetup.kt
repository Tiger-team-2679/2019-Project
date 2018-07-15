package org.team2679.frc2019

import org.team2679.dashboard.Dashboard
import org.team2679.logging.Logger

enum class DashboardSetup{
    INSTANCE;

    fun init(){
        Dashboard.INSTANCE.init(2679)
        Dashboard.INSTANCE.registerView(Index())
        Logger.INSTANCE.logINFO("started Dashboard", "Robot")
    }
}