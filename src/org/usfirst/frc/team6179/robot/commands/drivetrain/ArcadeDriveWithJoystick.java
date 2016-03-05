package org.usfirst.frc.team6179.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by huangzhengcheng1 on 2/26/16.
 *
 * Drive the robot in arcade mode with joystick inputs from the driver.
 */
public class ArcadeDriveWithJoystick extends Command {

    public ArcadeDriveWithJoystick() {
        requires(Robot.instance.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.instance.driveTrain.arcadeDrive(Robot.instance.oi.getMovement(), Robot.instance.oi.getRotation());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {

    }

}
