package org.itmo.Presentation.Commands.CommandLoader;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;
import org.itmo.Data.IDatabase;
import org.itmo.Presentation.Commands.AuthenticationActions.LogInCommand;
import org.itmo.Presentation.Commands.AuthenticationActions.LogOutCommand;
import org.itmo.Presentation.Commands.Bank.*;
import org.itmo.Presentation.Commands.CentralBank.AccrueInterestNotificationCommand;
import org.itmo.Presentation.Commands.CentralBank.ChargeFeeNotificationCommand;
import org.itmo.Presentation.Commands.CentralBank.CreateBankCommand;
import org.itmo.Presentation.Commands.Client.*;
import org.itmo.Presentation.Commands.ICommand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The CommandLoader class implements the ICommandLoader interface and provides methods to load different types of commands
 * and set users for command execution.
 */
public class CommandLoader implements ICommandLoader {
    private IDatabase database;
    private ICentralBank centralBank;
    private IBank bank;
    private IClient client;
    private Scanner input;
    private ITimeAccelerationMechanism timeAccelerationMechanism;

    /**
     * Constructs a new CommandLoader object with the given database and time acceleration mechanism.
     *
     * @param database                  The database instance.
     * @param timeAccelerationMechanism The time acceleration mechanism instance.
     */
    public CommandLoader(IDatabase database, ITimeAccelerationMechanism timeAccelerationMechanism) {
        this.database = database;
        this.timeAccelerationMechanism = timeAccelerationMechanism;
    }

    @Override
    public ICommand getLogInCommand(ArrayList<ICommand> userCommands) {
        return new LogInCommand(input, userCommands, database, this);
    }

    @Override
    public ICommand getLogOutCommand(ArrayList<ICommand> userCommands, boolean logged) {
        return new LogOutCommand(input, userCommands, logged);
    }

    @Override
    public void getCentralBankCommands(ArrayList<ICommand> commands) {
        commands.add(new AccrueInterestNotificationCommand(input, centralBank));
        commands.add(new ChargeFeeNotificationCommand(input, centralBank));
        commands.add(new CreateBankCommand(input, centralBank, timeAccelerationMechanism));
    }

    @Override
    public void getBankCommands(ArrayList<ICommand> commands) {
        commands.add(new CreateClientCommand(input, bank));
        commands.add(new NewCreditAccountCommissionCommand(input, bank));
        commands.add(new NewCreditLimitCommand(input, bank));
        commands.add(new NewDebitInterestCommand(input, bank));
        commands.add(new NewDepositInterestCommand(input, bank));
        commands.add(new NewMaxUnverifiedTransactionSumCommand(input, bank));
    }

    @Override
    public void getClientCommands(ArrayList<ICommand> commands) {
        commands.add(new ReplenishmentCommand(input, client));
        commands.add(new TransferCommand(input, client));
        commands.add(new CheckMessagesCommand(input, client));
        commands.add(new CreateAccountCommand(input, client));
        commands.add(new DisplayAccountLogsCommand(input, client));
        commands.add(new WithdrawalCommand(input, client));
    }

    @Override
    public void setCentralBankUser(ICentralBank centralBank) {
        this.centralBank = centralBank;
    }

    @Override
    public void setBankUser(IBank bank) {
        this.bank = bank;
    }

    @Override
    public void setClientUser(IClient client) {
        this.client = client;
    }

    @Override
    public void setInput(Scanner scanner) {
        this.input = scanner;
    }
}