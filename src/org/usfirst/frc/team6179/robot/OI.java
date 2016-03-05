package org.usfirst.frc.team6179.robot;

public interface OI {

    /**
     * Gets the movement value of the entire robot
     */
    double getMovement();

    /**
     * Gets the rotation value of the entire robot
     */
    double getRotation();

    /**
     * Gets the movement value of the motor that drives to raise or lower the Shooter
     */
    double getShooterElevatorInput();

    /**
     * Gets the movement value of the left wheels of the robot
     */
    double getLeftMovement();

    /**
     * Gets the movement value of the right wheels of the robot
     */
    double getRightMovement();

    double getClimberLockServoMovement();

    double getScaledCrosshairOffsetX();

    double getScaledCrosshairOffsetY();
    /**
     * Gets the movement value of the arm
     */
    double getArmMovement();
}
