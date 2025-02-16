/**
 * The AccelerateTimeCommand class represents a command for accelerating time for a client's account.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;

import java.util.Date;
import java.util.Scanner;

/**
 * The AccelerateTimeCommand class represents a command for accelerating time for a client's account.
 * It extends the ClientCommand class.
 */
public class AccelerateTimeCommand extends ClientCommand{

    /**
     * Constructs an AccelerateTimeCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client whose account's time will be accelerated.
     */
    public AccelerateTimeCommand(Scanner input, IClient client){
        name = "AccelerateTime";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the accelerate time command, prompting the user for account ID, today's date, and end date,
     * and then invoking the accelerateTime method on the client to calculate the accelerated time.
     */
    @Override
    public void run(){
        System.out.print("Print in order separating by enters: accountID " +
                "data endDay\n");
        int accountID = input.nextInt();
        Date today = new Date(input.next());
        Date endDay = new Date(input.next());
        System.out.print(client.accelerateTime(accountID,today,endDay));
    }
}