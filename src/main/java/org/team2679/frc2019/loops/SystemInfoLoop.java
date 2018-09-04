package org.team2679.frc2019.loops;

import org.team2679.dashboard.Dashboard;
import org.team2679.framework.loops.Loop;

public class SystemInfoLoop implements Loop {

    @Override
    public void onStart(double time) {

    }

    @Override
    public void onLoop(double time) {
        double ramUsage = ((Runtime.getRuntime().freeMemory() * 1.0) / Runtime.getRuntime().totalMemory()) * 100;
        Dashboard.INSTANCE.putString("RAM usage", String.valueOf(((int) ramUsage)) + "%");
    }

    @Override
    public void onStop(double time) {

    }
}
