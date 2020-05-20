package com.suzhou.love.autumn.security.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring工具类
 * Created by macro on 2020/3/3.
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 功能说明: 获取applicationContext
     *
     * @Description 获取applicationContext
     * @Author chendq
     * @Date 2020/5/20 15:33
     * @Param []
     * @Return org.springframework.context.ApplicationContext
     **/
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 功能说明: 设置applicationContext
     * 
     * @Description 设置applicationContext
     * @Author chendq
     * @Date 2020/5/20 15:34 
     * @Param [applicationContext]
     * @Return void
     **/
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
    }

    /**
     * 功能说明: 通过name获取Bean
     *
     * @Description 通过name获取Bean
     * @Author chendq
     * @Date 2020/5/20 15:33
     * @Param [name]
     * @Return java.lang.Object
     **/
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 功能说明: 通过class获取Bean
     *
     * @Description 通过class获取Bean
     * @Author chendq
     * @Date 2020/5/20 15:33
     * @Param [clazz]
     * @Return T
     **/
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 功能说明: 通过name,以及Clazz返回指定的Bean
     *
     * @Description 通过name,以及Clazz返回指定的Bean
     * @Author chendq
     * @Date 2020/5/20 15:34
     * @Param [name, clazz]
     * @Return T
     **/
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
