package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6179.robot.commands.AimMode;
import org.usfirst.frc.team6179.robot.commands.BeastMode;
import org.usfirst.frc.team6179.robot.commands.climber.Pull;
import org.usfirst.frc.team6179.robot.commands.climber.ResetClimberLock;
import org.usfirst.frc.team6179.robot.commands.climber.Stretch;
import org.usfirst.frc.team6179.robot.commands.climber.UnlockClimber;
import org.usfirst.frc.team6179.robot.commands.shooter.CollectBoulder;
import org.usfirst.frc.team6179.robot.commands.shooter.ShootBoulder;
import org.usfirst.frc.team6179.robot.commands.vision.SendVideoWithAimingMarkings;
import org.usfirst.frc.team6179.robot.commands.vision.SendVideoWithCrosshair;
import org.usfirst.frc.team6179.robot.configurations.ArmConfig;
import org.usfirst.frc.team6179.robot.mappings.LogitechGamepadKeyMapping;

public class LogitechGamepad implements OI {
    // TODO: Resolve keymap conflict

    private Joystick driveStick;
    private Joystick sidekickStick;

    public LogitechGamepad() {
        driveStick = new Joystick(0);
        sidekickStick = new Joystick(1);

        // bind buttons to commands. //
        new JoystickButton(sidekickStick, LogitechGamepadKeyMapping.BTN_X).whileHeld(new CollectBoulder());
        new JoystickButton(sidekickStick, LogitechGamepadKeyMapping.BTN_LB).whenPressed(new ShootBoulder());
        new JoystickButton(sidekickStick, LogitechGamepadKeyMapping.BTN_A).toggleWhenPressed(new Pull());
        new JoystickButton(driveStick, LogitechGamepadKeyMapping.BTN_RB).whileHeld(new AimMode());
        new JoystickButton(driveStick, LogitechGamepadKeyMapping.BTN_B).whileHeld(new BeastMode());
        new JoystickButton(sidekickStick, LogitechGamepadKeyMapping.BTN_Y).whenPressed(new UnlockClimber());
        // bind buttons to commands. //

        // display commands on dashboard for easy testing. //
        // Vision
        SmartDashboard.putData("Display Shooter Camera Video with Crosshair", new SendVideoWithCrosshair(Robot.instance.shooterVision));
        SmartDashboard.putData("Display Shooter Camera Video with Aiming Markings", new SendVideoWithAimingMarkings(Robot.instance.shooterVision));
        // Climber
        SmartDashboard.putData("Reset Climber Lock", new ResetClimberLock());
        SmartDashboard.putData("Pull Climber", new Pull());
        SmartDashboard.putData("Stretch Climber", new Stretch());
        // display commands on dashboard for easy testing. //

    }

    @Override
    public double getMovement() {
        return -driveStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
//        return 0;
    }

    @Override
    public double getRotation() {
        return -driveStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
//        return 0;
    }

    @Override
    public double getLeftMovement() {
//        return driveStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
        return 0;
    }

    @Override
    public double getRightMovement() {
//        return driveStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetX() {
//        return driveStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_X);
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetY() {
//        return driveStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_Y);
        return 0;
    }

    @Override
    public double getArmMovement() {
        return (sidekickStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_TRIGGER) - sidekickStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_LEFT_TRIGGER)) * ArmConfig.armMovementMultiplier;
    }

    @Override
    public double getShooterElevatorInput() {
        return sidekickStick.getRawAxis(LogitechGamepadKeyMapping.AXIS_RIGHT_Y);
    }

}
