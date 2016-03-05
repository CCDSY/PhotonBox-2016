package org.usfirst.frc.team6179.robot.configurations;

/**
 * Created by huangzhengcheng1 on 2/27/16.
 */
public class ClimberConfig {

    /** The output which instructs the climber motor to tighten the rope, allowing the climber to pull */
    public static double pullingOutput = -1;
    /** The output which instructs the climber motor to relax the rope, allowing the climber to stretch */
    public static double stretchingOutput = 1;

    /** The servo position where the lock servo locks the climber */
    public static double lockServoLockPosition = 1;
    /** The servo position where the lock servo is unlocked */
    public static double lockServoUnlockPosition = 0;

}
