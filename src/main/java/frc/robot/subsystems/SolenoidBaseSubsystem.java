package frc.robot.subsystems;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
// currently using placeholder vaules

public class SolenoidBaseSubsystem extends Subsystem {

    private static final int kDoubleSolenoidForward = 1;
    private static final int kDoubleSolenoidReverse = 2;
    // values are not official


    public static void solenoidForward() {

        RobotMap.spinnerSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public static void solenoidReverse() {

        RobotMap.spinnerSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }

    public static void solenoidOff () {

        RobotMap.spinnerSolenoid.set(DoubleSolenoid.Value.kOff);   
    }

	
    
    

}