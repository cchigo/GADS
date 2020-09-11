package me.chigo.gads.utils;

import android.app.Activity;
import android.content.Intent;

import me.chigo.gads.MainActivity;

public class AppNavigator {

    private final Activity activity;

    public AppNavigator(Activity activity){
        this.activity = activity;
    }

    public void navigateToMainScreen(){
        Intent intent = new Intent(activity, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.overridePendingTransition(0,0);
        activity.startActivity(intent);
    }
}
