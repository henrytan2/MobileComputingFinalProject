package com.ucdenver.puppylove.data.interfaces;

import com.ucdenver.puppylove.data.models.User;

public interface IUser {
    boolean accountExists(String email);

    boolean login(String username, String password);

    void resetPassword(com.ucdenver.puppylove.data.models.User user, String password);

    void createAccount(String username, String password, String firstName, String lastName,
                       String email, String phone, String occupation);
}
