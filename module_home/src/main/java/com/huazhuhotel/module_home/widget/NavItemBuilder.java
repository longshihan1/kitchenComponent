package com.huazhuhotel.module_home.widget;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class NavItemBuilder {
    private String customerUrl;
    private String selectedUrl;
    private String customerStr;
    private String selectedStr;
    @ColorRes
    private int customerColor;
    @ColorRes
    private int selectedColor;
    @DrawableRes
    private int customerDrawable;
    @DrawableRes
    private int selectedDrawable;

    public String getCustomerUrl() {
        return customerUrl;
    }

    public NavItemBuilder setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
        return this;
    }

    public String getSelectedUrl() {
        return selectedUrl;
    }

    public NavItemBuilder setSelectedUrl(String selectedUrl) {
        this.selectedUrl = selectedUrl;
        return this;
    }

    public String getCustomerStr() {
        return customerStr;
    }

    public NavItemBuilder setCustomerStr(String customerStr) {
        this.customerStr = customerStr;
        return this;
    }

    public String getSelectedStr() {
        return selectedStr;
    }

    public NavItemBuilder setSelectedStr(String selectedStr) {
        this.selectedStr = selectedStr;
        return this;
    }

    public int getCustomerColor() {
        return customerColor;
    }

    public NavItemBuilder setCustomerColor(int customerColor) {
        this.customerColor = customerColor;
        return this;
    }

    public int getSelectedColor() {
        return selectedColor;
    }

    public NavItemBuilder setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
        return this;
    }

    public int getCustomerDrawable() {
        return customerDrawable;
    }

    public NavItemBuilder setCustomerDrawable(int customerDrawable) {
        this.customerDrawable = customerDrawable;
        return this;
    }

    public int getSelectedDrawable() {
        return selectedDrawable;
    }

    public NavItemBuilder setSelectedDrawable(int selectedDrawable) {
        this.selectedDrawable = selectedDrawable;
        return this;
    }
}
