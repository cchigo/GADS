package me.chigo.gads.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import me.chigo.gads.R;

public class Utility {
    public static ProgressDialog pbar;



    public static void shortToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }



    public static void showProgressDialog(Context context, boolean cancelable) {
        if (pbar == null) {
            pbar = new ProgressDialog(context);
        } else if (pbar != null) {
            pbar.dismiss();
            pbar = new ProgressDialog(context);
        }

        pbar.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pbar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.custom_dialog));
        pbar.setCancelable(cancelable);
        pbar.setIndeterminate(true);
        pbar.show();
        pbar.setContentView(R.layout.layout_custom_dialog);
    }
    public static void hideProgressDialog(Activity activity) {
        if (pbar != null && !activity.isFinishing())
            pbar.dismiss();
        pbar = null;
    }

}
