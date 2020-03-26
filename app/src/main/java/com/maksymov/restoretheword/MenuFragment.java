package com.maksymov.restoretheword;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

public class MenuFragment extends Fragment {
    private Button startSettingsButton;
    private Button startGameButton;
    MainActivity mainActivity = null;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.text);
        textView.setText("Length = " + mainActivity.getLength() + " Time = " + mainActivity.getTime());

        startSettingsButton = view.findViewById(R.id.button_settings);
        startSettingsButton.setOnClickListener(v -> {
            Fragment fragment = new SettingsFragment();
            //fragment.setTargetFragment(MenuFragment.this, RQ_CODE);
            String tag = UUID.randomUUID().toString();
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainer, fragment, tag)
                    .commit();
        });
        startGameButton = view.findViewById(R.id.button_start);
        startGameButton.setOnClickListener(v -> {
            Fragment fragment = new GameFragment();
            //fragment.setTargetFragment(MenuFragment.this, RQ_CODE);
            String tag = UUID.randomUUID().toString();
            getFragmentManager().beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainer, fragment, tag)
                    .commit();
        });
    }


}
