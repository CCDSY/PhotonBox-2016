package org.usfirst.frc.team6179.robot.commands.vision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.configurations.VisionConfig;
import org.usfirst.frc.team6179.robot.subsystems.Vision;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 * A command that sends back video from a camera to the driver's computer
 * with a crosshair drawn in the center
 */
public class SendVideoWithCrosshair extends Command {

    private Vision vision;
    private CameraServer server;

    public SendVideoWithCrosshair(Vision vision) {
        this.vision = vision;

        requires(vision);
    }

    @Override
    protected void initialize() {
        vision.useCamera();
        this.server = CameraServer.getInstance();
    }

    @Override
    protected void execute() {
        server.setImage(vision.showCrosshairOnImage(vision.grabPicture(), (int)(Robot.instance.oi.getScaledCrosshairOffsetX() * VisionConfig.maxOffset), (int)(Robot.instance.oi.getScaledCrosshairOffsetY() * VisionConfig.maxOffset)));
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
