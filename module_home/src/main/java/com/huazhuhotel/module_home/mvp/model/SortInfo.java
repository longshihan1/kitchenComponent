package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class SortInfo {

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

        private String nv;
        private List<CsBeanXX> cs;
        private List<AdsBean> ads;

        public String getNv() {
            return nv;
        }

        public void setNv(String nv) {
            this.nv = nv;
        }

        public List<CsBeanXX> getCs() {
            return cs;
        }

        public void setCs(List<CsBeanXX> cs) {
            this.cs = cs;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public static class CsBeanXX {
            private String name;
            private String id;
            private String ju;
            private String image_url;
            private List<CsBeanX> cs;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getJu() {
                return ju;
            }

            public void setJu(String ju) {
                this.ju = ju;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public List<CsBeanX> getCs() {
                return cs;
            }

            public void setCs(List<CsBeanX> cs) {
                this.cs = cs;
            }

            public static class CsBeanX {
                /**
                 * name : 热门食材
                 * id : 16
                 * ju :
                 * cs : [{"name":"面条","id":"3411","ju":"recipes://www.douguo.com/search?key=面条&_vs=400","cs":[],"image_url":""},{"name":"豆腐","id":"3412","ju":"recipes://www.douguo.com/search?key=豆腐&_vs=400","cs":[],"image_url":""},{"name":"土豆","id":"3413","ju":"recipes://www.douguo.com/search?key=土豆&_vs=400","cs":[],"image_url":""},{"name":"牛肉","id":"3414","ju":"recipes://www.douguo.com/search?key=牛肉&_vs=400","cs":[],"image_url":""},{"name":"排骨","id":"3415","ju":"recipes://www.douguo.com/search?key=排骨&_vs=400","cs":[],"image_url":""},{"name":"虾","id":"3416","ju":"recipes://www.douguo.com/search?key=虾&_vs=400","cs":[],"image_url":""},{"name":"茄子","id":"3417","ju":"recipes://www.douguo.com/search?key=茄子&_vs=400","cs":[],"image_url":""},{"name":"鸡蛋","id":"3418","ju":"recipes://www.douguo.com/search?key=鸡蛋&_vs=400","cs":[],"image_url":""},{"name":"鱼","id":"3419","ju":"recipes://www.douguo.com/search?key=鱼&_vs=400","cs":[],"image_url":""}]
                 * image_url : http://cp1.douguo.net/upload/article/9/3/e/93cd2270452144925874c693a93561ce.jpg
                 */

                private String name;
                private String id;
                private String ju;
                private String image_url;
                private List<CsBean> cs;
                public boolean isSelected;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getJu() {
                    return ju;
                }

                public void setJu(String ju) {
                    this.ju = ju;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public List<CsBean> getCs() {
                    return cs;
                }

                public void setCs(List<CsBean> cs) {
                    this.cs = cs;
                }

                public static class CsBean {
                    /**
                     * name : 面条
                     * id : 3411
                     * ju : recipes://www.douguo.com/search?key=面条&_vs=400
                     * cs : []
                     * image_url :
                     */

                    private String name;
                    private String id;
                    private String ju;
                    private String image_url;
                    private List<?> cs;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getJu() {
                        return ju;
                    }

                    public void setJu(String ju) {
                        this.ju = ju;
                    }

                    public String getImage_url() {
                        return image_url;
                    }

                    public void setImage_url(String image_url) {
                        this.image_url = image_url;
                    }

                    public List<?> getCs() {
                        return cs;
                    }

                    public void setCs(List<?> cs) {
                        this.cs = cs;
                    }
                }
            }
        }

        public static class AdsBean {
            /**
             * dsp : {"id":"ad4613","pid":"","ch":0,"url":"recipes://www.douguo.com/user?id=21610006&tab=1","i":"http://i1.douguo.net/upload//recipe/b/2/d/b222dc764bade8de6c0fdbee977f377d.jpg","cap":"","position":"3351recipecategory","imp_trackers":[],"t":"早餐好营养，学期新起航！","d":"早餐好营养，学期新起航！","query":"","client_ip":"58.246.71.154","req_min_i":86400,"channel":"","media_type":0,"max_impression_count":0,"canclose":0,"click_trackers":["http://cp1.douguo.net/upload/article/9/3/e/93cd2270452144925874c693a93561ce.jpg"]}
             * cid : 3352
             */

            private DspBean dsp;
            private String cid;

            public DspBean getDsp() {
                return dsp;
            }

            public void setDsp(DspBean dsp) {
                this.dsp = dsp;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public static class DspBean {
                /**
                 * id : ad4613
                 * pid :
                 * ch : 0
                 * url : recipes://www.douguo.com/user?id=21610006&tab=1
                 * i : http://i1.douguo.net/upload//recipe/b/2/d/b222dc764bade8de6c0fdbee977f377d.jpg
                 * cap :
                 * position : 3351recipecategory
                 * imp_trackers : []
                 * t : 早餐好营养，学期新起航！
                 * d : 早餐好营养，学期新起航！
                 * query :
                 * client_ip : 58.246.71.154
                 * req_min_i : 86400
                 * channel :
                 * media_type : 0
                 * max_impression_count : 0
                 * canclose : 0
                 * click_trackers : ["http://cp1.douguo.net/upload/article/9/3/e/93cd2270452144925874c693a93561ce.jpg"]
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
                private int max_impression_count;
                private int canclose;
                private List<?> imp_trackers;
                private List<String> click_trackers;

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

                public List<String> getClick_trackers() {
                    return click_trackers;
                }

                public void setClick_trackers(List<String> click_trackers) {
                    this.click_trackers = click_trackers;
                }
            }
        }
    }
}
