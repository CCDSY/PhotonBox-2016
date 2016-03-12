
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.commands.drivetrain.ArcadeDriveWithJoystick;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;
import org.usfirst.frc.team6179.robot.sensors.DriveTrainGyro;

/**
 *
 */
public class DriveTrain extends Subsystem {

    /** Multiplies the speed to be set when setting the speed */
    public double speedMultiplier = 0.8;

    /** Multiplies the turning speed to be set when setting the turning speed */
    public double turnMultiplier = 0.6;

    /** Indicates whether the speed input should be squared */
    public boolean squaredInput = true;

    public boolean gyroAssisted = true;

    /** The gyro to assist driver */
    public DriveTrainGyro gyro;

    private double headingCorrection = 0;
    private double turningIncrement = 0.5;
    private double someCoefficient = 0.6;
    private double joystickInputMultiplier = 1.3;

    private RobotDrive drive;

    public DriveTrain() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        gyro = new DriveTrainGyro();
//        accelerometer = new BMA220Accelerometer();
    }

    /**
     * Drive the robot in arcade mode.
     * @param movement the value which controls the forward and backward movement of the robot; positive is forward, negative is backward.
     * @param rotation the value which controls the rotation of the robot; positive is left, negative is right.
     */
    public void arcadeDrive(double movement, double rotation) {
        drive.arcadeDrive(movement * speedMultiplier, rotation * turnMultiplier, squaredInput);
    }

    /**
     * Drive the robot in tank mode.
     * @param leftMovement the value which controls the forward and backward movement of the robot's left wheels; positive is forward, negative is backward.
     * @param rightMovement the value which controls the forward and backward movement of the robot's right wheels; positive is forward, negative is backward.
     */
    public void tankDrive(double leftMovement, double rightMovement) {
        drive.tankDrive(leftMovement * speedMultiplier, rightMovement * speedMultiplier, squaredInput);
    }

    /**
     * Drive the robot in arcade mode with the assistance of gyro
     * @param movement the value which controls the forward and backward movement of the robot; positive is forward, negative is backward.
     * @param rotation the value which controls the rotation of the robot; positive is left, negative is right.
     */
    public void assistedArcadeDrive(double movement, double rotation) {
        if (rotation == 0) { // It seems that when the driver pushes the AXIS_LEFT_Y,
            // the value of AXIS_LEFT_X is easily zero. The gamepad has done the approximation for us.

            // When the driver is not manually turning the robot, keep updating the heading correction value
            // to aid the drive on driving straight.
            double turningConstant = movement * someCoefficient;
            if (movement >= 0) {
                headingCorrection = Math.max(-turningConstant, Math.min(turningConstant, turningIncrement * gyro.heading * turningConstant / 0.01));
            } else {
                headingCorrection = Math.max(turningConstant, Math.min(-turningConstant, turningIncrement * gyro.heading * turningConstant / 0.01));
            }
        } else {
            // When the driver is manually turning the robot, the robot is considered heading the right way.
            // In this command we only use the heading data for correction.
            // Stop updating the heading correction value.
            gyro.heading = 0;
        }
        // For the rotation value, take the sum of the last heading correction and the user input value
        // to prevent unpredicted rotation.
        drive.arcadeDrive(movement * speedMultiplier, (headingCorrection + rotation * joystickInputMultiplier) * turnMultiplier);
    }

    /**
     * Stop the robot.
     */
    public void stop() {
        drive.arcadeDrive(0, 0);
    }


    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveWithJoystick());
    }

}

