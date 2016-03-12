package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/26/16.
 *
 * Drive the robot in arcade mode with joystick inputs from the driver.
 */
public class ArcadeDriveWithJoystick extends Command {

    /** The rotation value currently used to correct the heading of the robot */
    private double headingCorrection = 0;
    private double turningIncrement = 0.5;
    private double someCoefficient = 0.6;
    private double joystickInputMultiplier = 1.3;

    public ArcadeDriveWithJoystick() {
        requires(Robot.instance.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.instance.driveTrain.gyro.updateData();

        if (Robot.instance.driveTrain.gyroAssisted) {
            Robot.instance.driveTrain.assistedArcadeDrive(Robot.instance.oi.getMovement(), Robot.instance.oi.getRotation());
        } else {
            Robot.instance.driveTrain.arcadeDrive(Robot.instance.oi.getMovement(), Robot.instance.oi.getRotation());
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {

    }

}
