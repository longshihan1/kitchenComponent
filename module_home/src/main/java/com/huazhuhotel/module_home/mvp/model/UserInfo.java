package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/17 0017
 * @des
 * @function
 */

public class UserInfo {


    /**
     * state : success
     * result : {"user":{"userid":"23177077","user_name":"u48063544660849","user_id":"23177077","nick":"白滚滚的糯米糍","country_code":"+86","user_photo":"http://i1.douguo.net/upload/photo/8/a/c/70_u48063544660849162257.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/8/a/c/140_u48063544660849162257.jpg","gender":2,"email":"","mobile":"","user_cover":"https://i1.douguo.com/upload/caiku/f/b/6/fb8e207fa987b4f7ac0e8956dfd151d6.jpg","verified":0,"weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","introduction":"","setted_email":1,"user_large_photo":"http://i1.douguo.net/upload/photo/8/a/c/yuan_u48063544660849162257.jpg","followers_count":"0","following_count":"5","location":"","diaries_count":"0","recipes_count":0,"notes_count":0,"dishes_count":"0","favorites_count":5,"favor_diaries_count":0,"point":"35","birthday":"","regist_time":"2019-01-21 17:39:04","fc":0,"pc":0,"lv":"0","age":"豆龄 0.2岁","subscription_article_count":"0","subscription":0,"lvl":1,"purview":"0","draft_count":1,"rs":[{"id":1,"reason":"广告骚扰"},{"id":2,"reason":"色情低俗"},{"id":3,"reason":"盗图侵权"},{"id":4,"reason":"人身攻击"}],"fpdt":0,"pdd":0,"liveanchor":0,"coursecount":0,"prime_guide":"立即开通","is_prime":false,"sign":"","relationship":-1},"relationship":-1,"tf":[],"sa":0}
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
         * user : {"userid":"23177077","user_name":"u48063544660849","user_id":"23177077","nick":"白滚滚的糯米糍","country_code":"+86","user_photo":"http://i1.douguo.net/upload/photo/8/a/c/70_u48063544660849162257.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/8/a/c/140_u48063544660849162257.jpg","gender":2,"email":"","mobile":"","user_cover":"https://i1.douguo.com/upload/caiku/f/b/6/fb8e207fa987b4f7ac0e8956dfd151d6.jpg","verified":0,"weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","introduction":"","setted_email":1,"user_large_photo":"http://i1.douguo.net/upload/photo/8/a/c/yuan_u48063544660849162257.jpg","followers_count":"0","following_count":"5","location":"","diaries_count":"0","recipes_count":0,"notes_count":0,"dishes_count":"0","favorites_count":5,"favor_diaries_count":0,"point":"35","birthday":"","regist_time":"2019-01-21 17:39:04","fc":0,"pc":0,"lv":"0","age":"豆龄 0.2岁","subscription_article_count":"0","subscription":0,"lvl":1,"purview":"0","draft_count":1,"rs":[{"id":1,"reason":"广告骚扰"},{"id":2,"reason":"色情低俗"},{"id":3,"reason":"盗图侵权"},{"id":4,"reason":"人身攻击"}],"fpdt":0,"pdd":0,"liveanchor":0,"coursecount":0,"prime_guide":"立即开通","is_prime":false,"sign":"","relationship":-1}
         * relationship : -1
         * tf : []
         * sa : 0
         */

        private UserBean user;
        private int relationship;
        private int sa;
        private List<?> tf;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getRelationship() {
            return relationship;
        }

        public void setRelationship(int relationship) {
            this.relationship = relationship;
        }

        public int getSa() {
            return sa;
        }

        public void setSa(int sa) {
            this.sa = sa;
        }

        public List<?> getTf() {
            return tf;
        }

        public void setTf(List<?> tf) {
            this.tf = tf;
        }

        public static class UserBean {
            /**
             * userid : 23177077
             * user_name : u48063544660849
             * user_id : 23177077
             * nick : 白滚滚的糯米糍
             * country_code : +86
             * user_photo : http://i1.douguo.net/upload/photo/8/a/c/70_u48063544660849162257.jpg
             * avatar_medium : http://i1.douguo.net/upload/photo/8/a/c/140_u48063544660849162257.jpg
             * gender : 2
             * email :
             * mobile :
             * user_cover : https://i1.douguo.com/upload/caiku/f/b/6/fb8e207fa987b4f7ac0e8956dfd151d6.jpg
             * verified : 0
             * weibo_nick :
             * qq_weibo_nick :
             * qzone_nick :
             * introduction :
             * setted_email : 1
             * user_large_photo : http://i1.douguo.net/upload/photo/8/a/c/yuan_u48063544660849162257.jpg
             * followers_count : 0
             * following_count : 5
             * location :
             * diaries_count : 0
             * recipes_count : 0
             * notes_count : 0
             * dishes_count : 0
             * favorites_count : 5
             * favor_diaries_count : 0
             * point : 35
             * birthday :
             * regist_time : 2019-01-21 17:39:04
             * fc : 0
             * pc : 0
             * lv : 0
             * age : 豆龄 0.2岁
             * subscription_article_count : 0
             * subscription : 0
             * lvl : 1
             * purview : 0
             * draft_count : 1
             * rs : [{"id":1,"reason":"广告骚扰"},{"id":2,"reason":"色情低俗"},{"id":3,"reason":"盗图侵权"},{"id":4,"reason":"人身攻击"}]
             * fpdt : 0
             * pdd : 0
             * liveanchor : 0
             * coursecount : 0
             * prime_guide : 立即开通
             * is_prime : false
             * sign :
             * relationship : -1
             */

