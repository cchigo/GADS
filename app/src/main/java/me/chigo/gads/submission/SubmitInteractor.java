package me.chigo.gads.submission;

import android.content.Context;
import android.renderscript.Script;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.chigo.gads.fragment.leader.LeaderContract;
import me.chigo.gads.model.hours.HoursResponseData;
import me.chigo.gads.utils.service.NetworkService;
import me.chigo.gads.utils.service.RetrofitInstance;
import me.chigo.gads.utils.service.SubmitRetrofitInstance;

public class SubmitInteractor {
    private SubmitContract.SubmitListener submitListener;

    final String SUBMIT = "Submit Project";

    public SubmitInteractor(SubmitContract.SubmitListener submitListener){
        this.submitListener = submitListener;

    }

    public void submit(Context context, String firstName, String lastName, String emailAdd, String githubLink) {

        transactionHistoryObserver().subscribeWith(transactionHistoryObservable(firstName, lastName, emailAdd, githubLink));
    }


    public Observable transactionHistoryObserver(String firstName, String lastName, String emailAdd, String githubLink) {

        return SubmitRetrofitInstance.getRetrofitInstance().create(NetworkService.class)
                .submit(firstName, lastName, emailAdd, githubLink)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<Object> transactionHistoryObservable(final Context context){
        return new DisposableObserver() {

            @Override
            public void onNext() {
                submitListener.onSuccess(context);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(SUBMIT,"Error " + e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(SUBMIT,"Completed");
            }
        };
    }
}
