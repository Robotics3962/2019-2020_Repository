package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CompressorStart;

public class StopCompressor extends Command {

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
       // CompressorStart.stop();
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
      end();
    }

}