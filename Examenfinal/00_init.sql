-- Crear el usuario de replicación si no existe
DO $
$
BEGIN
    IF NOT EXISTS (
        SELECT 1
    FROM pg_roles
    WHERE rolname = 'replicator'
    ) THEN
    CREATE USER replicator
    REPLICATION LOGIN PASSWORD 'replicator_password';
END
IF;
END $$;

-- Crear el replication slot físico si no existe
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1
    FROM pg_replication_slots
    WHERE slot_name = 'replication_slot'
    ) THEN
        PERFORM pg_create_physical_replication_slot
    ('replication_slot');
END
IF;
END $$;
