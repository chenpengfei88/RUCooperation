package me.free.rucooperation;

/**
 * Created by cpf on 2017/8/17.
 */

public class RUCTip {

    /**
     *  view spacing left
     */
    private int mLeft;

    /**
     *  view spacing right
     */
    private int mTop;

    /**
     *  view tip text
     */
    private String mTip;

    public int getLeft() {
        return mLeft;
    }

    public void setLeft(int mLeft) {
        this.mLeft = mLeft;
    }

    public int getTop() {
        return mTop;
    }

    public void setTop(int mTop) {
        this.mTop = mTop;
    }

    public String getTip() {
        if (mTip == null) mTip = "";
        return mTip;
    }

    public void setTip(String mTip) {
        this.mTip = mTip;
    }


}
