/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Add your docs here.
 */
public class SolenoidReverse extends Command{

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

      // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SolenoidBase.solenoidReverse();
}


}
