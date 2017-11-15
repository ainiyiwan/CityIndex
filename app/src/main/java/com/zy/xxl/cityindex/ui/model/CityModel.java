package com.zy.xxl.cityindex.ui.model;


import com.zy.xxl.cityindex.base.BaseModel;
import com.zy.xxl.cityindex.common.TaskCallback;
import com.zy.xxl.cityindex.common.TaskScheduler;
import com.zy.xxl.cityindex.db.DBManage;

import java.util.List;

/**
 * Created by SilenceDut on 16/10/28.
 */

public class CityModel extends BaseModel {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void getAllCities(final TaskCallback.Success<List<CityInfoData>> taskCallback) {
        TaskScheduler.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                List<CityInfoData> allCities = DBManage.getInstance().getAllCities();
                TaskScheduler.notifySuccessToUI(allCities,taskCallback);
            }
        });
    }

    public void matchCities(final String key, final TaskCallback.Success<List<CityInfoData>> matchedCityCallback) {
        TaskScheduler.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                List<CityInfoData> matchedCities = DBManage.getInstance().searchCity(key);
                TaskScheduler.notifySuccessToUI(matchedCities,matchedCityCallback);
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
