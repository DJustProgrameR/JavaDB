/**
 * The CreateAccountCommand class represents a command for creating a new account for a client.
 * It extends the ClientCommand class.
 */
package org.itmo.Presentation.Commands.Client;

import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Models.AccountType;
import org.itmo.Business.Models.Records.AccountCreationRecord;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

/**
 * The CreateAccountCommand class represents a command for creating a new account for a client.
 * It extends the ClientCommand class.
 */
public class CreateAccountCommand extends ClientCommand {

    /**
     * Constructs a CreateAccountCommand object with the specified input scanner and client.
     *
     * @param input  The scanner object for input.
     * @param client The client for whom the account will be created.
     */
    public CreateAccountCommand(Scanner input, IClient client){
        name = "CreateAccount";
        this.client = client;
        this.input = input;
    }

    /**
     * Runs the create account command, prompting the user for account type, balance, and date of closing,
     * and then invoking the createAccount method on the client to create the account.
     */
    @Override
    public void run(){
        System.out.print("Print in order separating by enters: accountType " +
                "balance " +
                "dateOfClosing\n");
        String accountTypeString = input.next();
        AccountType accountType;
        switch (accountTypeString){
            case "Debit":
                accountType = AccountType.Debit;
            case "Deposit":
                accountType = AccountType.Deposit;
            default:
                accountType = AccountType.Credit;
        }
        BigDecimal balance = input.nextBigDecimal();
        Date dateOfClosing = new Date(input.next());
        System.out.print(client.createAccount(new AccountCreationRecord(0,0,0,accountType,balance,dateOfClosing)));
    }
}