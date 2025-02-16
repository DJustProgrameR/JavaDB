/**
 * The ICentralBank interface represents a central bank in the banking system.
 */
package org.itmo.Business.Entities.CentralBank;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Models.Records.BankCreationRecord;
import org.itmo.Business.Models.Records.DeclineInterbankTransactionRecord;
import org.itmo.Business.Models.Records.DeclineTransactionRecord;
import org.itmo.Business.Models.Records.LogCreationRecord;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;

/**
 * The ICentralBank interface represents a central bank in the banking system.
 */
public interface ICentralBank {

    /**
     * Notifies the central bank to accrue interest.
     */
    void accrueInterestNotification();

    /**
     * Notifies the central bank to charge fees.
     */
    void chargeFeeNotification();

    /**
     * Creates a new bank with the provided bank creation record.
     * @param data The bank creation record.
     * @param timeAccelerationMechanism The time acceleration mechanism.
     * @return A string representing the result of the operation.
     */
    String createBank(BankCreationRecord data, ITimeAccelerationMechanism timeAccelerationMechanism);

    /**
     * Makes a transaction using the provided transaction data.
     * @param data The transaction data.
     */
    void makeTransaction(LogCreationRecord data);

    /**
     * Retrieves the bank with the specified bank ID.
     * @param bankID The bank ID.
     * @return The bank object.
     */
    IBank getBank(int bankID);

    /**
     * Declines an interbank transaction with the provided decline interbank transaction record.
     * @param data The decline interbank transaction record.
     */
    void declineInterbankTransaction(DeclineInterbankTransactionRecord data);
}