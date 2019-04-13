package com.huazhuhotel.module_home.mvp.model;

/**
 * Created by LONGHE001.
 *
 * @time 2019/4/13 0013
 * @des
 * @function
 */

public class CommentUploadInfo {

    /**
     * state : success
     * result : {"comment_id":6506104}
     * message : 发布成功，+2经验值！
     */

    private String state;
    private ResultBean result;
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class ResultBean {
        /**
         * comment_id : 6506104
         */

        private int comment_id;

        public int getComment_id() {
            return comment_id;
        }

        public void setComment_id(int comment_id) {
            this.comment_id = comment_id;
        }
    }
}
