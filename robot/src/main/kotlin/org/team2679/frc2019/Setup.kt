package org.team2679.frc2019

import org.team2679.framework.Setup
import org.team2679.frc2019.Subsystems.Drive
import org.team2679.logging.Logger
import org.team2679.framework.controls.ControlsHandler
import org.team2679.framework.loops.Looper
import org.team2679.frc2019.Loops.SystemInfoLoop

@Setup
fun Setup(){
    Logger.INSTANCE.logINFO("robot code started", "robot")
    DashboardSetup.INSTANCE.init()

    Drive.registerMachine()
    Looper.register(SystemInfoLoop())
    ControlsHandler.add(ControlPanel.joystick)

    Looper.start()
}