/**
 * The LogOutCommand class represents a command for logging out.
 * It extends the Command class.
 */
package org.itmo.Presentation.Commands.AuthenticationActions;

import org.itmo.Presentation.Commands.Command;
import org.itmo.Presentation.Commands.ICommand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The LogOutCommand class represents a command for logging out.
 * It extends the Command class.
 */
public class LogOutCommand extends Command {

    /** The list of user commands available after logging out. */
    private ArrayList<ICommand> userCommands;

    /** A boolean indicating whether the user is logged in. */
    private boolean logged;

    /**
     * Constructs a LogOutCommand with the specified scanner input, list of user commands, and login status.
     * @param input The scanner input for user interaction.
     * @param userCommands The list of user commands available after logging out.
     * @param logged A boolean indicating whether the user is logged in.
     */
    public LogOutCommand(Scanner input, ArrayList<ICommand> userCommands, boolean logged) {
        name = "LogOut";
        this.userCommands = userCommands;
        this.logged = logged;
        this.input = input;
    }

    /**
     * Runs the LogOutCommand, clearing the user commands list, updating the login status, and displaying a log out message.
     */
    @Override
    public void run() {
        userCommands.clear();
        userCommands.add(this);
        logged = false;
        System.out.print("You logged out\n");
    }
}