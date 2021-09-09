package com.example.searchnearestattractionapp.ui.add_points_act;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.searchnearestattractionapp.R;
import com.example.searchnearestattractionapp.common.Constants;
import com.example.searchnearestattractionapp.common.EventBus;
import com.example.searchnearestattractionapp.common.TypeTransport;
import com.example.searchnearestattractionapp.common.base_act.BaseActivity;
import com.example.searchnearestattractionapp.data.MyRequest;

import java.util.Calendar;
import java.util.Date;

public class AddPointsActivity extends BaseActivity implements AddPointsActMvp.Presenter
{
    private AddPointsActMvp.MvpView mvpView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new AddPointsActMvpView(getLayoutInflater(), this);
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
    }

    @Override
    public void btnAddDayClicked()
    {
        Toast.makeText(this, "btnAddDayClicked", Toast.LENGTH_SHORT).show();
        Calendar calendar = mvpView.getDate();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = year + "-" + (month + 1) + "-" + day;

        String[] departureInfo = getStationByPosition(mvpView.getStationDeparture());
        String[] arrivalInfo = getStationByPosition(mvpView.getStationArrival());
        String transport_type = TypeTransport.initFromPos(mvpView.getTransportType()).toString();

        MyRequest request = new MyRequest(date, departureInfo, arrivalInfo, transport_type);

        EventBus.request.onNext(request);
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    private String[] getStationByPosition(int position)
    {
        String[] stationInfo = new String[2];
        String stationCode;
        String stationTitle;

        if (position != 0)
        {
            switch (position)
            {
                case 1:
                    stationCode = Constants.PAVELETSKIY_CODE;
                    stationTitle = Constants.PAVELETSKIY;
                    stationInfo[0] = stationCode;
                    stationInfo[1] = stationTitle;
                    break;
                case 2:
                    stationCode = Constants.VERHNIE_KOTLY_CODE;
                    stationTitle = Constants.VERHNIE_KOTLY;
                    stationInfo[0] = stationCode;
                    stationInfo[1] = stationTitle;
                    break;
                case 3:
                    stationCode = Constants.NAGATINSKAYA_CODE;
                    stationTitle = Constants.NAGATINSKAYA;
                    stationInfo[0] = stationCode;
                    stationInfo[1] = stationTitle;
                    break;
                case 4:
                    stationCode = Constants.BARYBINO_CODE;
                    stationTitle = Constants.BARYBINO;
                    stationInfo[0] = stationCode;
                    stationInfo[1] = stationTitle;
                    break;
            }
        }else
        {
            Toast.makeText(this, "Выберите пункт", Toast.LENGTH_SHORT).show();
        }

        return stationInfo;

    }
}







