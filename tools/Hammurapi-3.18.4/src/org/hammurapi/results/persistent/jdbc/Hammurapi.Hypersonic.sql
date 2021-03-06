CREATE CACHED TABLE BASELINE_VIOLATION (
       ID INTEGER NOT NULL IDENTITY PRIMARY KEY
     , REPORT_NAME VARCHAR(50) NOT NULL
     , INSPECTOR VARCHAR(15) NOT NULL
     , SIGNATURE VARCHAR(2500) NOT NULL
);
CREATE INDEX "IX_BASELINE_VIOLATION_SQLC$E_SIGNATURE" ON BASELINE_VIOLATION (REPORT_NAME, INSPECTOR, SIGNATURE);

CREATE CACHED TABLE RESULT (
       ID INTEGER NOT NULL
     , TYPE VARCHAR(100) NOT NULL
     , CODEBASE BIGINT DEFAULT '0'
     , RESULT_DATE DATETIME
     , MAX_SEVERITY SMALLINT
     , REVIEWS BIGINT DEFAULT '0'
     , VIOLATION_LEVEL DOUBLE DEFAULT '0'
     , VIOLATIONS BIGINT DEFAULT '0'
     , WAIVED_VIOLATIONS BIGINT DEFAULT '0'
     , NAME VARCHAR(250)
     , HAS_WARNINGS INTEGER DEFAULT '0'
     , COMMITED BIT DEFAULT '0' NOT NULL
     , COMPILATION_UNIT INTEGER
     , IS_NEW BIT DEFAULT 'false' NOT NULL
     , PRIMARY KEY (ID)
);

CREATE CACHED TABLE METRIC (
       RESULT_ID INTEGER DEFAULT '0' NOT NULL
     , NAME VARCHAR(50) NOT NULL
     , PRIMARY KEY (RESULT_ID, NAME)
     , CONSTRAINT FK_METRIC_RESULT FOREIGN KEY (RESULT_ID)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
);

CREATE CACHED TABLE REPORT (
       ID INTEGER NOT NULL
     , NAME VARCHAR(50)
     , REPORT_NUMBER INTEGER
     , RESULT_ID INTEGER
     , EXECUTION_TIME BIGINT
     , HOST_NAME VARCHAR(250)
     , HOST_ID VARCHAR(50)
     , DESCRIPTION VARCHAR(250)
     , IS_OLD BIT DEFAULT '0' NOT NULL
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_REPORT_RESULT FOREIGN KEY (RESULT_ID)
                  REFERENCES RESULT (ID) ON DELETE SET NULL
);

CREATE CACHED TABLE INSPECTOR (
       REPORT_ID INTEGER NOT NULL
     , NAME VARCHAR(15) NOT NULL
     , SEVERITY SMALLINT NOT NULL
     , DESCRIPTION VARCHAR(250)
     , CONFIG_INFO VARCHAR(250)
     , PRIMARY KEY (REPORT_ID, NAME)
     , CONSTRAINT FK_INSPECTOR_REPORT FOREIGN KEY (REPORT_ID)
                  REFERENCES REPORT (ID) ON DELETE CASCADE
);
CREATE INDEX IX_INSPECTOR_ORDER ON INSPECTOR (NAME, DESCRIPTION, CONFIG_INFO, REPORT_ID);

CREATE CACHED TABLE ANNOTATION (
       ID INTEGER NOT NULL IDENTITY PRIMARY KEY
     , RESULT_ID INTEGER NOT NULL
     , HANDLE VARCHAR(250)
     , CONSTRAINT FK_ANNOTATION_RESULT FOREIGN KEY (RESULT_ID)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
);

CREATE CACHED TABLE MEASUREMENT (
       ID INTEGER NOT NULL
     , RESULT_ID INTEGER DEFAULT '0' NOT NULL
     , NAME VARCHAR(50) NOT NULL
     , MEASUREMENT_VALUE DOUBLE NOT NULL
     , SOURCE VARCHAR(250)
     , LINE INTEGER DEFAULT '0' NOT NULL
     , COL INTEGER DEFAULT '0' NOT NULL
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_MEASUREMENT_METRIC FOREIGN KEY (RESULT_ID, NAME)
                  REFERENCES METRIC (RESULT_ID, NAME) ON DELETE CASCADE
);
CREATE INDEX IX_MEASUREMENT_VALUE ON MEASUREMENT (MEASUREMENT_VALUE);

CREATE CACHED TABLE RESULT_NET (
       PARENT INTEGER NOT NULL
     , CHILD INTEGER NOT NULL
     , PRIMARY KEY (PARENT, CHILD)
     , CONSTRAINT FK_RESULT_NET_PARENT FOREIGN KEY (PARENT)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
     , CONSTRAINT FK_RESULT_NET_CHILD FOREIGN KEY (CHILD)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
);

CREATE CACHED TABLE KINDRED (
       ANCESTOR INTEGER NOT NULL
     , DESCENDANT INTEGER NOT NULL
     , PRIMARY KEY (ANCESTOR, DESCENDANT)
     , CONSTRAINT FK_KINDRED_ANCESTOR FOREIGN KEY (ANCESTOR)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
     , CONSTRAINT FK_KINDRED_DESCENDANT FOREIGN KEY (DESCENDANT)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
);

CREATE CACHED TABLE VIOLATION (
       ID INTEGER NOT NULL
     , RESULT_ID INTEGER DEFAULT '0' NOT NULL
     , REPORT_ID INTEGER DEFAULT '0' NOT NULL
     , INSPECTOR VARCHAR(15)
     , MESSAGE_ID INT
     , SOURCE_ID INT
     , LINE INT DEFAULT '0' NOT NULL
     , COL INT DEFAULT '0' NOT NULL
     , SIGNATURE_POSTFIX VARCHAR(250)
     , WAIVER_REASON INT
     , WAIVER_EXPIRES DATE
     , VIOLATION_TYPE TINYINT DEFAULT '0' NOT NULL
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_VIOLATION_RESULT FOREIGN KEY (RESULT_ID)
                  REFERENCES RESULT (ID) ON DELETE CASCADE
     , CONSTRAINT FK_VIOLATION_MESSAGE FOREIGN KEY (MESSAGE_ID)
                  REFERENCES MESSAGE (ID)
     , CONSTRAINT FK_VIOLATION_WAIVER_REASON FOREIGN KEY (WAIVER_REASON)
                  REFERENCES MESSAGE (ID)
     , CONSTRAINT FK_VIOLATION_INSPECTOR FOREIGN KEY (REPORT_ID, INSPECTOR)
                  REFERENCES INSPECTOR (REPORT_ID, NAME) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE RESULT ADD CONSTRAINT FK_RESULT_COMPILATION_UNIT FOREIGN KEY (COMPILATION_UNIT)
                  REFERENCES COMPILATION_UNIT (ID) ON DELETE CASCADE;

ALTER TABLE VIOLATION ADD CONSTRAINT FK_VIOLATION_COMPILATION_UNIT FOREIGN KEY (SOURCE_ID)
                  REFERENCES COMPILATION_UNIT (ID) ON DELETE CASCADE;


