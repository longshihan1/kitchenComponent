package com.huazhuhotel.module_home.sort.model.entity;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class SortBean {
    public int bigSortId;
    public String bigSortName;

    public List<ListBean> list;

    public static class ListBean {
        public int smallSortId;
        public String smallSortName;
    }

    public boolean isSelected;
}
