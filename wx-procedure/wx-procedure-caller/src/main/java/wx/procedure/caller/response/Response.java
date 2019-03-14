package wx.procedure.caller.response;

import wx.procedure.caller.response.enums.ExceptionEnums;
import wx.procedure.caller.response.enums.RES;

import java.io.Serializable;

public class Response implements Serializable {
    private String code;
    private String message;
    private Object data = new Response.Value();

    public Response success() {
        this.code = RES.SUCCESS.getCode();
        this.message = RES.SUCCESS.getMsg();
        return this;
    }

    public Response success(String message) {
        this.success();
        this.message = message;
        return this;
    }

    public Response success(String message, Object data) {
        this.success(message);
        this.data = data;
        return this;
    }

    public Response error(ExceptionEnums ex) {
        this.code = ex.getCode();
        this.message = ex.getMessage();
        return this;
    }

    public Response error(ExceptionEnums ex, Object data) {
        this.error(ex);
        this.data = data;
        return this;
    }

    public Response error(String message) {
        this.error();
        this.message = message;
        return this;
    }

    public Response error(String message, Object data) {
        this.error(message);
        this.data = data;
        return this;
    }

    public Response error() {
        this.code = RES.ERROR.getCode();
        this.message = RES.ERROR.getMsg();
        return this;
    }

    public Response failure() {
        this.code = RES.ERROR.getCode();
        this.message = RES.ERROR.getMsg();
        return this;
    }

    public Response failure(String message) {
        this.failure();
        this.message = message;
        return this;
    }

    public Response failure(String message, Object data) {
        this.failure(message);
        this.data = data;
        return this;
    }

    public Response selfDefine(String message, Object data, String code) {
        this.selfDefine(data);
        this.selfDefine(message);
        this.code = code;
        return this;
    }

    public Response selfDefine(String message) {
        this.message = message;
        return this;
    }

    public Response selfDefine(Object data) {
        this.data = data;
        return this;
    }

    public Response() {
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Response)) {
            return false;
        } else {
            Response other = (Response)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Response;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "Response(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }

    class Value implements Serializable {
        Value() {
        }
    }
}
