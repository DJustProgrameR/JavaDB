package org.itmo.Data;

import org.itmo.Business.Entities.Account.IAccount;
import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Entities.Client.IClient;

import java.util.ArrayList;

/**
 * The IDatabase interface defines methods to interact with the database.
 */
public interface IDatabase {
    /**
     * Retrieves all accounts from the database.
     *
     * @return An ArrayList of IAccount objects representing all accounts in the database.
     */
    ArrayList<IAccount> getAccounts();

    /**
     * Retrieves all clients from the database.
     *
     * @return An ArrayList of IClient objects representing all clients in the database.
     */
    ArrayList<IClient> getClients();

    /**
     * Retrieves all banks from the database.
     *
     * @return An ArrayList of IBank objects representing all banks in the database.
     */
    ArrayList<IBank> getBanks();

    /**
     * Retrieves an account from the database based on the client ID and account ID.
     *
     * @param clientID  The ID of the client.
     * @param accountID The ID of the account.
     * @return An IAccount object representing the retrieved account.
     */
    IAccount getAccountByIDs(int clientID, int accountID);

    /**
     * Retrieves a client from the database based on the client ID.
     *
     * @param clientID The ID of the client.
     * @return An IClient object representing the retrieved client.
     */
    IClient getClientByID(int clientID);

    /**
     * Retrieves a bank from the database based on the bank ID.
     *
     * @param bankID The ID of the bank.
     * @return An IBank object representing the retrieved bank.
     */
    IBank getBankByBankID(int bankID);

    /**
     * Retrieves the central bank from the database.
     *
     * @return An ICentralBank object representing the central bank.
     */
    ICentralBank getCentralBank();

    /**
     * Adds a new account to the database.
     *
     * @param account The account to be added.
     */
    void addNewAccount(IAccount account);

    /**
     * Adds a new client to the database.
     *
     * @param client The client to be added.
     */
    void addNewClient(IClient client);

    /**
     * Adds a new bank to the database.
     *
     * @param bank The bank to be added.
     */
    void addNewBank(IBank bank);

    /**
     * Adds the central bank to the database.
     *
     * @param centralBank The central bank to be added.
     */
    void addCentralBank(ICentralBank centralBank);
}