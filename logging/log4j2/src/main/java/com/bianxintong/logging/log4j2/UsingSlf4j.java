package com.bianxintong.logging.log4j2;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingSlf4j {
	private static final Logger LOG = LoggerFactory.getLogger(UsingSlf4j.class);
	
	public UsingSlf4j() throws FileNotFoundException{
		LOG.info("debug w/ slf4j");
//		LoggerFactory.getLogger("root").info("throw", new FileNotFoundException());
		throw new FileNotFoundException();
	}
}
