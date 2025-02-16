/**
 * The LogInCommand class represents a command for logging in.
 * It extends the Command class.
 */
package org.itmo.Presentation.Commands.AuthenticationActions;

import org.itmo.Data.IDatabase;
import org.itmo.Presentation.Commands.Command;
import org.itmo.Presentation.Commands.CommandLoader.ICommandLoader;
import org.itmo.Presentation.Commands.ICommand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The LogInCommand class represents a command for logging in.
 * It extends the Command class.
 */
public class LogInCommand extends Command {

    /** The list of user commands available after logging in. */
    private ArrayList<ICommand> userCommands;

    /** The database used for authentication. */
    protected IDatabase database;

    /** The command loader responsible for loading user-specific commands. */
    private ICommandLoader commandLoader;

    /**
     * Constructs a LogInCommand with the specified scanner input, list of user commands, database, and command loader.
     * @param input The scanner input for user interaction.
     * @param userCommands The list of user commands available after logging in.
     * @param database The database used for authentication.
     * @param commandLoader The command loader responsible for loading user-specific commands.
     */
    public LogInCommand(Scanner input, ArrayList<ICommand> userCommands, IDatabase database, ICommandLoader commandLoader) {
        name = "LogIn";
        this.userCommands = userCommands;
        this.commandLoader = commandLoader;
        this.database = database;
        this.input = input;
    }

    /**
     * Runs the LogInCommand, prompting the user to log in as CentralBank, Bank, or Client, and loading user-specific commands accordingly.
     */
    @Override
    public void run() {
        System.out.print("Log in as:\nCentralBank - 1\nBank - 2\nClient - 3");
        int answer = input.nextInt();
        switch (answer){
            case 1:
                commandLoader.getCentralBankCommands(userCommands);
                commandLoader.setCentralBankUser(database.getCentralBank());
            case 2:
                System.out.print("Input bankID\n");
                int bankID = input.nextInt();
                commandLoader.getBankCommands(userCommands);
                commandLoader.setBankUser(database.getCentralBank().getBank(bankID));
            case 3:
                System.out.print("Input separated with enters: bankID, clientID\n");
                bankID = input.nextInt();
                int clientID = input.nextInt();
                commandLoader.getClientCommands(userCommands);
                commandLoader.setClientUser(database.getCentralBank().getBank(bankID).getClient(clientID));
        }
    }
}
