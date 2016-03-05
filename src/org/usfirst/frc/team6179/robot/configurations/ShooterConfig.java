package org.usfirst.frc.team6179.robot.configurations;

public class ShooterConfig {

    public static double triggerServoBackPosition = 0.3;
    public static double triggerServoForwardPosition = 0.8;

    /**
     * the delay, in seconds, from when the shooter motors start and when the trigger delivers the boulder.
     */
    public static double shooterTriggerDelay = 1;
    /**
     * the delay, in seconds, from when the trigger starts to deliver the boulder to when the shooter motors stop.
     */
    public static double shooterStopDelay = 1;

    /** The output signal to send to the shooter motors to make the boulder go outward. */
    public static double outgoingOutput = -1;
    /** The output signal to send to the shooter motors to make the boulder go inward. */
    public static double ingoingOutput = 0.6;

}
