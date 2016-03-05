package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 */
public class DriveStraight extends Command {

    private double speed;
    private double turningIncrement;

    public DriveStraight() {
        requires(Robot.instance.driveTrain);
    }

    @Override
    protected void initialize() {
        // todo: remove this. we no longer need to control these parameters.
        speed = SmartDashboard.getNumber("Speed");
        turningIncrement = SmartDashboard.getNumber("Turning Increment");

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
