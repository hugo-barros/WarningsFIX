CREATE TABLE HISTORY ( 
        ID INTEGER NOT NULL 
      , CODEBASE BIGINT DEFAULT 0 NOT NULL
      , MAX_SEVERITY INTEGER 
      , REVIEWS BIGINT DEFAULT 0 NOT NULL
      , VIOLATION_LEVEL DOUBLE DEFAULT 0 NOT NULL
      , VIOLATIONS BIGINT DEFAULT 0 NOT NULL
      , WAIVED_VIOLATIONS BIGINT DEFAULT 0 NOT NULL
      , HAS_WARNINGS INTEGER DEFAULT 0 NOT NULL
      , CHANGE_RATIO DOUBLE DEFAULT 0 NOT NULL
      , COMPILATION_UNITS INTEGER DEFAULT 0 NOT NULL
      , REPORT_DATE TIMESTAMP
      , NAME VARCHAR(50)
      , DESCRIPTION VARCHAR(250)
      , EXECUTION_TIME BIGINT
      , PRIMARY KEY (ID) 
);
