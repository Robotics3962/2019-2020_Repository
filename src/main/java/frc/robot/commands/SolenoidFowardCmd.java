package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.subsystems.SolenoidBase;
import frc.robot.subsystems.SolenoidBaseSubsystem;

public class SolenoidFowardCmd extends Command {
    
    @Override
    protected boolean isFinished() {
	// TODO Auto-generated method stub
	return false;
    }

    protected void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }

    @Override
    public void execute() {

        SolenoidBaseSubsystem.solenoidForward();
    }

    @Override
    public void end(){
        SolenoidBaseSubsystem.solenoidOff();
    }

}

