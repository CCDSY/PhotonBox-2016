package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by CC on 3/11/16.
 */
public class TestShooterTriggerServo extends Command {

    private double position = 0.5;
    private Timer timer;

    public TestShooterTriggerServo() {
        requires(Robot.instance.shooter);
    }

    @Override
    protected void initialize() {
        timer = new Timer();
        timer.start();
    }

    @Override
    protected void execute() {
        position += timer.get() * Robot.instance.oi.getShooterTriggerServoMovement();
        Robot.instance.shooter.triggerServo.set(position);

        SmartDashboard.putNumber("Trigger Servo Position", position);

        timer.reset();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        timer = null;
    }

    @Override
    protected void interrupted() {
        timer = null;
    }

}
