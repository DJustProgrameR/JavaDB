package org.itmo.Business.Services.Builders.Account;

import org.itmo.Business.Entities.Account.Account;
import org.itmo.Business.Models.Records.AccountCreationRecord;

/**
 * The AccountBuilder class is responsible for building an Account object.
 */
public class AccountBuilder implements IAccountBuilder {
    private int accountID;
    private boolean accountIDFlag = false;
    private int clientID;
    private boolean clientIDFlag = false;
    private int bankID;
    private boolean bankIDFlag = false;
    private AccountCreationRecord data;
    private boolean dataFlag = false;

    /**
     * Sets the account ID for the account being built.
     *
     * @param accountID The account ID.
     * @return The AccountBuilder object.
     */
    @Override
    public IAccountBuilder setAccountID(int accountID) {
        this.accountID = accountID;
        accountIDFlag = true;
        return this;
    }

    /**
     * Sets the client ID for the account being built.
     *
     * @param clientID The client ID.
     * @return The AccountBuilder object.
     */
    @Override
    public IAccountBuilder setClientID(int clientID) {
        this.clientID = clientID;
        clientIDFlag = true;
        return this;
    }

    /**
     * Sets the bank ID for the account being built.
     *
     * @param bankID The bank ID.
     * @return The AccountBuilder object.
     */
    @Override
    public IAccountBuilder setBankID(int bankID) {
        this.bankID = bankID;
        bankIDFlag = true;
        return this;
    }

    /**
     * Sets the console parameters for the account being built.
     *
     * @param data The account creation record containing the necessary data.
     * @return The AccountBuilder object.
     */
    @Override
    public AccountBuilder setConsoleParams(AccountCreationRecord data) {
        this.data = data;
        dataFlag = true;
        return this;
    }

    /**
     * Builds the Account object.
     *
     * @return The built Account object.
     * @throws RuntimeException if any required parameters are missing.
     */
    @Override
    public Account build() {
        if (accountIDFlag && clientIDFlag && bankIDFlag && dataFlag) {
            return new Account(new AccountCreationRecord(accountID, clientID, bankID, data.accountType(), data.balance(), data.dateOfClosing()), null);
        } else {
            throw new RuntimeException("Some required parameters are missing for building the account.");
        }
    }
}