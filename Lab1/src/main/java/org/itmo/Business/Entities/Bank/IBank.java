/**
 * The IBank interface represents a bank in the banking system.
 */
package org.itmo.Business.Entities.Bank;

import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Models.Records.AccountCreationRecord;
import org.itmo.Business.Models.Records.ClientCreationRecord;
import org.itmo.Business.Models.Records.DeclineTransactionRecord;
import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The IBank interface represents a bank in the banking system.
 */
public interface IBank {

    /**
     * Accrues interest on accounts.
     */
    void accrueInterest();

    /**
     * Charges fees on accounts.
     */
    void chargeFee();

    /**
     * Creates a new client with the provided client creation record.
     * @param data The client creation record.
     * @return A string representing the result of the operation.
     */
    String createClient(ClientCreationRecord data);

    /**
     * Creates a new account with the provided account creation record.
     * @param data The account creation record.
     */
    void createAccount(AccountCreationRecord data);

    /**
     * Makes a transaction using the provided transaction data.
     * @param data The transaction data.
     * @param verified Indicates whether the transaction is verified.
     */
    void makeTransaction(LogCreationRecord data, boolean verified);

    /**
     * Declines a transaction with the provided decline transaction record.
     * @param data The decline transaction record.
     */
    void declineTransaction(DeclineTransactionRecord data);

    /**
     * Sets a new credit account commission.
     * @param commission The new commission amount.
     */
    void newCreditAccountCommission(BigDecimal commission);

    /**
     * Sets a new credit limit.
     * @param limit The new credit limit.
     */
    void newCreditLimit(BigDecimal limit);

    /**
     * Sets a new debit interest rate.
     * @param interest The new interest rate.
     */
    void newDebitInterest(BigDecimal interest);

    /**
     * Sets a new deposit interest rate.
     * @param interest The new interest rate.
     */
    void newDepositInterest(BigDecimal interest);

    /**
     * Sets a new maximum unverified transaction sum.
     * @param maxSum The new maximum sum.
     */
    void newMaxUnverifiedTransactionSum(BigDecimal maxSum);

    /**
     * Checks if the bank matches the specified bank ID.
     * @param bankID The bank ID to check.
     * @return True if the bank matches the bank ID, otherwise false.
     */
    boolean checkByBankID(int bankID);

    /**
     * Displays account logs for the specified account and client IDs.
     * @param accountID The account ID.
     * @param clientID The client ID.
     * @return A string representing the account logs.
     */
    String displayAccountLogs(int accountID, int clientID);

    /**
     * Retrieves the client with the specified client ID.
     * @param clientID The client ID.
     * @return The client object.
     */
    IClient getClient(int clientID);

    /**
     * Accelerates time for the specified client and account IDs.
     * @param clientID The client ID.
     * @param accountID The account ID.
     * @param today The current date.
     * @param endDay The end date.
     * @return A string representing the result of the operation.
     */
    String accelerateTime(int clientID, int accountID, Date today, Date endDay);
}