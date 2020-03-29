package com.maksymov.restoretheword;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.UUID;

public class SettingsFragment extends Fragment {

    private static final String KEY_USERNAME = "USERNAME";
    MainActivity mainActivity = null;
    Button saveButton;
    private String length = "short";
    private int time = 60000;
    private String[] levels = {"Beginner (4 or 5 or 6 word length)", "Veteran (7 or 8 or 9 word length)"};
    private String[] times = {"1 min", "2 min", "3 min"};


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
        saveButton.setOnClickListener(v -> {

            mainActivity.onDataSend(length, time);

            Fragment fragment = new MenuFragment();
            String tag = UUID.randomUUID().toString();
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainer, fragment, tag)
                    .commit();
        });

        // адаптер
        ArrayAdapter<String> adapterLevel = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, levels);
        adapterLevel.setDropDownViewResource(R.layout.spinner_item);
        Spinner spinnerLevel = view.findViewById(R.id.spinnerLevel);
        spinnerLevel.setAdapter(adapterLevel);
        // выделяем элемент
        spinnerLevel.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if (position == 0)
                   length = "short";
               else if (position == 1)
                   length = "veteran";
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //nothing
            }
        });

        // адаптер
        ArrayAdapter<String> adapterTime = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, times);
        adapterTime.setDropDownViewResource(R.layout.spinner_item);
        Spinner spinnerTime = view.findViewById(R.id.spinnerTime);
        spinnerTime.setAdapter(adapterTime);
        // выделяем элемент
        spinnerTime.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                    time = 60000;
                else if (position == 1)
                    time = 120000;
                else if (position == 2)
                    time = 180000;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                //nothing
            }
        });



    }

}
