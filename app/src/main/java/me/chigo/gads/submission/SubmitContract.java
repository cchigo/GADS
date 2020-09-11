package me.chigo.gads.submission;

import android.content.Context;

import java.util.List;

import me.chigo.gads.model.hours.HoursResponseData;

public interface SubmitContract {
    interface SubmitView {

        void showToast(String message);

        void showProgress();

        void hideProgress();


        void submit();
    }

    interface SubmitListener{

        void onSuccess(Context context);

        void onFailure(String message);
    }
}
