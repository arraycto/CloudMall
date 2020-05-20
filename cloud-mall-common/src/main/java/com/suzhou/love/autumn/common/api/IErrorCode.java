package com.suzhou.love.autumn.common.api;

import java.io.Serializable;

/**
 * 功能说明: 业务代码接口、封装API的错误码
 * 
 * @author chendq
 * @date 2020/4/30 14:11
 **/
public interface IErrorCode extends Serializable {

    /**
     * 状态码
     *
     * @return int
     */
    long getCode();

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();
}
