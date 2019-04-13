package com.huazhuhotel.module_home.mvp.model;

/**
 * Created by LONGHE001.
 *
 * @time 2019/4/13 0013
 * @des
 * @function
 */

public class CollectaddInfo {


    /**
     * state : success
     * result : {"sm":1,"msg":"收藏成功"}
     */

    private String state;
    private ResultBean result;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sm : 1
         * msg : 收藏成功
         */

        private int sm;
        private String msg;

        public int getSm() {
            return sm;
        }

        public void setSm(int sm) {
            this.sm = sm;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
