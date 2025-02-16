/**
 * The ChargeFeeNotificationCommand class represents a command for notifying the central bank to charge fees.
 * It extends the CentralBankCommand class.
 */
package org.itmo.Presentation.Commands.CentralBank;

import org.itmo.Business.Entities.CentralBank.ICentralBank;

import java.util.Scanner;

/**
 * The ChargeFeeNotificationCommand class represents a command for notifying the central bank to charge fees.
 * It extends the CentralBankCommand class.
 */
public class ChargeFeeNotificationCommand extends CentralBankCommand {

    /**
     * Constructs a ChargeFeeNotificationCommand object with the specified input scanner and central bank.
     *
     * @param input       The scanner object for input.
     * @param centralBank The central bank responsible for charging fees.
     */
    public ChargeFeeNotificationCommand(Scanner input, ICentralBank centralBank){
        name = "ChargeFeeNotification";
        this.centralBank = centralBank;
        this.input = input;
    }

    /**
     * Runs the charge fee notification command, invoking the chargeFeeNotification method on the central bank
     * to notify it to charge fees.
     */
    @Override
    public void run(){
        centralBank.chargeFeeNotification();
    }
}