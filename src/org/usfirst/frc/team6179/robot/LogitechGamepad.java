package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.commands.AimMode;
import org.usfirst.frc.team6179.robot.commands.climber.ResetClimberLock;
import org.usfirst.frc.team6179.robot.commands.climber.UnlockClimber;
import org.usfirst.frc.team6179.robot.commands.drivetrain.DriveStraight;
import org.usfirst.frc.team6179.robot.commands.shooter.CollectBoulder;
import org.usfirst.frc.team6179.robot.commands.shooter.ShootBoulder;
import org.usfirst.frc.team6179.robot.commands.vision.ResetCrosshair;
import org.usfirst.frc.team6179.robot.commands.vision.SendVideo;
import org.usfirst.frc.team6179.robot.commands.vision.SendVideoWithCrosshair;
import org.usfirst.frc.team6179.robot.configurations.ArmConfig;
import org.usfirst.frc.team6179.robot.mappings.LogitechGamepadKeyMapping;

public class LogitechGamepad implements OI {
    // TODO: Resolve keymap conflict

    private Joystick stick;

    public LogitechGamepad() {
        stick = new Joystick(0);

        // bind buttons to commands. //
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_X).toggleWhenPressed(new CollectBoulder());
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_LB).whenPressed(new ShootBoulder());
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_A).whenPressed(new ResetCrosshair());
        new JoystickButton(stick, LogitechGamepadKeyMapping.BTN_RB).whileHeld(new AimMode());
        // bind buttons to commands. //

        // set parameters for drive straight test
        SmartDashboard.putNumber("Speed", 0.8);
        SmartDashboard.putNumber("Turning Increment", 0.5);

        // display commands on dashboard for easy testing. //
        // Shooter
        SmartDashboard.putData("Shoot Boulder", new ShootBoulder());
        SmartDashboard.putData("Collect Boulder", new CollectBoulder());
        // Vision
        SmartDashboard.putData("Display Shooter Camera Video", new SendVideo(Robot.instance.shooterVision));
        SmartDashboard.putData("Display Shooter Camera Video with Crosshair", new SendVideoWithCrosshair(Robot.instance.shooterVision));
        SmartDashboard.putData("Drive Straight", new DriveStraight());
        SmartDashboard.putData("Unlock Climber", new UnlockClimber());
        SmartDashboard.putData("Reset Climber Lock", new ResetClimberLock());
        // display commands on dashboard for easy testing. //

    }

    @Override
    public double getMovement() {
        return -stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
//        return 0;
    }

    @Override
    public double getRotation() {
        return -stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
//        return 0;
    }

    @Override
    public double getLeftMovement() {
//        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
        return 0;
    }

    @Override
    public double getRightMovement() {
//        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetX() {
//        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetY() {
//        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
        return 0;
    }

    @Override
    public double getArmMovement() {
        return (stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_TRIGGER) - stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_TRIGGER)) * ArmConfig.armMovementMultiplier;
    }

    @Override
    public double getClimberLockServoMovement() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_X);
    }

    @Override
    public double getShooterElevatorInput() {
        return stick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
    }

}
