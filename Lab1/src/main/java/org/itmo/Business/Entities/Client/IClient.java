/**
 * The IClient interface represents a client in the banking system.
 */
package org.itmo.Business.Entities.Client;

import org.itmo.Business.Models.Records.AccountCreationRecord;
import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The IClient interface represents a client in the banking system.
 */
public interface IClient {

    /**
     * Replenishes the specified account with the given sum.
     * @param accountID The ID of the account to replenish.
     * @param sum The amount to replenish.
     */
    void accountReplenishment(int accountID, BigDecimal sum);

    /**
     * Checks the messages for the client.
     * @return A string containing the messages.
     */
    String checkMessages();

    /**
     * Receives a message and processes it.
     * @param message The message to receive.
     */
    void receiveMessage(String message);

    /**
     * Creates a new account for the client.
     * @param data The account creation record.
     * @return A string representing the result of the operation.
     */
    String createAccount(AccountCreationRecord data);

    /**
     * Withdraws the specified sum from the given account.
     * @param accountID The ID of the account to withdraw from.
     * @param sum The amount to withdraw.
     */
    void withdrawal(int accountID, BigDecimal sum);

    /**
     * Makes a transaction based on the provided log creation record.
     * @param logCreationRecord The log creation record for the transaction.
     */
    void makeTransaction(LogCreationRecord logCreationRecord);

    /**
     * Checks if the client belongs to the specified bank ID.
     * @param bankID The bank ID to check.
     * @return True if the client belongs to the bank, false otherwise.
     */
    boolean checkByBankID(int bankID);

    /**
     * Checks if the client has the specified client ID.
     * @param clientID The client ID to check.
     * @return True if the client has the specified ID, false otherwise.
     */
    boolean checkByClientID(int clientID);

    /**
     * Displays the client's information including accounts and logs.
     * @return A string representing the client's information.
     */
    String displayClient();

    /**
     * Accelerates time for the specified account within the given range of dates.
     * @param accountID The ID of the account.
     * @param today The current date.
     * @param endDay The end date for acceleration.
     * @return A string representing the result of accelerating time.
     */
    String accelerateTime(int accountID, Date today, Date endDay);
}