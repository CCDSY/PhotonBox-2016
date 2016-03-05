package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.commands.arm.MoveArm;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

/**
 * The subsystem which controls the mechanism that helps the robot cross certain defenses and facilitate boulder collection.
 */
public class Arm extends Subsystem {
    /**
     * The motors that controls the movement of the entire robot arm.
     */
    public Victor armMotor = new Victor(RobotMap.armMotor);
    /**
     * The motor that controls a wheel (or of some sort) which guides the boulder into the Shooter.
     */
    public Victor intakeMotor = new Victor(RobotMap.armIntakeMotor);

    public Arm(){
        LiveWindow.addActuator("Arm", "ArmMotor", armMotor);
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new MoveArm());
    }

    /**
     * Stop the arm.
     */
    public void stop(){
    	armMotor.set(0);
    }
}

