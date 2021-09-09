package com.example.searchnearestattractionapp.ui.schedule_act;

import android.view.LayoutInflater;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchnearestattractionapp.R;
import com.example.searchnearestattractionapp.adapters.ScheduleItemAdapter;
import com.example.searchnearestattractionapp.common.base_act.BaseActMvpView;
import com.example.searchnearestattractionapp.data.MyScheduleItem;

import java.util.List;

public class ScheduleActMvpView extends BaseActMvpView implements ScheduleActMvp.MvpView
{
    private ScheduleActMvp.Presenter presenter;
    private RecyclerView rvItems;
    private ScheduleItemAdapter adapter;

    public ScheduleActMvpView(LayoutInflater inflater)
    {
        super(inflater);


        rootView = inflater.inflate(R.layout.act_schedule, null, false);
        rvItems = rootView.findViewById(R.id.rv_items);
        adapter = new ScheduleItemAdapter();
        rvItems.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        rvItems.setAdapter(adapter);

    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(ScheduleActMvp.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setScheduleItems(List<MyScheduleItem> items)
    {
        adapter.setItems(items);
    }
}
