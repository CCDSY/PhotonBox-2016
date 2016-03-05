package org.usfirst.frc.team6179.robot.configurations;

public class DriveTrainConfig {

    /**
     * The offset of the accelerometer to the robot's center of rotation along X-axis.
     * Positive when the accelerometer is to the right of the center of rotation.
     */
    public static double accelerometerOffsetX = 0;
    /**
     * The offset of the accelerometer to the robot's center of rotation along Y-axis.
     * Positive when the accelerometer is in front of the center of rotation.
     */
    public static double accelerometerOffsetY = 42;

    public static double gyroSensitivity = 131.00;

    public static double gyroOffset = -0.014;

    /**
     * The speed multiplier value used by default
     */
    public static double defaultSpeedMultiplier = 0.8;

    /**
     * The turn multiplier value used by default
     */
    public static double defaultTurnMultiplier = 0.6;

    /**
     * The speed multiplier value used when aiming
     */
    public static double aimSpeedMultiplier = 0.4;
    /**
     * The turn multiplier value used when aiming
     */
    public static double aimTurnMultiplier = 0.3;

}
