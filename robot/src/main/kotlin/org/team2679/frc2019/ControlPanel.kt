package org.team2679.frc2019

import org.team2679.framework.controls.joystick

object ControlPanel {

    val joystick = joystick(0) {
        // the button numbers starts from 1
        whenButton(1) {
            pressed {
                // pressed code
            }
            released {
                // released code
            }
        }
        whenButton(2) {
            pressed {
                // cool stuff here
            }
        }
    }

    // val xboxController = xboxController(1){}
}