package com.example.j_m_financial_10;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AccountRepository {
    private AccountDao accountDao;
    private LiveData<List<Account>> allAccounts;

    public AccountRepository(Application application){
        AccountDatabase database = AccountDatabase.getInstance(application);
        accountDao = database.AccountDao();
        allAccounts = accountDao.getAllAccounts();
    }

    public void insert(Account account){
        new InsertAccountAsyncTask(accountDao).execute(account);
    }
    public void update(Account account){
        new UpdateAccountAsyncTask(accountDao).execute(account);
    }
    public void delete(Account account){
        new DeleteAccountAsyncTask(accountDao).execute(account);
    }

    public LiveData<List<Account>> getAllAccounts() {
        return allAccounts;
    }

    private static class InsertAccountAsyncTask extends AsyncTask<Account,Void,Void>{
        private AccountDao accountDao;

        private InsertAccountAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }
        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.insert(accounts[0]);
            return null;
        }
    }
    private static class UpdateAccountAsyncTask extends AsyncTask<Account,Void,Void>{
        private AccountDao accountDao;

        private UpdateAccountAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }
        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.update(accounts[0]);
            return null;
        }
    }
    private static class DeleteAccountAsyncTask extends AsyncTask<Account,Void,Void>{
        private AccountDao accountDao;

        private DeleteAccountAsyncTask(AccountDao accountDao){
            this.accountDao = accountDao;
        }
        @Override
        protected Void doInBackground(Account... accounts) {
            accountDao.delete(accounts[0]);
            return null;
        }
    }



}
