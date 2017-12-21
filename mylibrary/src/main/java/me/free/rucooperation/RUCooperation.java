package me.free.rucooperation;

import android.app.Activity;
import android.app.Application;

/**
 * Created by cpf on 2017/8/17.
 */

public class RUCooperation {

    /**
     *  static instance
     */
    private static RUCooperation mInstance = null;

    /**
     *  lifecycle callbacks
     */
    private RUCActivityLifecycleCallbacks mRUCActivityLcCallbacks;

    /**
     *  get default instance
     * @return
     */
    public static RUCooperation getDefault() {
        if (mInstance == null) {
            synchronized (RUCooperation.class){
                if (mInstance == null){
                    mInstance = new RUCooperation();
                }
            }
        }
        return mInstance;
    }

    private RUCooperation() {
    }

    /**
     *  init
     * @param application
     */
    public void init(Application application) {
        mRUCActivityLcCallbacks = new RUCActivityLifecycleCallbacks();
        application.registerActivityLifecycleCallbacks(mRUCActivityLcCallbacks);
    }

    /**
     *  get top activity
     * @return
     */
    protected Activity getStackTopActivity() {
        if (mRUCActivityLcCallbacks == null) return null;

        return mRUCActivityLcCallbacks.getStackTopActivity();
    }
}
