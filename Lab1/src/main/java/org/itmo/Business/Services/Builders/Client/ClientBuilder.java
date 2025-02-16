package org.itmo.Business.Services.Builders.Client;

import org.itmo.Business.Entities.Bank.IBank;
import org.itmo.Business.Entities.Client.Client;
import org.itmo.Business.Entities.Client.IClient;
import org.itmo.Business.Models.Records.ClientCreationRecord;

/**
 * The ClientBuilder class implements the IClientBuilder interface and provides methods
 * to build client objects.
 */
public class ClientBuilder implements IClientBuilder {
    private int clientID;
    private boolean clientIDFlag = false;
    private int bankID;
    private boolean bankIDFlag = false;
    private IBank owner;
    private boolean ownerFlag = false;
    private ClientCreationRecord data;
    private boolean dataFlag = false;

    @Override
    public IClientBuilder setClientID(int clientID) {
        this.clientID = clientID;
        clientIDFlag = true;
        return this;
    }

    @Override
    public IClientBuilder setBankID(int bankID) {
        this.bankID = bankID;
        bankIDFlag = true;
        return this;
    }

    @Override
    public IClientBuilder setOwner(IBank bank) {
        owner = bank;
        ownerFlag = true;
        return this;
    }

    @Override
    public IClientBuilder setConsoleParams(ClientCreationRecord data) {
        this.data = data;
        dataFlag = true;
        return this;
    }

    @Override
    public IClient build() {
        if (clientIDFlag && bankIDFlag && ownerFlag && dataFlag) {
            return new Client(new ClientCreationRecord(clientID, bankID, data.nameSurname(), data.address(), data.passport(), data.address().length() > 1 && data.passport().length() > 1, data.receivingUpdates(), data.updates()), owner, null);
        } else {
            throw new RuntimeException();
        }
    }
}