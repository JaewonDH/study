package com.selvashealthcare.chapter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private TextView mQuestionTextView;
    private int  mCurrentIndex=0;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.button1);
        mFalseButton = (Button) findViewById(R.id.button2);
        mNextButton = (ImageButton) findViewById(R.id.button3);
        mPreviousButton = (ImageButton) findViewById(R.id.button4);
        mQuestionTextView = (TextView) findViewById(R.id.QuestionTextView);

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextQuestion();
            }
        });

        UpdateTextView();
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CheckAnsewer(true);
            }
        });

        View.OnClickListener i= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAnsewer(false);
            }
        };
        mFalseButton.setOnClickListener(i);


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NextQuestion();
            }
        });

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex--;
                if(mCurrentIndex < 0){
                    mCurrentIndex=4;
                }
                UpdateTextView();
            }
        });
    }

    private void CheckAnsewer(boolean userPress){
        if(mQuestionBank[mCurrentIndex].isAnswerTrue()==userPress){
            Toast.makeText(QuizActivity.this,R.string.toast_true,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(QuizActivity.this,R.string.toast_false,Toast.LENGTH_SHORT).show();
        }
    }


    public void UpdateTextView(){
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResid());
    }

    public void NextQuestion(){
        mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;
        UpdateTextView();
    }




}

