package com.lxx.oa.service.exception;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description
 */
public class LoginException extends  RuntimeException {
    public LoginException(String message){
        super(message);
    }
}