            private String userid;
            private String user_name;
            private String user_id;
            private String nick;
            private String country_code;
            private String user_photo;
            private String avatar_medium;
            private int gender;
            private String email;
            private String mobile;
            private String user_cover;
            private int verified;
            private String weibo_nick;
            private String qq_weibo_nick;
            private String qzone_nick;
            private String introduction;
            private int setted_email;
            private String user_large_photo;
            private String followers_count;
            private String following_count;
            private String location;
            private String diaries_count;
            private int recipes_count;
            private int notes_count;
            private String dishes_count;
            private int favorites_count;
            private int favor_diaries_count;
            private String point;
            private String birthday;
            private String regist_time;
            private int fc;
            private int pc;
            private String lv;
            private String age;
            private String subscription_article_count;
            private int subscription;
            private int lvl;
            private String purview;
            private int draft_count;
            private int fpdt;
            private int pdd;
            private int liveanchor;
            private int coursecount;
            private String prime_guide;
            private boolean is_prime;
            private String sign;
            private int relationship;
            private List<RsBean> rs;
            private String profession;

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
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

            public String getCountry_code() {
                return country_code;
            }

            public void setCountry_code(String country_code) {
                this.country_code = country_code;
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

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
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

            public String getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(String followers_count) {
                this.followers_count = followers_count;
            }

            public String getFollowing_count() {
                return following_count;
            }

            public void setFollowing_count(String following_count) {
                this.following_count = following_count;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getDiaries_count() {
                return diaries_count;
            }

            public void setDiaries_count(String diaries_count) {
                this.diaries_count = diaries_count;
            }

            public int getRecipes_count() {
                return recipes_count;
            }

            public void setRecipes_count(int recipes_count) {
                this.recipes_count = recipes_count;
            }

            public int getNotes_count() {
                return notes_count;
            }

            public void setNotes_count(int notes_count) {
                this.notes_count = notes_count;
            }

            public String getDishes_count() {
                return dishes_count;
            }

            public void setDishes_count(String dishes_count) {
                this.dishes_count = dishes_count;
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

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
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

            public String getLv() {
                return lv;
            }

            public void setLv(String lv) {
                this.lv = lv;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getSubscription_article_count() {
                return subscription_article_count;
            }

            public void setSubscription_article_count(String subscription_article_count) {
                this.subscription_article_count = subscription_article_count;
            }

            public int getSubscription() {
                return subscription;
            }

            public void setSubscription(int subscription) {
                this.subscription = subscription;
            }

            public int getLvl() {
                return lvl;
            }

            public void setLvl(int lvl) {
                this.lvl = lvl;
            }

            public String getPurview() {
                return purview;
            }

            public void setPurview(String purview) {
                this.purview = purview;
            }

            public int getDraft_count() {
                return draft_count;
            }

            public void setDraft_count(int draft_count) {
                this.draft_count = draft_count;
            }

            public int getFpdt() {
                return fpdt;
            }

            public void setFpdt(int fpdt) {
                this.fpdt = fpdt;
            }

            public int getPdd() {
                return pdd;
            }

            public void setPdd(int pdd) {
                this.pdd = pdd;
            }

            public int getLiveanchor() {
                return liveanchor;
            }

            public void setLiveanchor(int liveanchor) {
                this.liveanchor = liveanchor;
            }

            public int getCoursecount() {
                return coursecount;
            }

            public void setCoursecount(int coursecount) {
                this.coursecount = coursecount;
            }

            public String getPrime_guide() {
                return prime_guide;
            }

            public void setPrime_guide(String prime_guide) {
                this.prime_guide = prime_guide;
            }

            public boolean isIs_prime() {
                return is_prime;
            }

            public void setIs_prime(boolean is_prime) {
                this.is_prime = is_prime;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public int getRelationship() {
                return relationship;
            }

            public void setRelationship(int relationship) {
                this.relationship = relationship;
            }

            public List<RsBean> getRs() {
                return rs;
            }

            public void setRs(List<RsBean> rs) {
                this.rs = rs;
            }

            public String getProfession() {
                return profession;
            }

            public void setProfession(String profession) {
                this.profession = profession;
            }

            public static class RsBean {
                /**
                 * id : 1
                 * reason : 广告骚扰
                 */

                private int id;
                private String reason;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getReason() {
                    return reason;
                }

                public void setReason(String reason) {
                    this.reason = reason;
                }
            }
        }
    }
}
