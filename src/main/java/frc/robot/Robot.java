/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DiffDriveBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

//limelight libraries
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import oi.limelightvision.limelight.frc.LimeLight;
//import oi.limelightvision.limelight.frc.ControlMode.*;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;

  Command m_autonomousCommand; 
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // subsystems
  public static DiffDriveBase diffDriveBase = null;

  
  Solenoid solenoid_1 = new Solenoid(1,2);// placeholder int
  DoubleSolenoid anotherDoubleSolenoid = new DoubleSolenoid(5,1,2);


  //cameras
  public static UsbCamera camera1;
  public static UsbCamera camera2;

  //timestamp used for autonomous
  double time;
  double startTime;

  //gyro
  static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  //encoders
  //Constants
  public static final double kDistancePerRevolution = 1.2;//placeholder value
  public static final double kPulsesPerRevolution = 1024; //not sure if this value is correct
  public static final double kDistancePerPulse = kDistancePerRevolution/kPulsesPerRevolution;

  private Encoder leftEncoder = new Encoder (0,0, false, EncodingType.k4X);//both right and left need something to be assigned for their ports
  private Encoder rightEncoder = new Encoder (0,0, true, EncodingType.k4X);

  
  leftEncoder.setDistanceperPulse(kDistancePerPulse);
  rightEncoder.setDistanceperPulse(kDistancePerPulse);

  leftEncoder.start();
  rightEncoder.start();

    
    

  // this is used to log output to the console
  public static void Log(String msg) {
    System.out.println(msg);
  }

  // used in out of phase encoder detection
  public enum Direction {
    NONE, UP, DOWN
  }

  // this is a divide by 0 which will
  // throw an exception which should
  // stop the program from running or otherwise
  // indicate an error
  public static void die() {
    // int x = 0;
    // int u = 1/x;
  }

  public static void UpdateDashboard(String tag, double value) {
    SmartDashboard.putNumber(tag, value);
  }

  public static void UpdateDashboard(String tag, boolean value) {
    SmartDashboard.putBoolean(tag, value);
  }

  public static void UpdateDashboard(String tag, String value) {
    SmartDashboard.putString(tag, value);
  }

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

    // calibrates the gyro sensor
    gyro.calibrate();

    resetEncoders();

    // create all subsystems
    diffDriveBase = new DiffDriveBase();

    // call control loop
    m_oi = new OI();

    // set up camera servers
    camera1 = CameraServer.getInstance().startAutomaticCapture(0);
    camera2 = CameraServer.getInstance().startAutomaticCapture(1);

    camera1.setResolution(320, 420);
    camera2.setResolution(320, 420);

    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    // SmartDashboard.putData("Auto mode", m_chooser);

    
  }

  private double getAverageEncoderPosition() {
    return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;

}

  private void resetEncoders() {
      leftEncoder.reset();
      rightEncoder.reset();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    DiffDriveBase.rightMotors.setInverted(false);
    DiffDriveBase.leftMotors.setInverted(false);
    // IMPORTANT: this timer starts when the ROBOT turns on, not when autonomous is
    // activated
    startTime = Timer.getFPGATimestamp();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    //
    
    Scheduler.getInstance().run();

    System.out.println("Current val for 'time':" + time);
    System.out.println("Current val for 'startTime':" + startTime);

    // max time always will equal 15 seconds, then Teleop starts after 15 secs
    // passed

    // continually update value
    time = Timer.getFPGATimestamp();

    // should work so that after autonomous is initializd timer starts

    /*
    if (time - startTime <= 10) {

      DiffDriveBase.setSpeedAndRotation(0.4, 0.0); // RobotMap.autonomousSSF, RobotMap.autonomousRSF)

    }
    else if (time - startTime > 10 && time - startTime < 18) {

      if (gyro.getAngle() < 45) {

        DiffDriveBase.setSpeedAndRotation(0, 0.4);
      }
    }
    */

    if (time -startTime <= 5){

      DiffDriveBase.setSpeedAndRotation(0.4, 0);
    }
    if (time - startTime > 5 && time - startTime <= 10){

      if (gyro.getAngle() < 90) {

        DiffDriveBase.setSpeedAndRotation(0, 0.4);
      }
    } 

    if (time - startTime > 10 && time - startTime <= 15) {

      DiffDriveBase.setSpeedAndRotation(0.4, 0);
    }

    if (time - startTime > 5 && time - startTime <= 10){

      if (gyro.getAngle() < 90) {
       
        DiffDriveBase.setSpeedAndRotation(0,0.4);
      }
    }

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public static void getGyroAngle() {
    // get angle(goes past 360)
    gyro.getAngle();
  }
  
}
