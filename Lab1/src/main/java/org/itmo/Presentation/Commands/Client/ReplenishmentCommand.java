/**
 * The ReplenishmentCommand class represents a command for replenishing funds to a client's account.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The ReplenishmentCommand class represents a command for replenishing funds to a client's account.
 * It extends the ClientCommand class.
 */
public class ReplenishmentCommand extends ClientCommand {

    /**
     * Constructs a ReplenishmentCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client to which funds will be replenished.
     */
    public ReplenishmentCommand(Scanner input, IClient client){
        name = "AccountReplenishment";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the replenishment command, prompting the user for account ID and replenishment amount,
     * and then invoking the accountReplenishment method on the client.
     */
    @Override
    public void run(){
        System.out.print("Print in order separating by enters: accountID sum\n");
        int accountID = input.nextInt();
        BigDecimal sum = input.nextBigDecimal();
        client.accountReplenishment(accountID, sum);
    }
}