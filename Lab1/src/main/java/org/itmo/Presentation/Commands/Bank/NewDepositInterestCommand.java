/**
 * The NewDepositInterestCommand class represents a command for setting a new deposit interest rate for a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The NewDepositInterestCommand class represents a command for setting a new deposit interest rate for a bank.
 * It extends the BankCommand class.
 */
public class NewDepositInterestCommand extends BankCommand {

    /**
     * Constructs a NewDepositInterestCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank for which to set the new deposit interest rate.
     */
    public NewDepositInterestCommand(Scanner input, IBank bank){
        name = "NewDepositInterest";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to set a new deposit interest rate for the bank, taking input from the user and
     * invoking the newDepositInterest method on the bank.
     */
    @Override
    public void run(){
        System.out.print("Print newDepositInterest\n");
        BigDecimal interest = input.nextBigDecimal();
        bank.newDepositInterest(interest);
    }
}