package org.itmo.Business.Services.TimeAccelerationMechanism;

import org.itmo.Business.Models.AccountStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The TimeAccelerationMechanism class implements the ITimeAccelerationMechanism interface
 * and provides functionality to calculate the sum of an account over a certain period of time.
 */
public class TimeAccelerationMechanism implements ITimeAccelerationMechanism {

    /**
     * Calculates the sum of an account over a certain period of time.
     *
     * @param accountStatus The status of the account.
     * @param today         The start date of the period.
     * @param endDay        The end date of the period.
     * @return The sum of the account over the specified period.
     */
    @Override
    public BigDecimal countSum(AccountStatus accountStatus, Date today, Date endDay) {
        // Loop through each day in the period
        for (Date start = today; start.before(endDay); start.setTime(start.getTime() + 86400)) {
            // Accrue debit interest
            accountStatus.accrueDebitInterest();
            // Accrue deposit interest
            accountStatus.accrueDepositInterest();
            // Charge fee
            accountStatus.chargeFee();
            // Check if it's the end of the month
            if (start.getTime() % 2592000 == 0) {
                // Replenish additional sum at the end of each month
                accountStatus.replenishAdditionalSum();
            }
        }
        // Return the balance of the account
        return accountStatus.getBalance();
    }
}