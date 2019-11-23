package competition.subsystems.drive.commands;
import com.google.inject.Inject;

import competition.operator_interface.OperatorInterface;
import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.pose.PoseSubsystem;
import xbot.common.command.BaseCommand;

import xbot.common.math.PIDFactory;
import xbot.common.math.PIDManager;
import xbot.common.subsystems.drive.control_logic.HeadingModule;
import xbot.common.injection.wpi_factories.CommonLibFactory;

public class TurnAnyAngleCommand extends BaseCommand{
    final DriveSubsystem drive;
    final OperatorInterface oi;
    PIDManager pid;
    HeadingModule headingModule;
    double target_pos;
    

    @Inject
    public TurnAnyAngleCommand(OperatorInterface oi, DriveSubsystem driveSubsystem,PIDFactory pf,PoseSubsystem pose, CommonLibFactory clf) {
        this.oi = oi;
        this.drive = driveSubsystem;
        this.requires(this.drive);

        pid = pf.createPIDManager("Rotate");
        pid.setP(1);
        headingModule = clf.createHeadingModule(pid);

        pid.setEnableErrorThreshold(true); // Turn on distance checking
        pid.setErrorThreshold(0.1);
        pid.setEnableDerivativeThreshold(true); // Turn on speed checking
        pid.setDerivativeThreshold(0.1);

        // manually adjust these values to adjust the action
        pid.setP(1);
        pid.setD(4.2);
    }


    @Override
    public void initialize() {
        pid.reset();
    }

    @Override
    public void execute() {
        double power = headingModule.calculateHeadingPower(target_pos);
        drive.tankDrive(-1 * power, power);
    }

    @Override
    public boolean isFinished() {
        return pid.isOnTarget();
    }

}