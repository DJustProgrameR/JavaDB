/**
 * The AccrueInterestNotificationCommand class represents a command for notifying the central bank to accrue interest.
 * It extends the CentralBankCommand class.
 */
package org.itmo.Presentation.Commands.CentralBank;

import org.itmo.Business.Entities.CentralBank.ICentralBank;

import java.util.Scanner;

/**
 * The AccrueInterestNotificationCommand class represents a command for notifying the central bank to accrue interest.
 * It extends the CentralBankCommand class.
 */
public class AccrueInterestNotificationCommand extends CentralBankCommand {

    /**
     * Constructs an AccrueInterestNotificationCommand object with the specified input scanner and central bank.
     *
     * @param input       The scanner object for input.
     * @param centralBank The central bank responsible for accruing interest.
     */
    public AccrueInterestNotificationCommand(Scanner input, ICentralBank centralBank){
        name = "AccureInterestNotification";
        this.centralBank = centralBank;
        this.input = input;
    }

    /**
     * Runs the accrue interest notification command, invoking the accrueInterestNotification method on the central bank
     * to notify it to accrue interest.
     */
    @Override
    public void run(){
        centralBank.accrueInterestNotification();
    }
}