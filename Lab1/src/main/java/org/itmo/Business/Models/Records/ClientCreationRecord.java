package org.itmo.Business.Models.Records;

/**
 * The ClientCreationRecord class represents the data required to create a new client.
 */
public record ClientCreationRecord(
        /**
         * The ID of the client.
         */
        int clientID,
        /**
         * The ID of the bank associated with the client.
         */
        int bankID,
        /**
         * The name and surname of the client.
         */
        String nameSurname,
        /**
         * The address of the client.
         */
        String address,
        /**
         * The passport number of the client.
         */
        String passport,
        /**
         * Indicates whether the client is verified.
         */
        boolean verified,
        /**
         * Indicates whether the client is receiving updates.
         */
        boolean receivingUpdates,
        /**
         * The updates received by the client.
         */
        String updates
) {
}