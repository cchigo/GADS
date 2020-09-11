package me.chigo.gads.fragment.leader;

import android.content.Context;

import java.util.List;

import me.chigo.gads.model.hours.HoursResponseData;

public interface LeaderContract {
    interface LeaderView {

        void showToast(String message);

        void showProgress();

        void hideProgress();


        void loadLeaders(List<HoursResponseData> hoursResponseModel);
    }

    interface LeadersListener{

        void onSuccess(Context context, List<HoursResponseData> hoursResponseModel);

        void onFailure(String message);
    }
}
