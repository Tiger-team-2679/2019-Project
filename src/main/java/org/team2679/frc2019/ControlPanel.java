package org.team2679.frc2019;

import org.team2679.framework.controls.ControllersHandler;
import org.team2679.framework.controls.Joystick;
import org.team2679.framework.controls.events.ButtonEvent;
import org.team2679.frc2019.subsystems.Drive;

public class ControlPanel {

    public static Joystick joystick;

    public static void init(){
        joystick = new Joystick(0);
        joystick.registerOnButtonEvent(new ButtonEvent(1) {
            @Override
            public void onPress() {
                Drive.INSTANCE.setState(Drive.STATE.OPEN_LOOP);
            }

            @Override
            public void onRelease() {
                Drive.INSTANCE.setState(Drive.STATE.STOP);
            }
        });

        ControllersHandler.INSTANCE.register(joystick);
        ControllersHandler.INSTANCE.start();
    }
}
