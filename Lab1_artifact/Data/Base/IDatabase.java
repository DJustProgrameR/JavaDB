package org.itmo.Data.Base;

public interface IDatabase {
    IAccountLogRepository GetLogsByBankIDAccountID(int bankID, int accountID);

    IAccountRepository GetAccountsByBankID(int bankID);

    IClientRepository GetClientsByBankID(int bank_ID);

    IBankRepository GetBanks();
}
