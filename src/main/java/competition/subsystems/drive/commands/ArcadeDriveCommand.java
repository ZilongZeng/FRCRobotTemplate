package competition.subsystems.drive.commands;
import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

public class ArcadeDriveCommand extends BaseCommand{
    final DriveSubsystem drive;
    final OperatorInterface oi;
    double y;
    double x;

    @Inject
    public ArcadeDriveCommand(OperatorInterface oi, DriveSubsystem drive){
        this.oi = oi;
        this.drive = drive;
        this.requires(this.drive);
    } 
    
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        y = oi.gamepad.getLeftVector().y;
        x = oi.gamepad.getLeftVector().x;
        double leftPower = (y + x)*0.5;
        double rightPower = (y - x)*0.5;
        drive.tankDrive(leftPower, rightPower);

    }
}