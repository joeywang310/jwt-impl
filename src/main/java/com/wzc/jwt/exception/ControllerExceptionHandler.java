package com.wzc.jwt.exception;

import com.wzc.jwt.model.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(UserException.class)
	public HttpResult handleRRException(UserException e){
		HttpResult r = new HttpResult();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());
		return r;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public HttpResult handlerNoFoundException(Exception e) {
		logger.error(e.getMessage(), e);
		return HttpResult.error(404, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler(Exception.class)
	public HttpResult handleException(Exception e){
		logger.error(e.getMessage(), e);
		return HttpResult.error();
	}
}
