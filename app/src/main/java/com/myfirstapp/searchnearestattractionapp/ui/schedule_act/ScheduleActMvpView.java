package com.myfirstapp.searchnearestattractionapp.ui.schedule_act;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myfirstapp.searchnearestattractionapp.R;
import com.myfirstapp.searchnearestattractionapp.adapters.ScheduleItemAdapter;
import com.myfirstapp.searchnearestattractionapp.common.base_act.BaseActMvpView;
import com.myfirstapp.searchnearestattractionapp.data.MyScheduleItem;

import java.util.List;

public class ScheduleActMvpView extends BaseActMvpView implements ScheduleActMvp.MvpView
{
    private ScheduleActMvp.Presenter presenter;
    private RecyclerView rvItems;
    private ScheduleItemAdapter adapter;
    private TextView btnAdvSearch;

    public ScheduleActMvpView(LayoutInflater inflater)
    {
        super(inflater);
        rootView = inflater.inflate(R.layout.act_schedule, null, false);
        rvItems = rootView.findViewById(R.id.rv_items);
        adapter = new ScheduleItemAdapter();
        rvItems.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        rvItems.setAdapter(adapter);
        initViews();
    }

    private void initViews()
    {
        btnAdvSearch = rootView.findViewById(R.id.btn_adv_search);
        btnAdvSearch.setOnClickListener(v -> {
            presenter.btnAdvSearchClicked();
        });
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
