package org.usfirst.frc.team6179.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/29/16.
 */
public class ResetCrosshair extends Command {
    @Override
    protected void initialize() {
        Robot.instance.shooterVision.crosshairOffsetX = 0;
        Robot.instance.shooterVision.crosshairOffsetY = 0;
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
