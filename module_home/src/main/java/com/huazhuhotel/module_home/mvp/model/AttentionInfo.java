package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 *
 * 关注的人
 */

public class AttentionInfo {


    /**
     * state : success
     * result : {"follows":[{"userid":"1704870","user_id":"1704870","nick":"糖小饼","user_photo":"http://i1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/a/2/a/140_u4095206075346702231831.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":1,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/a/2/a/yuan_u4095206075346702231831.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":7,"is_prime":false,"relationship":1},{"userid":"4264926","user_id":"4264926","nick":"吾爱烘焙_","user_photo":"http://i1.douguo.net/upload/photo/3/d/4/70_u9787988960052104191357.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/3/d/4/140_u9787988960052104191357.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":1,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/3/d/4/yuan_u9787988960052104191357.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":6,"is_prime":false,"relationship":1},{"userid":"2606056","user_id":"2606056","nick":"FS_sweety","user_photo":"http://i1.douguo.net/upload/photo/a/e/8/70_u6419677946216803251648.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/a/e/8/140_u6419677946216803251648.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":1,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/a/e/8/yuan_u6419677946216803251648.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":3,"is_prime":false,"relationship":1},{"userid":"619960","user_id":"619960","nick":"妍维尼私房菜","user_photo":"http://i1.douguo.net/upload/photo/d/3/5/70_u29318306000555.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/d/3/5/140_u29318306000555.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":1,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/d/3/5/yuan_u29318306000555.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":6,"is_prime":false,"relationship":1},{"userid":"21078489","user_id":"21078489","nick":"爱美食的拉拉","user_photo":"http://i1.douguo.net/upload/photo/3/9/5/70_u06251292567706201121.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/3/9/5/140_u06251292567706201121.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":0,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/3/9/5/yuan_u06251292567706201121.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":6,"is_prime":false,"relationship":1}]}
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
        private List<FollowsBean> follows;

        public List<FollowsBean> getFollows() {
            return follows;
        }

        public void setFollows(List<FollowsBean> follows) {
            this.follows = follows;
        }

        public static class FollowsBean {
            /**
             * userid : 1704870
             * user_id : 1704870
             * nick : 糖小饼
             * user_photo : http://i1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg
             * avatar_medium : http://i1.douguo.net/upload/photo/a/2/a/140_u4095206075346702231831.jpg
             * gender : 2
             * email :
             * mobile :
             * user_cover :
             * verified : 1
             * sign :
             * weibo_nick :
             * qq_weibo_nick :
             * qzone_nick :
             * setted_email : 0
             * user_large_photo : http://i1.douguo.net/upload/photo/a/2/a/yuan_u4095206075346702231831.jpg
             * followers_count : 0
             * following_count : 0
             * location : 0
             * diaries_count : 0
             * recipes_count : 0
             * favorites_count : 0
             * favor_diaries_count : 0
             * introduction :
             * dishes_count : 0
             * point : 0
             * birthday :
             * regist_time :
             * fc : 0
             * pc : 0
             * lv : 0
             * age :
             * subscription : 0
             * subscription_article_count : 0
             * coursecount : 0
             * lvl : 7
             * is_prime : false
             * relationship : 1
             */

            private String userid;
            private String user_id;
            private String nick;
            private String user_photo;
            private String avatar_medium;
            private int gender;
            private String email;
            private String mobile;
            private String user_cover;
            private int verified;
            private String sign;
            private String weibo_nick;
            private String qq_weibo_nick;
            private String qzone_nick;
            private int setted_email;
            private String user_large_photo;
            private int followers_count;
            private int following_count;
            private int location;
            private int diaries_count;
            private int recipes_count;
            private int favorites_count;
            private int favor_diaries_count;
            private String introduction;
            private int dishes_count;
            private int point;
            private String birthday;
            private String regist_time;
            private int fc;
            private int pc;
            private int lv;
            private String age;
            private int subscription;
            private int subscription_article_count;
            private int coursecount;
            private int lvl;
            private boolean is_prime;
            private int relationship;

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getUser_photo() {
                return user_photo;
            }

