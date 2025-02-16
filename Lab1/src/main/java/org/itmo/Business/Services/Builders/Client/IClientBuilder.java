package org.itmo.Business.Services.Builders.Client;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.Client.Client;
import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Models.Records.ClientCreationRecord;

/**
 * The IClientBuilder interface provides methods for building client objects.
 */
public interface IClientBuilder {

    /**
     * Sets the client ID for the client being built.
     * @param clientID The ID of the client.
     * @return The client builder instance.
     */
    IClientBuilder setClientID(int clientID);

    /**
     * Sets the bank ID associated with the client being built.
     * @param bankID The ID of the bank associated with the client.
     * @return The client builder instance.
     */
    IClientBuilder setBankID(int bankID);

    /**
     * Sets the owner bank for the client being built.
     * @param bank The bank entity that owns the client.
     * @return The client builder instance.
     */
    IClientBuilder setOwner(IBank bank);

    /**
     * Sets the console parameters for the client being built.
     * @param clientCreationRecord The record containing client creation data.
     * @return The client builder instance.
     */
    IClientBuilder setConsoleParams(ClientCreationRecord clientCreationRecord);

    /**
     * Builds the client object based on the provided parameters.
     * @return The built client object.
     */
    IClient build();
}