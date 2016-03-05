package org.usfirst.frc.team6179.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.ShooterConfig;

/**
 * A command which makes the Shooter shoot the boulder, and stops itself afterwards.
 */
public class ShootBoulder extends Command {

    private Timer timer;
    private boolean boulderFired = false;

    public ShootBoulder() {
        requires(Robot.instance.shooter);
    }

    protected void initialize() {
        // start the wheels when the command starts.
        Robot.instance.shooter.shootMotor.set(ShooterConfig.outgoingOutput);

        timer = new Timer();
        timer.start();
    }

    protected void execute() {
        if (!boulderFired && timer.get() >= ShooterConfig.shooterTriggerDelay) {
            Robot.instance.shooter.triggerServo.set(ShooterConfig.triggerServoForwardPosition);

            timer.reset();
            boulderFired = true;
            // not sure if the timer needs to be started again after reset.
        }
    }

    protected boolean isFinished() {
        // stop the command when designated delay has elapsed.
        return boulderFired && timer.get() >= ShooterConfig.shooterStopDelay;
    }

    protected void end() {
        endCommand();
    }

    protected void interrupted() {
        endCommand();
    }

    private void endCommand() {
        // stop the wheels when the command ends.
        Robot.instance.shooter.shootMotor.set(0);
        // move back the trigger servo to allow for future boulder collection.
        Robot.instance.shooter.triggerServo.set(ShooterConfig.triggerServoBackPosition);

        // reset state
        boulderFired = false;

        // memory clean up.
        timer.stop();
        timer = null;
    }
}
