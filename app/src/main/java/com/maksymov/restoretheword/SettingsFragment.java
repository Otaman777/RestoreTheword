package com.maksymov.restoretheword;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.UUID;

public class SettingsFragment extends Fragment {

    private static final String KEY_USERNAME = "USERNAME";
    MainActivity mainActivity = null;
    Button  saveButton;
    RadioGroup rg;
    RadioGroup rgTime;
    private String length = "short";
    private int time = 60000;

    @Override
    public void onAttach(@NonNull Context context) {
        mainActivity = (MainActivity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saveButton = view.findViewById(R.id.saveButton);
        rgTime = view.findViewById(R.id.radioGroupTimer);
        rg = view.findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener((group, checkedId) -> {
            switch(checkedId){
                case R.id.beginner_button:
                    length = "short";
                    break;
                case R.id.veteran_button:
                    length = "veteran";
                    break;
            }
        });

        rgTime.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.one_min:
                    time = 60000;
                    break;
                case R.id.two_min:
                    time = 120000;
                    break;
                case R.id.three_min:
                    time = 180000;
                    break;
            }
        });

        saveButton.setOnClickListener(v -> {

            mainActivity.onDataSend(length, time);

            Fragment fragment = new MenuFragment();
            String tag = UUID.randomUUID().toString();
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainer, fragment, tag)
                    .commit();
        });
    }

}
