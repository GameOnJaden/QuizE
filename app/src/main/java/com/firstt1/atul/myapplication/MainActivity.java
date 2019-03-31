package com.firstt1.atul.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button mTrueButton;
    Button mFalseButton;
    TextView mQuetionTextView;
    TextView mScoreTextView;
    ProgressBar mProgressBar;
    int mIndex = 0;
    int mQuestion;
    int mScore;

    TrueFalse [] mQuestionBank = new TrueFalse[]{

            new TrueFalse(R.string.Question_1,true),
            new TrueFalse(R.string.question_2,true),
            new TrueFalse(R.string.question_3,true),
            new TrueFalse(R.string.question_4,true),
            new TrueFalse(R.string.question_5,true),
            new TrueFalse(R.string.question_6,false),
            new TrueFalse(R.string.question_7,true),
            new TrueFalse(R.string.question_8,false),
            new TrueFalse(R.string.question_9,true),
            new TrueFalse(R.string.question_10,true),
            new TrueFalse(R.string.question_11,false),
            new TrueFalse(R.string.question_12,false),
            new TrueFalse(R.string.question_13,true),

    };

    final int PROGRESS_BAR_INCREMENT = (int)Math.ceil(100.0/mQuestionBank.length);


    @Override
    protected void onCreate(Bundle savedInstanceState)/*initially savedInstanceState = null */
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){

            mScore = savedInstanceState.getInt("ScoreKey");//retrieving the integer value using getInt()
            mIndex = savedInstanceState.getInt("IndexKey");


        }else{

            mScore = 0;
            mIndex = 0;
        }

        mTrueButton = findViewById(R.id.True_Button);
        mFalseButton = findViewById(R.id.False_Button);
        mQuetionTextView = findViewById(R.id.My_Questions);
        mScoreTextView = findViewById(R.id.Score_13);
        mProgressBar = findViewById(R.id.progressBar);

        mScoreTextView.setText("Score" + mScore + "/" + mQuestionBank.length);

        mQuestion = mQuestionBank[mIndex].getQuestionid();
        mQuetionTextView.setText(mQuestion);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckAnswer(true);
                UpdateQuestion();


            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckAnswer(false);
                UpdateQuestion();

            }
        });


    }

    public void UpdateQuestion(){
        mIndex = (mIndex + 1) % mQuestionBank.length;

        if(mIndex == 0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);// this refers to our Main_Activity
            alert.setTitle("Game_Over!!");
            alert.setCancelable(false);
            alert.setMessage("You_Scored_" +mScore+"_Points");
            alert.setPositiveButton("Close_Apllication", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });
            alert.show();
        }
        mQuestion = mQuestionBank[mIndex].getQuestionid();
        mQuetionTextView.setText(mQuestion);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mScoreTextView.setText("Score " + mScore + "/" + mQuestionBank.length);

    }

    public void CheckAnswer(boolean UserSelection){

        boolean CheckAnswer = mQuestionBank[mIndex].isTrueOrFalse();

        if(UserSelection == CheckAnswer){

            Toast.makeText(getApplicationContext(),R.string.Correct_Toast,Toast.LENGTH_SHORT).show();
            mScore = mScore + 1;

        }else{

            Toast.makeText(getApplicationContext(),R.string.Incorrecr_Toast,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){

        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey",mScore);
        outState.putInt("IndexKey",mIndex);

    }
}
