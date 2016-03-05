package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.configurations.ClimberConfig;
import org.usfirst.frc.team6179.robot.configurations.ShooterConfig;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

/**
 * The subsystem that controls the mechanism used to lift the robot to scale the tower.
 */
public class Climber extends Subsystem {
    /** The servo used to lock the climber */
    public Servo lockServo = new Servo(RobotMap.climberLockServo);

    /** The motor used controls the stretch of the climber by tightening or relaxing the rope that holds the climber */
    public Victor climberMotor = new Victor(RobotMap.climberMotor);

    /** The encoder that sends back data from the climber motor */
    public Encoder climberMotorEncoder = new Encoder(RobotMap.channelA, RobotMap.channelB, true, Encoder.EncodingType.k4X);

    public Climber() {
        lockServo.set(ClimberConfig.lockServoLockPosition);
        LiveWindow.addActuator("Climber", "Lock Servo", lockServo);
        LiveWindow.addActuator("Climber", "GearMotor", climberMotor);
        LiveWindow.addSensor("Climber", "Encoder", climberMotorEncoder);
    }

    public void initDefaultCommand() {
    }

}

