package org.itmo.Business.Models.Records;

import org.itmo.Business.Models.AccountType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The AccountCreationRecord class represents the data required to create a new account.
 */
public record AccountCreationRecord(
        /**
         * The ID of the account.
         */
        int accountID,
        /**
         * The ID of the client associated with the account.
         */
        int clientID,
        /**
         * The ID of the bank associated with the account.
         */
        int bankID,
        /**
         * The type of the account.
         */
        AccountType accountType,
        /**
         * The balance of the account.
         */
        BigDecimal balance,
        /**
         * The date when the account will be closed.
         */
        Date dateOfClosing
) {
}