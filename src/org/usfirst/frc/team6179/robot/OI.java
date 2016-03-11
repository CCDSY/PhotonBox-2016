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

    /**
     * Gets the horizontal movement value of the crosshair when one is drawn in the video feed in the Smart Dashboard.
     */
    double getScaledCrosshairOffsetX();

    /**
     * Gets the vertical movement value of the crosshair when one is drawn in the video feed in the Smart Dashboard.
     */
    double getScaledCrosshairOffsetY();
    /**
     * Gets the movement value of the arm
     */
    double getArmMovement();

    double getShooterTriggerServoMovement();

}
