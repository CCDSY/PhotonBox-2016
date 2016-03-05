package org.usfirst.frc.team6179.robot.commands.vision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.Util;
import org.usfirst.frc.team6179.robot.configurations.VisionConfig;
import org.usfirst.frc.team6179.robot.subsystems.Vision;

/**
 * Created by huangzhengcheng1 on 2/28/16.
 *
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
        // update the crosshair position based on user input.
        Robot.instance.shooterVision.crosshairOffsetX = Util.limit(Robot.instance.shooterVision.crosshairOffsetX + (int)(Robot.instance.oi.getScaledCrosshairOffsetX() * VisionConfig.offsetIncrement), -VisionConfig.maxOffset, VisionConfig.maxOffset);
        Robot.instance.shooterVision.crosshairOffsetY = Util.limit(Robot.instance.shooterVision.crosshairOffsetY + (int)(Robot.instance.oi.getScaledCrosshairOffsetY() * VisionConfig.offsetIncrement), -VisionConfig.maxOffset, VisionConfig.maxOffset);

        // display the new crosshair position.
        SmartDashboard.putNumber("Crosshair offset X", Robot.instance.shooterVision.crosshairOffsetX);
        SmartDashboard.putNumber("Crosshair offset Y", Robot.instance.shooterVision.crosshairOffsetY);

        // send back the new image.
        server.setImage(vision.showCrosshairOnImage(vision.grabPicture(), Robot.instance.shooterVision.crosshairOffsetX, Robot.instance.shooterVision.crosshairOffsetY));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        vision.stopCamera();
    }

    @Override
    protected void interrupted() {
        vision.stopCamera();
    }
}
