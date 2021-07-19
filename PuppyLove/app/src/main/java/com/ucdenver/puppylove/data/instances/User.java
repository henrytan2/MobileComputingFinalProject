package com.ucdenver.puppylove.data.instances;

import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.enums.WhyCreateAccountFailed;
import com.ucdenver.puppylove.data.interfaces.IUser;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
                "from users " +
                "where user_name = '" + username + "';";
        boolean response = false;
        try {
            cursor = DataSingleton.instance.getDB().rawQuery(query, null);
            cursor.moveToFirst();
            String dbUserName = cursor.getString(0);
            String dbPassword = cursor.getString(1);
            String passwordHashCode = this.hashPassword(password);
            if (dbUserName.equals(username) && dbPassword.equals(passwordHashCode)) {
                response = true;
            }
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }

    @Override
    public void resetPassword(com.ucdenver.puppylove.data.models.User user, String password) {
        String passwordHashcode = this.hashPassword(password);
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
    public com.ucdenver.puppylove.data.requests.User.CreateAccountResponse createAccount(String username, String password, String firstName, String lastName,
                                                                                         String email, String phone, String occupation) {
        com.ucdenver.puppylove.data.requests.User.CreateAccountResponse response = new com.ucdenver.puppylove.data.requests.User.CreateAccountResponse();
        String passwordHashcode = this.hashPassword(password);
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
        } catch (SQLiteConstraintException ex) {
            response.setErrorCode(WhyCreateAccountFailed.UsernameAlreadyExists);
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }

    private String hashPassword(String password) {
        String response = "";
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            response = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }
}
