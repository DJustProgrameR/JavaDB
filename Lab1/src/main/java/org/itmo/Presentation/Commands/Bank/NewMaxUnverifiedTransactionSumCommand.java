/**
 * The NewMaxUnverifiedTransactionSumCommand class represents a command for setting a new maximum unverified transaction sum for a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The NewMaxUnverifiedTransactionSumCommand class represents a command for setting a new maximum unverified transaction sum for a bank.
 * It extends the BankCommand class.
 */
public class NewMaxUnverifiedTransactionSumCommand extends BankCommand {

    /**
     * Constructs a NewMaxUnverifiedTransactionSumCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank for which to set the new maximum unverified transaction sum.
     */
    public NewMaxUnverifiedTransactionSumCommand(Scanner input, IBank bank){
        name = "NewMaxTransactionSum";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to set a new maximum unverified transaction sum for the bank, taking input from the user and
     * invoking the newMaxUnverifiedTransactionSum method on the bank.
     */
    @Override
    public void run(){
        System.out.print("Print newDepositInterest\n");
        BigDecimal interest = input.nextBigDecimal();
        bank.newMaxUnverifiedTransactionSum(interest);
    }
}