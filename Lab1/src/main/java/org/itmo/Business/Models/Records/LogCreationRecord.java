package org.itmo.Business.Models.Records;

import java.math.BigDecimal;

/**
 * The LogCreationRecord class represents the data required to create a log for a transaction.
 */
public record LogCreationRecord(
        /**
         * The ID of the log.
         */
        int logID,
        /**
         * The ID of the account the transaction is from.
         */
        int fromAccountID,
        /**
         * The ID of the account the transaction is to.
         */
        int toAccountID,
        /**
         * The ID of the client initiating the transaction.
         */
        int fromClientID,
        /**
         * The ID of the client receiving the transaction.
         */
        int toClientID,
        /**
         * The ID of the bank the transaction is from.
         */
        int fromBankID,
        /**
         * The ID of the bank the transaction is to.
         */
        int toBankID,
        /**
         * Indicates whether the transaction was declined or not.
         */
        boolean declined,
        /**
         * The sum of money involved in the transaction.
         */
        BigDecimal sum
) {
}