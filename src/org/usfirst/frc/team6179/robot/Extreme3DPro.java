package org.usfirst.frc.team6179.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team6179.robot.mappings.Extreme3DProKeyMapping;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Extreme3DPro implements OI {

    private Joystick stick;

    public Extreme3DPro() {
        stick = new Joystick(0);
    }

    @Override
    public double getMovement() {
        return 0;
    }

    @Override
    public double getRotation() {
        return 0;
    }

    @Override
    public double getLeftMovement() {
        return 0;
    }

    @Override
    public double getRightMovement() {
        return 0;
    }

    @Override
    public double getClimberLockServoMovement() {
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetX() {
        return 0;
    }

    @Override
    public double getScaledCrosshairOffsetY() {
        return 0;
    }

    @Override
    public double getArmMovement() {
        return 0;
    }

    @Override
    public double getShooterElevatorInput() {
        return 0;
    }

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

