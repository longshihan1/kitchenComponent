package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/17 0017
 * @des
 * @function
 */

public class UnRecipesListInfo {




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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {

            private int type;
            private RBean r;

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

            public static class RBean {
                /**
                 * stc : 0
                 * sti : 0
                 * an : 糖小饼
                 * id : 1700765
                 * cookstory : 黄油抹面包一生推！有很长一段时间迷这个迷到每天晚上不啃两片都睡不着觉。
                 对，是两片，是晚上，是临睡前=0=自己想想都觉得可怕，但就是这么好吃我能怎么办我也很绝望啊。
                 做起来也毫无技术含量，用的黄油好不好吃决定一切！奶香味浓郁但不腻口的最棒~

                 PS: 最近在外地，没有条件做饭~吃外卖吃到绝望QAQ有好吃的外卖推荐吗
                 * n : 黄油抹酱手绘吐司
                 * img : https://cp1.douguo.com/upload/caiku/7/d/9/300_7d6e63c416ce8c389668f8789be93fd9.jpg
                 * dc : 1
                 * fc : 48
                 * ecs : 0
                 * hq : 0
                 * a : {"id":1704870,"n":"糖小饼","v":1,"p":"http://tx1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg","lvl":7,"is_prime":false,"lv":0}
                 * p : https://cp1.douguo.com/upload/caiku/7/d/9/600_7d6e63c416ce8c389668f8789be93fd9.jpg
                 * cook_difficulty :
                 * cook_time :
                 * pw : 5760
                 * ph : 3840
                 * tags : []
                 * vc : 5080
                 * display_ingredient : 1
                 */

                private int stc;
                private int sti;
                private String an;
                private int id;
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
                private int pw;
                private int ph;
                private int vc;
                private int display_ingredient;
                private List<?> tags;

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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
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

                public List<?> getTags() {
                    return tags;
                }

                public void setTags(List<?> tags) {
                    this.tags = tags;
                }

                public static class ABean {
                    /**
                     * id : 1704870
                     * n : 糖小饼
                     * v : 1
                     * p : http://tx1.douguo.net/upload/photo/a/2/a/70_u4095206075346702231831.jpg
                     * lvl : 7
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
            }
        }
    }
}
