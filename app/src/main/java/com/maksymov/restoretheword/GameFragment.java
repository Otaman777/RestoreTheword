package com.maksymov.restoretheword;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maksymov.restoretheword.wordsStore.Words;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameFragment extends Fragment implements View.OnClickListener {
    private MainActivity mainActivity = null;
    private Context gameFragment = null;
    private boolean level = false;
    private Words words;
    private int stage;
    private TextView timer;
    private CountDownTimer countDownTimer = null;
    private long remainingTime = 999999999;
    private byte counter = 0;
    private TextView counterTextView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView11;
    private TextView textView22;
    private TextView textView33;
    private TextView textView44;
    private TextView textView55;
    private TextView textView66;
    private TextView textView77;
    private TextView textView88;
    private TextView textView99;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("stage", stage);
        outState.putString("textView1", textView1.getText().toString());
        outState.putString("textView2", textView2.getText().toString());
        outState.putString("textView3", textView3.getText().toString());
        outState.putString("textView4", textView4.getText().toString());
        outState.putString("textView5", textView5.getText().toString());
        outState.putString("textView6", textView6.getText().toString());
        outState.putString("textView7", textView7.getText().toString());
        outState.putString("textView8", textView8.getText().toString());
        outState.putString("textView9", textView9.getText().toString());
        outState.putString("textView11", textView11.getText().toString());
        outState.putString("textView22", textView22.getText().toString());
        outState.putString("textView33", textView33.getText().toString());
        outState.putString("textView44", textView44.getText().toString());
        outState.putString("textView55", textView55.getText().toString());
        outState.putString("textView66", textView66.getText().toString());
        outState.putString("textView77", textView77.getText().toString());
        outState.putString("textView88", textView88.getText().toString());
        outState.putString("textView99", textView99.getText().toString());
        outState.putString("counterTextView", counterTextView.getText().toString());
        //outState.putInt("timer", Integer.parseInt(timer.getText().toString()));
        outState.putLong("remainingTime", remainingTime);
        Log.d("Час при збереженні", String.valueOf(remainingTime));
        countDownTimer.onFinish();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gameFragment = getContext();

        textView1 = view.findViewById(R.id.firstR);
        textView2 = view.findViewById(R.id.secondR);
        textView3 = view.findViewById(R.id.thirdR);
        textView4 = view.findViewById(R.id.fourthR);
        textView5 = view.findViewById(R.id.fifthR);
        textView6 = view.findViewById(R.id.sixthR);
        textView7 = view.findViewById(R.id.seventhR);
        textView8 = view.findViewById(R.id.eighthR);
        textView9 = view.findViewById(R.id.ninthR);

        textView11 = view.findViewById(R.id.first);
        textView22 = view.findViewById(R.id.second);
        textView33 = view.findViewById(R.id.third);
        textView44 = view.findViewById(R.id.fourth);
        textView55 = view.findViewById(R.id.fifth);
        textView66 = view.findViewById(R.id.sixth);
        textView77 = view.findViewById(R.id.seventh);
        textView88 = view.findViewById(R.id.eighth);
        textView99 = view.findViewById(R.id.ninth);
        counterTextView = view.findViewById(R.id.counter);
        counterTextView.setText("0");
        timer = view.findViewById(R.id.timer);
        stage = 1;
        fillingInTheRandomLayout(stage, view);
        textView1.setOnClickListener((View.OnClickListener) this);
        textView2.setOnClickListener((View.OnClickListener) this);
        textView3.setOnClickListener((View.OnClickListener) this);
        textView4.setOnClickListener((View.OnClickListener) this);
        textView5.setOnClickListener((View.OnClickListener) this);
        textView6.setOnClickListener((View.OnClickListener) this);
        textView7.setOnClickListener((View.OnClickListener) this);
        textView8.setOnClickListener((View.OnClickListener) this);
        textView9.setOnClickListener((View.OnClickListener) this);
        textView11.setOnClickListener((View.OnClickListener) this);
        textView22.setOnClickListener((View.OnClickListener) this);
        textView33.setOnClickListener((View.OnClickListener) this);
        textView44.setOnClickListener((View.OnClickListener) this);
        textView55.setOnClickListener((View.OnClickListener) this);
        textView66.setOnClickListener((View.OnClickListener) this);
        textView77.setOnClickListener((View.OnClickListener) this);
        textView88.setOnClickListener((View.OnClickListener) this);
        textView99.setOnClickListener((View.OnClickListener) this);

        if (savedInstanceState != null) {
            stage = savedInstanceState.getInt("stage");
            textView1.setText(savedInstanceState.getString("textView1"));
            textView2.setText(savedInstanceState.getString("textView2"));
            textView3.setText(savedInstanceState.getString("textView3"));
            textView4.setText(savedInstanceState.getString("textView4"));
            textView5.setText(savedInstanceState.getString("textView5"));
            textView6.setText(savedInstanceState.getString("textView6"));
            textView7.setText(savedInstanceState.getString("textView7"));
            textView8.setText(savedInstanceState.getString("textView8"));
            textView9.setText(savedInstanceState.getString("textView9"));
            textView11.setText(savedInstanceState.getString("textView11"));
            textView22.setText(savedInstanceState.getString("textView22"));
            textView33.setText(savedInstanceState.getString("textView33"));
            textView44.setText(savedInstanceState.getString("textView44"));
            textView55.setText(savedInstanceState.getString("textView55"));
            textView66.setText(savedInstanceState.getString("textView66"));
            textView77.setText(savedInstanceState.getString("textView77"));
            textView88.setText(savedInstanceState.getString("textView88"));
            textView99.setText(savedInstanceState.getString("textView99"));
            counterTextView.setText(savedInstanceState.getString("counterTextView"));
            remainingTime = savedInstanceState.getLong("remainingTime");

            countDownTimer = new CountDownTimer((remainingTime * 1000), 1000) {
                public void onTick(long millisUntilFinished) {
                    remainingTime = millisUntilFinished / 1000;
                    timer.setText(millisUntilFinished / 1000 + "");
                }

                @Override
                public void onFinish() {
                    dialogFinish();
                }
            }.start();

        } else countDownTimer = new CountDownTimer(mainActivity.getTime(), 1000) {
            public void onTick(long millisUntilFinished) {
                remainingTime = millisUntilFinished / 1000;
                timer.setText(millisUntilFinished / 1000 + "");
            }

            @Override
            public void onFinish() {
                dialogFinish();
            }
        }.start();

    }

    private void dialogFinish() {
        new AlertDialog.Builder(this.getContext())
                .setTitle("THE GAME")
                .setMessage("THE TIME IS OUT \n You guessed " + counter + " word(s)!")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> android.os.Process.killProcess(android.os.Process.myPid())).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.firstR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView1.getText());
                    textView1.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView1.getText());
                    textView1.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.secondR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView2.getText());
                    textView2.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView2.getText());
                    textView2.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.thirdR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView3.getText());
                    textView3.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView3.getText());
                    textView3.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.fourthR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView4.getText());
                    textView4.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView4.getText());
                    textView4.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.fifthR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView5.getText());
                    textView5.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView5.getText());
                    textView5.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.sixthR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView6.getText());
                    textView6.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView6.getText());
                    textView6.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.seventhR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView7.getText());
                    textView7.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView7.getText());
                    textView7.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.eighthR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView8.getText());
                    textView8.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView8.getText());
                    textView8.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;
            case R.id.ninthR:
                if (textView11.getText().equals("")) {
                    textView11.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView22.getText().equals("")) {
                    textView22.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView33.getText().equals("")) {
                    textView33.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView44.getText().equals("")) {
                    textView44.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView55.getText().equals("")) {
                    textView55.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView66.getText().equals("")) {
                    textView66.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView77.getText().equals("")) {
                    textView77.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView88.getText().equals("")) {
                    textView88.setText(textView9.getText());
                    textView9.setText("");
                } else if (textView99.getText().equals("")) {
                    textView99.setText(textView9.getText());
                    textView9.setText("");
                }
                if (checkForFinish(stage)) {
                    stage++;
                    cleaningTheSurface();
                    fillingInTheRandomLayout(stage, view);
                }
                break;

            case R.id.first:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView11.getText());
                    textView11.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView11.getText());
                    textView11.setText("");
                }
                break;
            case R.id.second:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView22.getText());
                    textView22.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView22.getText());
                    textView22.setText("");
                }
                break;
            case R.id.third:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView33.getText());
                    textView33.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView33.getText());
                    textView33.setText("");
                }
                break;
            case R.id.fourth:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView44.getText());
                    textView44.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView44.getText());
                    textView44.setText("");
                }
                break;
            case R.id.fifth:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView55.getText());
                    textView55.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView55.getText());
                    textView55.setText("");
                }
                break;
            case R.id.sixth:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView66.getText());
                    textView66.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView66.getText());
                    textView66.setText("");
                }
                break;
            case R.id.seventh:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView77.getText());
                    textView77.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView77.getText());
                    textView77.setText("");
                }
                break;
            case R.id.eighth:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView88.getText());
                    textView88.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView88.getText());
                    textView88.setText("");
                }
                break;
            case R.id.ninth:
                if (textView1.getText().equals("")) {
                    textView1.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView2.getText().equals("")) {
                    textView2.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView3.getText().equals("")) {
                    textView3.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView4.getText().equals("")) {
                    textView4.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView5.getText().equals("")) {
                    textView5.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView6.getText().equals("")) {
                    textView6.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView7.getText().equals("")) {
                    textView7.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView8.getText().equals("")) {
                    textView8.setText(textView99.getText());
                    textView99.setText("");
                } else if (textView9.getText().equals("")) {
                    textView9.setText(textView99.getText());
                    textView99.setText("");
                }
                break;
        }
    }

    private void cleaningTheSurface() {
        textView1.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        textView4.setVisibility(View.VISIBLE);
        textView5.setVisibility(View.VISIBLE);
        textView6.setVisibility(View.VISIBLE);
        textView7.setVisibility(View.VISIBLE);
        textView8.setVisibility(View.VISIBLE);
        textView9.setVisibility(View.VISIBLE);
        textView11.setVisibility(View.VISIBLE);
        textView22.setVisibility(View.VISIBLE);
        textView33.setVisibility(View.VISIBLE);
        textView44.setVisibility(View.VISIBLE);
        textView55.setVisibility(View.VISIBLE);
        textView66.setVisibility(View.VISIBLE);
        textView77.setVisibility(View.VISIBLE);
        textView88.setVisibility(View.VISIBLE);
        textView99.setVisibility(View.VISIBLE);
        textView1.setText("");
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        textView5.setText("");
        textView6.setText("");
        textView7.setText("");
        textView8.setText("");
        textView9.setText("");
        textView11.setText("");
        textView22.setText("");
        textView33.setText("");
        textView44.setText("");
        textView55.setText("");
        textView66.setText("");
        textView77.setText("");
        textView88.setText("");
        textView99.setText("");
    }

    private boolean checkForFinish(int stage) {
        if (mainActivity.getLength().equals("short")) {
            level = false;
        } else if (mainActivity.getLength().equals("veteran"))
            level = true;
        StringBuilder str = new StringBuilder();
        StringBuilder time = new StringBuilder(words.TIME.toString());
        StringBuilder event = new StringBuilder(words.EVENT.toString());
        StringBuilder corona = new StringBuilder(words.CORONA.toString());
        StringBuilder restore = new StringBuilder(words.RESTORE.toString());
        StringBuilder bookmark = new StringBuilder(words.BOOKMARK.toString());
        StringBuilder microsoft = new StringBuilder(words.MICROSOFT.toString());
        str.append(textView11.getText().toString());
        str.append(textView22.getText().toString());
        str.append(textView33.getText().toString());
        str.append(textView44.getText().toString());
        str.append(textView55.getText().toString());
        str.append(textView66.getText().toString());
        str.append(textView77.getText().toString());
        str.append(textView88.getText().toString());
        str.append(textView99.getText().toString());
        if (str.toString().equals(time.toString())) {
            guessToast(str.toString());
            return true;
        } else if (str.toString().equals(event.toString())) {
            guessToast(str.toString());
            return true;
        } else if (str.toString().equals(corona.toString())) {
            winnerDialog();
            return true;
        } else if (str.toString().equals(restore.toString())) {
            guessToast(str.toString());
            return true;
        } else if (str.toString().equals(bookmark.toString())) {
            guessToast(str.toString());
            return true;
        } else if (str.toString().equals(microsoft.toString())) {
            winnerDialog();
            return true;
        } else
            return false;
    }

    private void winnerDialog() {
        String level = "";
        if (mainActivity.getLength().equals("short"))
            level = "BEGINNER";
        else
            level = "VETERAN";
        new AlertDialog.Builder(this.getContext())
                .setTitle("YOU ARE THE CLEVEREST PERSON IN THE WORLD")
                .setMessage("You've won the " + level + " level! \n Press Ok to exit")
                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                // A null listener allows the button to dismiss the dialog and take no further action.
                //.setNegativeButton(android.R.string.no, null)
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void guessToast(String str) {
        Toast toast = Toast.makeText(this.getContext(),
                "You guessed the word " + str, Toast.LENGTH_SHORT);
        toast.show();
        counter++;
        counterTextView.setText(counter + "");
    }

    private String randomizeLetters(String word) {
        Random random = new Random();
        char a[] = word.toCharArray();
        // Scramble the letters using the standard Fisher-Yates shuffle
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(a.length);
            // Swap letters
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return new String(a);
    }

    private void fillingInTheRandomLayout(int stage, View view) {
        String timeRand = randomizeLetters(words.TIME.toString());
        String eventRand = randomizeLetters(words.EVENT.toString());
        String coronaRand = randomizeLetters(words.CORONA.toString());
        String restoreRand = randomizeLetters(words.RESTORE.toString());
        String bookmarkRand = randomizeLetters(words.BOOKMARK.toString());
        String microsoftRand = randomizeLetters(words.MICROSOFT.toString());
        if (mainActivity.getLength().equals("short")) {
            level = false;
        } else if (mainActivity.getLength().equals("veteran"))
            level = true;
        if (!level && stage == 1) {
            textView1.setText(String.valueOf(timeRand.charAt(0)));
            textView2.setText(String.valueOf(timeRand.charAt(1)));
            textView3.setText(String.valueOf(timeRand.charAt(2)));
            if (timeRand.length() > 3)
                textView4.setText(String.valueOf(timeRand.charAt(3)));
            if (timeRand.length() > 4)
                textView5.setText(String.valueOf(timeRand.charAt(4)));
            if (timeRand.length() > 5)
                textView6.setText(String.valueOf(timeRand.charAt(5)));
            if (timeRand.length() > 6)
                textView7.setText(String.valueOf(timeRand.charAt(6)));
            if (timeRand.length() > 7)
                textView8.setText(String.valueOf(timeRand.charAt(7)));
            if (timeRand.length() > 8)
                textView9.setText(String.valueOf(timeRand.charAt(8)));
        } else if (!level && stage == 2) {
            textView1.setText(String.valueOf(eventRand.charAt(0)));
            textView2.setText(String.valueOf(eventRand.charAt(1)));
            textView3.setText(String.valueOf(eventRand.charAt(2)));
            textView4.setText(String.valueOf(eventRand.charAt(3)));
            if (eventRand.length() > 4)
                textView5.setText(String.valueOf(eventRand.charAt(4)));
            if (eventRand.length() > 5)
                textView6.setText(String.valueOf(eventRand.charAt(5)));
            if (eventRand.length() > 6)
                textView7.setText(String.valueOf(eventRand.charAt(6)));
            if (eventRand.length() > 7)
                textView8.setText(String.valueOf(eventRand.charAt(7)));
            if (eventRand.length() > 8)
                textView9.setText(String.valueOf(eventRand.charAt(8)));
        } else if (!level && stage == 3) {
            textView1.setText(String.valueOf(coronaRand.charAt(0)));
            textView2.setText(String.valueOf(coronaRand.charAt(1)));
            textView3.setText(String.valueOf(coronaRand.charAt(2)));
            textView4.setText(String.valueOf(coronaRand.charAt(3)));
            textView5.setText(String.valueOf(coronaRand.charAt(4)));
            if (coronaRand.length() > 5)
                textView6.setText(String.valueOf(coronaRand.charAt(5)));
            if (coronaRand.length() > 6)
                textView7.setText(String.valueOf(coronaRand.charAt(6)));
            if (coronaRand.length() > 7)
                textView8.setText(String.valueOf(coronaRand.charAt(7)));
            if (coronaRand.length() > 8)
                textView9.setText(String.valueOf(coronaRand.charAt(8)));
        } else if (level && stage == 1) {
            textView1.setText(String.valueOf(restoreRand.charAt(0)));
            textView2.setText(String.valueOf(restoreRand.charAt(1)));
            textView3.setText(String.valueOf(restoreRand.charAt(2)));
            textView4.setText(String.valueOf(restoreRand.charAt(3)));
            textView5.setText(String.valueOf(restoreRand.charAt(4)));
            textView6.setText(String.valueOf(restoreRand.charAt(5)));
            if (restoreRand.length() > 6)
                textView7.setText(String.valueOf(restoreRand.charAt(6)));
            if (restoreRand.length() > 7)
                textView8.setText(String.valueOf(restoreRand.charAt(7)));
            if (restoreRand.length() > 8)
                textView9.setText(String.valueOf(restoreRand.charAt(8)));
        } else if (level && stage == 2) {
            textView1.setText(String.valueOf(bookmarkRand.charAt(0)));
            textView2.setText(String.valueOf(bookmarkRand.charAt(1)));
            textView3.setText(String.valueOf(bookmarkRand.charAt(2)));
            textView4.setText(String.valueOf(bookmarkRand.charAt(3)));
            textView5.setText(String.valueOf(bookmarkRand.charAt(4)));
            textView6.setText(String.valueOf(bookmarkRand.charAt(5)));
            if (bookmarkRand.length() > 6)
                textView7.setText(String.valueOf(bookmarkRand.charAt(6)));
            if (bookmarkRand.length() > 7)
                textView8.setText(String.valueOf(bookmarkRand.charAt(7)));
            if (bookmarkRand.length() > 8)
                textView9.setText(String.valueOf(bookmarkRand.charAt(8)));
        } else if (level && stage == 3) {
            textView1.setText(String.valueOf(microsoftRand.charAt(0)));
            textView2.setText(String.valueOf(microsoftRand.charAt(1)));
            textView3.setText(String.valueOf(microsoftRand.charAt(2)));
            textView4.setText(String.valueOf(microsoftRand.charAt(3)));
            textView5.setText(String.valueOf(microsoftRand.charAt(4)));
            textView6.setText(String.valueOf(microsoftRand.charAt(5)));
            if (microsoftRand.length() > 6)
                textView7.setText(String.valueOf(microsoftRand.charAt(6)));
            if (microsoftRand.length() > 7)
                textView8.setText(String.valueOf(microsoftRand.charAt(7)));
            if (microsoftRand.length() > 8)
                textView9.setText(String.valueOf(microsoftRand.charAt(8)));
        }
    }
}
