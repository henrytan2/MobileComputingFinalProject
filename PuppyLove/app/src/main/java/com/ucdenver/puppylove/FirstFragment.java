package com.ucdenver.puppylove;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ucdenver.puppylove.data.DataManager;
import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.Interactor;
import com.ucdenver.puppylove.data.models.User;
import com.ucdenver.puppylove.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Context _this = getActivity();
        DataManager dataManager = new DataManager(_this);
        DataSingleton.SetInstance(dataManager);
        Interactor.getInstance().getUserInstance().createAccount(
                "asdf",
                "dsfs",
                "asda",
                "asdas",
                "asdas",
                "asdaa",
                "asda"
        );
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}