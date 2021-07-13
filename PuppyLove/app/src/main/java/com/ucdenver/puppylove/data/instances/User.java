package com.ucdenver.puppylove.data.instances;

import android.database.Cursor;
import android.util.Log;

import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.Interactor;
import com.ucdenver.puppylove.data.interfaces.IUser;

public class User implements IUser {
    @Override
    public boolean accountExists(String email) {
        Cursor cursor = null;
        String query = "select user_name" +
                "from users" +
                "where email = " + email;
        boolean response = false;
        try {
            cursor = DataSingleton.instance.getDB().rawQuery(query, null);
            String dbUserName = cursor.getString(0);
            if (dbUserName != null) {
                response = true;
            }
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }

    @Override
    public boolean login(String username, String password) {
        Cursor cursor = null;
        String query = "select user_name, password " +
                "from users" +
                "where user_name = " + username;
        boolean response = false;
        try {
            cursor = DataSingleton.instance.getDB().rawQuery(query, null);
            String dbUserName = cursor.getString(0);
            String dbPassword = cursor.getString(1);
            String passwordHashCode = Integer.toString(password.hashCode());
            if (dbUserName == username && dbPassword == dbPassword) {
                response = true;
            }
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }

    @Override
    public void resetPassword(com.ucdenver.puppylove.data.models.User user, String password) {
        String passwordHashcode = Integer.toString(password.hashCode());
        String query = "update users " +
                "set password = " + passwordHashcode +
                "where id = " + user.getId();
        try {
            DataSingleton.instance.getDB().execSQL(query);
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
    }

    @Override
    public void createAccount(String username, String password, String firstName, String lastName,
                       String email, String phone, String occupation) {
        String passwordHashcode = Integer.toString(password.hashCode());
        String query = "insert into users " +
                "(" + com.ucdenver.puppylove.data.models.User.userNameColumn + ", " +
                com.ucdenver.puppylove.data.models.User.passwordColumn + ", " +
                com.ucdenver.puppylove.data.models.User.firstNameColumn + ", " +
                com.ucdenver.puppylove.data.models.User.lastNameColumn + ", " +
                com.ucdenver.puppylove.data.models.User.emailColumn + ", " +
                com.ucdenver.puppylove.data.models.User.phoneColumn + ", " +
                com.ucdenver.puppylove.data.models.User.occupationColumn + ") " +
                "values (" +
                "'" + username + "', " +
                "'" + passwordHashcode + "', " +
                "'" + firstName + "', " +
                "'" + lastName + "', " +
                "'" + email + "', " +
                "'" + phone + "', " +
                "'" + occupation + "');";
        try {
            DataSingleton.instance.getDB().execSQL(query);
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
    }
}
