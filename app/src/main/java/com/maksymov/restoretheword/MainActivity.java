package com.maksymov.restoretheword;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.maksymov.restoretheword.interfaces.Navigator;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements Navigator {
    private String length;
    private int time;

    public String getLength() {
        return length;
    }

    public int getTime() {
        return time;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            launchFragment(null, new MenuFragment());
            length = "short";
            time = 60000;
        } else if (savedInstanceState != null) {
            length = savedInstanceState.getString("length");
            time = savedInstanceState.getInt("time");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("length", length);
        outState.putInt("time", time);
    }

    private void launchFragment(@Nullable Fragment target, Fragment fragment) {
        if (target != null) {
            fragment.setTargetFragment(target, 0);
        }
        String tag = UUID.randomUUID().toString();
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainer, fragment, tag)
                .commit();
    }

    @Override
    public void onDataSend(String d, int time) {
        this.length = d;
        this.time = time;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
