package com.example.searchnearestattractionapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchnearestattractionapp.R;
import com.example.searchnearestattractionapp.common.DateConverter;
import com.example.searchnearestattractionapp.data.MyScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleItemAdapter extends RecyclerView.Adapter<ScheduleItemAdapter.ScheduleItemsHolder>
{
    private List<MyScheduleItem> items;


    public ScheduleItemAdapter()
    {
        items = new ArrayList<>();

    }

    public List<MyScheduleItem> getItems()
    {
        return items;
    }

    public void setItems(List<MyScheduleItem> items)
    {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScheduleItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new ScheduleItemsHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleItemsHolder holder, int position)
    {
        MyScheduleItem item = items.get(position);
        holder.ivTransType.setImageResource(R.drawable.suburban2);
        holder.tvNumberTitle.setText(item.getNumber() + " " + item.getThreadTitle());

        holder.tvExcept.setText(item.getStops());
        holder.tvPointDep.setText(item.getDepStationTitle());
        holder.tvPointArr.setText(item.getArrStationTitle());
        holder.tvTimeDep.setText(DateConverter.getTimeFromJSON(item.getDepartureTime()));
        holder.tvTimeArr.setText(DateConverter.getTimeFromJSON(item.getArrivalTime()));
        holder.tvDayDep.setText(DateConverter.getDateFromJSON(item.getDepartureTime()));
        holder.tvDayArr.setText(DateConverter.getDateFromJSON(item.getArrivalTime()));
        setTravelTime(item, holder);
    }

    @Override
    public int getItemCount()
    {
        if (items == null)
        {
            return 0;
        }
        return items.size();
    }



    class ScheduleItemsHolder extends RecyclerView.ViewHolder
    {
        private ImageView ivTransType;
        private TextView tvNumberTitle;
        private TextView tvDayDep;
        private TextView tvTimeDep;
        private TextView tvPointDep;
        private TextView tvDayArr;
        private TextView tvTimeArr;
        private TextView tvPointArr;
        private TextView tvExcept;
        private TextView tvTime1;
        private TextView tvTime2;
        private TextView tvTime3;
        private TextView tvTime4;

        public ScheduleItemsHolder(@NonNull View itemView)
        {
            super(itemView);
            ivTransType = itemView.findViewById(R.id.iv_trans_type);
            tvNumberTitle = itemView.findViewById(R.id.tv_number_title);
            tvDayDep = itemView.findViewById(R.id.tv_day_dep);
            tvTimeDep = itemView.findViewById(R.id.tv_time_dep);
            tvPointDep = itemView.findViewById(R.id.tv_point_dep);
            tvDayArr = itemView.findViewById(R.id.tv_day_arr);
            tvTimeArr = itemView.findViewById(R.id.tv_time_arr);
            tvPointArr = itemView.findViewById(R.id.tv_point_arr);
            tvExcept = itemView.findViewById(R.id.tv_except);
            tvTime1 = itemView.findViewById(R.id.tv_time1);
            tvTime2 = itemView.findViewById(R.id.tv_time2);
            tvTime3 = itemView.findViewById(R.id.tv_time3);
            tvTime4 = itemView.findViewById(R.id.tv_time4);
        }
    }
    private int getHours(String duration)
    {
        int bD = (int) Double.parseDouble(duration);
        int hours = bD / 60/ 60;
        return hours;
    }
    private int getMinutes(String duration)
    {
        int bD =(int) Double.parseDouble(duration);
        int min = (bD % 3600) / 60;
        return min;
    }
    private void setTravelTime(MyScheduleItem item, ScheduleItemsHolder holder)
    {
        if (getHours(item.getDuration()) != 0)
        {
            holder.tvTime1.setText("" + getHours(item.getDuration()));
            holder.tvTime1.setVisibility(View.VISIBLE);
            holder.tvTime2.setVisibility(View.VISIBLE);
        }else
        {
            holder.tvTime1.setVisibility(View.GONE);
            holder.tvTime2.setVisibility(View.GONE);
        }
        if (getMinutes(item.getDuration()) != 0)
        {
            holder.tvTime3.setText("" + getMinutes(item.getDuration()));
        }else
        {
            holder.tvTime3.setVisibility(View.GONE);
            holder.tvTime4.setVisibility(View.GONE);
        }
    }
}
