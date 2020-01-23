package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


class CompressorStart {
  static Compressor c = Robot.c;
    public CompressorStart() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      }

  
  protected void initialize() {

    Compressor c = Robot.c;

    c.setClosedLoopControl(true);

    
  }
    public static void start() {
      
      c.setClosedLoopControl(true);
    }
    public static void stop() {
      c.setClosedLoopControl(false);

      
      
    }
}


