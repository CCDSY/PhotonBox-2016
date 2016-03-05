package org.usfirst.frc.team6179.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team6179.robot.Robot;
import org.usfirst.frc.team6179.robot.commands.arm.MoveArm;
import org.usfirst.frc.team6179.robot.mappings.RobotMap;

public class Arm extends Subsystem {
    public Victor armMotor = new Victor(RobotMap.armMotor);
    public Victor intakeMotor = new Victor(RobotMap.armIntakeMotor);

    public Arm(){
        LiveWindow.addActuator("Arm", "ArmMotor", armMotor);
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new MoveArm());
    }
    
    public void stop(){
    	armMotor.set(0);
    }
}

