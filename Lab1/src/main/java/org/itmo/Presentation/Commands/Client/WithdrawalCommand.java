/**
 * The WithdrawalCommand class represents a command for withdrawing funds from a client's account.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The WithdrawalCommand class represents a command for withdrawing funds from a client's account.
 * It extends the ClientCommand class.
 */
public class WithdrawalCommand extends ClientCommand {

    /**
     * Constructs a WithdrawalCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client from which funds will be withdrawn.
     */
    public WithdrawalCommand(Scanner input, IClient client){
        name = "Withdrawal";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the withdrawal command, prompting the user for account ID and withdrawal amount,
     * and then invoking the withdrawal method on the client.
     */
    @Override
    public void run(){
        System.out.print("Print separating by enters accountID sum\n");
        int accountID = input.nextInt();
        BigDecimal sum = input.nextBigDecimal();
        client.withdrawal(accountID, sum);
    }
}