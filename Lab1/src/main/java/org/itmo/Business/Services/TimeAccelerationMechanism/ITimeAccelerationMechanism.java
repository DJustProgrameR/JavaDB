package org.itmo.Business.Services.TimeAccelerationMechanism;

import org.itmo.Business.Entities.Account.IAccount;
import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Models.AccountStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The ITimeAccelerationMechanism interface provides a method to calculate the sum
 * of an account over a certain period of time.
 */
public interface ITimeAccelerationMechanism {
    /**
     * Calculates the sum of an account over a certain period of time.
     *
     * @param accountStatus The status of the account.
     * @param today         The start date of the period.
     * @param endDay        The end date of the period.
     * @return The sum of the account over the specified period.
     */
    BigDecimal countSum(AccountStatus accountStatus, Date today, Date endDay);
}