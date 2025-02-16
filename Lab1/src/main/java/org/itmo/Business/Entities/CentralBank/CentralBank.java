/**
 * The CentralBank class represents a central bank entity.
 * It implements the ICentralBank interface.
 */
package org.itmo.Business.Entities.CentralBank;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Models.Records.BankCreationRecord;
import org.itmo.Business.Models.Records.DeclineInterbankTransactionRecord;
import org.itmo.Business.Models.Records.DeclineTransactionRecord;
import org.itmo.Business.Models.Records.LogCreationRecord;
import org.itmo.Business.Services.Builders.Bank.BankBuilder;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;
import org.itmo.Data.IDatabase;

/**
 * The CentralBank class represents a central bank entity.
 * It implements the ICentralBank interface.
 */
public class CentralBank implements ICentralBank {

    /** The number of banks associated with the central bank. */
    private int amountOfBanks;

    /** The database associated with the central bank. */
    private IDatabase database;

    /**
     * Constructs a CentralBank object with the provided database.
     *
     * @param database The database associated with the central bank.
     */
    public CentralBank(IDatabase database){
        amountOfBanks=0;
        this.database = database;
    }

    /**
     * Notifies banks to accrue interest.
     */
    @Override
    public void accrueInterestNotification() {
        for(int i=0;i<amountOfBanks;i++){
            database.getBankByBankID(i+1).accrueInterest();
        }
    }

    /**
     * Notifies banks to charge fees.
     */
    @Override
    public void chargeFeeNotification() {
        for(int i=0;i<amountOfBanks;i++){
            database.getBankByBankID(i+1).chargeFee();
        }
    }

    /**
     * Creates a new bank and adds it to the database.
     *
     * @param bankCreationRecord       The creation record for the bank.
     * @param timeAccelerationMechanism The time acceleration mechanism to be used by the bank.
     * @return                          A string containing information about the created bank.
     */
    @Override
    public String createBank(BankCreationRecord bankCreationRecord, ITimeAccelerationMechanism timeAccelerationMechanism) {
        amountOfBanks++;
        BankBuilder bankBuilder = new BankBuilder();
        IBank bank = bankBuilder.setBankID(amountOfBanks).setConsoleParams(bankCreationRecord).setDatabase(database).setOwner(this).build();
        database.addNewBank(bank);
        return "bankID: "+amountOfBanks+'\n';
    }

    /**
     * Makes a transaction within the central bank.
     *
     * @param data The creation data for the transaction.
     */
    @Override
    public void makeTransaction(LogCreationRecord data) {
        database.getBankByBankID(data.toBankID()).makeTransaction(data, true);
    }

    /**
     * Retrieves the bank associated with the given bank ID.
     *
     * @param bankID The ID of the bank.
     * @return       The bank associated with the given ID.
     */
    @Override
    public IBank getBank(int bankID) {
        return database.getBankByBankID(bankID);
    }

    /**
     * Declines an interbank transaction based on the provided record.
     *
     * @param data The record containing information about the transaction to be declined.
     */
    @Override
    public void declineInterbankTransaction(DeclineInterbankTransactionRecord data) {
        database.getBankByBankID(data.bankID1()).declineTransaction(new DeclineTransactionRecord(data.logID1(),data.accountID1(),data.clientID1(),0,0,0));
        database.getBankByBankID(data.bankID2()).declineTransaction(new DeclineTransactionRecord(data.logID2(),data.accountID2(),data.clientID2(),0,0,0));
    }
}
