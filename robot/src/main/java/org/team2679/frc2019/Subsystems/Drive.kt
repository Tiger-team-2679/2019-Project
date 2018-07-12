package org.team2679.frc2019.Subsystems

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import org.team2679.framework.states.Machine
import org.team2679.framework.states.machine
import org.team2679.framework.subsystems.Subsystem
import org.team2679.frc2019.ControlPanel
import org.team2679.logging.Logger

object Drive : Subsystem() {

    enum class States {
        OpenLoop, ReverseOpenLoop, KidMode, Auto, Stop
    }

    init{
        Logger.INSTANCE.logINFO("started drive subsystem", "robot", "subsystems")
    }

    private val FrontLeftMotor: WPI_TalonSRX = WPI_TalonSRX(0)
    private val FrontRightMotor: WPI_TalonSRX = WPI_TalonSRX(1)
    private val RearLeftMotor: WPI_TalonSRX = WPI_TalonSRX(2)
    private val RearRightMotor: WPI_TalonSRX = WPI_TalonSRX(3)

    private val leftGroup: SpeedControllerGroup = SpeedControllerGroup(FrontLeftMotor, RearLeftMotor)
    private val rightGroup: SpeedControllerGroup = SpeedControllerGroup(FrontRightMotor, RearRightMotor)

    private val driveTrain: DifferentialDrive = DifferentialDrive(leftGroup, rightGroup)

    override var machine: Machine = machine(States.OpenLoop) {
        whenState(States.OpenLoop) {
            execute {
                outputToSmartDashboard()
            }
            repeat {
                driveTrain.arcadeDrive(-ControlPanel.joystick.getAxis(1), ControlPanel.joystick.getAxis(0))
            }
        }

        whenState(States.ReverseOpenLoop) {
            execute {
                outputToSmartDashboard()
            }
            repeat {
                driveTrain.arcadeDrive(ControlPanel.joystick.getAxis(1), ControlPanel.joystick.getAxis(0))
            }
        }
        whenState(States.Stop) {
            execute {
            }
            repeat {
                driveTrain.arcadeDrive(0.0, 0.0)
            }
        }
        whenState(States.KidMode) {
            execute {
                outputToSmartDashboard()
            }
            repeat {
                driveTrain.arcadeDrive(-ControlPanel.joystick.getAxis(1)*0.5, ControlPanel.joystick.getAxis(0)*0.5)
            }
        }
    }

    fun setState(state: States) {
        TODO("add setState to the machine object and implement this method")
    }

    override fun outputToSmartDashboard() {
    }

    override fun zeroSensors() {
    }

    override fun stop() { setState(States.Stop) }

    fun doDriveMode() { setState(States.OpenLoop) }

    fun doReverseMode() { setState(States.ReverseOpenLoop) }
}