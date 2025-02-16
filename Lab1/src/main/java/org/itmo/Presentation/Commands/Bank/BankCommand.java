/**
 * The BankCommand class is a base class for commands related to bank operations.
 * It extends the Command class.
 */
package org.itmo.Presentation.Commands.Bank;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Presentation.Commands.Command;

/**
 * The BankCommand class is a base class for commands related to bank operations.
 * It extends the Command class.
 */
public class BankCommand extends Command {

    /** The bank instance associated with the command. */
    protected IBank bank;
}