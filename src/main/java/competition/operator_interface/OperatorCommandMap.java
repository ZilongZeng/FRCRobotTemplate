package competition.operator_interface;

import java.util.ArrayList;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import competition.subsystems.drive.commands.ArcadeDriveCommand;
import competition.subsystems.drive.commands.DrivetoPosition;
import competition.subsystems.drive.commands.MoveBackwardsCommand;
import competition.subsystems.drive.commands.TankDriveWithJoysticksCommand;
import competition.subsystems.drive.commands.TurnAnyAngleCommand;
import edu.wpi.first.wpilibj.command.Command;
import xbot.common.command.SimpleCommandGroup;
import xbot.common.command.SimpleCommandGroup.ExecutionType;

@Singleton
public class OperatorCommandMap {

    // For mapping operator interface buttons to commands

    // Example for setting up a command to fire when a button is pressed:
    /*
     * @Inject public void setupMyCommands( OperatorInterface operatorInterface,
     * MyCommand myCommand) {
     * operatorInterface.leftButtons.getifAvailable(1).whenPressed(myCommand); }
     */

    @Inject
    public void simplecommands(TankDriveWithJoysticksCommand forward, MoveBackwardsCommand backwards,
            ArcadeDriveCommand arcade, OperatorInterface oi) {
        oi.gamepad.getifAvailable(1).whenPressed(arcade);
        oi.gamepad.getifAvailable(2).whenPressed(forward);
        forward.includeOnSmartDashboard("forward");
        backwards.includeOnSmartDashboard("backward");
    }

    @Inject
    public void setupAutoCommands(
        OperatorInterface oi,
        Provider<TurnAnyAngleCommand> angleProvider,
        DrivetoPosition goStraight_1
    ) {
        TurnAnyAngleCommand left90_1 = angleProvider.get();
        left90_1.setGoal(-90);

        var commands = new ArrayList<Command>();
        commands.add(left90_1);
        commands.add(goStraight_1);

        SimpleCommandGroup auto = new SimpleCommandGroup("Auto", commands, ExecutionType.Serial);

        oi.gamepad.getifAvailable(3).whenPressed(auto);
    }
}
