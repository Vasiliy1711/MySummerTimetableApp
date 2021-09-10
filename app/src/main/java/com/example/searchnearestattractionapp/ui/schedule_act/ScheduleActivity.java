package com.example.searchnearestattractionapp.ui.schedule_act;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.searchnearestattractionapp.common.BaseDownloader;
import com.example.searchnearestattractionapp.common.Callback;
import com.example.searchnearestattractionapp.common.DateConverter;
import com.example.searchnearestattractionapp.common.EventBus;
import com.example.searchnearestattractionapp.common.base_act.BaseActivity;
import com.example.searchnearestattractionapp.data.MyRequest;
import com.example.searchnearestattractionapp.data.MyScheduleItem;
import com.example.searchnearestattractionapp.pojo.response1.NetworkResponse1;
import com.example.searchnearestattractionapp.pojo.response1.ScheduleItem1;
import com.example.searchnearestattractionapp.pojo.response1.StationType;
import com.example.searchnearestattractionapp.pojo.response1.Thread;
import com.example.searchnearestattractionapp.ui.base_search_act.AdvSearchAct;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ScheduleActivity extends BaseActivity implements ScheduleActMvp.Presenter
{
    private ScheduleActMvp.MvpView mvpView;
    private List<MyScheduleItem> myScheduleItems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new ScheduleActMvpView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
        downloadData();
    }

    private void downloadData()
    {
        Disposable disposable = EventBus.request.subscribe(new Consumer<MyRequest>()
        {
            @Override
            public void accept(MyRequest myRequest) throws Exception
            {
                BaseDownloader.getScheduleFromNetwork(compositeDisposable, myRequest.getDepartureInfo()[0]
                        , myRequest.getArrivalInfo()[0], myRequest.getTransport_type(), DateConverter.stringFromInt(myRequest.getDate())
                        , new Callback<NetworkResponse1>()
                {
                    @Override
                    public void onSuccess(NetworkResponse1 response)
                    {
                        if (response != null)
                        {
                            List<ScheduleItem1> item1s = response.getSchedule();

                            for (int i = 0; i < item1s.size(); i++)
                            {

                                ScheduleItem1 item1 = item1s.get(i);
                                StationType from = item1.getFrom();
                                Thread thread = item1.getThread();
                                StationType to = item1.getTo();
                                String departureTime = item1.getDeparture();
                                String arrivalTime = (String) item1.getArrival();
                                String stops = item1.getStops();
                                String duration = item1.getDuration();
                                String uid = thread.getUid();
                                String number = thread.getNumber();
                                String threadTitle = thread.getTitle();
                                String transType = thread.getTransportType();
                                String depStationCode = from.getCode();
                                String depStationTitle = from.getTitle();
                                String arrStationCode = to.getCode();
                                String arrStationTitle = to.getTitle();
                                MyScheduleItem myScheduleItem = new MyScheduleItem(number, threadTitle,
                                        departureTime, depStationTitle, arrivalTime, arrStationTitle,
                                        stops, duration, transType);
                                myScheduleItems.add(myScheduleItem);
                            }
                            mvpView.setScheduleItems(myScheduleItems);
                        }
                    }

                    @Override
                    public void onError()
                    {
                        onResponseNull();
                        finish();
                    }
                });
            }
        });
        compositeDisposable.add(disposable);
    }

    private void onErrorToast()
    {
        Toast.makeText(this, "Download Error!", Toast.LENGTH_SHORT).show();
    }
    private void onResponseNull()
    {
        Toast.makeText(this, "Расписание доступно на 30 дней до и 11 месяцев после текущей даты", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void btnAdvSearchClicked()
    {
        Intent intent = new Intent(this, AdvSearchAct.class);
        startActivity(intent);
    }
}
