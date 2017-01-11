package hp.com.retrofitdemo.bean;

/**
 * Created by tangdekun on 2017/1/11.
 */

public class JsonBean {
//    error_code": 0,"reason": "Success","result":
    private int error_code;
    private String reason;
    private DataBean result;

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

    public DataBean getResult() {
        return result;
    }

    public void setResult(DataBean result) {
        this.result = result;
    }
}
