/**
 * The TransferCommand class represents a command for transferring funds between accounts.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The TransferCommand class represents a command for transferring funds between accounts.
 * It extends the ClientCommand class.
 */
public class TransferCommand extends ClientCommand {

    /**
     * Constructs a TransferCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client initiating the transfer.
     */
    public TransferCommand(Scanner input, IClient client){
        name = "AccountTransfer";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the transfer command, prompting the user for necessary information,
     * and then invoking the makeTransaction method on the client to perform the transfer.
     */
    @Override
    public void run(){
        System.out.print("Print in order separating by enters: fromAccountID toAccountID toClientID toBankID sum\n");
        int fromAccountID = input.nextInt();
        int toAccountID = input.nextInt();
        int toClientID = input.nextInt();
        int toBankID = input.nextInt();
        BigDecimal sum = input.nextBigDecimal();
        client.makeTransaction(new LogCreationRecord(0,fromAccountID,toAccountID,0,toClientID, 0,toBankID,false,sum));
    }
}