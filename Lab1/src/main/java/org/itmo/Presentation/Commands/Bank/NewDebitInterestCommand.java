/**
 * The NewDebitInterestCommand class represents a command for setting a new debit interest rate for a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The NewDebitInterestCommand class represents a command for setting a new debit interest rate for a bank.
 * It extends the BankCommand class.
 */
public class NewDebitInterestCommand extends BankCommand {

    /**
     * Constructs a NewDebitInterestCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank for which to set the new debit interest rate.
     */
    public NewDebitInterestCommand(Scanner input, IBank bank){
        name = "NewDebitInterest";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to set a new debit interest rate for the bank, taking input from the user and
     * invoking the newDebitInterest method on the bank.
     */
    @Override
    public void run(){
        System.out.print("Print newDebitInterest\n");
        BigDecimal interest = input.nextBigDecimal();
        bank.newDebitInterest(interest);
    }
}