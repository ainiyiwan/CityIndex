package com.zy.xxl.cityindex.ui.model;

import com.zy.xxl.cityindex.common.Constants;

/**
 * Author ： zhangyang
 * Date   ： 2017/11/15
 * Email  :  18610942105@163.com
 * Description  :
 */

public class CityInfoData {

    private String mInitial = Constants.DEFAULT_STR;
    private String mCityName;
    private String mCityNamePinyin;
    private String mCityId;

    public CityInfoData(String cityName, String cityNamePinyin, String cityId) {
        this.mCityName = cityName;
        this.mCityNamePinyin = cityNamePinyin;
        this.mCityId = cityId;
    }

    public String getInitial() {
        return mInitial;
    }

    public void setInitial(String initial) {
        this.mInitial = initial;
    }


    public String getCityName() {
        return mCityName;
    }


    public String getCityNamePinyin() {
        return mCityNamePinyin;
    }

    public String getCityId() {
        return mCityId;
    }
}
