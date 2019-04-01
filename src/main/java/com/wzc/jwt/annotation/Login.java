package com.wzc.jwt.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: joey
 * Date: 2019-03-29 16:06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
