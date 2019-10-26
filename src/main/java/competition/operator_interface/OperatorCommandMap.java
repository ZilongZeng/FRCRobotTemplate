package competition.operator_interface;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.drive.commands.MoveBackwardsCommand;
import competition.subsystems.drive.commands.TankDriveWithJoysticksCommand;

@Singleton
public class OperatorCommandMap {
    // For mapping operator interface buttons to commands

    // Example for setting up a command to fire when a button is pressed:
    /*
    @Inject
    public void setupMyCommands(
            OperatorInterface operatorInterface,
            MyCommand myCommand)
    {
        operatorInterface.leftButtons.getifAvailable(1).whenPressed(myCommand);
    }
    */

    @Inject 
    public void simplecommands(TankDriveWithJoysticksCommand forward, MoveBackwardsCommand backwards) {
        forward.includeOnSmartDashboard("forward");
        backwards.includeOnSmartDashboard("backward");
    }
}
