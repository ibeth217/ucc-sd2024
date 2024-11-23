#!/bin/bash
set -e

# Esperar a que replica1 esté disponible
until pg_isready -h replica1 -p 5432; do
    echo "Waiting for replica1 to be ready..."
    sleep 1
done

# Si el directorio de datos está vacío, iniciar replicación
if [ ! -s "$PGDATA/PG_VERSION" ]; then
    # Limpiar directorio de datos
    rm -rf ${PGDATA}/*
    
    # Ejecutar pg_basebackup desde replica1
    pg_basebackup -h replica1 -p 5432 -U ${POSTGRES_REPLICATION_USER} -X stream -C -S replica2_slot -v -R -W -D ${PGDATA}
fi