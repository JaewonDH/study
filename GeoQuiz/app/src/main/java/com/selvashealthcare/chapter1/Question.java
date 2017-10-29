package com.selvashealthcare.chapter1;

/**
 * Created by jaewon on 2017-10-29.
 */

public class Question {
    private int mTextResid;
    private boolean mAnswerTrue;

    public Question(int TextResid,boolean AnswerTrue){
        mTextResid=TextResid;
        mAnswerTrue=AnswerTrue;
    }

    public int getTextResid() {
        return mTextResid;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setTextResid(int textResid) {
        mTextResid = textResid;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
