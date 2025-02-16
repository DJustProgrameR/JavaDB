/**
 * The NewCreditLimitCommand class represents a command for setting a new credit limit for a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The NewCreditLimitCommand class represents a command for setting a new credit limit for a bank.
 * It extends the BankCommand class.
 */
public class NewCreditLimitCommand extends BankCommand {

    /**
     * Constructs a NewCreditLimitCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank for which to set the new credit limit.
     */
    public NewCreditLimitCommand(Scanner input, IBank bank){
        name = "NewCreditLimit";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to set a new credit limit for the bank, taking input from the user and
     * invoking the newCreditLimit method on the bank.
     */
    @Override
    public void run(){
        System.out.print("Print newCreditLimit\n");
        BigDecimal limit = input.nextBigDecimal();
        bank.newCreditLimit(limit);
    }
}