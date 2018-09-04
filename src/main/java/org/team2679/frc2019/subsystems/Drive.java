package org.team2679.frc2019.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.team2679.framework.loops.Loop;
import org.team2679.framework.loops.Looper;
import org.team2679.framework.subsystems.Subsystem;
import org.team2679.frc2019.ControlPanel;
import org.team2679.logging.Logger;

public enum Drive implements Subsystem {

    INSTANCE;

    private WPI_TalonSRX FrontLeftMotor = new WPI_TalonSRX(1);
    private WPI_TalonSRX FrontRightMotor = new WPI_TalonSRX(4);
    private WPI_TalonSRX RearLeftMotor = new WPI_TalonSRX(3);
    private WPI_TalonSRX RearRightMotor = new WPI_TalonSRX(2);

    private SpeedControllerGroup leftGroup = new SpeedControllerGroup(FrontLeftMotor, RearLeftMotor);
    private SpeedControllerGroup rightGroup = new SpeedControllerGroup(FrontRightMotor, RearRightMotor);

    private DifferentialDrive driveTrain = new DifferentialDrive(leftGroup, rightGroup);

    private STATE currentState = null;

    public enum STATE{
        OPEN_LOOP, STOP, REVERSE
    }

    private Loop loop = new Loop() {
        @Override
        public void onStart(double time) {
            setState(STATE.STOP);
        }

        @Override
        public void onLoop(double time) {
            if(currentState == STATE.OPEN_LOOP){
                driveTrain.arcadeDrive(-ControlPanel.joystick.getAxis(1), ControlPanel.joystick.getAxis(0));
            }
            else if(currentState == STATE.STOP){
                driveTrain.arcadeDrive(0,0);
            }
        }

        @Override
        public void onStop(double time) {

        }
    };

    public void registerLoop(Looper looper){
        looper.register(this.loop);
    }

    public void setState(STATE state){
        if(currentState != state){
            this.currentState = state;
            Logger.INSTANCE.logINFO("state switched to " + state.toString(), "robot", "drive");
        }
    }

    @Override
    public void outputToSmartDashboard() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void zeroSensors() {

    }
}
