/**
 * The Account class represents a bank account entity.
 * It implements the IAccount interface.
 */
package org.itmo.Business.Entities.Account;

import org.itmo.Business.Entities.Log.ILog;
import org.itmo.Business.Entities.Log.Log;
import org.itmo.Business.Models.AccountStatus;
import org.itmo.Business.Models.AccountType;
import org.itmo.Business.Models.Records.AccountCreationRecord;
import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Account class represents a bank account entity.
 * It implements the IAccount interface.
 */
public class Account implements IAccount {

    /** List of logs associated with this account. */
    private ArrayList<ILog> logs;

    /** The ID of the account. */
    private int accountID;

    /** The ID of the client associated with this account. */
    private int clientID;

    /** The ID of the bank associated with this account. */
    private int bankID;

    /** The type of the account. */
    private AccountType accountType;

    /** The current balance of the account. */
    private BigDecimal balance;

    /** The date when the account was closed. */
    private Date dateOfClosing;

    /** Additional amount associated with the account. */
    private BigDecimal additionalAmount;

    /**
     * Constructs an Account object with the provided creation data and logs.
     *
     * @param data The creation data for the account.
     * @param logs The list of logs associated with the account.
     */
    public Account(AccountCreationRecord data, ArrayList<ILog> logs) {
        this.logs = logs;
        accountID = data.accountID();
        clientID = data.clientID();
        bankID = data.bankID();
        accountType = data.accountType();
        balance = data.balance();
        dateOfClosing = data.dateOfClosing();
        additionalAmount = new BigDecimal(0);
    }

    /**
     * Displays the account information along with its logs.
     *
     * @return A string representing the account information.
     */
    @Override
    public String displayAccount() {
        String answer = new String("accountID: " + accountID +
                " accountType: " + accountType +
                " balance: " + balance +
                " dateOfClosing: " + dateOfClosing +
                " additionalAmount: " + additionalAmount + "\n\n");
        for (int i = 0; i < logs.size(); i++) {
            answer = answer.concat(logs.get(i).displayLog());
        }
        answer = answer.concat("\n");
        return answer;
    }

    /**
     * Makes a transaction and adds a log to the account.
     *
     * @param data The creation data for the log.
     */
    @Override
    public void makeTransaction(LogCreationRecord data) {
        logs.add(new Log(data));
    }

    /**
     * Checks if a transaction is valid based on specific criteria.
     *
     * @param data                      The creation data for the log.
     * @param maxUnverifiedTransactionSum  The maximum sum allowed for unverified transactions.
     * @param creditAccountLimit        The credit account limit.
     * @param verified                  Indicates if the transaction is verified.
     * @return                          True if the transaction is valid, false otherwise.
     */
    @Override
    public boolean checkTransaction(LogCreationRecord data, BigDecimal maxUnverifiedTransactionSum, BigDecimal creditAccountLimit, boolean verified) {
        if (accountID == data.fromAccountID() && clientID == data.fromClientID() && bankID == data.fromBankID()) {
            if (accountType == AccountType.Deposit) {
                return false;
            }
            if (!verified && data.sum().compareTo(maxUnverifiedTransactionSum) > 0) {
                return false;
            }
            if (accountType == AccountType.Debit && balance.compareTo(data.sum()) < 0) {
                return false;
            }
            if (accountType == AccountType.Credit && balance.add(data.sum().negate()).compareTo(creditAccountLimit) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Declines a transaction based on the provided log ID and sign.
     *
     * @param logID The ID of the log to decline.
     * @param sign  The sign indicating the transaction direction.
     */
    @Override
    public void declineTransaction(int logID, int sign) {
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).checkByID(logID)) {
                logs.get(i).decline();
                if (sign > 0) {
                    balance.add(logs.get(i).getSum());
                } else {
                    balance.add(logs.get(i).getSum().negate());
                }
            }
        }
    }

    /**
     * Checks if the account belongs to a specific client.
     *
     * @param clientID The ID of the client to check against.
     * @return         True if the account belongs to the client, false otherwise.
     */
    @Override
    public boolean checkByClientID(int clientID) {
        return this.clientID == clientID;
    }

    /**
     * Checks if the account matches the provided client and account IDs.
     *
     * @param clientID  The ID of the client to check against.
     * @param accountID The ID of the account to check against.
     * @return          True if the account matches both IDs, false otherwise.
     */
    @Override
    public boolean checkByIDs(int clientID, int accountID) {
        return this.clientID == clientID && this.accountID == accountID;
    }

    /**
     * Accrues debit interest to the account.
     *
     * @param interest The interest rate to be applied.
     */
    @Override
    public void accrueDebitInterest(BigDecimal interest) {
        if(accountType==AccountType.Debit){
            additionalAmount.add(balance.multiply(interest));
        }
    }

    /**
     * Accrues deposit interest to the account.
     *
     * @param interest The interest rate to be applied.
     */
    @Override
    public void accrueDepositInterest(BigDecimal interest) {
        if(accountType==AccountType.Deposit) {
            additionalAmount.add(balance.multiply(interest));
        }
    }

    /**
     * Charges a fee to the account if it is a credit account with a negative balance.
     *
     * @param fee The fee amount to be charged.
     */
    @Override
    public void chargeFee(BigDecimal fee) {
        if(accountType==AccountType.Credit && balance.compareTo(new BigDecimal(0))<0) {
            balance.add(fee.negate());
        }
    }

    /**
     * Retrieves the current status of the account.
     *
     * @param debitInterest  The accrued debit interest.
     * @param depositInterest  The accrued deposit interest.
     * @param creditFee  The charged credit fee.
     * @return  The status of the account.
     */
    @Override
    public AccountStatus getStatus(BigDecimal debitInterest, BigDecimal depositInterest, BigDecimal creditFee) {
        return new AccountStatus(accountType,balance,dateOfClosing,additionalAmount,debitInterest,depositInterest,creditFee);
    }

    /**
     * Displays logs associated with the account.
     *
     * @return  A string containing logs associated with the account.
     */
    private String displayLogs() {
        String answer = "";
        for (int i = 0; i < logs.size(); i++) {
            answer += logs.get(i).displayLog();
        }
        return answer;
    }
}
