/**
 * The DeclineTransactionCommand class represents a command for declining a transaction in a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Models.Records.DeclineTransactionRecord;

import java.util.Scanner;

/**
 * The DeclineTransactionCommand class represents a command for declining a transaction in a bank.
 * It extends the BankCommand class.
 */
public class DeclineTransactionCommand extends BankCommand {

    /**
     * Constructs a DeclineTransactionCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank in which to decline the transaction.
     */
    public DeclineTransactionCommand(Scanner input, IBank bank) {
        name = "DeclineTransaction";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to decline a transaction in the bank, taking input from the user and
     * invoking the declineTransaction method on the bank.
     */
    @Override
    public void run() {
        System.out.print("Print in order separating by enters: logID1 " +
                "accountID1 " +
                "clientID1 " +
                "logID2 " +
                "accountID2 " +
                "clientID2 " + "\n");
        int logID1 = input.nextInt();
        int accountID1 = input.nextInt();
        int clientID1 = input.nextInt();
        int logID2 = input.nextInt();
        int accountID2 = input.nextInt();
        int clientID2 = input.nextInt();
        bank.declineTransaction(new DeclineTransactionRecord(logID1, accountID1, clientID1, logID2, accountID2, clientID2));
    }
}