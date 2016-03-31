package org.usfirst.frc.team6179.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;

/**
 * Created by CC on 3/31/16.
 */
public class DriveStraightForDuration extends Command {

    private double duration;
    private Timer timer;

    private double speed = 1;

    public DriveStraightForDuration(double duration) {
        this.timer = new Timer();
        this.duration = duration;

        requires(Robot.instance.driveTrain);
    }

    @Override
    protected void initialize() {
        Robot.instance.driveTrain.assistedArcadeDrive(speed, 0);

        timer.start();
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return timer.get() > duration;
    }

    @Override
    protected void end() {
        endCommand();
    }

    @Override
    protected void interrupted() {
        endCommand();
    }

    private void endCommand() {
        timer.stop();

        Robot.instance.driveTrain.stop();
    }

}
