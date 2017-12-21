package me.free.rucooperation;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by cpf on 2017/8/17.
 */

public class RUCDialog {

    /**
     *  show dialog
     */
    private Dialog mDialog;

    /**
     * activity content view
     */
    private View mActivityContentView;

    /**
     *  top activity
     */
    private Activity mActivity;

    public void show(Activity activity, View contentView) {
        mActivityContentView = contentView;
        mActivity = activity;

        mDialog = new Dialog(activity, R.style.dialog);
        mDialog.setContentView(contentView);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setCancelable(true);
        Window localWindow = mDialog.getWindow();
        //设置动画
        localWindow.setGravity(Gravity.CENTER);
        localWindow.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = localWindow.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        localWindow.setAttributes(lp);

        mDialog.show();
    }

    /**
     *  cancel
     */
    public void cancle() {
        mDialog.cancel();
        mDialog = null;
    }

    /**
     *  get activity content view
     * @return
     */
    public View getActivityContentView() {
        RUCLayout rucLayout = (RUCLayout) mActivityContentView;
        View contentView = rucLayout.getActivityContentView();
        ViewGroup viewParent = (ViewGroup) contentView.getParent();
        if (viewParent != null) {
            viewParent.removeView(contentView);
        }
        return contentView;
    }

    /**
     *  get activity of dialog
     * @return
     */
    public Activity getActivityOfDialog() {
        return mActivity;
    }
}
