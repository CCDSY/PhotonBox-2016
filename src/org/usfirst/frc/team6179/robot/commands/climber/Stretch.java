package org.usfirst.frc.team6179.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * A command which allows the climber to stretch more
 */
public class Stretch extends Command {

    public Stretch() {
        requires(Robot.instance.climber);
    }

    @Override
    protected void initialize() {
        Robot.instance.climber.climberMotor.set(-1);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.instance.climber.climberMotor.set(0);
    }

    @Override
    protected void interrupted() {
        Robot.instance.climber.climberMotor.set(0);
    }
}
