package competition.subsystems.drive.commands;
import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

import xbot.common.math.PIDFactory;
import xbot.common.math.PIDManager;
import xbot.common.math.ContiguousHeading;
import xbot.common.subsystems.drive.control_logic.HeadingModule;
import xbot.common.injection.wpi_factories.CommonLibFactory;

public class TurnAnyAngleCommand extends BaseCommand{
    final DriveSubsystem drive;
    final OperatorInterface oi;

    @Inject
    public TurnAnyAngleCommand(OperatorInterface oi, DriveSubsystem driveSubsystem) {
        this.oi = oi;
        this.drive = driveSubsystem;
        this.requires(this.drive);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        

    }

}