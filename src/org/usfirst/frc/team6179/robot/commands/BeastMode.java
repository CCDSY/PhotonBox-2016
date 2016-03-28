package org.usfirst.frc.team6179.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 3/12/16.
 * A Command that makes the robot go into beast mode, disabling gyro assistance to increase speed.
 * The robot will exit beast mode when the command is finished.
 */
public class BeastMode extends Command {
    @Override
    protected void initialize() {
        Robot.instance.driveTrain.gyroAssisted = false;
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
        Robot.instance.driveTrain.gyroAssisted = true;
    }

    @Override
    protected void interrupted() {
        Robot.instance.driveTrain.gyroAssisted = true;
    }
}
