package com.bianxintong.logging.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ComJournalDevApp {
    public ComJournalDevApp(){
        Logger logger = LogManager.getLogger(ComJournalDevApp.class);
        logger.trace("COM :: JournalDev :: LEVEL :: ComJournalDevApp TRACE Message ::");
        logger.debug("ComJournalDevApp info");
    }
}