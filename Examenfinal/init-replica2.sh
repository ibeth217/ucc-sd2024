#!/bin/bash
set -e

# Detenemos postgres temporalmente
pg_ctl -D "$PGDATA" -m fast -w stop

# Limpiamos el directorio de datos
rm -rf "${PGDATA:?}"/*

# Configuramos la replicación desde replica1
pg_basebackup -h replica1 -p 5432 -U replica_user -X stream -C -S replica2_slot -v -R -W -D "$PGDATA"

# Configuraciones adicionales para el standby
cat >> "$PGDATA/postgresql.conf" <<EOL
primary_conninfo = 'host=replica1 port=5432 user=replica_user password=${POSTGRES_REPLICATION_PASSWORD} application_name=replica2'
promote_trigger_file = '/tmp/promote_replica2'
hot_standby = on
EOL

# Iniciamos postgres nuevamente
pg_ctl -D "$PGDATA" -w start