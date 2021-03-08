package cn.itcast.exception;

/**
 * 自定义异常类
 */
public class SysException extends Exception{
    //储存提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
//构造方法，
    public SysException(String message) {
        this.message = message;
    }
}