            public void setUser_photo(String user_photo) {
                this.user_photo = user_photo;
            }

            public String getAvatar_medium() {
                return avatar_medium;
            }

            public void setAvatar_medium(String avatar_medium) {
                this.avatar_medium = avatar_medium;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getUser_cover() {
                return user_cover;
            }

            public void setUser_cover(String user_cover) {
                this.user_cover = user_cover;
            }

            public int getVerified() {
                return verified;
            }

            public void setVerified(int verified) {
                this.verified = verified;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getWeibo_nick() {
                return weibo_nick;
            }

            public void setWeibo_nick(String weibo_nick) {
                this.weibo_nick = weibo_nick;
            }

            public String getQq_weibo_nick() {
                return qq_weibo_nick;
            }

            public void setQq_weibo_nick(String qq_weibo_nick) {
                this.qq_weibo_nick = qq_weibo_nick;
            }

            public String getQzone_nick() {
                return qzone_nick;
            }

            public void setQzone_nick(String qzone_nick) {
                this.qzone_nick = qzone_nick;
            }

            public int getSetted_email() {
                return setted_email;
            }

            public void setSetted_email(int setted_email) {
                this.setted_email = setted_email;
            }

            public String getUser_large_photo() {
                return user_large_photo;
            }

            public void setUser_large_photo(String user_large_photo) {
                this.user_large_photo = user_large_photo;
            }

            public int getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(int followers_count) {
                this.followers_count = followers_count;
            }

            public int getFollowing_count() {
                return following_count;
            }

            public void setFollowing_count(int following_count) {
                this.following_count = following_count;
            }

            public int getLocation() {
                return location;
            }

            public void setLocation(int location) {
                this.location = location;
            }

            public int getDiaries_count() {
                return diaries_count;
            }

            public void setDiaries_count(int diaries_count) {
                this.diaries_count = diaries_count;
            }

            public int getRecipes_count() {
                return recipes_count;
            }

            public void setRecipes_count(int recipes_count) {
                this.recipes_count = recipes_count;
            }

            public int getFavorites_count() {
                return favorites_count;
            }

            public void setFavorites_count(int favorites_count) {
                this.favorites_count = favorites_count;
            }

            public int getFavor_diaries_count() {
                return favor_diaries_count;
            }

            public void setFavor_diaries_count(int favor_diaries_count) {
                this.favor_diaries_count = favor_diaries_count;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getDishes_count() {
                return dishes_count;
            }

            public void setDishes_count(int dishes_count) {
                this.dishes_count = dishes_count;
            }

            public int getPoint() {
                return point;
            }

            public void setPoint(int point) {
                this.point = point;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getRegist_time() {
                return regist_time;
            }

            public void setRegist_time(String regist_time) {
                this.regist_time = regist_time;
            }

            public int getFc() {
                return fc;
            }

            public void setFc(int fc) {
                this.fc = fc;
            }

            public int getPc() {
                return pc;
            }

            public void setPc(int pc) {
                this.pc = pc;
            }

            public int getLv() {
                return lv;
            }

            public void setLv(int lv) {
                this.lv = lv;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public int getSubscription() {
                return subscription;
            }

            public void setSubscription(int subscription) {
                this.subscription = subscription;
            }

            public int getSubscription_article_count() {
                return subscription_article_count;
            }

            public void setSubscription_article_count(int subscription_article_count) {
                this.subscription_article_count = subscription_article_count;
            }

            public int getCoursecount() {
                return coursecount;
            }

            public void setCoursecount(int coursecount) {
                this.coursecount = coursecount;
            }

            public int getLvl() {
                return lvl;
            }

            public void setLvl(int lvl) {
                this.lvl = lvl;
            }

            public boolean isIs_prime() {
                return is_prime;
            }

            public void setIs_prime(boolean is_prime) {
                this.is_prime = is_prime;
            }

            public int getRelationship() {
                return relationship;
            }

            public void setRelationship(int relationship) {
                this.relationship = relationship;
            }
        }
    }
}
