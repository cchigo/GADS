package me.chigo.gads.fragment.leader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.chigo.gads.R;
import me.chigo.gads.model.hours.HoursResponseData;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.MyViewHolder> {

    private List<HoursResponseData> hoursList;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text_name, text_hours, text_country;
        public CardView leaders_list;

        public MyViewHolder(View view) {
            super(view);
            text_name = (TextView) view.findViewById(R.id.name_tv);
            text_hours = (TextView) view.findViewById(R.id.hours_tv);
            text_country = (TextView) view.findViewById(R.id.country_tv);
            leaders_list = (CardView) view.findViewById(R.id.leaders_list);

        }
    }


    public HoursAdapter(List<HoursResponseData> hoursList, Context context) {
        this.hoursList = hoursList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HoursResponseData leaderDetails = hoursList.get(position);

        holder.text_name.setText(leaderDetails.getName());
        holder.text_hours.setText(Integer.toString(leaderDetails.getHours()));
        holder.text_country.setText(leaderDetails.getCountry());

        holder.leaders_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return hoursList.size();
    }



}
