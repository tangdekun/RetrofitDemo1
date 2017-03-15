package hp.com.retrofitdemo.bean;

import java.util.List;

/**
 * Created by tangdekun on 2017/3/15.
 */

public class JokePictureBean {

    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"妹子当时就懵逼了","hashId":"F91E9F3C1848538EE9365C497B3B479A","unixtime":1487661099,
     * "updatetime":"2017-02-21 15:11:39","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/F91E9F3C1848538EE9365C497B3B479A.gif"},{"content":"这是被突然停下来甩出去吓怕了",
     * "hashId":"84A7F8B78299EDA08DE45DB2E7603F6D","unixtime":1487661099,"updatetime":"2017-02-21 15:11:39",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/84A7F8B78299EDA08DE45DB2E7603F6D.gif"},
     * {"content":"坑孩子啊","hashId":"541133598C8E1DF464EE2EE61D27344F","unixtime":1487661099,"updatetime":"2017-02-21
     * 15:11:39","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/541133598C8E1DF464EE2EE61D27344F
     * .gif"},{"content":"日本7D主题乐园，我差点以为是真的","hashId":"7E025EC81F2EA4B44BDBCABE9DF67E6D","unixtime":1487661099,
     * "updatetime":"2017-02-21 15:11:39","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/7E025EC81F2EA4B44BDBCABE9DF67E6D.gif"},{"content":"我也是这么想的",
     * "hashId":"33768833A59CCA97225664E17F45C389","unixtime":1487661099,"updatetime":"2017-02-21 15:11:39",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/33768833A59CCA97225664E17F45C389.jpg"},
     * {"content":"二鹅戏人","hashId":"735DF8E41FC69EBCB879173CA5D5CE2E","unixtime":1487661099,"updatetime":"2017-02-21
     * 15:11:39","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/735DF8E41FC69EBCB879173CA5D5CE2E
     * .gif"},{"content":"没有比较就没有。。。霜害","hashId":"EA3E1A331436B833DE3F6DEAE1E184EA","unixtime":1487661098,
     * "updatetime":"2017-02-21 15:11:38","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/EA3E1A331436B833DE3F6DEAE1E184EA.gif"},{"content":"这就尴尬了",
     * "hashId":"5D8E0D226B969E949BC9C3B3E6D41832","unixtime":1487661098,"updatetime":"2017-02-21 15:11:38",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/5D8E0D226B969E949BC9C3B3E6D41832.gif"},
     * {"content":"也不一定是命案，说不定是强奸案呢","hashId":"9CFBA1F60BECD5D3106D24BC1336277A","unixtime":1487661098,
     * "updatetime":"2017-02-21 15:11:38","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/9CFBA1F60BECD5D3106D24BC1336277A.jpg"},{"content":"哭出声来！",
     * "hashId":"153ED22F89827086C5A2DF51AD7004F5","unixtime":1487657119,"updatetime":"2017-02-21 14:05:19",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/153ED22F89827086C5A2DF51AD7004F5.jpg"},
     * {"content":"输入法打","hashId":"E8DF0D35BC7E52B58F861F2130D98F25","unixtime":1487657119,"updatetime":"2017-02-21
     * 14:05:19","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/E8DF0D35BC7E52B58F861F2130D98F25.jpg"},{"content":"哥们，你让个路也太风骚了",
     * "hashId":"667B4F7A9BD81112E12029230D0F34B4","unixtime":1487657119,"updatetime":"2017-02-21 14:05:19",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/667B4F7A9BD81112E12029230D0F34B4.gif"},
     * {"content":"走你！!!","hashId":"CF057E9455DE8B7903168B3F1B62DEDF","unixtime":1487657119,"updatetime":"2017-02-21
     * 14:05:19","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/CF057E9455DE8B7903168B3F1B62DEDF
     * .gif"},{"content":"女儿不愧是贴身小棉袄","hashId":"DC3A9CBDC3A28423DAE577A7BA64EA4E","unixtime":1487657119,
     * "updatetime":"2017-02-21 14:05:19","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/DC3A9CBDC3A28423DAE577A7BA64EA4E.gif"},{"content":"据说很多老司机等红绿灯时都有这个习惯",
     * "hashId":"BF915C524F89281664A0CCF0D0CC7DEB","unixtime":1487657119,"updatetime":"2017-02-21 14:05:19",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/BF915C524F89281664A0CCF0D0CC7DEB.gif"},
     * {"content":"熊孩子上线了","hashId":"D7A23D196C7A2CA562B97C8055C4AD74","unixtime":1487657119,"updatetime":"2017-02-21
     * 14:05:19","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/21/D7A23D196C7A2CA562B97C8055C4AD74.gif"},{"content":"真正的肉包铁",
     * "hashId":"6B8EB38EBD25CC3EF5BE70A489585832","unixtime":1487570752,"updatetime":"2017-02-20 14:05:52",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/20/6B8EB38EBD25CC3EF5BE70A489585832.gif"},
     * {"content":"好腿法~","hashId":"5A89F4FBC93CFA1E60B65C72D8320700","unixtime":1487570752,"updatetime":"2017-02-20
     * 14:05:52","url":"http://juheimg.oss-cn-hangzhou.aliyuncs
     * .com/joke/201702/20/5A89F4FBC93CFA1E60B65C72D8320700.gif"},{"content":"某网评的2016韩国网红top10",
     * "hashId":"4CD89F2D9B7E161E66D28CE944678E5B","unixtime":1487563505,"updatetime":"2017-02-20 12:05:05",
     * "url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/20/4CD89F2D9B7E161E66D28CE944678E5B.jpg"},
     * {"content":"找个人试","hashId":"EED5B680E63D97A38DD8C897AB45194D","unixtime":1487563505,"updatetime":"2017-02-20
     * 12:05:05","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/20/EED5B680E63D97A38DD8C897AB45194D
     * .jpg"}]}
     */

    private int error_code;
    private String reason;
    private ResultSimple result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultSimple getResult() {
        return result;
    }

    public void setResult(ResultSimple result) {
        this.result = result;
    }

    public static class ResultSimple {
        private List<DataSimple> data;

        public List<DataSimple> getData() {
            return data;
        }

        public void setData(List<DataSimple> data) {
            this.data = data;
        }

        public static class DataSimple {
            /**
             * content : 妹子当时就懵逼了
             * hashId : F91E9F3C1848538EE9365C497B3B479A
             * unixtime : 1487661099
             * updatetime : 2017-02-21 15:11:39
             * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201702/21/F91E9F3C1848538EE9365C497B3B479A.gif
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;
            private String url;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
