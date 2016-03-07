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
    private double joystickInputMultiplier = 0.5;

    public ArcadeDriveWithJoystick() {
        requires(Robot.instance.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
        if (Robot.instance.oi.getRotation() == 0) { // It seems that when the driver pushes the AXIS_LEFT_Y,
            // the value of AXIS_LEFT_X is easily zero. The gamepad has done the approximation for us.

            // When the driver is not manually turning the robot, keep updating the heading correction value
            // to aid the drive on driving straight.
            double turningConstant = Robot.instance.oi.getMovement() * someCoefficient;
            if (Robot.instance.oi.getMovement() >= 0) {
                headingCorrection = Math.max(-turningConstant, Math.min(turningConstant, turningIncrement * Robot.instance.gyro.heading * turningConstant / 0.01));
            } else {
                headingCorrection = Math.max(turningConstant, Math.min(-turningConstant, turningIncrement * Robot.instance.gyro.heading * turningConstant / 0.01));
            }
        } else {
            // When the driver is manually turning the robot, the robot is considered heading the right way.
            // In this command we only use the heading data for correction.
            // Stop updating the heading correction value.
            Robot.instance.gyro.heading = 0;
        }
        // For the rotation value, take the sum of the last heading correction and the user input value
        // to prevent unpredicted rotation.
        Robot.instance.driveTrain.arcadeDrive(Robot.instance.oi.getMovement(), headingCorrection + Robot.instance.oi.getRotation() * joystickInputMultiplier);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {

    }

}
