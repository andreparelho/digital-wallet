ALTER TABLE users
    ALTER COLUMN user_id TYPE bigint USING user_id::bigint;
