package me.free.rucooperation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cpf on 2017/8/18.
 */

public class RUCBroadcastReceiver extends BroadcastReceiver {

    /**
     *  dialog
     */
    private static RUCDialog mRucDialog;

    @Override
    public void onReceive(Context context, Intent intent) {
        Activity topActivity = RUCooperation.getDefault().getStackTopActivity();

        if (mRucDialog == null) {
            RUCLayout rucLayout = new RUCLayout(topActivity, getViewOfActivity(topActivity));

            mRucDialog = new RUCDialog();
            mRucDialog.show(topActivity, rucLayout);
        } else {
            mRucDialog.cancle();
            recoveryContentViewToActivity(mRucDialog.getActivityOfDialog(), mRucDialog.getActivityContentView());

            mRucDialog = null;
        }
    }

    /**
     * recovery view to activity
     * @param activity
     * @param activityContentView
     */
    private void recoveryContentViewToActivity(Activity activity, View activityContentView) {
        getContentViewGroup(activity).addView(activityContentView);
    }

    /**
     *  get contentview of decorView
     * @param activity
     * @return
     */
    private ViewGroup getContentViewGroup(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        return  (ViewGroup) decorView.findViewById(android.R.id.content);
    }

    /**
     *  get view of activity
     * @param activity
     * @return
     */
    private ViewGroup getViewOfActivity(Activity activity) {
        ViewGroup contentViewGroup = (ViewGroup) getContentViewGroup(activity).getChildAt(0);

        ViewGroup viewParent = (ViewGroup) contentViewGroup.getParent();
        if (viewParent != null) {
            viewParent.removeView(contentViewGroup);
        }
        return contentViewGroup;
    }
}
