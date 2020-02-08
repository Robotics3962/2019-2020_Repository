package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DiffDriveBase;

public class PrintEncoderValues extends Command {


    public PrintEncoderValues() {

        requires(Robot.diffDriveBase);
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        //DiffDriveBase.dumpEncoderValues();
    }

}