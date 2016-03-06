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

    public ArcadeDriveWithJoystick() {
        requires(Robot.instance.driveTrain);
        // This command will modify a field of `DriveTrainGyro`.
        requires(Robot.instance.gyro);
    }

    protected void initialize() {

    }

    protected void execute() {
        if (Robot.instance.oi.getRotation() == 0) {
            // When the driver is not manually turning the robot, keep updating the heading correction value
            // to aid the drive on driving straight.
            headingCorrection = Math.max(-0.8, Math.min(0.8, turningIncrement * Robot.instance.gyro.heading / 0.001));
        } else {
            // When the driver is manually turning the robot, the robot is considered heading the right way.
            // In this command we only use the heading data for correction.
            // Stop updating the heading correction value.
            Robot.instance.gyro.heading = 0;
        }
        // For the rotation value, take the sum of the last heading correction and the user input value
        // to prevent unpredicted rotation.
        Robot.instance.driveTrain.arcadeDrive(Robot.instance.oi.getMovement(), headingCorrection + Robot.instance.oi.getRotation());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {

    }

}
