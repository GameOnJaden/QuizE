package com.firstt1.atul.myapplication;

public class TrueFalse {

    private int mQuestionid;
    private boolean mTrueOrFalse;

    public TrueFalse(int Question_id,boolean TrueOrFalse){

        mQuestionid = Question_id;
        mTrueOrFalse = TrueOrFalse;
    }

    public int getQuestionid() {
        return mQuestionid;
    }

    public void setQuestionid(int questionid) {
        mQuestionid = questionid;
    }

    public boolean isTrueOrFalse() {
        return mTrueOrFalse;
    }

    public void setTrueOrFalse(boolean trueOrFalse) {
        mTrueOrFalse = trueOrFalse;
    }
}
