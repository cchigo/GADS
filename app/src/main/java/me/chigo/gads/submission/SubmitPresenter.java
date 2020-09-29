package me.chigo.gads.submission;

import android.content.Context;

import me.chigo.gads.fragment.leader.LeaderContract;
import me.chigo.gads.fragment.leader.LoadLeadersInteractor;

public class SubmitPresenter implements SubmitContract.SubmitListener {

    private SubmitContract.SubmitView submitView;
    private SubmitInteractor submitInteractor;

    public SubmitPresenter(SubmitContract.SubmitView submitView){
        this.submitView = submitView;
        submitInteractor = new SubmitInteractor(this);
    }

    @Override
    public void onSuccess(Context context) {

        submitView.hideProgress();
        submitView.submit();
    }

    @Override
    public void onFailure(String message) {

        submitView.hideProgress();
        submitView.showToast(message);
    }

    public void onDestroy(){
        submitView = null;
    }

    public void submitReq(Context context, String firstName, String lastName, String emailAdd, String githubLink){

        submitView.showProgress();
        submitInteractor.submit(context, firstName, lastName, emailAdd, githubLink);
    }
}
