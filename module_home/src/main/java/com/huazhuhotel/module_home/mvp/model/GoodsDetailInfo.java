package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class GoodsDetailInfo {


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


        private RecipeBean recipe;

        public RecipeBean getRecipe() {
            return recipe;
        }

        public void setRecipe(RecipeBean recipe) {
            this.recipe = recipe;
        }

        public static class RecipeBean {

            private String cook_id;
            private String title;
            private String image;
            private String thumb_path;
            private String photo_path;
            private String original_photo_path;
            private int thumb_height;
            private String author_id;
            private String tips;
            private String cookstory;
            private String cook_time;
            private String cook_difficulty;
            private String clicks;
            private String create_time;
            private int recommended;
            private String act_des;
            private String v_u;
            private int ecs;
            private int hq;
            private String eu;
            private String hqu;
            private UserBean user;
            private String author;
            private String author_photo;
            private int author_verified;
            private int collect_status;
            private int favo_counts;
            private int comments_count;
            private String dish_count;
            private String pw;
            private String ph;
            private int display_ingredient;
            private int vc;
            private int as;
            private String release_time;
            private int rips;
            private String su;
            private String sc;
            private String sr;
            private String ssu;
            private String ipci;
            private String ipoi;
            private String ipt;
            private float rate;
            private int rate_count;
            private int rate_show;
            private BtmDspBean btm_dsp;
            private String rsm;
            private String recommendation_tag;
            private List<CookstepBean> cookstep;
            private List<MajorBean> major;
            private List<?> minor;
            private List<RecentCommentsBean> recent_comments;
            private List<RecentCommentsBean> old_comments;
            private List<RecentCommentsBean> comments;
            private List<?> dishes;
            private List<?> bs;
            private List<?> ss;
            private List<RdspsBean> rdsps;
            private List<NotesBean> notes;

            public String getCook_id() {
                return cook_id;
            }

            public void setCook_id(String cook_id) {
                this.cook_id = cook_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getThumb_path() {
                return thumb_path;
            }

            public void setThumb_path(String thumb_path) {
                this.thumb_path = thumb_path;
            }

            public String getPhoto_path() {
                return photo_path;
            }

            public void setPhoto_path(String photo_path) {
                this.photo_path = photo_path;
            }

            public String getOriginal_photo_path() {
                return original_photo_path;
            }

            public void setOriginal_photo_path(String original_photo_path) {
                this.original_photo_path = original_photo_path;
            }

            public int getThumb_height() {
                return thumb_height;
            }

            public void setThumb_height(int thumb_height) {
                this.thumb_height = thumb_height;
            }

            public String getAuthor_id() {
                return author_id;
            }

            public void setAuthor_id(String author_id) {
                this.author_id = author_id;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public String getCookstory() {
                return cookstory;
            }

            public void setCookstory(String cookstory) {
                this.cookstory = cookstory;
            }

            public String getCook_time() {
                return cook_time;
            }

            public void setCook_time(String cook_time) {
                this.cook_time = cook_time;
            }

            public String getCook_difficulty() {
                return cook_difficulty;
            }

            public void setCook_difficulty(String cook_difficulty) {
                this.cook_difficulty = cook_difficulty;
            }

            public String getClicks() {
                return clicks;
            }

            public void setClicks(String clicks) {
                this.clicks = clicks;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getRecommended() {
                return recommended;
            }

            public void setRecommended(int recommended) {
                this.recommended = recommended;
            }

            public String getAct_des() {
                return act_des;
            }

            public void setAct_des(String act_des) {
                this.act_des = act_des;
            }

            public String getV_u() {
                return v_u;
            }

            public void setV_u(String v_u) {
                this.v_u = v_u;
            }

            public int getEcs() {
                return ecs;
            }

            public void setEcs(int ecs) {
                this.ecs = ecs;
            }

            public int getHq() {
                return hq;
            }

            public void setHq(int hq) {
                this.hq = hq;
            }

            public String getEu() {
                return eu;
            }

            public void setEu(String eu) {
                this.eu = eu;
            }

            public String getHqu() {
                return hqu;
            }

            public void setHqu(String hqu) {
                this.hqu = hqu;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getAuthor_photo() {
                return author_photo;
            }

            public void setAuthor_photo(String author_photo) {
                this.author_photo = author_photo;
            }

            public int getAuthor_verified() {
                return author_verified;
            }

            public void setAuthor_verified(int author_verified) {
                this.author_verified = author_verified;
            }

            public int getCollect_status() {
                return collect_status;
            }

            public void setCollect_status(int collect_status) {
                this.collect_status = collect_status;
            }

            public int getFavo_counts() {
                return favo_counts;
            }

            public void setFavo_counts(int favo_counts) {
                this.favo_counts = favo_counts;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public String getDish_count() {
                return dish_count;
            }

            public void setDish_count(String dish_count) {
                this.dish_count = dish_count;
            }

            public String getPw() {
                return pw;
            }

            public void setPw(String pw) {
                this.pw = pw;
            }

            public String getPh() {
                return ph;
            }

            public void setPh(String ph) {
                this.ph = ph;
            }

            public int getDisplay_ingredient() {
                return display_ingredient;
            }

            public void setDisplay_ingredient(int display_ingredient) {
                this.display_ingredient = display_ingredient;
            }

            public int getVc() {
                return vc;
            }

            public void setVc(int vc) {
                this.vc = vc;
            }

            public int getAs() {
                return as;
            }

            public void setAs(int as) {
                this.as = as;
            }

            public String getRelease_time() {
                return release_time;
            }

            public void setRelease_time(String release_time) {
                this.release_time = release_time;
            }

            public int getRips() {
                return rips;
            }

            public void setRips(int rips) {
                this.rips = rips;
            }

            public String getSu() {
                return su;
            }

            public void setSu(String su) {
                this.su = su;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSsu() {
                return ssu;
            }

            public void setSsu(String ssu) {
                this.ssu = ssu;
            }

            public String getIpci() {
                return ipci;
            }

            public void setIpci(String ipci) {
                this.ipci = ipci;
            }

            public String getIpoi() {
                return ipoi;
            }

            public void setIpoi(String ipoi) {
                this.ipoi = ipoi;
            }

            public String getIpt() {
                return ipt;
            }

            public void setIpt(String ipt) {
                this.ipt = ipt;
            }

            public float getRate() {
                return rate;
            }

            public void setRate(float rate) {
                this.rate = rate;
            }

            public int getRate_count() {
                return rate_count;
            }

            public void setRate_count(int rate_count) {
                this.rate_count = rate_count;
            }

            public int getRate_show() {
                return rate_show;
            }

            public void setRate_show(int rate_show) {
                this.rate_show = rate_show;
            }

            public BtmDspBean getBtm_dsp() {
                return btm_dsp;
            }

            public void setBtm_dsp(BtmDspBean btm_dsp) {
                this.btm_dsp = btm_dsp;
            }

            public String getRsm() {
                return rsm;
            }

            public void setRsm(String rsm) {
                this.rsm = rsm;
            }

            public String getRecommendation_tag() {
                return recommendation_tag;
            }

            public void setRecommendation_tag(String recommendation_tag) {
                this.recommendation_tag = recommendation_tag;
            }

            public List<CookstepBean> getCookstep() {
                return cookstep;
            }

            public void setCookstep(List<CookstepBean> cookstep) {
                this.cookstep = cookstep;
            }

            public List<MajorBean> getMajor() {
                return major;
            }

            public void setMajor(List<MajorBean> major) {
                this.major = major;
            }

            public List<?> getMinor() {
                return minor;
            }

            public void setMinor(List<?> minor) {
                this.minor = minor;
            }

            public List<RecentCommentsBean> getRecent_comments() {
                return recent_comments;
            }

            public void setRecent_comments(List<RecentCommentsBean> recent_comments) {
                this.recent_comments = recent_comments;
            }

            public List<?> getDishes() {
                return dishes;
            }

            public void setDishes(List<?> dishes) {
                this.dishes = dishes;
            }

            public List<?> getBs() {
                return bs;
            }

            public void setBs(List<?> bs) {
                this.bs = bs;
            }

            public List<?> getSs() {
                return ss;
            }

            public void setSs(List<?> ss) {
                this.ss = ss;
            }

            public List<RdspsBean> getRdsps() {
                return rdsps;
            }

            public void setRdsps(List<RdspsBean> rdsps) {
                this.rdsps = rdsps;
            }

            public List<NotesBean> getNotes() {
                return notes;
            }

            public void setNotes(List<NotesBean> notes) {
                this.notes = notes;
            }

            public List<RecentCommentsBean> getOld_comments() {
                return old_comments;
            }

            public void setOld_comments(List<RecentCommentsBean> old_comments) {
                this.old_comments = old_comments;
            }

            public List<RecentCommentsBean> getComments() {
                return comments;
            }

            public void setComments(List<RecentCommentsBean> comments) {
                this.comments = comments;
            }

            public static class UserBean {
                /**
                 * user_id : 19386332
                 * nick : 麦可安
                 * nickname : 麦可安
                 * user_photo : http://i1.douguo.net/upload/photo/1/c/8/70_u83701666827580173046.jpeg
                 * avatar_medium : http://i1.douguo.net/upload/photo/1/c/8/140_u83701666827580173046.jpeg
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
                 * user_large_photo : http://i1.douguo.net/upload/photo/1/c/8/yuan_u83701666827580173046.jpeg
                 * followers_count : 0
                 * following_count : 0
                 * location : 0
                 * diaries_count : 0
                 * recipes_count : 0
                 * favorites_count : 0
                 * favor_diaries_count : 0
                 * lvl : 5
                 * is_prime : true
                 */

                private String user_id;
                private String nick;
                private String nickname;
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
                private int lvl;
                private boolean is_prime;

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

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
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
            }

            public static class BtmDspBean {
                /**
                 * id : 7966
                 * pid :
                 * ch : 0
                 * url : recipes://www.douguo.com/user?id=21610006&tab=1
                 * i : http://i1.douguo.net/upload/advert_user/4/4/4/44cda56fe5c1dc529ef8cbef040dc024.jpg
                 * cap :
                 * position : 1detailbanners
                 * t : 雀巢3.1-3.5菜谱详情页底部banner
                 * d : 雀巢3.1-3.5菜谱详情页底部banner
                 * query :
                 * client_ip : 114.94.99.199
                 * req_min_i : 2
                 * channel :
                 * media_type : 0
                 * max_impression_count : 0
                 * canclose : 0
                 */

                private String id;
                private String pid;
                private int ch;
                private String url;
                private String i;
                private String cap;
                private String position;
                private String t;
                private String d;
                private String query;
                private String client_ip;
                private int req_min_i;
                private String channel;
                private int media_type;
                private String max_impression_count;
                private int canclose;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public int getCh() {
                    return ch;
                }

                public void setCh(int ch) {
                    this.ch = ch;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getI() {
                    return i;
                }

                public void setI(String i) {
                    this.i = i;
                }

                public String getCap() {
                    return cap;
                }

                public void setCap(String cap) {
                    this.cap = cap;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getT() {
                    return t;
                }

                public void setT(String t) {
                    this.t = t;
                }

                public String getD() {
                    return d;
                }

                public void setD(String d) {
                    this.d = d;
                }

                public String getQuery() {
                    return query;
                }

                public void setQuery(String query) {
                    this.query = query;
                }

                public String getClient_ip() {
                    return client_ip;
                }

                public void setClient_ip(String client_ip) {
                    this.client_ip = client_ip;
                }

                public int getReq_min_i() {
                    return req_min_i;
                }

                public void setReq_min_i(int req_min_i) {
                    this.req_min_i = req_min_i;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public int getMedia_type() {
                    return media_type;
                }

                public void setMedia_type(int media_type) {
                    this.media_type = media_type;
                }

                public String getMax_impression_count() {
                    return max_impression_count;
                }

                public void setMax_impression_count(String max_impression_count) {
                    this.max_impression_count = max_impression_count;
                }

                public int getCanclose() {
                    return canclose;
                }

                public void setCanclose(int canclose) {
                    this.canclose = canclose;
                }
            }

            public static class CookstepBean {
                /**
                 * position : 1
                 * content : 白砂糖、盐、小麦胚芽和脱脂奶粉，依次加入高筋面粉、全麦面粉中，用筷子稍微搅拌。
                 * thumb : https://cp1.douguo.com/upload/caiku/d/6/0/140_d676d000437ccb1da3bffaceb6cbf680.jpg
                 * image : https://cp1.douguo.com/upload/caiku/d/6/0/600_d676d000437ccb1da3bffaceb6cbf680.jpg
                 */

                private String position;
                private String content;
                private String thumb;
                private String image;

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }


            public static class RecentCommentsBean {
                /**
                 * user_photo : http://i1.douguo.net/upload/photo/1/c/8/70_u83701666827580173046.jpeg
                 * author_nick : 麦可安
                 * author_id : 19386332
                 * author_lvl : 5
                 * author_verified : 0
                 * id : 6276573
                 * time : 2018-12-15 08:45:11
                 * type : 0
                 * content : @臭臭的臭宝贝 配方有写
                 * parent_id : 6276503
                 * reply_id : 6276503
                 */

                private String user_photo;
                private String author_nick;
                private int author_id;
                private int author_lvl;
                private int author_verified;
                private String id;
                private String time;
                private String type;
                private String content;
                private String parent_id;
                private String reply_id;

                public String getUser_photo() {
                    return user_photo;
                }

                public void setUser_photo(String user_photo) {
                    this.user_photo = user_photo;
                }

                public String getAuthor_nick() {
                    return author_nick;
                }

                public void setAuthor_nick(String author_nick) {
                    this.author_nick = author_nick;
                }

                public int getAuthor_id() {
                    return author_id;
                }

                public void setAuthor_id(int author_id) {
                    this.author_id = author_id;
                }

                public int getAuthor_lvl() {
                    return author_lvl;
                }

                public void setAuthor_lvl(int author_lvl) {
                    this.author_lvl = author_lvl;
                }

                public int getAuthor_verified() {
                    return author_verified;
                }

                public void setAuthor_verified(int author_verified) {
                    this.author_verified = author_verified;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getParent_id() {
                    return parent_id;
                }

                public void setParent_id(String parent_id) {
                    this.parent_id = parent_id;
                }

                public String getReply_id() {
                    return reply_id;
                }

                public void setReply_id(String reply_id) {
                    this.reply_id = reply_id;
                }
            }

            public static class RdspsBean {
                /**
                 * d : {"id":"ad4391","pid":"3545249","ch":2,"url":"","i":"","cap":"广告","position":"1recipedetail","query":"","client_ip":"114.94.99.199","req_min_i":86400,"channel":"","media_type":0,"max_impression_count":0,"canclose":0}
                 */

                private DBean d;

                public DBean getD() {
                    return d;
                }

                public void setD(DBean d) {
                    this.d = d;
                }

                public static class DBean {
                    /**
                     * id : ad4391
                     * pid : 3545249
                     * ch : 2
                     * url :
                     * i :
                     * cap : 广告
                     * position : 1recipedetail
                     * query :
                     * client_ip : 114.94.99.199
                     * req_min_i : 86400
                     * channel :
                     * media_type : 0
                     * max_impression_count : 0
                     * canclose : 0
                     */

                    private String id;
                    private String pid;
                    private int ch;
                    private String url;
                    private String i;
                    private String cap;
                    private String position;
                    private String query;
                    private String client_ip;
                    private int req_min_i;
                    private String channel;
                    private int media_type;
                    private int max_impression_count;
                    private int canclose;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getPid() {
                        return pid;
                    }

                    public void setPid(String pid) {
                        this.pid = pid;
                    }

                    public int getCh() {
                        return ch;
                    }

                    public void setCh(int ch) {
                        this.ch = ch;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getI() {
                        return i;
                    }

                    public void setI(String i) {
                        this.i = i;
                    }

                    public String getCap() {
                        return cap;
                    }

                    public void setCap(String cap) {
                        this.cap = cap;
                    }

                    public String getPosition() {
                        return position;
                    }

                    public void setPosition(String position) {
                        this.position = position;
                    }

                    public String getQuery() {
                        return query;
                    }

                    public void setQuery(String query) {
                        this.query = query;
                    }

                    public String getClient_ip() {
                        return client_ip;
                    }

                    public void setClient_ip(String client_ip) {
                        this.client_ip = client_ip;
                    }

                    public int getReq_min_i() {
                        return req_min_i;
                    }

                    public void setReq_min_i(int req_min_i) {
                        this.req_min_i = req_min_i;
                    }

                    public String getChannel() {
                        return channel;
                    }

                    public void setChannel(String channel) {
                        this.channel = channel;
                    }

                    public int getMedia_type() {
                        return media_type;
                    }

                    public void setMedia_type(int media_type) {
                        this.media_type = media_type;
                    }

                    public int getMax_impression_count() {
                        return max_impression_count;
                    }

                    public void setMax_impression_count(int max_impression_count) {
                        this.max_impression_count = max_impression_count;
                    }

                    public int getCanclose() {
                        return canclose;
                    }

                    public void setCanclose(int canclose) {
                        this.canclose = canclose;
                    }
                }
            }

            public static class NotesBean {
                /**
                 * id : 22047470
                 * image_u : https://i1.douguo.com/upload/note/2/9/f/293763273da9a84c65790bf4d60e5b3f.jpeg
                 * image_w : 750
                 * image_h : 1000
                 * title :
                 * publishtime : 2018-12-13 06:43:59
                 * recipe_rate : 5
                 * author : {"lvl":5,"is_prime":true,"id":"19386332","n":"麦可安","p":"http://i1.douguo.net/upload/photo/1/c/8/70_u83701666827580173046.jpeg","v":1,"lv":0,"wn":"mikeann_coco","relationship":0}
                 * like_state : 0
                 * like_count : 105
                 */

                private String id;
                private String image_u;
                private String image_w;
                private String image_h;
                private String title;
                private String publishtime;
                private int recipe_rate;
                private AuthorBean author;
                private int like_state;
                private int like_count;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getImage_u() {
                    return image_u;
                }

                public void setImage_u(String image_u) {
                    this.image_u = image_u;
                }

                public String getImage_w() {
                    return image_w;
                }

                public void setImage_w(String image_w) {
                    this.image_w = image_w;
                }

                public String getImage_h() {
                    return image_h;
                }

                public void setImage_h(String image_h) {
                    this.image_h = image_h;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getPublishtime() {
                    return publishtime;
                }

                public void setPublishtime(String publishtime) {
                    this.publishtime = publishtime;
                }

                public int getRecipe_rate() {
                    return recipe_rate;
                }

                public void setRecipe_rate(int recipe_rate) {
                    this.recipe_rate = recipe_rate;
                }

                public AuthorBean getAuthor() {
                    return author;
                }

                public void setAuthor(AuthorBean author) {
                    this.author = author;
                }

                public int getLike_state() {
                    return like_state;
                }

                public void setLike_state(int like_state) {
                    this.like_state = like_state;
                }

                public int getLike_count() {
                    return like_count;
                }

                public void setLike_count(int like_count) {
                    this.like_count = like_count;
                }

                public static class AuthorBean {
                    /**
                     * lvl : 5
                     * is_prime : true
                     * id : 19386332
                     * n : 麦可安
                     * p : http://i1.douguo.net/upload/photo/1/c/8/70_u83701666827580173046.jpeg
                     * v : 1
                     * lv : 0
                     * wn : mikeann_coco
                     * relationship : 0
                     */

                    private int lvl;
                    private boolean is_prime;
                    private String id;
                    private String n;
                    private String p;
                    private int v;
                    private int lv;
                    private String wn;
                    private int relationship;

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

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getN() {
                        return n;
                    }

                    public void setN(String n) {
                        this.n = n;
                    }

                    public String getP() {
                        return p;
                    }

                    public void setP(String p) {
                        this.p = p;
                    }

                    public int getV() {
                        return v;
                    }

                    public void setV(int v) {
                        this.v = v;
                    }

                    public int getLv() {
                        return lv;
                    }

                    public void setLv(int lv) {
                        this.lv = lv;
                    }

                    public String getWn() {
                        return wn;
                    }

                    public void setWn(String wn) {
                        this.wn = wn;
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
    }
}
