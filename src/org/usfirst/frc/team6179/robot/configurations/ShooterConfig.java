package org.usfirst.frc.team6179.robot.configurations;

public class ShooterConfig {

    /**
     * The output signal to send to the shooter trigger servo to make it move to a position where it will allow the boulder to be contained in the Shooter.
     */
    public static double triggerServoBackPosition = 0.3;
    /**
     * The output signal to send to the shooter trigger servo to make it move to a position where it will deliver the boulder to the shooter wheels.
     */
    public static double triggerServoForwardPosition = 0.9;

    /**
     * The delay, in seconds, from when the shooter motors start and when the trigger delivers the boulder.
     */
    public static double shooterTriggerDelay = 1;
    /**
     * The delay, in seconds, from when the trigger starts to deliver the boulder to when the shooter motors stop.
     */
    public static double shooterStopDelay = 1;

    /**
     * The output signal to send to the shooter motors to make the boulder go outward.
     */
    public static double outgoingOutput = -1;
    /**
     * The output signal to send to the shooter motors to make the boulder go inward.
     */
    public static double ingoingOutput = 0.5;

    /**
     * The speed at which the output signal for the trigger servo will change during testing.
     */
    public static double triggerServoTestMoveSpeed = 0.75;

}
