/**
 * The Client class represents a client entity.
 * It implements the IClient interface.
 */
package org.itmo.Business.Entities.Client;

import org.itmo.Business.Entities.Account.IAccount;
import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Models.Records.AccountCreationRecord;
import org.itmo.Business.Models.Records.ClientCreationRecord;
import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Client class represents a client entity.
 * It implements the IClient interface.
 */
public class Client implements IClient {

    /** The number of accounts associated with the client. */
    private int amountOfAccounts;

    /** The ID of the client. */
    private int clientID;

    /** The ID of the bank associated with the client. */
    private int bankID;

    /** The name and surname of the client. */
    private String nameSurname;

    /** The address of the client. */
    private String address;

    /** The passport information of the client. */
    private String passport;

    /** Indicates whether the client is verified. */
    private boolean verified;

    /** Indicates whether the client is receiving updates. */
    private boolean receivingUpdate;

    /** The updates received by the client. */
    private String updates;

    /** The owner bank of the client. */
    private IBank owner;

    /**
     * Constructs a Client object with the provided creation data, owner bank, and associated accounts.
     *
     * @param data     The creation data for the client.
     * @param owner    The owner bank of the client.
     * @param accounts The list of accounts associated with the client.
     */
    public Client(ClientCreationRecord data, IBank owner, ArrayList<IAccount> accounts) {
        amountOfAccounts = 0;
        clientID = data.clientID();
        bankID = data.bankID();
        nameSurname = data.nameSurname();
        address = data.address();
        passport = data.passport();
        verified = data.verified();
        receivingUpdate = data.receivingUpdates();
        updates = data.updates();
        this.owner = owner;
    }

    /**
     * Performs account replenishment.
     *
     * @param accountID The ID of the account.
     * @param sum       The amount to be replenished.
     */
    @Override
    public void accountReplenishment(int accountID, BigDecimal sum) {
        owner.makeTransaction(new LogCreationRecord(0,0,accountID, 0,clientID,0,bankID,false,sum), verified);
    }

    /**
     * Checks messages received by the client.
     *
     * @return A string containing the updates received by the client.
     */
    @Override
    public String checkMessages() {
        return updates + '\n';
    }

    /**
     * Receives a message and updates the client's message log if receiving updates is enabled.
     *
     * @param message The message to be received.
     */
    @Override
    public void receiveMessage(String message) {
        if (receivingUpdate) {
            updates = updates.concat(message);
        }
    }

    /**
     * Creates a new account for the client.
     *
     * @param accountCreationRecord The creation record for the account.
     * @return                      A string containing information about the created account.
     */
    @Override
    public String createAccount(AccountCreationRecord accountCreationRecord) {
        amountOfAccounts++;

        owner.createAccount(new AccountCreationRecord(amountOfAccounts, clientID, 0, accountCreationRecord.accountType(), accountCreationRecord.balance(), accountCreationRecord.dateOfClosing()));

        return "accountID: " + amountOfAccounts + '\n';
    }

    /**
     * Performs a withdrawal from the client's account.
     *
     * @param accountID The ID of the account.
     * @param sum       The amount to be withdrawn.
     */
    @Override
    public void withdrawal(int accountID, BigDecimal sum) {
        owner.makeTransaction(new LogCreationRecord(0, accountID, 0, clientID, 0, bankID, 0, false, sum), verified);
    }

    /**
     * Makes a transaction for the client.
     *
     * @param logCreationRecord The creation record for the transaction log.
     */
    @Override
    public void makeTransaction(LogCreationRecord logCreationRecord) {
        owner.makeTransaction(logCreationRecord, verified);
    }

    /**
     * Checks if the client matches the provided bank ID.
     *
     * @param bankID The bank ID to check against.
     * @return       True if the client matches the provided bank ID, otherwise false.
     */
    @Override
    public boolean checkByBankID(int bankID) {
        return this.bankID == bankID;
    }

    /**
     * Checks if the client matches the provided client ID.
     *
     * @param clientID The client ID to check against.
     * @return         True if the client matches the provided client ID, otherwise false.
     */
    @Override
    public boolean checkByClientID(int clientID) {
        return this.clientID == clientID;
    }

    /**
     * Accelerates time for the client's account and returns the result.
     *
     * @param accountID The ID of the account.
     * @param today     The current date.
     * @param endDay    The end date.
     * @return          A string containing the result of accelerating time for the client's account.
     */
    @Override
    public String accelerateTime(int accountID, Date today, Date endDay) {
        return owner.accelerateTime(clientID, accountID, today, endDay);
    }

    /**
     * Displays information about the client, including associated accounts and their logs.
     *
     * @return A string containing information about the client and associated accounts.
     */
    @Override
    public String displayClient() {
        String answer = new String("clientID: " + clientID +
                " bankID: " + bankID +
                " nameSurname: " + nameSurname +
                " address: " + address +
                " passport: " + passport +
                " verified: " + verified +
                " receivingUpdate: " + receivingUpdate + "\n\n");
        for (int i = 0; i < amountOfAccounts; i++) {
            answer = answer.concat(owner.displayAccountLogs(i + 1, clientID));
        }
        return answer;
    }
}
