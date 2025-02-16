/**
 * The CreateClientCommand class represents a command for creating a new client in a bank.
 * It extends the BankCommand class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Models.Records.ClientCreationRecord;

import java.util.Scanner;

/**
 * The CreateClientCommand class represents a command for creating a new client in a bank.
 * It extends the BankCommand class.
 */
public class CreateClientCommand extends BankCommand {

    /**
     * Constructs a CreateClientCommand object with the specified input scanner and bank.
     *
     * @param input The scanner object for input.
     * @param bank  The bank in which to create the client.
     */
    public CreateClientCommand(Scanner input, IBank bank) {
        name = "CreateClient";
        this.bank = bank;
        this.input = input;
    }

    /**
     * Runs the command to create a new client in the bank, taking input from the user and
     * invoking the createClient method on the bank.
     */
    @Override
    public void run() {
        System.out.print("Print in order separating by enters: nameSurname " +
                "address " +
                "passport " +
                "receivingUpdates " +
                "updates\n");
        String nameSurname = input.next();
        String address = input.next();
        String passport = input.next();
        boolean receivingUpdates = input.nextBoolean();
        String updates = input.next();
        System.out.print(bank.createClient(new ClientCreationRecord(0, 0, nameSurname, address, passport, false, receivingUpdates, updates)));
    }
}
