package com.glg.easyloading.lib;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import java.util.Stack;

public final class EasyLoading {
    private static Stack<Activity> activityStack;

    private static Application mAPP;
    private static EasyLoading instance;
    private EasyLoading() {
    }

    public static EasyLoading getInstance() {
        if (instance == null) {
            instance = new EasyLoading();
        }
        return instance;
    }
    public   void  init(final Application application){
        mAPP=application;
    }

    /**
     * 添加Activity到堆栈
     */
    public static void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    public static void  showLoading(){
        Intent intent = new Intent();
        intent.setClass(mAPP, EasyLoadingDialog.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags( Intent.FLAG_ACTIVITY_NO_ANIMATION );
        mAPP.startActivity(intent);
    }

    public static void  dismissLoading(){
        if(activityStack==null){
            return;
        }
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(EasyLoadingDialog.class)) {
                activity.finish();
            }
        }
        activityStack.clear();
    }
}
