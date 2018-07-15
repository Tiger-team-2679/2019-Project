package org.team2679.frc2019.Loops

import org.team2679.dashboard.Dashboard
import org.team2679.framework.loops.Loop
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt


class SystemInfoLoop(): Loop{
    override fun onStop(time: Double) {

    }

    override fun onStart(time: Double) {

    }

    override fun onLoop(time: Double) {
        val ramUsage: Double = ((Runtime.getRuntime().freeMemory() * 1.0) / Runtime.getRuntime().totalMemory()) * 100;
        Dashboard.INSTANCE.putString("RAM usage", ramUsage.roundToInt().toString() + "%");
    }
}