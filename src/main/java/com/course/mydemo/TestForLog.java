package com.course.mydemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class TestForLog {
	private final static Logger logger = LoggerFactory.getLogger(TestForLog.class);
	
	public static void main(String[] args) {
		logger.info("logback 成功了");
		logger.error("logback 成功了");
		logger.debug("logback 成功了");
	}
}
