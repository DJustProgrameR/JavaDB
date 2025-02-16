/**
 * The NewCreditAccountCommissionCommand class represents a command for setting a new commission for credit accounts in a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The NewCreditAccountCommissionCommand class represents a command for setting a new commission for credit accounts in a bank.
 * It extends the BankCommand class.
 */
public class NewCreditAccountCommissionCommand extends BankCommand {

    /**
     * Constructs a NewCreditAccountCommissionCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank for which to set the new credit account commission.
     */
    public NewCreditAccountCommissionCommand(Scanner input, IBank bank){
        name = "NewCreditAccountCommission";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to set a new commission for credit accounts in the bank, taking input from the user and
     * invoking the newCreditAccountCommission method on the bank.
     */
    @Override
    public void run(){
        System.out.print("Print newCreditAccountCommission\n");
        BigDecimal commission = input.nextBigDecimal();
        bank.newCreditAccountCommission(commission);
    }
}