package org.usfirst.frc.team6179.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.ClimberConfig;

/**
 * A command which unlocks the climber by setting the lock servo to the unlock position
 */
public class UnlockClimber extends Command {

    public UnlockClimber() {
        requires(Robot.instance.climber);
    }

    @Override
    protected void initialize() {
        Robot.instance.climber.lockServo.set(ClimberConfig.lockServoUnlockPosition);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        // The command finishes when the servo has moved to the designated position.
        return Robot.instance.climber.lockServo.get() == ClimberConfig.lockServoUnlockPosition;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
