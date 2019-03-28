package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

public class CommentListInfo {



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

        private int cc;
        private String el;
        private RBean r;
        private List<CommentsBean> comments;

        public int getCc() {
            return cc;
        }

        public void setCc(int cc) {
            this.cc = cc;
        }

        public String getEl() {
            return el;
        }

        public void setEl(String el) {
            this.el = el;
        }

        public RBean getR() {
            return r;
        }

        public void setR(RBean r) {
            this.r = r;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class RBean {
            /**
             * title : 可可千层蛋糕
             * thumb_path : https://i1.douguo.com/upload/caiku/4/d/c/300_4db6b341855cd8c4cec9c89851418bcc.jpg
             * cook_id : 1228338
             * actionurl : recipes://www.douguo.com/details?id=1228338
             * user : {"nick":"格妈"}
             */

            private String title;
            private String thumb_path;
            private String cook_id;
            private String actionurl;
            private UserBean user;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb_path() {
                return thumb_path;
            }

            public void setThumb_path(String thumb_path) {
                this.thumb_path = thumb_path;
            }

            public String getCook_id() {
                return cook_id;
            }

            public void setCook_id(String cook_id) {
                this.cook_id = cook_id;
            }

            public String getActionurl() {
                return actionurl;
            }

            public void setActionurl(String actionurl) {
                this.actionurl = actionurl;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                /**
                 * nick : 格妈
                 */

                private String nick;

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }
            }
        }

        public static class CommentsBean {
            /**
             * id : 5907079
             * u : {"lvl":3,"is_prime":false,"id":"21569064","n":"Wwwwq小食","p":"http://i1.douguo.net/upload/photo/5/b/c/70_u16951020198604092949.jpg","v":0,"lv":0,"relationship":0}
             * content : [{"c":"奶油从来没有打发成功过"}]
             * time : 2018-08-03 18:23:08
             * reply_id : 0
             * like_count : 0
             * city :
             * ccc : 1
             * like : 0
             * at :
             * ac : #999999
             * cmc : 2
             * ia : 0
             * child_comments : [{"id":"6421818","u":{"lvl":1,"is_prime":false,"id":"23334384","n":"豆粉7389245259","p":"","v":0,"lv":0,"relationship":0},"content":[{"c":" 无油无水的盆。盆和打奶油的工具放冷藏半个小时左右。在准备个比打奶油大的盆放点水放冷冻里。也可以用冰袋垫在打奶油的盆底下。反正就是低温打奶油。"}],"time":"2019-03-03 13:46:25","reply_id":5907079,"like_count":0,"reply_user":{"lvl":3,"is_prime":false,"id":"21569064","n":"Wwwwq小食","p":"http://i1.douguo.net/upload/photo/5/b/c/70_u16951020198604092949.jpg","v":0,"lv":0,"relationship":0},"city":"呼伦贝尔市","ccc":0,"like":0,"at":"呼伦贝尔市","ac":"#999999","cmc":2,"ia":0}]
             */

            private String id;
            private UBean u;
            private String time;
            private int reply_id;
            private int like_count;
            private String city;
            private int ccc;
            private int like;
            private String at;
            private String ac;
            private int cmc;
            private int ia;
            private List<ContentBean> content;
            private List<ChildCommentsBean> child_comments;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UBean getU() {
                return u;
            }

