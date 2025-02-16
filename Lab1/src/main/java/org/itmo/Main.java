package org.itmo;

import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Services.Builders.CentralBank.CentralBankBuilder;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;
import org.itmo.Business.Services.TimeAccelerationMechanism.TimeAccelerationMechanism;
import org.itmo.Data.Database;
import org.itmo.Data.IDatabase;
import org.itmo.Presentation.Commands.CommandLoader.CommandLoader;
import org.itmo.Presentation.Commands.CommandLoader.ICommandLoader;
import org.itmo.Presentation.Console.Console;
import org.itmo.Presentation.Console.IConsole;

/**
 * The Main class serves as the entry point of the application.
 * It initializes the necessary components and starts the console session.
 */
public class Main {

    /**
     * The main method initializes the components and starts the console session.
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Create an instance of the database
        IDatabase database = new Database();

        // Create an instance of the central bank and add it to the database
        ICentralBank centralBank = new CentralBankBuilder().build();
        database.addCentralBank(centralBank);

        // Create an instance of the time acceleration mechanism
        ITimeAccelerationMechanism timeAccelerationMechanism = new TimeAccelerationMechanism();

        // Create an instance of the command loader
        ICommandLoader commandLoader = new CommandLoader(database, timeAccelerationMechanism);

        // Create an instance of the console and start the console session
        IConsole console = new Console(commandLoader);
        console.startWork();
    }
}