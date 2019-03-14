package wx.procedure.caller.response.enums;


public enum RES {
    SUCCESS("success", "10000"),
    WARN("warn", "20000"),
    ERROR("error", "30000"),
    UNAUTH("unauth", "40000");

    private String msg;
    private String code;

    private RES(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
