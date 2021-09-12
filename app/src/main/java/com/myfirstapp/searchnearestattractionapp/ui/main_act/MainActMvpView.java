package com.myfirstapp.searchnearestattractionapp.ui.main_act;

import android.view.LayoutInflater;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.myfirstapp.searchnearestattractionapp.R;
import com.myfirstapp.searchnearestattractionapp.common.base_act.BaseActMvpView;
import com.myfirstapp.searchnearestattractionapp.databinding.ActivityMainBinding;

public class MainActMvpView extends BaseActMvpView implements MainActMvp.MvpView
{
    private MainActMvp.Presenter presenter;
    private ActivityMainBinding binding;

    public MainActMvpView(LayoutInflater inflater)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false);
        rootView = binding.getRoot();
        initViews();
    }

    private void initViews()
    {
        binding.lnlSearch.setOnClickListener(v ->
        {
            presenter.lalSearchClicked();
        });
        binding.btnSearch.setOnClickListener(v ->
        {
            presenter.btnSearchScheduleClicked();
        });
    }

    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(MainActMvp.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setDate(String date)
    {
        binding.tvDate.setText(date);
    }

    @Override
    public void setDeparture(String departure)
    {
        binding.tvDeparture.setText(departure);
    }

    @Override
    public void setArrival(String arrival)
    {
        binding.tvArrival.setText(arrival);
    }

    @Override
    public void setTransportType(String transportType)
    {
        binding.tvTransport.setText(transportType);
    }
}