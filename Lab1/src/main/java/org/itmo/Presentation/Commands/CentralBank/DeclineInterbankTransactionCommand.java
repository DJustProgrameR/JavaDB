/**
 * The DeclineInterbankTransactionCommand class represents a command for declining an interbank transaction.
 * It extends the CentralBankCommand class.
 */
package org.itmo.Presentation.Commands.CentralBank;

import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Models.Records.DeclineInterbankTransactionRecord;

import java.util.Scanner;

/**
 * The DeclineInterbankTransactionCommand class represents a command for declining an interbank transaction.
 * It extends the CentralBankCommand class.
 */
public class DeclineInterbankTransactionCommand extends CentralBankCommand {

    /**
     * Constructs a DeclineInterbankTransactionCommand object with the specified input scanner and central bank.
     *
     * @param input       The scanner object for input.
     * @param centralBank The central bank responsible for handling the transaction decline.
     */
    public DeclineInterbankTransactionCommand(Scanner input, ICentralBank centralBank){
        name = "DeclineInterbankTransaction";
        this.centralBank = centralBank;
        this.input = input;
    }

    /**
     * Runs the decline interbank transaction command, prompting the user for log IDs, account IDs,
     * client IDs, and bank IDs, and then invoking the declineInterbankTransaction method on the central bank
     * to decline the interbank transaction.
     */
    @Override
    public void run(){
        System.out.print("Print in order separating by enters: logID1 " +
                "accountID1 " +
                "clientID1 " +
                "bankID1 " +
                "logID2 " +
                "accountID2 " +
                "clientID2 " +
                "bankID2 " + "\n");
        int logID1 = input.nextInt();
        int accountID1 = input.nextInt();
        int clientID1 = input.nextInt();
        int bankID1 = input.nextInt();
        int logID2 = input.nextInt();
        int accountID2 = input.nextInt();
        int clientID2 = input.nextInt();
        int bankID2 = input.nextInt();
        centralBank.declineInterbankTransaction(new DeclineInterbankTransactionRecord(logID1,accountID1,clientID1,bankID1,logID2,accountID2,clientID2, bankID2));
    }
}