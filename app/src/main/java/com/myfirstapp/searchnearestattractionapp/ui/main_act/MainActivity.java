package com.myfirstapp.searchnearestattractionapp.ui.main_act;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.myfirstapp.searchnearestattractionapp.common.Constants;
import com.myfirstapp.searchnearestattractionapp.common.DateConverter;
import com.myfirstapp.searchnearestattractionapp.common.EventBus;
import com.myfirstapp.searchnearestattractionapp.common.base_act.BaseActivity;
import com.myfirstapp.searchnearestattractionapp.data.MyRequest;
import com.myfirstapp.searchnearestattractionapp.ui.add_points_act.AddPointsActivity;
import com.myfirstapp.searchnearestattractionapp.ui.schedule_act.ScheduleActivity;

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
                    mvpView.setDate(DateConverter.intToString(myRequest.getDate()));
                    mvpView.setDeparture(myRequest.getDepartureInfo()[1]);
                    mvpView.setArrival(myRequest.getArrivalInfo()[1]);
                    mvpView.setTransportType(myRequest.getTransport_type());
                }
            });
            compositeDisposable.add(disposable);
        }
    }
//    private String onTranslate(String enType)
//    {
//        String rusType = null;
//        switch (enType)
//        {
//            case "Bus":
//                rusType = TypeTransport.Bus.toString();
//                break;
//            case "Suburban":
//                rusType = TypeTransport.Suburban.toString();
//                break;
//            case "Train":
//                rusType = TypeTransport.Train.toString();
//                break;
//            case "Plane":
//                rusType = TypeTransport.Plane.toString();
//                break;
//            default:
//                Toast.makeText(this, "Вид транспорта не выбран", Toast.LENGTH_SHORT).show();
//                Log.e("TAG", "onTranslate: " + rusType);
//        }
//        return rusType;
//    }
}


