package org.itmo.Business.Services.Builders.Account;

import org.itmo.Business.Entities.Account.IAccount;
import org.itmo.Business.Models.Records.AccountCreationRecord;

/**
 * The IAccountBuilder interface defines the methods for building an account.
 */
public interface IAccountBuilder {
    /**
     * Sets the account ID for the account being built.
     *
     * @param accountID The account ID.
     * @return The IAccountBuilder object.
     */
    IAccountBuilder setAccountID(int accountID);

    /**
     * Sets the client ID for the account being built.
     *
     * @param clientID The client ID.
     * @return The IAccountBuilder object.
     */
    IAccountBuilder setClientID(int clientID);

    /**
     * Sets the bank ID for the account being built.
     *
     * @param bankID The bank ID.
     * @return The IAccountBuilder object.
     */
    IAccountBuilder setBankID(int bankID);

    /**
     * Sets the console parameters for the account being built.
     *
     * @param data The account creation record containing the necessary data.
     * @return The IAccountBuilder object.
     */
    IAccountBuilder setConsoleParams(AccountCreationRecord data);

    /**
     * Builds the Account object.
     *
     * @return The built Account object.
     * @throws RuntimeException if any required parameters are missing.
     */
    IAccount build();
}