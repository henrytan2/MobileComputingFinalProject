package com.ucdenver.puppylove;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MatchSuccessFragment extends DialogFragment {
    private Button backToHomeButton;

    public MatchSuccessFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragment_match_success, null);

        this.backToHomeButton = dialogView.findViewById(R.id.goBackToHome);
        this.backToHomeButton.setOnClickListener(v -> {
            dismiss();
        });

        builder.setView(dialogView);
        return builder.create();
    }
}