package org.usfirst.frc.team6179.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * A command which allows the driver to control the Arm with joystick.
 */
public class MoveArm extends Command {

    public MoveArm() {
        requires(Robot.instance.arm);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.instance.arm.armMotor.set(Robot.instance.oi.getArmMovement());
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
