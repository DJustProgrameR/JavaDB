/**
 * The IAccount interface represents an account in the banking system.
 */
package org.itmo.Business.Entities.Account;

import org.itmo.Business.Models.AccountStatus;
import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;

/**
 * The IAccount interface represents an account in the banking system.
 */
public interface IAccount {

    /**
     * Displays information about the account.
     * @return A string representing the account information.
     */
    String displayAccount();

    /**
     * Performs a transaction using the provided transaction data.
     * @param data The data of the transaction to be performed.
     */
    void makeTransaction(LogCreationRecord data);

    /**
     * Checks if a transaction is valid based on various factors such as the maximum unverified transaction sum,
     * credit account limit, and verification status.
     * @param data The transaction data.
     * @param maxUnverifiedTransactionSum The maximum unverified transaction sum allowed.
     * @param creditAccountLimit The credit account limit.
     * @param verified Indicates whether the transaction is verified.
     * @return True if the transaction is valid, otherwise false.
     */
    boolean checkTransaction(LogCreationRecord data, BigDecimal maxUnverifiedTransactionSum,
                             BigDecimal creditAccountLimit, boolean verified);

    /**
     * Declines a transaction with the specified log ID and sign.
     * @param logID The ID of the transaction log.
     * @param sign The sign of the transaction.
     */
    void declineTransaction(int logID, int sign);

    /**
     * Checks if the account belongs to the specified client.
     * @param clientID The ID of the client.
     * @return True if the account belongs to the client, otherwise false.
     */
    boolean checkByClientID(int clientID);

    /**
     * Checks if the account matches the specified client and account IDs.
     * @param clientID The ID of the client.
     * @param accountID The ID of the account.
     * @return True if the account matches the client and account IDs, otherwise false.
     */
    boolean checkByIDs(int clientID, int accountID);

    /**
     * Accrues debit interest on the account based on the provided interest rate.
     * @param interest The interest rate to accrue.
     */
    void accrueDebitInterest(BigDecimal interest);

    /**
     * Accrues deposit interest on the account based on the provided interest rate.
     * @param interest The interest rate to accrue.
     */
    void accrueDepositInterest(BigDecimal interest);

    /**
     * Charges a fee on the account.
     * @param fee The fee amount to be charged.
     */
    void chargeFee(BigDecimal fee);

    /**
     * Determines the status of the account based on debit interest, deposit interest, and credit fee.
     * @param debitInterest The debit interest rate.
     * @param depositInterest The deposit interest rate.
     * @param creditFee The credit fee.
     * @return The status of the account.
     */
    AccountStatus getStatus(BigDecimal debitInterest, BigDecimal depositInterest, BigDecimal creditFee);
}