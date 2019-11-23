package competition.subsystems.drive.commands;

import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;
import xbot.common.properties.DoubleProperty;
import xbot.common.properties.PropertyFactory;

public class TankDriveWithJoysticksCommand extends BaseCommand {

    final DriveSubsystem driveSubsystem;
    final OperatorInterface oi;
    DoubleProperty power;

    @Inject
    public TankDriveWithJoysticksCommand(OperatorInterface oi, DriveSubsystem driveSubsystem, PropertyFactory prop) {
        this.oi = oi;
        this.driveSubsystem = driveSubsystem;
        this.requires(this.driveSubsystem);
        prop.setPrefix(this);
        power = prop.createEphemeralProperty("power", 0);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveSubsystem.tankDrive(power.get()*0.25,power.get()*0.25);

    }

}
