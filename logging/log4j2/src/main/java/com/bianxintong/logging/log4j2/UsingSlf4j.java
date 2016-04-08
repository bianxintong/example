package com.bianxintong.logging.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingSlf4j {
	private static final Logger LOG = LoggerFactory.getLogger(UsingSlf4j.class);
	
	public UsingSlf4j(){
		LOG.debug("debug w/ slf4j");
	}
}
