package com.huazhuhotel.module_home.mvp.model;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/26 0026
 * @des
 * @function
 */

public class FollowInfo {


    /**
     * state : success
     * result : {"fid":"385864","relationship":0}
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
         * fid : 385864
         * relationship : 0
         */

        private String fid;
        private int relationship;

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public int getRelationship() {
            return relationship;
        }

        public void setRelationship(int relationship) {
            this.relationship = relationship;
        }
    }
}
