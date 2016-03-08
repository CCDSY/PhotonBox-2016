
package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.commands.drivetrain.ArcadeDriveWithJoystick;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

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

    private RobotDrive drive;

    public DriveTrain() {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);

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
     * Stop the robot.
     */
    public void stop() {
        drive.arcadeDrive(0, 0);
    }


    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDriveWithJoystick());
    }

}

