/**
 * The CreateBankCommand class represents a command for creating a new bank.
 * It extends the CentralBankCommand class.
 */
package org.itmo.Presentation.Commands.CentralBank;

import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Models.Records.BankCreationRecord;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * The CreateBankCommand class represents a command for creating a new bank.
 * It extends the CentralBankCommand class.
 */
public class CreateBankCommand extends CentralBankCommand {

    private ITimeAccelerationMechanism timeAccelerationMechanism;

    /**
     * Constructs a CreateBankCommand object with the specified input scanner, central bank, and time acceleration mechanism.
     *
     * @param input                     The scanner object for input.
     * @param centralBank               The central bank responsible for creating the new bank.
     * @param timeAccelerationMechanism The time acceleration mechanism for the bank.
     */
    public CreateBankCommand(Scanner input, ICentralBank centralBank, ITimeAccelerationMechanism timeAccelerationMechanism){
        name = "CreateBank";
        this.centralBank = centralBank;
        this.input = input;
        this.timeAccelerationMechanism = timeAccelerationMechanism;
    }

    /**
     * Runs the create bank command, prompting the user for bank creation parameters such as interest rates, limits, and transaction sums,
     * and then invoking the createBank method on the central bank to create the new bank.
     */
    @Override
    public void run(){
        System.out.print("Print in order separating by enters: debitAccountInterest " +
                "depositAccountInterest " +
                "creditAccountLimit " +
                "creditAccountCommission " +
                "maxUnverifiedTransactionSum\n");
        BigDecimal debitAccountInterest = input.nextBigDecimal();
        BigDecimal depositAccountInterest = input.nextBigDecimal();
        BigDecimal creditAccountLimit = input.nextBigDecimal();
        BigDecimal creditAccountCommission = input.nextBigDecimal();
        BigDecimal maxUnverifiedTransactionSum = input.nextBigDecimal();
        System.out.print(centralBank.createBank(new BankCreationRecord(0,debitAccountInterest,depositAccountInterest,creditAccountLimit,creditAccountCommission,maxUnverifiedTransactionSum), timeAccelerationMechanism));
    }
}
