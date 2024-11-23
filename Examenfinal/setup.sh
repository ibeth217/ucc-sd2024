#!/bin/bash

# Detener contenedores existentes
docker-compose down -v

# Eliminar directorios de datos existentes
sudo rm -rf master-data replica1-data replica2-data

# Crear nuevos directorios
mkdir -p master-data replica1-data replica2-data

# Establecer permisos correctos
sudo chown -R 999:999 master-data replica1-data replica2-data
sudo chmod -R 700 master-data replica1-data replica2-data

# Dar permisos a los scripts de inicio
sudo chmod +x init-master.sh init-replica1.sh init-replica2.sh

# Iniciar contenedores
docker-compose up -d

# Esperar a que los contenedores estén listos
echo "Esperando a que los contenedores estén listos..."
sleep 30

# Verificar el estado de los contenedores
docker-compose ps

# Mostrar logs si hay errores
docker-compose logs master