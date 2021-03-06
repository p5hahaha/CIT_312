-- Create the user table
-- Conditionally drop the table PRICE
BEGIN
  FOR i IN (SELECT   object_name, object_type
            FROM     user_objects
            WHERE    object_name IN ('MY_USER', 'S1_USER')) LOOP
    IF i.object_type = 'TABLE' THEN       
      EXECUTE IMMEDIATE 'DROP TABLE '||i.object_name||' CASCADE CONSTRAINTS';
    ELSIF i.object_type = 'SEQUENCE' THEN
      EXECUTE IMMEDIATE 'DROP SEQUENCE '||i.object_name;
    ELSE
      dbms_output.put_line('Unknown object type: ' || i.object_type);
    END IF;  
  END LOOP;
END;
/

CREATE TABLE my_user
( user_id				INT PRIMARY KEY
, uname					VARCHAR2(30)
, pword					VARCHAR2(65)
, first_name			VARCHAR2(30)
, last_name				VARCHAR2(30)
, preferred_vehicle		INT
, created_by			INT
, creation_date			DATE
, last_updated_by		INT
, last_update_date		DATE
, CONSTRAINT uq_my_user_1 UNIQUE (uname)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON student.my_user to application; 

CREATE SEQUENCE s1_user;

GRANT SELECT on student.s1_user to application;

-- ------------------Session Table-------------------------------------
BEGIN
  FOR i IN (SELECT   object_name, object_type
            FROM     user_objects
            WHERE    object_name IN ('USER_SESSION', 'S1_USER_SESSION')) LOOP
    IF i.object_type = 'TABLE' THEN       
      EXECUTE IMMEDIATE 'DROP TABLE '||i.object_name||' CASCADE CONSTRAINTS';
    ELSIF i.object_type = 'SEQUENCE' THEN
      EXECUTE IMMEDIATE 'DROP SEQUENCE '||i.object_name;
    ELSE
      dbms_output.put_line('Unknown object type: ' || i.object_type);
    END IF;  
  END LOOP;
END;
/

CREATE TABLE user_session
( session_id		INT PRIMARY KEY
, session_number	VARCHAR2(36)
, user_id			INT
, android_id		VARCHAR2(16)
, created_by		INT
, creation_date		DATE
, last_updated_by	INT
, last_update_date	DATE
, ended_by			INT
, end_date			DATE
);

GRANT SELECT, INSERT, UPDATE ON student.user_session to application;

CREATE SEQUENCE s1_user_session;
GRANT SELECT on student.s1_user_session to application;
-- ------------------Vehicle Table-------------------------------------
BEGIN
  FOR i IN (SELECT   object_name, object_type
            FROM     user_objects
            WHERE    object_name IN ('VEHICLE', 'S1_VEHICLE')) LOOP
    IF i.object_type = 'TABLE' THEN       
      EXECUTE IMMEDIATE 'DROP TABLE '||i.object_name||' CASCADE CONSTRAINTS';
    ELSIF i.object_type = 'SEQUENCE' THEN
      EXECUTE IMMEDIATE 'DROP SEQUENCE '||i.object_name;
    ELSE
      dbms_output.put_line('Unknown object type: ' || i.object_type);
    END IF;  
  END LOOP;
END;
/

CREATE TABLE vehicle
( vehicle_id			INT PRIMARY KEY
, name			VARCHAR2(30)
, user_id				INT
, vehicle_year			INT
, avg_mpg				NUMBER
, gas_tank_size			NUMBER
, current_gas_amount	NUMBER
, current_odometer		NUMBER
, vehicle				VARCHAR2(30)
, created_by			INT
, creation_date			DATE
, last_updated_by		INT
, last_update_date		DATE
);

GRANT SELECT, INSERT, UPDATE ON student.vehicle to application;

CREATE SEQUENCE s1_vehicle;
GRANT SELECT on student.s1_vehicle to application;

