/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software
 * License version 1.1, a copy of which has been included with this
 * distribution in the LICENSE.APL file.  */

package org.apache.log4j.test;

import java.io.FileWriter;

import org.apache.log4j.AsyncAppender;
import org.apache.log4j.Category;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Priority;
import org.apache.log4j.TTCCLayout;
import org.apache.log4j.spi.LoggingEvent;

public class UnitTestAppender {

    static org.apache.log4j.Category cat = Category.getInstance(UnitTestAppender.class);

    public void testAppender() {
        FileAppender f = null;
        try {
            f = new FileAppender(new TTCCLayout(), new FileWriter("myLog.txt"));
        } catch (Exception e ) {
            e.printStackTrace();
        }
        AsyncAppender appender = null;
        try {
            appender = new AsyncAppender();
        } catch (Exception e ) {
            e.printStackTrace();
        }
        appender.addAppender(f);
        appender.activateOptions();
        Category root = Category.getRoot();
        root.addAppender(appender);
        LoggingEvent event1 = new LoggingEvent("", cat, Priority.DEBUG, "message1", null);
        appender.doAppend(event1);
        Category.shutdown();
    }

    public static void main (String args[]) {
        UnitTestAppender t = new UnitTestAppender();
        t.testAppender();
    }
}
