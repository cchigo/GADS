package me.chigo.gads.fragment.leader;

import android.content.Context;

import java.util.List;

import me.chigo.gads.model.hours.HoursResponseData;

public class  LeaderPresenter implements LeaderContract.LeadersListener {

    private LeaderContract.LeaderView leaderView;
    private LoadLeadersInteractor loadLeadersInteractor;

    public LeaderPresenter(LeaderContract.LeaderView leaderView){
        this.leaderView = leaderView;
        loadLeadersInteractor = new LoadLeadersInteractor(this);
    }
    @Override
    public void onSuccess(Context context, List<HoursResponseData> hoursResponseModel) {

        leaderView.hideProgress();
        leaderView.loadLeaders(hoursResponseModel);
    }

    @Override
    public void onFailure(String message) {

        leaderView.hideProgress();
        leaderView.showToast(message);
    }

    public void onDestroy(){
        leaderView = null;
    }

    public void getHourLeaders(Context context){

        leaderView.showProgress();
        loadLeadersInteractor.transactionHistory(context);
    }
}
