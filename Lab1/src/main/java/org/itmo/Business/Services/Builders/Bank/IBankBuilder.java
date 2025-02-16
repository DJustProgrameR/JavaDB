package org.itmo.Business.Services.Builders.Bank;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Business.Models.Records.BankCreationRecord;
import org.itmo.Business.Services.TimeAccelerationMechanism.ITimeAccelerationMechanism;
import org.itmo.Data.IDatabase;

/**
 * The IBankBuilder interface defines methods for building a bank object.
 */
public interface IBankBuilder {

    /**
     * Sets the bank ID for the bank being built.
     * @param bankID The bank ID.
     * @return The bank builder instance.
     */
    IBankBuilder setBankID(int bankID);

    /**
     * Sets the owner of the bank being built.
     * @param centralBank The central bank that owns the bank.
     * @return The bank builder instance.
     */
    IBankBuilder setOwner(ICentralBank centralBank);

    /**
     * Sets the database for the bank being built.
     * @param database The database associated with the bank.
     * @return The bank builder instance.
     */
    IBankBuilder setDatabase(IDatabase database);

    /**
     * Sets the time acceleration mechanism for the bank being built.
     * @param timeAccelerationMechanism The time acceleration mechanism.
     * @return The bank builder instance.
     */
    IBankBuilder setTimeAccelerationMechanism(ITimeAccelerationMechanism timeAccelerationMechanism);

    /**
     * Sets the parameters for the bank creation from the console input.
     * @param bankCreationRecord The record containing bank creation information.
     * @return The bank builder instance.
     */
    IBankBuilder setConsoleParams(BankCreationRecord bankCreationRecord);

    /**
     * Builds the bank object based on the provided parameters.
     * @return The built bank object.
     */
    IBank build();
}