package org.itmo.Business.Services.Builders.Bank;

import org.itmo.Business.Entities.Bank.Bank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Models.Records.BankCreationRecord;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;
import org.itmo.Data.IDatabase;

/**
 * The BankBuilder class implements the IBankBuilder interface and is responsible for building a Bank object.
 */
public class BankBuilder implements IBankBuilder {
    private int bankID;
    private boolean bankIDFlag = false;
    private ICentralBank owner;
    private boolean ownerFlag = false;
    private ITimeAccelerationMechanism timeAccelerationMechanism;
    private boolean timeAccelerationMechanismFlag = false;
    private IDatabase database;
    private boolean databaseFlag = false;
    private BankCreationRecord data;
    private boolean dataFlag = false;

    @Override
    public BankBuilder setBankID(int bankID) {
        this.bankID = bankID;
        bankIDFlag = true;
        return this;
    }

    @Override
    public IBankBuilder setOwner(ICentralBank centralBank) {
        owner = centralBank;
        ownerFlag = true;
        return this;
    }

    @Override
    public BankBuilder setDatabase(IDatabase database) {
        this.database = database;
        databaseFlag = true;
        return this;
    }

    @Override
    public IBankBuilder setTimeAccelerationMechanism(ITimeAccelerationMechanism timeAccelerationMechanism) {
        this.timeAccelerationMechanism = timeAccelerationMechanism;
        timeAccelerationMechanismFlag = true;
        return this;
    }

    @Override
    public BankBuilder setConsoleParams(BankCreationRecord data) {
        this.data = data;
        dataFlag = true;
        return this;
    }

    @Override
    public Bank build() {
        if (bankIDFlag && ownerFlag && databaseFlag && dataFlag && timeAccelerationMechanismFlag) {
            return new Bank(new BankCreationRecord(bankID, data.debitAccountInterest(), data.depositAccountInterest(), data.creditAccountLimit(), data.creditAccountCommission(), data.maxUnverifiedTransactionSum()), owner, database, timeAccelerationMechanism);
        } else {
            throw new RuntimeException("Required parameters are missing for building the Bank object.");
        }
    }
}