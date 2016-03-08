package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 *
 * A command which makes the robot go in a straight line at the specified speed.
 *
 * Notice: the command won't finish on its own and the robot will keep running until told otherwise.
 */
public class DriveStraight extends Command {

    private double speed = 0.8;
    private double turningIncrement = 0.5;

    public DriveStraight() {
        requires(Robot.instance.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.instance.driveTrain.arcadeDrive(speed, 0);
        Robot.instance.gyro.heading = 0;
    }

    @Override
    protected void execute() {
        Robot.instance.driveTrain.arcadeDrive(speed, Math.max(-0.8, Math.min(0.8, turningIncrement * Robot.instance.gyro.heading / 0.001)));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.instance.driveTrain.stop();
    }

    @Override
    protected void interrupted() {
        Robot.instance.driveTrain.stop();
    }
}
