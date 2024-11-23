#!/bin/bash
set -e

# Esperar a que el master esté disponible
until pg_isready -h master -p 5432; do
    echo "Waiting for master to be ready..."
    sleep 1
done

# Si el directorio de datos está vacío, iniciar replicación
if [ ! -s "$PGDATA/PG_VERSION" ]; then
    # Limpiar directorio de datos
    rm -rf ${PGDATA}/*
    
    # Ejecutar pg_basebackup
    pg_basebackup -h master -p 5432 -U ${POSTGRES_REPLICATION_USER} -X stream -C -S replica1_slot -v -R -W -D ${PGDATA}

    # Configurar para ser un standby que puede ser origen de replicación
    cat >> "${PGDATA}/postgresql.conf" << EOF
hot_standby = on
max_wal_senders = 2
max_replication_slots = 2
EOF

    # Modificar pg_hba.conf para permitir replicación hacia replica2
    cat >> "${PGDATA}/pg_hba.conf" << EOF
host replication ${POSTGRES_REPLICATION_USER} all md5
EOF
fi