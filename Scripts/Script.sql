BEGIN
   FOR r IN (SELECT table_name FROM all_tables WHERE owner = 'ETL') LOOP
      EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON ETL.' || r.table_name || ' TO system';
   END LOOP;
END;

