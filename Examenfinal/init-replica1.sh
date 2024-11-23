#!/bin/bash
set -e

# Detenemos postgres temporalmente
pg_ctl -D "$PGDATA" -m fast -w stop

# Limpiamos el directorio de datos
rm -rf "${PGDATA:?}"/*

# Configuramos la replicación desde el master
pg_basebackup -h master -p 5432 -U replica_user -X stream -C -S replica1_slot -v -R -W -D "$PGDATA"

# Configuraciones adicionales para el standby
cat >> "$PGDATA/postgresql.conf" <<EOL
primary_conninfo = 'host=master port=5432 user=replica_user password=${POSTGRES_REPLICATION_PASSWORD} application_name=replica1'
promote_trigger_file = '/tmp/promote_replica1'
hot_standby = on
EOL

# Iniciamos postgres nuevamente
pg_ctl -D "$PGDATA" -w start