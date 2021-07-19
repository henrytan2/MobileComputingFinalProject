package com.ucdenver.puppylove.data.interfaces;

public interface IUser {
    boolean accountExists(String email);

    boolean login(String username, String password);

    void resetPassword(com.ucdenver.puppylove.data.models.User user, String password);

    com.ucdenver.puppylove.data.requests.User.CreateAccountResponse createAccount(String username, String password, String firstName, String lastName,
                                                                                  String email, String phone, String occupation);
}
