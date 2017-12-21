package me.free.rucooperation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpf on 2017/8/17.
 */

public class RUCActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {


    /**
     *  stack all activitys
     */
    private List<Activity> mStackActivitys;


    public RUCActivityLifecycleCallbacks() {
        mStackActivitys = new ArrayList<>();
    }

    /**
     *  get stack top activity
     * @return
     */
    public Activity getStackTopActivity() {
        return mStackActivitys.get(mStackActivitys.size() - 1);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        mStackActivitys.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        mStackActivitys.remove(activity);
    }
}
