/**
 * The DisplayAccountLogsCommand class represents a command for displaying account logs of a client.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;

import java.util.Scanner;

/**
 * The DisplayAccountLogsCommand class represents a command for displaying account logs of a client.
 * It extends the ClientCommand class.
 */
public class DisplayAccountLogsCommand extends ClientCommand {

    /**
     * Constructs a DisplayAccountLogsCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client whose account logs will be displayed.
     */
    public DisplayAccountLogsCommand(Scanner input, IClient client){
        name = "DisplayAccountLogs";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the display account logs command, invoking the displayClient method on the client
     * to retrieve and display the account logs.
     */
    @Override
    public void run(){
        System.out.print(client.displayClient());
    }
}