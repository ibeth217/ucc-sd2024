#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$postgres" --dbname "$postgres" <<-EOSQL
    CREATE USER $POSTGRES_REPLICATION_USER WITH REPLICATION PASSWORD '$POSTGRES_REPLICATION_PASSWORD';
EOSQL

cat >> "${PGDATA}/postgresql.conf" <<EOL
wal_level = replica
max_wal_senders = 10
max_replication_slots = 10
hot_standby = on
listen_addresses = '*'
EOL

cat >> "${PGDATA}/pg_hba.conf" <<EOL
host replication ${POSTGRES_REPLICATION_USER} all md5
host all all all md5
EOL