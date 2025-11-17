package peng.zhi.liu.carmainpfcommon.exception;

import org.apache.catalina.User;

public class UserException extends RuntimeException{
    public UserException(){

    }
    public UserException(String msg){
        super(msg);
    }
}
