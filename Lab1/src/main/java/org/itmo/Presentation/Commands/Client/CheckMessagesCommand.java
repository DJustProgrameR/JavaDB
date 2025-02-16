/**
 * The CheckMessagesCommand class represents a command for checking messages for a client.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;

import java.util.Scanner;

/**
 * The CheckMessagesCommand class represents a command for checking messages for a client.
 * It extends the ClientCommand class.
 */
public class CheckMessagesCommand extends ClientCommand {

    /**
     * Constructs a CheckMessagesCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client whose messages will be checked.
     */
    public CheckMessagesCommand(Scanner input, IClient client){
        name = "CheckMessages";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the check messages command, invoking the checkMessages method on the client
     * to retrieve and display the messages.
     */
    @Override
    public void run(){
        System.out.print(client.checkMessages());
    }
}