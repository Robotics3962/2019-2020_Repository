package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.subsystems.SolenoidBase;
import frc.robot.subsystems.SolenoidBaseSubsystem;

public class SolenoidFowardCmd extends Command {

    public SolenoidFowardCmd() {
        requires(Robot.solenoidBase);
    }
    
    @Override
    protected boolean isFinished() {
	// TODO Auto-generated method stub
	return false;
    }

    protected void initialize() {
        // TODO Auto-generated method stub
        SolenoidBaseSubsystem.solenoidOff();
    }

    @Override
    public void execute() {
        System.out.println("Solenoid Foward on");
        SolenoidBaseSubsystem.solenoidForward();
    }

    @Override
    public void end(){
        System.out.println("Solenoid Foward off");
        SolenoidBaseSubsystem.solenoidOff();
    }

    @Override
    protected void interrupted() {

        end();
    }

}

