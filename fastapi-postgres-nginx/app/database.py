from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
import time

POSTGRES_URL = "postgresql://postgres:postgres@db/postgres"

# Función para intentar la conexión con reintentos
def get_db_connection():
    retry_count = 0
    max_retries = 5
    while retry_count < max_retries:
        try:
            engine = create_engine(POSTGRES_URL)
            engine.connect()
            return engine
        except Exception as e:
            retry_count += 1
            print(f"Intento {retry_count} de {max_retries} para conectar a la base de datos...")
            if retry_count == max_retries:
                raise e
            time.sleep(5)

engine = get_db_connection()
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)
Base = declarative_base()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()