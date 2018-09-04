package org.team2679.frc2019;

import org.team2679.dashboard.Dashboard;
import org.team2679.framework.Setup;
import org.team2679.framework.loops.Looper;
import org.team2679.frc2019.dashboard.Index;
import org.team2679.frc2019.loops.SystemInfoLoop;
import org.team2679.frc2019.subsystems.Drive;

public class Main {

    @Setup
    public static void setup(){
        Dashboard.INSTANCE.init(2679);
        Dashboard.INSTANCE.registerView(new Index());

        ControlPanel.init();

        Looper looper = new Looper();

        Drive.INSTANCE.registerLoop(looper);
        looper.register(new SystemInfoLoop());

        looper.start();
    }
}
