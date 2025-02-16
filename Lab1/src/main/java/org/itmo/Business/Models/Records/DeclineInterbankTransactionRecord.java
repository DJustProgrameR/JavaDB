package org.itmo.Business.Models.Records;

/**
 * The DeclineInterbankTransactionRecord class represents the data required to decline an interbank transaction.
 */
public record DeclineInterbankTransactionRecord(
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
         * The ID of the first bank.
         */
        int bankID1,
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
        int clientID2,
        /**
         * The ID of the second bank.
         */
        int bankID2
) {
}