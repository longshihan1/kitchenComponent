package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class SearchInfo {

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

        private IeBean ie;
        private MdspBean mdsp;
        private int end;
        private FeedbackBean feedback;
        private List<String> sts;
        private List<ListBean> list;

        public IeBean getIe() {
            return ie;
        }

        public void setIe(IeBean ie) {
            this.ie = ie;
        }

        public MdspBean getMdsp() {
            return mdsp;
        }

        public void setMdsp(MdspBean mdsp) {
            this.mdsp = mdsp;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public FeedbackBean getFeedback() {
            return feedback;
        }

        public void setFeedback(FeedbackBean feedback) {
            this.feedback = feedback;
        }

        public List<String> getSts() {
            return sts;
        }

        public void setSts(List<String> sts) {
            this.sts = sts;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class IeBean {

            private String i;
            private String n;
            private String d;
            private String u;

            public String getI() {
                return i;
            }

            public void setI(String i) {
                this.i = i;
            }

            public String getN() {
                return n;
            }

            public void setN(String n) {
                this.n = n;
            }

            public String getD() {
                return d;
            }

            public void setD(String d) {
                this.d = d;
            }

            public String getU() {
                return u;
            }

            public void setU(String u) {
                this.u = u;
            }
        }

        public static class MdspBean {

            private DspBean dsp;
            private int type;

            public DspBean getDsp() {
                return dsp;
            }

            public void setDsp(DspBean dsp) {
                this.dsp = dsp;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public static class DspBean {
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
                private List<?> imp_trackers;
                private List<?> click_trackers;

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

                public List<?> getImp_trackers() {
                    return imp_trackers;
                }

                public void setImp_trackers(List<?> imp_trackers) {
                    this.imp_trackers = imp_trackers;
                }

                public List<?> getClick_trackers() {
                    return click_trackers;
                }

                public void setClick_trackers(List<?> click_trackers) {
                    this.click_trackers = click_trackers;
                }
            }
        }

        public static class FeedbackBean {

            private String icon;
            private String url;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ListBean {

            private int type;
            private RBean r;
            private DspBeanX dsp;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public RBean getR() {
                return r;
            }

            public void setR(RBean r) {
                this.r = r;
            }

            public DspBeanX getDsp() {
                return dsp;
            }

            public void setDsp(DspBeanX dsp) {
                this.dsp = dsp;
            }

            public static class RBean {
                /**
                 * stc : 0
                 * sti : 0
                 * an : 葉子的爱与厨房
                 * id : 203450
                 * cookstory :       最近早餐特别偏好吐司披萨，快捷简单，肉和蔬菜都吃到了，口感也达到了。以前做吐司披萨还要再做个煎蛋。偶然一天，觉得要是把蛋一起放在烤箱烤不是更简单嘛。于是就有了这款吐司太阳蛋披萨。太阳蛋是用鹌鹑蛋做的，我也试过用鸡蛋，不过鸡蛋个头大，做出来没有这么乖巧。舍掉了我另起锅煎蛋的麻烦，真是方便。

                 用吐司做底，烤出来口感特别好，底部酥脆，比用法棍做底烤出来好吃好多倍。
                 * n : 吐司太阳蛋披萨
                 * img : https://cp1.douguo.com/upload/caiku/4/9/4/300_498474d93cd9fcc2961884ef2edc6684.jpg
                 * dc : 37
                 * fc : 41112
                 * ecs : 0
                 * hq : 0
                 * a : {"id":1338074,"n":"葉子的爱与厨房","v":1,"p":"http://tx1.douguo.net/upload/photo/4/9/0/70_u3715812556878211261218.jpg","lvl":6,"is_prime":false,"lv":0}
                 * p : https://cp1.douguo.com/upload/caiku/4/9/4/600_498474d93cd9fcc2961884ef2edc6684.jpg
                 * cook_difficulty : 配菜(中级)
                 * cook_time : 10-30分钟
                 * tags : [{"t":"外国菜"},{"t":"美式快餐"},{"t":"烘烤"},{"t":"咸"},{"t":"咸鲜"},{"t":"创意菜"},{"t":"电器"},{"t":"烤箱"},{"t":"二人世界"},{"t":"一家三口"},{"t":"朋友聚餐"},{"t":"生日聚会"},{"t":"户外野炊"},{"t":"婴幼儿"},{"t":"不爱吃蔬菜"},{"t":"3岁以上"},{"t":"2-3岁"},{"t":"1-2岁"},{"t":"烘焙"},{"t":"披萨"},{"t":"早餐"},{"t":"补钙"}]
                 * vc : 890751
                 * display_ingredient : 1
                 * major : [{"note":"2片","title":"吐司"},{"note":"1个","title":"口蘑"},{"note":"1/3根","title":"胡萝卜"},{"note":"小半把","title":"玉米粒"},{"note":"小半把","title":"马苏里拉芝士碎"},{"note":"2片","title":"培根"},{"note":"2个","title":"鹌鹑蛋"}]
                 * pw : 800
                 * ph : 533
                 * rate : 4.7
                 * recommendation_tag : 727人做过
                 */

                private int stc;
                private int sti;
                private String an;
                private String id;
                private String cookstory;
                private String n;
                private String img;
                private int dc;
                private int fc;
                private int ecs;
                private int hq;
                private ABean a;
                private String p;
                private String cook_difficulty;
                private String cook_time;
                private int vc;
                private int display_ingredient;
                private int pw;
                private int ph;
                private double rate;
                private String recommendation_tag;
                private List<TagsBean> tags;
                private List<MajorBean> major;

                public int getStc() {
                    return stc;
                }

                public void setStc(int stc) {
                    this.stc = stc;
                }

                public int getSti() {
                    return sti;
                }

                public void setSti(int sti) {
                    this.sti = sti;
                }

                public String getAn() {
                    return an;
                }

                public void setAn(String an) {
                    this.an = an;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCookstory() {
                    return cookstory;
                }

                public void setCookstory(String cookstory) {
                    this.cookstory = cookstory;
                }

                public String getN() {
                    return n;
                }

                public void setN(String n) {
                    this.n = n;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public int getDc() {
                    return dc;
                }

                public void setDc(int dc) {
                    this.dc = dc;
                }

                public int getFc() {
                    return fc;
                }

                public void setFc(int fc) {
                    this.fc = fc;
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

                public ABean getA() {
                    return a;
                }

                public void setA(ABean a) {
                    this.a = a;
                }

                public String getP() {
                    return p;
                }

                public void setP(String p) {
                    this.p = p;
                }

                public String getCook_difficulty() {
                    return cook_difficulty;
                }

                public void setCook_difficulty(String cook_difficulty) {
                    this.cook_difficulty = cook_difficulty;
                }

                public String getCook_time() {
                    return cook_time;
                }

                public void setCook_time(String cook_time) {
                    this.cook_time = cook_time;
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

                public int getPw() {
                    return pw;
                }

                public void setPw(int pw) {
                    this.pw = pw;
                }

                public int getPh() {
                    return ph;
                }

                public void setPh(int ph) {
                    this.ph = ph;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
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

                public List<MajorBean> getMajor() {
                    return major;
                }

                public void setMajor(List<MajorBean> major) {
                    this.major = major;
                }

                public static class ABean {
                    /**
                     * id : 1338074
                     * n : 葉子的爱与厨房
                     * v : 1
                     * p : http://tx1.douguo.net/upload/photo/4/9/0/70_u3715812556878211261218.jpg
                     * lvl : 6
                     * is_prime : false
                     * lv : 0
                     */

                    private int id;
                    private String n;
                    private int v;
                    private String p;
                    private int lvl;
                    private boolean is_prime;
                    private int lv;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getN() {
                        return n;
                    }

                    public void setN(String n) {
                        this.n = n;
                    }

                    public int getV() {
                        return v;
                    }

                    public void setV(int v) {
                        this.v = v;
                    }

                    public String getP() {
                        return p;
                    }

                    public void setP(String p) {
                        this.p = p;
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

                    public int getLv() {
                        return lv;
                    }

                    public void setLv(int lv) {
                        this.lv = lv;
                    }
                }

                public static class TagsBean {
                    /**
                     * t : 外国菜
                     */

                    private String t;

                    public String getT() {
                        return t;
                    }

                    public void setT(String t) {
                        this.t = t;
                    }
                }

                public static class MajorBean {
                    /**
                     * note : 2片
                     * title : 吐司
                     */

                    private String note;
                    private String title;

                    public String getNote() {
                        return note;
                    }

                    public void setNote(String note) {
                        this.note = note;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }
                }
            }

            public static class DspBeanX {
                /**
                 * id : ad4461
                 * pid : 7020048845462931
                 * ch : 1
                 * url :
                 * i :
                 * cap : 广告
                 * position : 15searchadvertisement
                 * query :
                 * client_ip : 1.132.109.91
                 * req_min_i : 86400
                 * channel :
                 * media_type : 0
                 * max_impression_count : 0
                 * canclose : 1
                 * imp_trackers : []
                 * click_trackers : []
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
                private List<?> imp_trackers;
                private List<?> click_trackers;

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

                public List<?> getImp_trackers() {
                    return imp_trackers;
                }

                public void setImp_trackers(List<?> imp_trackers) {
                    this.imp_trackers = imp_trackers;
                }

                public List<?> getClick_trackers() {
                    return click_trackers;
                }

                public void setClick_trackers(List<?> click_trackers) {
                    this.click_trackers = click_trackers;
                }
            }
        }
    }
}
