--
-- Database schema
--
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'postgres') THEN
        CREATE ROLE postgres;
    END IF;
END
$$;
CREATE DATABASE database;
GRANT ALL PRIVILEGES ON DATABASE database TO postgres;
