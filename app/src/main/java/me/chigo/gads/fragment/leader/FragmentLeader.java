package me.chigo.gads.fragment.leader;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.chigo.gads.R;
import me.chigo.gads.model.hours.HoursResponseData;
import me.chigo.gads.utils.Utility;

public class FragmentLeader extends Fragment implements LeaderContract.LeaderView{
    private RecyclerView leaders_rv;
    private HoursAdapter hAdapter;
    private TextView empty_view;
    LeaderPresenter leaderPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = prepareViews(inflater, container);
        leaderPresenter = new LeaderPresenter(this);
        leaderPresenter.getHourLeaders(getContext());
       return rootView;
    }

    private View prepareViews(LayoutInflater inflater, ViewGroup container) {
        final View mainView = inflater.inflate(R.layout.fragment_one, container, false);

        leaders_rv = (RecyclerView) mainView.findViewById(R.id.leaders_rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        leaders_rv.setLayoutManager(mLayoutManager);
        leaders_rv.setItemAnimator(new DefaultItemAnimator());

        empty_view = (TextView) mainView.findViewById(R.id.empty_view);

        return mainView;
    }

    @Override
    public void showToast(String message) {
        Utility.shortToast(getContext(), message);
    }

    @Override
    public void showProgress() {
        Utility.showProgressDialog(getContext(), false);
    }

    @Override
    public void hideProgress() {
        Utility.hideProgressDialog(getActivity());
    }


    @Override
    public void loadLeaders(List<HoursResponseData> hoursResponseModel) {
        List<HoursResponseData> hoursResponseModels = (List<HoursResponseData>) hoursResponseModel;

            hAdapter = new HoursAdapter(hoursResponseModels, getContext());
            leaders_rv.setAdapter(hAdapter);
            empty_view.setVisibility(View.GONE);
            leaders_rv.setVisibility(View.VISIBLE);
            //recycler_trans_history.addItemDecoration(new DividerItemDecoration(recycler_trans_history.getContext(), DividerItemDecoration.VERTICAL));

    }
}