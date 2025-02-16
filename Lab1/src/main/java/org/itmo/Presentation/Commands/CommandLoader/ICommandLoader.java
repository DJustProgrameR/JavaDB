package org.itmo.Presentation.Commands.CommandLoader;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Presentation.Commands.ICommand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ICommandLoader interface provides methods to load different types of commands and set users for the command execution.
 */
public interface ICommandLoader {
    /**
     * Retrieves the LogInCommand and sets the user commands list.
     *
     * @param userCommands The ArrayList containing user commands.
     * @return The LogInCommand instance.
     */
    ICommand getLogInCommand(ArrayList<ICommand> userCommands);

    /**
     * Retrieves the LogOutCommand and sets the user commands list and the login status.
     *
     * @param userCommands The ArrayList containing user commands.
     * @param logged       The login status.
     * @return The LogOutCommand instance.
     */
    ICommand getLogOutCommand(ArrayList<ICommand> userCommands, boolean logged);

    /**
     * Retrieves commands specific to the central bank and adds them to the provided ArrayList.
     *
     * @param commands The ArrayList to which commands will be added.
     */
    void getCentralBankCommands(ArrayList<ICommand> commands);

    /**
     * Retrieves commands specific to a bank and adds them to the provided ArrayList.
     *
     * @param commands The ArrayList to which commands will be added.
     */
    void getBankCommands(ArrayList<ICommand> commands);

    /**
     * Retrieves commands specific to a client and adds them to the provided ArrayList.
     *
     * @param commands The ArrayList to which commands will be added.
     */
    void getClientCommands(ArrayList<ICommand> commands);

    /**
     * Sets the current user to the central bank.
     *
     * @param centralBank The central bank user.
     */
    void setCentralBankUser(ICentralBank centralBank);

    /**
     * Sets the current user to a bank.
     *
     * @param bank The bank user.
     */
    void setBankUser(IBank bank);

    /**
     * Sets the current user to a client.
     *
     * @param client The client user.
     */
    void setClientUser(IClient client);

    /**
     * Sets the input source for command execution.
     *
     * @param scanner The Scanner object for input.
     */
    void setInput(Scanner scanner);
}