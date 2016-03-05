package org.usfirst.frc.team6179.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.subsystems.Vision;

/**
 * Created by CC on 2/27/16.
 * A command that keeps sending video feed from a camera back to driver's computer.
 * After a Vision object is used with this command, it should not be used to do any other vision processing operation.
 */
public class SendVideo extends Command {

    private Vision vision;

    public SendVideo(Vision vision) {
        this.vision = vision;

        requires(vision);
    }

    @Override
    protected void initialize() {
        vision.startAutoCapture();
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
}
