package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/29 0029
 * @des
 * @function
 */

public class CollectionInfo {

    /**
     * state : success
     * result : {"recipes":[{"cook_id":"1176304","title":"【香草卡仕达酥皮泡芙】","image":"https://cp1.douguo.com/upload/caiku/a/b/1/170_ab2117d9be893bc14c62b7363bfe04e1.jpg","thumb_path":"https://cp1.douguo.com/upload/caiku/a/b/1/300_ab2117d9be893bc14c62b7363bfe04e1.jpg","photo_path":"https://cp1.douguo.com/upload/caiku/a/b/1/600_ab2117d9be893bc14c62b7363bfe04e1.jpg","thumb_height":0,"tags":[{"text":"烘焙"},{"text":"泡芙"}],"author_id":"1704870","tips":"一个个的圆胖子，在烤箱里的时候就把人给萌化了\n我做的还比较大只的，有手掌心那么大\n \n土鳖的我以前没有做过也没有吃过酥皮泡芙\n托这次群里作业的福，做了这个\n感谢我们的创意小天后雪羽提议做酥皮泡芙\n \n泡芙体的方子是随便找的，没比较过也不好说是不是很值得推荐\n酥皮好容易蹭掉，问了群里的大家也都是一样的情况\n拍照的时候来回捯饬，被我蹭掉一堆的酥皮碎碎\n \n大泡芙的馅料很足量，直接上卡仕达酱感觉过于刺激了\n于是搭配了打发的淡奶油，味道好像冰淇淋一样\n口感是很丝滑的，一口下去还爆浆\n \n然后真是忍不住又要自黑一下\n爆浆的结果就是一口咬太狠的话那个场面真是惨不忍睹\n反正我是拿个盘子接着吃的，事后不忘舔盘子\n \n当然吃相优雅的就不需要有这种顾虑了","cookstory":"泡芙皮和夹馅都是大约25个大个泡芙的量","cookstep":[{"position":"1","content":"[准备酥皮]\n无盐黄油50G软化后加糖粉20G打发，再加低粉50G和玉米淀粉10G拌至无干粉状态","thumb":"https://cp1.douguo.com/upload/caiku/b/c/f/140_bc95f3a9375eb40b33df7309a8bd027f.jpg","image":"https://cp1.douguo.com/upload/caiku/b/c/f/600_bc95f3a9375eb40b33df7309a8bd027f.jpg"},{"position":"19","content":"掰开内部夹馅特写。可以看到夹馅里面是有一点一点的小黑点的，那是香草籽","thumb":"https://cp1.douguo.com/upload/caiku/c/a/f/140_ca13676545be66b08a291c70613ad66f.jpg","image":"https://cp1.douguo.com/upload/caiku/c/a/f/600_ca13676545be66b08a291c70613ad66f.jpg"}],"cook_time":"","cook_difficulty":"","clicks":"14","major":[{"title":"泡芙体：改自《顶级泡芙制作技术入门》","note":""},{"title":"淡奶油","note":"450ML"}],"minor":[],"create_time":"2015-05-12 15:40:34","recommended":0,"act_des":"","v_u":"","vu":"","vfurl":"","ecs":0,"hq":1,"eu":"recipes://www.douguo.com/postdetail?id=242016","hqu":"recipes://www.douguo.com/notedetail?id=21162253","user":{"userid":"1704870","user_id":"1704870","nick":"糖小饼","user_photo":"http://i1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/a/2/a/140_u4095206075346702231831.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":1,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/a/2/a/yuan_u4095206075346702231831.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":7,"is_prime":false},"author":"糖小饼","author_photo":"http://i1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg","author_verified":1,"collect_status":0,"favo_counts":18779,"comments_count":0,"dish_count":398,"vc":383766,"display_ingredient":1,"rate":4.8,"state":0,"advice":{"at":"能量充沛","da":{"t":"查看详细分析","url":"http://m.douguo.com/recipe/nutrient/1176304","iu":"https://i1.douguo.com/upload/caiku/6/c/6/6c7192ffaceb1a17a0b7b0846449fd86.png"},"has":[{"url":"recipes://www.douguo.com/simplerecipelist?t=高热量&id=高热量","t":"高热量"},{"url":"recipes://www.douguo.com/simplerecipelist?t=高脂肪&id=高脂肪","t":"高脂肪"}]},"recommendation_tag":"关注的好友"}],"tiu":"https://i1.douguo.com/upload/caiku/8/e/6/8eb4f186ad3114facc1dc54a053e97d6.jpg","end":1}
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
         * recipes : [{"cook_id":"1176304","title":"【香草卡仕达酥皮泡芙】","image":"https://cp1.douguo.com/upload/caiku/a/b/1/170_ab2117d9be893bc14c62b7363bfe04e1.jpg","thumb_path":"https://cp1.douguo.com/upload/caiku/a/b/1/300_ab2117d9be893bc14c62b7363bfe04e1.jpg","photo_path":"https://cp1.douguo.com/upload/caiku/a/b/1/600_ab2117d9be893bc14c62b7363bfe04e1.jpg","thumb_height":0,"tags":[{"text":"烘焙"},{"text":"泡芙"}],"author_id":"1704870","tips":"一个个的圆胖子，在烤箱里的时候就把人给萌化了\n我做的还比较大只的，有手掌心那么大\n \n土鳖的我以前没有做过也没有吃过酥皮泡芙\n托这次群里作业的福，做了这个\n感谢我们的创意小天后雪羽提议做酥皮泡芙\n \n泡芙体的方子是随便找的，没比较过也不好说是不是很值得推荐\n酥皮好容易蹭掉，问了群里的大家也都是一样的情况\n拍照的时候来回捯饬，被我蹭掉一堆的酥皮碎碎\n \n大泡芙的馅料很足量，直接上卡仕达酱感觉过于刺激了\n于是搭配了打发的淡奶油，味道好像冰淇淋一样\n口感是很丝滑的，一口下去还爆浆\n \n然后真是忍不住又要自黑一下\n爆浆的结果就是一口咬太狠的话那个场面真是惨不忍睹\n反正我是拿个盘子接着吃的，事后不忘舔盘子\n \n当然吃相优雅的就不需要有这种顾虑了","cookstory":"泡芙皮和夹馅都是大约25个大个泡芙的量","cookstep":[{"position":"1","content":"[准备酥皮]\n无盐黄油50G软化后加糖粉20G打发，再加低粉50G和玉米淀粉10G拌至无干粉状态","thumb":"https://cp1.douguo.com/upload/caiku/b/c/f/140_bc95f3a9375eb40b33df7309a8bd027f.jpg","image":"https://cp1.douguo.com/upload/caiku/b/c/f/600_bc95f3a9375eb40b33df7309a8bd027f.jpg"},{"position":"19","content":"掰开内部夹馅特写。可以看到夹馅里面是有一点一点的小黑点的，那是香草籽","thumb":"https://cp1.douguo.com/upload/caiku/c/a/f/140_ca13676545be66b08a291c70613ad66f.jpg","image":"https://cp1.douguo.com/upload/caiku/c/a/f/600_ca13676545be66b08a291c70613ad66f.jpg"}],"cook_time":"","cook_difficulty":"","clicks":"14","major":[{"title":"泡芙体：改自《顶级泡芙制作技术入门》","note":""},{"title":"淡奶油","note":"450ML"}],"minor":[],"create_time":"2015-05-12 15:40:34","recommended":0,"act_des":"","v_u":"","vu":"","vfurl":"","ecs":0,"hq":1,"eu":"recipes://www.douguo.com/postdetail?id=242016","hqu":"recipes://www.douguo.com/notedetail?id=21162253","user":{"userid":"1704870","user_id":"1704870","nick":"糖小饼","user_photo":"http://i1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg","avatar_medium":"http://i1.douguo.net/upload/photo/a/2/a/140_u4095206075346702231831.jpg","gender":2,"email":"","mobile":"","user_cover":"","verified":1,"sign":"","weibo_nick":"","qq_weibo_nick":"","qzone_nick":"","setted_email":0,"user_large_photo":"http://i1.douguo.net/upload/photo/a/2/a/yuan_u4095206075346702231831.jpg","followers_count":0,"following_count":0,"location":0,"diaries_count":0,"recipes_count":0,"favorites_count":0,"favor_diaries_count":0,"introduction":"","dishes_count":0,"point":0,"birthday":"","regist_time":"","fc":0,"pc":0,"lv":0,"age":"","subscription":0,"subscription_article_count":0,"coursecount":0,"lvl":7,"is_prime":false},"author":"糖小饼","author_photo":"http://i1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg","author_verified":1,"collect_status":0,"favo_counts":18779,"comments_count":0,"dish_count":398,"vc":383766,"display_ingredient":1,"rate":4.8,"state":0,"advice":{"at":"能量充沛","da":{"t":"查看详细分析","url":"http://m.douguo.com/recipe/nutrient/1176304","iu":"https://i1.douguo.com/upload/caiku/6/c/6/6c7192ffaceb1a17a0b7b0846449fd86.png"},"has":[{"url":"recipes://www.douguo.com/simplerecipelist?t=高热量&id=高热量","t":"高热量"},{"url":"recipes://www.douguo.com/simplerecipelist?t=高脂肪&id=高脂肪","t":"高脂肪"}]},"recommendation_tag":"关注的好友"}]
         * tiu : https://i1.douguo.com/upload/caiku/8/e/6/8eb4f186ad3114facc1dc54a053e97d6.jpg
         * end : 1
         */

