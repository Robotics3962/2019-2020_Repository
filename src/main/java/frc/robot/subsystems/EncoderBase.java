package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class EncoderBase extends Subsystem {

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }

    //Constants
    public static final double kDistancePerRevolution = 1.2;//placeholder value
    public static final double kPulsesPerRevolution = 1024; //not sure if this value is correct
    public static final double kDistancePerPulse = kDistancePerRevolution/kPulsesPerRevolution;

    private Encoder leftEncoder = new Encoder (0,0, false, EncodingType.k4X);
    private Encoder rightEncoder = new Encoder (0,0, true, EncodingType.k4X);

    //place inside of frc.robot.Robot
    
    leftEncoder.setDistanceperPulse(kDistancePerPulse);
    rightEncoder.setDistanceperPulse(kDistancePerPulse);

    leftEncoder.start();
    rightEncoder.start();

    private double getAverageEncoderPosition() {
        return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;

    }

    private void resetEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
    




}