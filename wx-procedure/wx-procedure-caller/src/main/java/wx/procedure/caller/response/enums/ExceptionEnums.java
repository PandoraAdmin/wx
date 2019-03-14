package wx.procedure.caller.response.enums;


public enum ExceptionEnums {
    FORMAT_EXCEPTION("30001", "字符串格式化为数字错误");

    private String code;
    private String message;

    private ExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
