-- Create the user table
-- Conditionally drop the table PRICE
BEGIN
  FOR i IN (SELECT   object_name
            FROM     user_object
            WHERE    object_name IN ('USER')
				AND 	object_type = 'TABLE') LOOP
    EXECUTE IMMEDIATE 'DROP TABLE '||i.table_name||' CASCADE CONSTRAINTS';
  END LOOP;
END;
/

CREATE TABLE user
( user_id		INT PRIMARY KEY
, user_name		VARCHAR2(30)
, password		
, first_name	VARCHAR2(30)
, last_name		VARCHAR2(30)	