package com.example.searchnearestattractionapp.ui.add_points_act;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import androidx.databinding.DataBindingUtil;

import com.example.searchnearestattractionapp.R;
import com.example.searchnearestattractionapp.common.DateConverter;
import com.example.searchnearestattractionapp.common.base_act.BaseActMvpView;
import com.example.searchnearestattractionapp.databinding.ActAddPointsBinding;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddPointsActMvpView extends BaseActMvpView implements AddPointsActMvp.MvpView, DatePickerDialog.OnDateSetListener
{
    private AddPointsActMvp.Presenter presenter;
    private ActAddPointsBinding binding;
    private Calendar calendar;


    public AddPointsActMvpView(LayoutInflater inflater, Context context)
    {
        super(inflater);
        binding = DataBindingUtil.inflate(inflater, R.layout.act_add_points, null,false);
        rootView = binding.getRoot();
        initViews(context);
    }

    private void initViews(Context context)
    {
        binding.tvDate.setOnClickListener(v -> {
            showDatePickerDialog(context);
        });

        binding.btnAddDay.setOnClickListener(v -> {
            presenter.btnAddDayClicked();
        });
    }


    @Override
    public View getRootView()
    {
        return rootView;
    }

    @Override
    public void registerPresenter(AddPointsActMvp.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public int getTransportType()
    {
        return getSpinnerPosition(binding.spinTrans.getSelectedItemPosition());
    }

    @Override
    public int getStationDeparture()
    {
        return getSpinnerPosition(binding.spinDeparture.getSelectedItemPosition());
    }


    @Override
    public int getStationArrival()
    {
        return getSpinnerPosition(binding.spinArrival.getSelectedItemPosition());
    }



    @Override
    public Calendar getDate()
    {
        return calendar;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        String sDate = DateConverter.intToString(new int[]{year, month, dayOfMonth});
        binding.tvDate.setText(sDate);
        calendar = new GregorianCalendar(year, month, dayOfMonth);
    }

    private void showDatePickerDialog(Context context)
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context
                ,this
                , Calendar.getInstance().get(Calendar.YEAR)
                , Calendar.getInstance().get(Calendar.MONTH)
                , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }


    private int getSpinnerPosition(int spinnerPosition)
    {
        int selectedPosition;
        switch (spinnerPosition)
        {
            case 1:
                selectedPosition = 1;
                break;
            case 2:
                selectedPosition = 2;
                break;
            case 3:
                selectedPosition = 3;
                break;
            case 4:
                selectedPosition = 4;
                break;
            default:
                selectedPosition = 0;
                break;
        }
        return selectedPosition;
    }
}
