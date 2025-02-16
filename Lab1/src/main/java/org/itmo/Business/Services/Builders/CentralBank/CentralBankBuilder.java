package org.itmo.Business.Services.Builders.CentralBank;

import org.itmo.Business.Entities.CentralBank.CentralBank;
import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Data.IDatabase;

/**
 * The CentralBankBuilder class implements the ICentralBankBuilder interface
 * and is responsible for building instances of the CentralBank class.
 */
public class CentralBankBuilder implements ICentralBankBuilder {
    private IDatabase database;
    private boolean databaseFlag = false;

    /**
     * Sets the database for the central bank being built.
     * @param database The database associated with the central bank.
     * @return The central bank builder instance.
     */
    @Override
    public ICentralBankBuilder setDatabase(IDatabase database) {
        this.database = database;
        databaseFlag = true;
        return this;
    }

    /**
     * Builds the central bank object based on the provided parameters.
     * @return The built central bank object.
     * @throws RuntimeException if the database is not set.
     */
    @Override
    public ICentralBank build() {
        if (databaseFlag) {
            return new CentralBank(database);
        } else {
            throw new RuntimeException("Database is not set for CentralBankBuilder.");
        }
    }
}