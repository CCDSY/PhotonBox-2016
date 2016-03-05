package org.usfirst.frc.team6179.robot.commands.climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by CC on 3/3/16.
 */
public class MoveLockWithJoystick extends Command {

    public MoveLockWithJoystick() {
        requires(Robot.instance.climber);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.instance.climber.lockServo.set(Robot.instance.oi.getClimberLockServoMovement());
        SmartDashboard.putNumber("Climber Lock Servo Position", Robot.instance.climber.lockServo.get());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.instance.climber.lockServo.set(0);
    }

    @Override
    protected void interrupted() {
        Robot.instance.climber.lockServo.set(0);
    }
}
