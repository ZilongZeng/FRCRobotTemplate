package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

public class MoveBackwardsCommand extends BaseCommand {

    final DriveSubsystem driveSubsystem;
    final OperatorInterface oi;

    @Inject
    public MoveBackwardsCommand(OperatorInterface oi, DriveSubsystem driveSubsystem) {
        this.oi = oi;
        this.driveSubsystem = driveSubsystem;
        this.requires(this.driveSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveSubsystem.tankDrive(-1,-1);

    }

}
