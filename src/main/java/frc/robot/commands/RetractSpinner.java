/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Spinner;

//import frc.robot.TestingDashboard;

public class RetractSpinner extends Command {
  Spinner m_spinner;
  boolean m_finished = false;
  DoubleSolenoid m_piston;
  
  public RetractSpinner() {
    // Use addRequirements() here to declare subsystem dependencies.
    m_spinner = Spinner.getInstance();
    m_piston = m_spinner.getPiston();
  }

 // public static void registerWithTestingDashboard() {
 //   Spinner spinner = Spinner.getInstance();
 //   RetractSpinner cmd = new RetractSpinner();
   // TestingDashboard.getInstance().registerCommand(spinner, "Basic", cmd);
 // }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_piston.set(DoubleSolenoid.Value.kReverse);
    m_finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_piston.get() == DoubleSolenoid.Value.kReverse) {
      m_piston.set(DoubleSolenoid.Value.kOff);
      m_finished = true;
    }
  }

  
  protected void interrupted() {
    // TODO Auto-generated method stub
  end();
  }


  
  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    m_piston.set(DoubleSolenoid.Value.kOff); 
  }
  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_finished;
  }
}
