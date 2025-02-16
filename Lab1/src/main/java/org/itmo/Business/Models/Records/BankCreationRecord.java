package org.itmo.Business.Models.Records;

import java.math.BigDecimal;

/**
 * The BankCreationRecord class represents the data required to create a new bank.
 */
public record BankCreationRecord(
        /**
         * The ID of the bank.
         */
        int bankID,
        /**
         * The interest rate for debit accounts.
         */
        BigDecimal debitAccountInterest,
        /**
         * The interest rate for deposit accounts.
         */
        BigDecimal depositAccountInterest,
        /**
         * The credit limit for credit accounts.
         */
        BigDecimal creditAccountLimit,
        /**
         * The commission for credit accounts.
         */
        BigDecimal creditAccountCommission,
        /**
         * The maximum sum allowed for unverified transactions.
         */
        BigDecimal maxUnverifiedTransactionSum
) {
}