#!/bin/sh

echo "Iniciando aplicación FastAPI..."
cd /app
exec uvicorn app.main:app --host 0.0.0.0 --port 8000 --reload