        private String tiu;
        private int end;
        private List<RecipesBean> recipes;

        public String getTiu() {
            return tiu;
        }

        public void setTiu(String tiu) {
            this.tiu = tiu;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public List<RecipesBean> getRecipes() {
            return recipes;
        }

        public void setRecipes(List<RecipesBean> recipes) {
            this.recipes = recipes;
        }

        public static class RecipesBean {
            private String cook_id;
            private String title;
            private String image;
            private String thumb_path;
            private String photo_path;
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
            private String vu;
            private String vfurl;
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
            private int dish_count;
            private int vc;
            private int display_ingredient;
            private double rate;
            private int state;
            private AdviceBean advice;
            private String recommendation_tag;
            private List<TagsBean> tags;
            private List<CookstepBean> cookstep;
            private List<MajorBean> major;
            private List<?> minor;

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

            public String getVu() {
                return vu;
            }

            public void setVu(String vu) {
                this.vu = vu;
            }

            public String getVfurl() {
                return vfurl;
            }

            public void setVfurl(String vfurl) {
                this.vfurl = vfurl;
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

            public int getDish_count() {
                return dish_count;
            }

            public void setDish_count(int dish_count) {
                this.dish_count = dish_count;
            }

            public int getVc() {
                return vc;
            }

            public void setVc(int vc) {
                this.vc = vc;
            }

            public int getDisplay_ingredient() {
                return display_ingredient;
            }

            public void setDisplay_ingredient(int display_ingredient) {
                this.display_ingredient = display_ingredient;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public AdviceBean getAdvice() {
                return advice;
            }

            public void setAdvice(AdviceBean advice) {
                this.advice = advice;
            }

            public String getRecommendation_tag() {
                return recommendation_tag;
            }

            public void setRecommendation_tag(String recommendation_tag) {
                this.recommendation_tag = recommendation_tag;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
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

            public static class UserBean {
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
            }

            public static class AdviceBean {
                /**
                 * at : 能量充沛
                 * da : {"t":"查看详细分析","url":"http://m.douguo.com/recipe/nutrient/1176304","iu":"https://i1.douguo.com/upload/caiku/6/c/6/6c7192ffaceb1a17a0b7b0846449fd86.png"}
                 * has : [{"url":"recipes://www.douguo.com/simplerecipelist?t=高热量&id=高热量","t":"高热量"},{"url":"recipes://www.douguo.com/simplerecipelist?t=高脂肪&id=高脂肪","t":"高脂肪"}]
                 */

                private String at;
                private DaBean da;
                private List<HasBean> has;

                public String getAt() {
                    return at;
                }

                public void setAt(String at) {
                    this.at = at;
                }

                public DaBean getDa() {
                    return da;
                }

                public void setDa(DaBean da) {
                    this.da = da;
                }

                public List<HasBean> getHas() {
                    return has;
                }

                public void setHas(List<HasBean> has) {
                    this.has = has;
                }

                public static class DaBean {
                    /**
                     * t : 查看详细分析
                     * url : http://m.douguo.com/recipe/nutrient/1176304
                     * iu : https://i1.douguo.com/upload/caiku/6/c/6/6c7192ffaceb1a17a0b7b0846449fd86.png
                     */

                    private String t;
                    private String url;
                    private String iu;

                    public String getT() {
                        return t;
                    }

                    public void setT(String t) {
                        this.t = t;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getIu() {
                        return iu;
                    }

                    public void setIu(String iu) {
                        this.iu = iu;
                    }
                }

                public static class HasBean {
                    /**
                     * url : recipes://www.douguo.com/simplerecipelist?t=高热量&id=高热量
                     * t : 高热量
                     */

                    private String url;
                    private String t;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getT() {
                        return t;
                    }

                    public void setT(String t) {
                        this.t = t;
                    }
                }
            }

            public static class TagsBean {
                /**
                 * text : 烘焙
                 */

                private String text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class CookstepBean {
                /**
                 * position : 1
                 * content : [准备酥皮]
                 无盐黄油50G软化后加糖粉20G打发，再加低粉50G和玉米淀粉10G拌至无干粉状态
                 * thumb : https://cp1.douguo.com/upload/caiku/b/c/f/140_bc95f3a9375eb40b33df7309a8bd027f.jpg
                 * image : https://cp1.douguo.com/upload/caiku/b/c/f/600_bc95f3a9375eb40b33df7309a8bd027f.jpg
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

            public static class MajorBean {
                /**
                 * title : 泡芙体：改自《顶级泡芙制作技术入门》
                 * note :
                 */

                private String title;
                private String note;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }
            }
        }
    }
}