            public void setU(UBean u) {
                this.u = u;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getReply_id() {
                return reply_id;
            }

            public void setReply_id(int reply_id) {
                this.reply_id = reply_id;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCcc() {
                return ccc;
            }

            public void setCcc(int ccc) {
                this.ccc = ccc;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public String getAt() {
                return at;
            }

            public void setAt(String at) {
                this.at = at;
            }

            public String getAc() {
                return ac;
            }

            public void setAc(String ac) {
                this.ac = ac;
            }

            public int getCmc() {
                return cmc;
            }

            public void setCmc(int cmc) {
                this.cmc = cmc;
            }

            public int getIa() {
                return ia;
            }

            public void setIa(int ia) {
                this.ia = ia;
            }

            public List<ContentBean> getContent() {
                return content;
            }

            public void setContent(List<ContentBean> content) {
                this.content = content;
            }

            public List<ChildCommentsBean> getChild_comments() {
                return child_comments;
            }

            public void setChild_comments(List<ChildCommentsBean> child_comments) {
                this.child_comments = child_comments;
            }

            public static class UBean {
                /**
                 * lvl : 3
                 * is_prime : false
                 * id : 21569064
                 * n : Wwwwq小食
                 * p : http://i1.douguo.net/upload/photo/5/b/c/70_u16951020198604092949.jpg
                 * v : 0
                 * lv : 0
                 * relationship : 0
                 */

                private int lvl;
                private boolean is_prime;
                private String id;
                private String n;
                private String p;
                private int v;
                private int lv;
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

                public int getRelationship() {
                    return relationship;
                }

                public void setRelationship(int relationship) {
                    this.relationship = relationship;
                }
            }

            public static class ContentBean {
                /**
                 * c : 奶油从来没有打发成功过
                 */

                private String c;

                public String getC() {
                    return c;
                }

                public void setC(String c) {
                    this.c = c;
                }
            }

            public static class ChildCommentsBean {
                /**
                 * id : 6421818
                 * u : {"lvl":1,"is_prime":false,"id":"23334384","n":"豆粉7389245259","p":"","v":0,"lv":0,"relationship":0}
                 * content : [{"c":" 无油无水的盆。盆和打奶油的工具放冷藏半个小时左右。在准备个比打奶油大的盆放点水放冷冻里。也可以用冰袋垫在打奶油的盆底下。反正就是低温打奶油。"}]
                 * time : 2019-03-03 13:46:25
                 * reply_id : 5907079
                 * like_count : 0
                 * reply_user : {"lvl":3,"is_prime":false,"id":"21569064","n":"Wwwwq小食","p":"http://i1.douguo.net/upload/photo/5/b/c/70_u16951020198604092949.jpg","v":0,"lv":0,"relationship":0}
                 * city : 呼伦贝尔市
                 * ccc : 0
                 * like : 0
                 * at : 呼伦贝尔市
                 * ac : #999999
                 * cmc : 2
                 * ia : 0
                 */

                private String id;
                private UBeanX u;
                private String time;
                private int reply_id;
                private int like_count;
                private ReplyUserBean reply_user;
                private String city;
                private int ccc;
                private int like;
                private String at;
                private String ac;
                private int cmc;
                private int ia;
                private List<ContentBeanX> content;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public UBeanX getU() {
                    return u;
                }

                public void setU(UBeanX u) {
                    this.u = u;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getReply_id() {
                    return reply_id;
                }

                public void setReply_id(int reply_id) {
                    this.reply_id = reply_id;
                }

                public int getLike_count() {
                    return like_count;
                }

                public void setLike_count(int like_count) {
                    this.like_count = like_count;
                }

                public ReplyUserBean getReply_user() {
                    return reply_user;
                }

                public void setReply_user(ReplyUserBean reply_user) {
                    this.reply_user = reply_user;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public int getCcc() {
                    return ccc;
                }

                public void setCcc(int ccc) {
                    this.ccc = ccc;
                }

                public int getLike() {
                    return like;
                }

                public void setLike(int like) {
                    this.like = like;
                }

                public String getAt() {
                    return at;
                }

                public void setAt(String at) {
                    this.at = at;
                }

                public String getAc() {
                    return ac;
                }

                public void setAc(String ac) {
                    this.ac = ac;
                }

                public int getCmc() {
                    return cmc;
                }

                public void setCmc(int cmc) {
                    this.cmc = cmc;
                }

                public int getIa() {
                    return ia;
                }

                public void setIa(int ia) {
                    this.ia = ia;
                }

                public List<ContentBeanX> getContent() {
                    return content;
                }

                public void setContent(List<ContentBeanX> content) {
                    this.content = content;
                }

                public static class UBeanX {
                    /**
                     * lvl : 1
                     * is_prime : false
                     * id : 23334384
                     * n : 豆粉7389245259
                     * p :
                     * v : 0
                     * lv : 0
                     * relationship : 0
                     */

                    private int lvl;
                    private boolean is_prime;
                    private String id;
                    private String n;
                    private String p;
                    private int v;
                    private int lv;
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

                    public int getRelationship() {
                        return relationship;
                    }

                    public void setRelationship(int relationship) {
                        this.relationship = relationship;
                    }
                }

                public static class ReplyUserBean {
                    /**
                     * lvl : 3
                     * is_prime : false
                     * id : 21569064
                     * n : Wwwwq小食
                     * p : http://i1.douguo.net/upload/photo/5/b/c/70_u16951020198604092949.jpg
                     * v : 0
                     * lv : 0
                     * relationship : 0
                     */

                    private int lvl;
                    private boolean is_prime;
                    private String id;
                    private String n;
                    private String p;
                    private int v;
                    private int lv;
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

                    public int getRelationship() {
                        return relationship;
                    }

                    public void setRelationship(int relationship) {
                        this.relationship = relationship;
                    }
                }

                public static class ContentBeanX {
                    /**
                     * c :  无油无水的盆。盆和打奶油的工具放冷藏半个小时左右。在准备个比打奶油大的盆放点水放冷冻里。也可以用冰袋垫在打奶油的盆底下。反正就是低温打奶油。
                     */

                    private String c;

                    public String getC() {
                        return c;
                    }

                    public void setC(String c) {
                        this.c = c;
                    }
                }
            }
        }
    }
}
