package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.subsystems.DriveTrainGyro;

/**
 * Created by huangzhengcheng1 on 3/5/16.
 */
public class UpdateDriveTrainGyroData extends Command {

    public UpdateDriveTrainGyroData() {
        requires(Robot.instance.gyro);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.instance.gyro.updateDriveTrainData();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
