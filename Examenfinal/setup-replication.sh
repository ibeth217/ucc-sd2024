#!/bin/bash
set -e

# Modificar postgresql.conf
cat >> "${PGDATA}/postgresql.conf" << EOF
wal_level = replica
max_wal_senders = 4
max_replication_slots = 4
synchronous_commit = on
EOF

# Modificar pg_hba.conf para permitir replicación
cat >> "${PGDATA}/pg_hba.conf" << EOF
host replication ${POSTGRES_REPLICATION_USER} all md5
EOF

# Crear usuario de replicación
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" << EOF
CREATE USER ${POSTGRES_REPLICATION_USER} REPLICATION LOGIN PASSWORD '${POSTGRES_REPLICATION_PASSWORD}';
EOF