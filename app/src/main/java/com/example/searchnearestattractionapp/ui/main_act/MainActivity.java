package com.example.searchnearestattractionapp.ui.main_act;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.searchnearestattractionapp.common.Constants;
import com.example.searchnearestattractionapp.common.EventBus;
import com.example.searchnearestattractionapp.common.base_act.BaseActivity;
import com.example.searchnearestattractionapp.data.MyRequest;
import com.example.searchnearestattractionapp.ui.add_points_act.AddPointsActivity;
import com.example.searchnearestattractionapp.ui.schedule_act.ScheduleActivity;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements MainActMvp.Presenter
{
    private MainActMvp.MvpView mvpView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mvpView = new MainActMvpView(getLayoutInflater());
        mvpView.registerPresenter(this);
        setContentView(mvpView.getRootView());
    }


    @Override
    public void lalSearchClicked()
    {
        Intent intent = new Intent(this, AddPointsActivity.class);
        startActivityForResult(intent, Constants.REQUEST_CODE_ADD_POINTS);
    }

    @Override
    public void btnSearchScheduleClicked()
    {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            Disposable disposable = EventBus.request.subscribe(new Consumer<MyRequest>()
            {
                @Override
                public void accept(MyRequest myRequest) throws Exception
                {
                    mvpView.setDate(myRequest.getDate());
                    mvpView.setDeparture(myRequest.getDepartureInfo()[1]);
                    mvpView.setArrival(myRequest.getArrivalInfo()[1]);
                    mvpView.setTransportType(onTranslate(myRequest.getTransport_type()));
                }
            });
            compositeDisposable.add(disposable);
        }
    }
    private String onTranslate(String enType)
    {
        String rusType = null;
        switch (enType)
        {
            case "Bus":
                rusType = "Автобус";
                break;
            case "Suburban":
                rusType = "Электричка";
                break;
            case "Train":
                rusType = "Поезд";
                break;
            case "Plane":
                rusType = "Самолет";
                break;
            default:
                Toast.makeText(this, "Вид транспорта не выбран", Toast.LENGTH_SHORT).show();
        }
        return rusType;
    }
}


