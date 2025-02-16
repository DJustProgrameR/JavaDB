/**
 * The Log class represents a transaction log.
 */
package org.itmo.Business.Entities.Log;

import org.itmo.Business.Models.Records.LogCreationRecord;

import java.math.BigDecimal;

/**
 * The Log class represents a transaction log.
 */
public class Log implements ILog {

    /** The unique identifier of the log. */
    private int logID;

    /** The account ID of the sender. */
    private int fromAccountID;

    /** The account ID of the receiver. */
    private int toAccountID;

    /** The client ID of the sender. */
    private int fromClientID;

    /** The client ID of the receiver. */
    private int toClientID;

    /** The bank ID of the sender. */
    private int fromBankID;

    /** The bank ID of the receiver. */
    private int toBankID;

    /** Indicates whether the transaction was declined or not. */
    private boolean declined;

    /** The amount of money involved in the transaction. */
    private BigDecimal sum;

    /**
     * Constructs a Log object with the provided log creation data.
     * @param data The data used to create the log.
     */
    public Log(LogCreationRecord data) {
        logID = data.logID();
        fromAccountID = data.fromAccountID();
        toAccountID = data.toAccountID();
        fromClientID = data.fromClientID();
        toClientID = data.toClientID();
        fromBankID = data.fromBankID();
        toBankID = data.toBankID();
        declined = data.declined();
        sum = data.sum();
    }

    /**
     * Displays information about the log.
     * @return A string representing the log information.
     */
    @Override
    public String displayLog() {
        return new String("logID: " + logID +
                " fromAccountID: " + fromAccountID +
                " fromClientID: " + fromClientID +
                " fromBankID: " + fromBankID +
                " toAccountID: " + toAccountID +
                " toClientID: " + toClientID +
                " toBankID: " + toBankID +
                " declined/not_declined: " + declined +
                " sum: " + sum + '\n');
    }

    /**
     * Checks if the log ID matches the provided ID.
     * @param logID The ID to check against.
     * @return True if the log ID matches, otherwise false.
     */
    @Override
    public boolean checkByID(int logID) {
        return this.logID == logID;
    }

    /**
     * Marks the transaction as declined.
     */
    @Override
    public void decline() {
        declined = true;
    }

    /**
     * Retrieves the sum of money involved in the transaction.
     * @return The sum of money.
     */
    @Override
    public BigDecimal getSum() {
        return sum;
    }
}