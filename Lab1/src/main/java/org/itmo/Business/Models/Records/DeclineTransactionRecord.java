package org.itmo.Business.Models.Records;

/**
 * The DeclineTransactionRecord class represents the data required to decline a transaction.
 */
public record DeclineTransactionRecord(
        /**
         * The ID of the first log.
         */
        int logID1,
        /**
         * The ID of the first account.
         */
        int accountID1,
        /**
         * The ID of the first client.
         */
        int clientID1,
        /**
         * The ID of the second log.
         */
        int logID2,
        /**
         * The ID of the second account.
         */
        int accountID2,
        /**
         * The ID of the second client.
         */
        int clientID2
) {
}