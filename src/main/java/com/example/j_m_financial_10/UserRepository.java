package com.example.j_m_financial_10;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application){
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.UserDao();
        allUsers = userDao.getAllUsers();
    }
    public void insert(User user){
        new InsertUserAsyncTask(userDao).execute(user);
    }
    public void update(User user){
        new UpdateUserAsyncTask(userDao).execute(user);
    }
    public void delete(User user){
        new DeleteUserAsyncTask(userDao).execute(user);
    }
    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    private static class InsertUserAsyncTask extends AsyncTask<User,Void,Void> {
        private UserDao userDao;

        private InsertUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            userDao.Insert(user[0]);
            return null;
        }
    }
    private static class UpdateUserAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;

        private UpdateUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.Update(users[0]);
            return null;
        }
    }
    private static class DeleteUserAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao userDao;

        private DeleteUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.Delete(users[0]);
            return null;
        }
    }
}
