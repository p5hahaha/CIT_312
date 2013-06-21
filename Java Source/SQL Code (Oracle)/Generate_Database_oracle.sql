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
( id		INT PRIMARY KEY
, uname			VARCHAR2(30)
, pword			VARCHAR2(65)
, first_name	VARCHAR2(30)
, last_name		VARCHAR2(30)	
);

GRANT SELECT, INSERT, UPDATE ON student.my_user to application;

CREATE SEQUENCE s1_user;

GRANT SELECT on student.s1_user to application;
