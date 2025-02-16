/**
 * The CentralBankCommand class represents a command related to the central bank.
 * It extends the Command class.
 */
package org.itmo.Presentation.Commands.CentralBank;

import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Presentation.Commands.Command;

/**
 * The CentralBankCommand class represents a command related to the central bank.
 * It extends the Command class.
 */
public class CentralBankCommand extends Command {
    protected ICentralBank centralBank;
}