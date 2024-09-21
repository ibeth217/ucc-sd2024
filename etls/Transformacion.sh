#!/bin/bash

# Obtener fecha y hora en el formato deseado
year=$(date +%Y)
month=$(date +%m)
day=$(date +%d)
hours=$(date +%H)
minutes=$(date +%M)

# Cambiar al directorio de trabajo (asegúrate de que la ruta sea correcta en WSL)
cd "/mnt/c/Users/Ibeth Pacheco/Documents/EjercicioPentaho"

# Ejecutar Kitchen.bat (asegúrate de que la ruta a Pentaho sea correcta en WSL)
"/mnt/c/Program Files/Pentaho/data-integration/Kitchen.bat" /file:"/mnt/c/Users/Ibeth Pacheco/Documents/repos-ucc-2024/ucc-sd2024/etls/Transformation 1.ktr" 

# Muestra un mensaje de éxito
echo "La tarea se completo correctamente."