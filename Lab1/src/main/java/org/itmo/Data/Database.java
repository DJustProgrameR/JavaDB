/**
 * The Database class represents a database storing accounts, clients, banks, and logs.
 * It implements the IDatabase interface.
 */
package org.itmo.Data;

import org.itmo.Business.Entities.Account.IAccount;
import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Entities.Log.ILog;

import java.util.ArrayList;

/**
 * The Database class represents a database storing accounts, clients, banks, and logs.
 * It implements the IDatabase interface.
 */
public class Database implements IDatabase {

    /** The list of logs stored in the database. */
    private ArrayList<ILog> logs;

    /** The list of accounts stored in the database. */
    private ArrayList<IAccount> accounts;

    /** The list of clients stored in the database. */
    private ArrayList<IClient> clients;

    /** The list of banks stored in the database. */
    private ArrayList<IBank> banks;

    /** The central bank stored in the database. */
    private ICentralBank centralBank;

    /**
     * Retrieves the list of accounts stored in the database.
     * @return The list of accounts.
     */
    @Override
    public ArrayList<IAccount> getAccounts() {
        return accounts;
    }

    /**
     * Retrieves the list of clients stored in the database.
     * @return The list of clients.
     */
    @Override
    public ArrayList<IClient> getClients() {
        return clients;
    }

    /**
     * Retrieves the list of banks stored in the database.
     * @return The list of banks.
     */
    @Override
    public ArrayList<IBank> getBanks() {
        return banks;
    }

    /**
     * Retrieves an account based on the client ID and account ID.
     * @param clientID The ID of the client.
     * @param accountID The ID of the account.
     * @return The account corresponding to the given IDs.
     * @throws RuntimeException if no account is found with the given IDs.
     */
    @Override
    public IAccount getAccountByIDs(int clientID, int accountID) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).checkByIDs(clientID, accountID)) {
                return accounts.get(i);
            }
        }
        throw new RuntimeException();
    }

    /**
     * Retrieves a client based on the client ID.
     * @param clientID The ID of the client.
     * @return The client corresponding to the given ID.
     * @throws RuntimeException if no client is found with the given ID.
     */
    @Override
    public IClient getClientByID(int clientID) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).checkByClientID(clientID)) {
                return clients.get(i);
            }
        }
        throw new RuntimeException();
    }

    /**
     * Retrieves a bank based on the bank ID.
     * @param bankID The ID of the bank.
     * @return The bank corresponding to the given ID.
     * @throws RuntimeException if no bank is found with the given ID.
     */
    @Override
    public IBank getBankByBankID(int bankID) {
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).checkByBankID(bankID)) {
                return banks.get(i);
            }
        }
        throw new RuntimeException();
    }

    /**
     * Retrieves the central bank stored in the database.
     * @return The central bank.
     */
    @Override
    public ICentralBank getCentralBank() {
        return centralBank;
    }

    /**
     * Adds a new account to the database.
     * @param account The account to be added.
     */
    @Override
    public void addNewAccount(IAccount account) {
        accounts.add(account);
    }

    /**
     * Adds a new client to the database.
     * @param client The client to be added.
     */
    @Override
    public void addNewClient(IClient client) {
        clients.add(client);
    }

    /**
     * Adds a new bank to the database.
     * @param bank The bank to be added.
     */
    @Override
    public void addNewBank(IBank bank) {
        banks.add(bank);
    }

    /**
     * Adds the central bank to the database.
     * @param centralBank The central bank to be added.
     */
    @Override
    public void addCentralBank(ICentralBank centralBank) {
        this.centralBank = centralBank;
    }
}