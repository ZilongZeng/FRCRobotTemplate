package competition.subsystems.drive.commands;
import com.google.inject.Inject;

import competition.subsystems.drive.DriveSubsystem;
import xbot.common.command.BaseCommand;

import xbot.common.math.PIDManager;

public class DrivetoPosition extends BaseCommand {
    DriveSubsystem drive;
    public double target_Position;
    PIDManager pid;
    public double currentPosition;

    @Inject
    public DrivetoPosition(DriveSubsystem drive, double end_Distance) {
        this.drive = drive;
        this.requires(this.drive);
        this.target_Position = end_Distance;
    }

    @Override
    public void initialize() {
        pid.reset();
    }

    @Override
    public void execute() {
        //double currentPosition = drive.distanceSensor.getDistance();
        double power = pid.calculate(target_Position, currentPosition);
        drive.tankDrive(power, power);
    }
}
