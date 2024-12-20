
CREATE TABLE "ETL"."CRIME_LACITY_13" 
(
    "DR_NO" NUMBER(15,0) NOT NULL ENABLE,
    "DATE_RPTD" VARCHAR2(30),
    "DATE_OCC" VARCHAR2(30),
    "TIME_OCC" VARCHAR2(30),
    "AREA" NUMBER(5,0),
    "AREA_NAME" VARCHAR2(30),
    "RPT_DIST_NO" VARCHAR2(10),
    "PART_1_2" VARCHAR2(5),
    "CRM_CD" VARCHAR2(10),
    "CRM_CD_DESC" VARCHAR2(100),
    "MOCODES" VARCHAR2(100),
    "VICT_AGE" NUMBER(3,0),
    "VICT_SEX" VARCHAR2(1)
) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
NOCOMPRESS LOGGING
STORAGE (
    INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
    BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
)
TABLESPACE "USERS";



CREATE TABLE "ETL"."CRIME_LACITY_21" 
(
    "DR_NO" NUMBER(15,0) NOT NULL ENABLE,
    "DATE_RPTD" VARCHAR2(30),
    "DATE_OCC" VARCHAR2(30),
    "TIME_OCC" VARCHAR2(30),
    "AREA" NUMBER(5,0),
    "AREA_NAME" VARCHAR2(30),
    "RPT_DIST_NO" VARCHAR2(10),
    "PART_1_2" VARCHAR2(5),
    "CRM_CD" VARCHAR2(10),
    "CRM_CD_DESC" VARCHAR2(100),
    "MOCODES" VARCHAR2(100),
    "VICT_AGE" NUMBER(3,0),
    "VICT_SEX" VARCHAR2(1),
    "VICT_DESCENT" VARCHAR2(2),
    "PREMIS_CD" VARCHAR2(10),
    "PREMIS_DESC" VARCHAR2(100),
    "WEAPON_USED_CD" VARCHAR2(10),
    "WEAPON_DESC" VARCHAR2(100),
    "STATUS" VARCHAR2(10),
    "STATUS_DESC" VARCHAR2(50),
    "CRM_CD_1" VARCHAR2(10)
) SEGMENT CREATION IMMEDIATE
PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
NOCOMPRESS LOGGING
STORAGE (
    INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
    PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
    BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
)
TABLESPACE "USERS";
