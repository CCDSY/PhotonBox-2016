package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.commands.drivetrain.UpdateDriveTrainGyroData;
import org.usfirst.frc.team6179.robot.configurations.DriveTrainConfig;
import org.usfirst.frc.team6179.robot.sensors.GY521GyroAccelerometer;

/**
 * Created by huangzhengcheng1 on 3/5/16.
 *
 * A subsystem used to control the 3-axis gyro installed on the robot.
 * This subsystem only has a sensor. It doesn't have any actuator.
 *
 * Other than the default command which updates the gyro's data every tick,
 * other command that uses the gyro's data should not `require` this subsystem;
 * they should just access the `heading` field.
 */
public class DriveTrainGyro extends Subsystem {

    /**
     * The current heading of the robot.
     * Commands that want the robot's heading should access this field.
     */
    public double heading;

    private GY521GyroAccelerometer gy521;
    private Timer timer;

    public DriveTrainGyro() {
        gy521 = new GY521GyroAccelerometer();
        heading = 0;
        timer = new Timer();
        timer.start();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new UpdateDriveTrainGyroData());
    }

    public void updateDriveTrainData() {
        double angularVelocity = getAngularVelocity();
        heading += timer.get() * angularVelocity;
        timer.reset();

        SmartDashboard.putNumber("Angular Velocity", angularVelocity);
        SmartDashboard.putNumber("Angle", Robot.instance.gyro.heading);
    }

    public double getAngularVelocity() {
        return gy521.getGyroZ() / DriveTrainConfig.gyroSensitivity - DriveTrainConfig.gyroOffset;
    }
}
