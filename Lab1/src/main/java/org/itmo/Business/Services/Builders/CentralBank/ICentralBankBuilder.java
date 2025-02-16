package org.itmo.Business.Services.Builders.CentralBank;

import org.itmo.Business.Entities.CentralBank.ICentralBank;
import org.itmo.Data.IDatabase;

/**
 * The ICentralBankBuilder interface defines methods for building a central bank object.
 */
public interface ICentralBankBuilder {

    /**
     * Sets the database for the central bank being built.
     * @param database The database associated with the central bank.
     * @return The central bank builder instance.
     */
    ICentralBankBuilder setDatabase(IDatabase database);

    /**
     * Builds the central bank object based on the provided parameters.
     * @return The built central bank object.
     */
    ICentralBank build();
}