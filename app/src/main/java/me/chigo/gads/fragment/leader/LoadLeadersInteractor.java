package me.chigo.gads.fragment.leader;

import android.content.Context;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.chigo.gads.model.hours.HoursResponseData;
import me.chigo.gads.utils.service.NetworkService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import me.chigo.gads.utils.service.RetrofitInstance;

public class LoadLeadersInteractor {
    private LeaderContract.LeadersListener leadersListener;

    final String LEADERS = "Leaders hours";

    public LoadLeadersInteractor(LeaderContract.LeadersListener leadersListener){
        this.leadersListener = leadersListener;

    }

    public void transactionHistory(Context context) {

        transactionHistoryObserver().subscribeWith(transactionHistoryObservable(context));
    }

    public Observable<List<HoursResponseData>> transactionHistoryObserver() {

        return RetrofitInstance.getRetrofitInstance().create(NetworkService.class)
                .getLeadersHours()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver <List<HoursResponseData>> transactionHistoryObservable(final Context context){
        return new DisposableObserver<List<HoursResponseData>>() {
//            @Override
//            public void onNext(HoursResponseData hoursResponseModel) {
//
//            //    Log.d(TRANS_HISTORY, "DATA" + hoursResponseModel.getData());
////                if(hoursResponseModel == null){
////                    leadersListener.onFailure( "Error loading Leaders, Please try again");
////                }else{
//                    leadersListener.onSuccess(context,hoursResponseModel);
//               // }
//
//            }

            @Override
            public void onNext(List<HoursResponseData> hoursResponseData) {
                leadersListener.onSuccess(context, hoursResponseData);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(LEADERS,"Error " + e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(LEADERS,"Completed");
            }
        };
    }

}
