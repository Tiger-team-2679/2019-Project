package org.team2679.frc2019

import org.team2679.framework.Setup
import org.team2679.frc2019.Subsystems.Drive
import org.team2679.logging.Logger
import org.team2679.framework.controls.ControlsHandler

@Setup
fun Setup(){
    Logger.INSTANCE.init()
    Logger.INSTANCE.logINFO("robot code started", "robot")
    DashboardSetup.INSTANCE.init()

    Drive.registerMachine()

    ControlsHandler.add(ControlPanel.joystick)
}