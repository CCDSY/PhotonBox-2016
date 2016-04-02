package org.usfirst.frc.team6179.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.GetImageSizeResult;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import com.ni.vision.NIVision.Rect;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6179.robot.configurations.VisionConfig;

/**
 * Created by huangzhengcheng1 on 2/27/16.
 * <p>
 * A subsystem that encapsulates the use of a camera.
 */
public class Vision extends Subsystem {

    /**
     * An object used to automatically capture images and send them back to driver's computer.
     */
    private CameraServer server;
    /**
     * An index value used to reference a camera during a NIVision camera session.
     */
    private int session;

    /**
     * The name of the camera currently used by this Vision object.
     */
    private String cameraName;

    private Image frame;
    public GetImageSizeResult size;

    public int crosshairOffsetX = 0;
    public int crosshairOffsetY = 0;

    public Vision(String cameraName) {
        this.cameraName = cameraName;

        frame = NIVision.imaqCreateImage(ImageType.IMAGE_RGB, 0);
    }

    @Override
    protected void initDefaultCommand() {
    }

    /**
     * Start automatically sending video feed back to driver's computer using a CameraServer instance.
     * This can only be called once, and no other features related to image processing should be used on this camera after the call.
     */
    public void startAutoCapture() {
        server = CameraServer.getInstance();
        server.setQuality(VisionConfig.autoCaptureImageQuality);
        server.startAutomaticCapture(cameraName);
    }

    /**
     * Start a NIVision session using this camera, enabling it to capture images.
     * This must be called prior to using any features related to image processing.
     *
     * @return an index value used to reference a camera during a NIVision camera session.
     */
    public int useCamera() {
        session = NIVision.IMAQdxOpenCamera(cameraName, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        NIVision.IMAQdxStartAcquisition(session);

        return session;
    }

    public Image grabPicture() {
        NIVision.IMAQdxGrab(session, frame, 1);
        size = NIVision.imaqGetImageSize(frame);

        return frame;
    }

    public Image showCrosshairOnImage(Image image) {
        return showCrosshairOnImage(image, 0, 0);
    }

    public Image showCrosshairOnImage(Image image, int offsetX, int offsetY) {
        Rect crossRect = new Rect(size.height / 2 - VisionConfig.crosshairLineWidth / 2 + offsetY, size.width / 2 - VisionConfig.crosshairSize / 2 + offsetX, VisionConfig.crosshairLineWidth, VisionConfig.crosshairSize);

        Rect verticalRect = new Rect(size.height / 2 - VisionConfig.crosshairSize / 2 + offsetY, size.width / 2 - VisionConfig.crosshairLineWidth / 2 + offsetX, VisionConfig.crosshairSize, VisionConfig.crosshairLineWidth);

        NIVision.imaqDrawShapeOnImage(image, image, crossRect, NIVision.DrawMode.PAINT_VALUE, NIVision.ShapeMode.SHAPE_RECT, 0);
        NIVision.imaqDrawShapeOnImage(image, image, verticalRect, NIVision.DrawMode.PAINT_VALUE, NIVision.ShapeMode.SHAPE_RECT, 0);

        return image;
    }

    public void drawLineAboveCenter(Image image, int offsetY, int lineWidth, int lineLength) {
        Rect lineRect = new Rect(size.height / 2 - lineWidth / 2 + offsetY, size.width / 2 - lineLength / 2, lineWidth, lineLength);
        NIVision.imaqDrawShapeOnImage(image, image, lineRect, NIVision.DrawMode.PAINT_VALUE, NIVision.ShapeMode.SHAPE_RECT, 0);
    }

    public void showRulerOnImage(Image image) {
        int rulerLineCount = size.height / 2 / VisionConfig.rulerLineGapSize;

        for (int i = 1; i < rulerLineCount; i++) {
            int offset = i * VisionConfig.rulerLineGapSize;

            drawLineAboveCenter(image, offset, VisionConfig.rulerLineWidth, VisionConfig.rulerLineLength);
        }
    }

    /**
     * Stops the current NIVision session with this camera, making it stop capturing images.
     * After this call, any other feature related to image processing should not be used any more.
     */
    public void stopCamera() {
        NIVision.IMAQdxStopAcquisition(session);
        NIVision.IMAQdxCloseCamera(session);
    }
}
