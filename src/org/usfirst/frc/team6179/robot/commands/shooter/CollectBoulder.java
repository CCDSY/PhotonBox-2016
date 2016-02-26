package org.usfirst.frc.team6179.robot.commands.shooter;

import org.usfirst.frc.team6179.robot.commands.CommandBase;

public class CollectBoulder extends CommandBase {

    public CollectBoulder() {
    	requires(shooter);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	shooter.collect();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
