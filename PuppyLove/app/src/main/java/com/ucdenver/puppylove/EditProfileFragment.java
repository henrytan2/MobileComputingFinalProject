package com.ucdenver.puppylove;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ucdenver.puppylove.data.Interactor;

public class EditProfileFragment extends DialogFragment {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneEditText;
    private EditText occupationEditText;
    private Button editProfileButton;
    private Button closeButton;

    public EditProfileFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_edit_profile, null);

        this.firstNameEditText = dialogView.findViewById(R.id.firstNameEditTextEdit);
        this.lastNameEditText = dialogView.findViewById(R.id.lastNameEditTextEdit);
        this.phoneEditText = dialogView.findViewById(R.id.phoneEditTextEdit);
        this.occupationEditText = dialogView.findViewById(R.id.occupationEditTextEdit);
        this.editProfileButton = dialogView.findViewById(R.id.editProfileButton);
        this.closeButton = dialogView.findViewById(R.id.closeButton);

        this.editProfileButton.setOnClickListener(v -> {
            this.editProfile();
            dismiss();
        });

        this.closeButton.setOnClickListener(v -> {
            dismiss();
        });

        com.ucdenver.puppylove.data.models.User loggedInUser = LoggedInUser.getInstance();
        String firstName = loggedInUser.getFirstName();
        String lastName = loggedInUser.getLastName();
        String phone = loggedInUser.getPhone();
        String occupation = loggedInUser.getOccupation();
        this.firstNameEditText.setText(firstName);
        this.lastNameEditText.setText(lastName);
        this.phoneEditText.setText(phone);
        this.occupationEditText.setText(occupation);

        builder.setView(dialogView);
        return builder.create();
    }

    private void editProfile() {
        String firstName = this.firstNameEditText.getText().toString();
        String lastName = this.lastNameEditText.getText().toString();
        String phone = this.phoneEditText.getText().toString();
        String occupation = this.occupationEditText.getText().toString();
        int id = LoggedInUser.getInstance().getId();

        Interactor.getUserInstance().editProfile(id, firstName, lastName, phone, occupation);
        com.ucdenver.puppylove.data.models.User editedUser = Interactor.getUserInstance().fetchByUserName(LoggedInUser.getInstance().getUserName());
        LoggedInUser.setInstance(editedUser);
    }
}