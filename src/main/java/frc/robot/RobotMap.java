/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  // indicate what we want to test
 

  
  // these are PWM ids
  public static final int SparkMotorId1 = 5;
  public static final int SparkMotorId2 = 6;

  // these are CAN bus ids(ghettobot)
  //public static final int TalonDriveLeftFront = 2; //2
  //public static final int TalonDriveLeftBack = 1; //1
  //public static final int TalonDriveRightFront = 3; //3
  //public static final int TalonDriveRightRear = 4;
  //public static final double TalonMinOutput = -0.25;
  //public static final double TalonMaxOutput = 0.3;

  //formerCompBot
  public static final int TalonDriveLeftFront = 2; //2
  public static final int TalonDriveLeftBack = 3; //1
  public static final int TalonDriveRightFront = 1; //3
  public static final int TalonDriveRightRear = 4;
  public static final double TalonMinOutput = -0.25;
  public static final double TalonMaxOutput = 0.3;


  /// generic
  public static final double TalonUpSpeed = -.2;
  public static final double TalonUpPidDelta = -20; // match sign of upspeed
  public static final double TalonDownSpeed = .3;
  public static final double TalonDownPidDelta = 20; // match sign of down speed
  public static final double TalonStopSpeed = .001;
  public static final double TalonAbsTolerance = 5;
  public static final int    TalonCruiseSpeed = 15000;
  public static final int    TalonAcceleration = 6000;
  public static final double TalonPID_P = 4; //0.2;
  public static final double TalonPID_I = 0.0;
  public static final double TalonPID_D = 0.0;
  public static final double TalonPID_F = 0.0;


  // intake values
  public static final int SparkIntakeId = 4;
  

  // Joystick to use
  public static final int Joystick0Id = 0;
  public static final int Joystick1Id = 1;

  // these are controller button ids (on joystick)
  public static final int JoystickButtonA = 1;
  public static final int JoystickButtonB = 2;
  public static final int JoystickButtonX = 3;
  public static final int JoystickButtonY = 4;
  public static final int JoystickButtonShoulderLeft = 5;
  public static final int JoystickButtonShoulderRight = 6;
  public static final int JoystickButtonBack = 7;
  public static final int JoystickButtonStart = 8;
  
  // joystick axis mapping
  public static final int JoystickAxisSpeed = 0;
  public static final int JoystickAxisRotation = 1;
  public static final double JoystickDeadZone = 0.05;

  // these values are used to expand (value > 1)
  // keep the identity (value == 1) or reduce
  // (value < 1) the max and min speed the joystick
  // moves the robot  
  public static final double SpeedScaleFactor = 0.85;
  public static final double RotationScaleFactor = 0.77;

  public static final double autonomousSSF = 0.5;
  public static final double autonomousRSF = 0.6;

  public static DoubleSolenoid spinnerSolenoid = new DoubleSolenoid(0,0,0); //placeholders.  values to plug are as such(int ModuleNumber, int fowrdChannel, int reverseChannel)
}
