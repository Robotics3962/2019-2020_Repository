/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;




import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // get both drive and operational joysticks
  public static Joystick driveJoystick = new Joystick(RobotMap.Joystick0Id);
  public static Joystick operationJoystick = new Joystick(RobotMap.Joystick1Id); 

  public OI() {     

    // get the buttons on the drive joystick
    //left to show as example
    //JoystickButton driveButtonA = new JoystickButton(driveJoystick, RobotMap.JoystickButtonA);
    JoystickButton opDriveButtonA = new JoystickButton(operationJoystick, RobotMap.JoystickButtonA);
    
    
    
    // map buttons to commands on the joystick that drives the robot
    
    

    // second joystick I'm calling it operational - no command mapping yet
    //JoystickButton opButtonA = new JoystickButton(operationJoyStick, RobotMap.JoystickButtonA);
    
    
    //-----------------------------------------------
    //not deleted as to show as example
   // opButtonA.whenPressed(new LockWristCmd());

  }

  
  
  public double getLeftThrottle() {
		return driveJoystick.getY(); // Laika needs negative, Belka is positive
	}	

	public double getRightRotation() {
		return driveJoystick.getRawAxis(4);
  }
}
