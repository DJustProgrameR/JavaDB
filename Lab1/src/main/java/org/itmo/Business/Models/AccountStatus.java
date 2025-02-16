package org.itmo.Business.Models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The AccountStatus class represents the status of an account.
 */
public class AccountStatus {
    private AccountType accountType;
    private BigDecimal balance;
    private Date dateOfClosing;
    private BigDecimal additionalAmount;
    private BigDecimal debitInterest;
    private BigDecimal depositInterest;
    private BigDecimal creditFee;

    /**
     * Constructs an AccountStatus object with the specified parameters.
     *
     * @param accountType       The type of the account.
     * @param balance           The balance of the account.
     * @param dateOfClosing     The date of closing for the account.
     * @param additionalAmount The additional amount associated with the account.
     * @param debitInterest     The debit interest rate.
     * @param depositInterest   The deposit interest rate.
     * @param creditFee         The credit fee.
     */
    public AccountStatus(AccountType accountType, BigDecimal balance, Date dateOfClosing, BigDecimal additionalAmount, BigDecimal debitInterest, BigDecimal depositInterest, BigDecimal creditFee) {
        this.accountType = accountType;
        this.balance = balance;
        this.dateOfClosing = dateOfClosing;
        this.additionalAmount = additionalAmount;
        this.debitInterest = debitInterest;
        this.depositInterest = depositInterest;
        this.creditFee = creditFee;
    }

    /**
     * Accrues debit interest if the account type is debit.
     */
    public void accrueDebitInterest() {
        if (accountType == AccountType.Debit) {
            additionalAmount = additionalAmount.add(balance.multiply(debitInterest));
        }
    }

    /**
     * Accrues deposit interest if the account type is deposit.
     */
    public void accrueDepositInterest() {
        if (accountType == AccountType.Deposit) {
            additionalAmount = additionalAmount.add(balance.multiply(depositInterest));
        }
    }

    /**
     * Charges fees if the account type is credit and the balance is negative.
     */
    public void chargeFee() {
        if (accountType == AccountType.Credit && balance.compareTo(BigDecimal.ZERO) < 0) {
            balance = balance.add(creditFee.negate());
        }
    }

    /**
     * Replenishes the additional amount to the balance.
     */
    public void replenishAdditionalSum() {
        balance = balance.add(additionalAmount);
        additionalAmount = BigDecimal.ZERO;
    }

    /**
     * Retrieves the balance of the account.
     *
     * @return The balance of the account.
     */
    public BigDecimal getBalance() {
        return balance;
    }
}