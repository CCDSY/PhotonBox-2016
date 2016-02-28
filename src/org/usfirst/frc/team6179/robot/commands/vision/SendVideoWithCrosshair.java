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
 * A command that sends back video from a camera to the driver's computer
 * with a crosshair drawn in the center
 */
public class SendVideoWithCrosshair extends Command {

    private Vision vision;
    private CameraServer server;

    private int offsetX;
    private int offsetY;

    public SendVideoWithCrosshair(Vision vision) {
        this.vision = vision;

        offsetX = 0;
        offsetY = 0;

        requires(vision);
    }

    @Override
    protected void initialize() {
        vision.useCamera();
        this.server = CameraServer.getInstance();
    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("Crosshair offset X", offsetX);
        SmartDashboard.putNumber("Crosshair offset Y", offsetY);
        offsetX = Util.limit((int)SmartDashboard.getNumber("Crosshair offset X") + (int)(Robot.instance.oi.getScaledCrosshairOffsetX() * VisionConfig.maxOffset), -VisionConfig.maxOffset, VisionConfig.maxOffset);
        offsetY = Util.limit((int)SmartDashboard.getNumber("Crosshair offset Y") + (int)(Robot.instance.oi.getScaledCrosshairOffsetY() * VisionConfig.maxOffset), -VisionConfig.maxOffset, VisionConfig.maxOffset);
        server.setImage(vision.showCrosshairOnImage(vision.grabPicture(), offsetX, offsetY));
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
