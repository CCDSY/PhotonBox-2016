package org.usfirst.frc.team6179.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;

public class AimMode extends Command {

    @Override
    protected void initialize() {
        Robot.instance.driveTrain.speedMultiplier = DriveTrainConfig.aimSpeedMultiplier;
        Robot.instance.driveTrain.turnMultiplier = DriveTrainConfig.aimTurnMultiplier;
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

    }

    @Override
    protected void interrupted() {

    }

    private void exitAimMode() {
        Robot.instance.driveTrain.speedMultiplier = DriveTrainConfig.defaultSpeedMultiplier;
        Robot.instance.driveTrain.turnMultiplier = DriveTrainConfig.defaultTurnMultiplier;
    }

}
