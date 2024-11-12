FROM python:3.9-alpine

# Instalar dependencias del sistema
RUN apk add --no-cache \
    gcc \
    musl-dev \
    python3-dev \
    libffi-dev \
    openssl-dev \
    postgresql-dev \
    postgresql-client \
    curl \
    iputils \
    bash

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar todos los archivos necesarios
COPY ./app /app/app/
COPY requirements.txt /app/
COPY start.sh /app/

# Dar permisos de ejecución al script
RUN chmod +x /app/start.sh
# Instalar dependencias Python
RUN pip install --no-cache-dir -r requirements.txt
# Variables de entorno
ENV PYTHONUNBUFFERED=1
ENV PYTHONPATH=/app
# Comando para iniciar la aplicación
CMD ["/app/start.sh"]