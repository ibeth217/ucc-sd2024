# app/main.py
from typing import List
from fastapi import FastAPI, Body, Depends
from starlette.responses import RedirectResponse
from sqlalchemy.orm import Session
import requests
import json
import datetime
from . import models, schemas, jwt_handler, jwt_bearer
from .database import engine, get_db

# Crear tablas en la base de datos
models.Base.metadata.create_all(bind=engine)

# Configuración de la aplicación FastAPI con metadata para OpenAPI
app = FastAPI(
    title="API de Usuarios",
    description="API para gestión de usuarios y datos con autenticación JWT",
    version="1.0.0",
    terms_of_service="http://example.com/terms/",
    contact={
        "name": "API Support",
        "email": "ibeth.pacheco@campusucc.edu.co",
    },
    license_info={
        "name": "Apache 2.0",
        "url": "https://www.apache.org/licenses/LICENSE-2.0.html",
    },
)

# Lista para almacenar usuarios (en producción deberías usar la base de datos)
users = []

def check_user(data: schemas.UserLoginSchema):
    for user in users:
        if user.email == data.email and user.password == data.password:
            return True
    return False

@app.get("/", tags=["Root"])
def main():
    return RedirectResponse(url="/docs/")

@app.get('/usuarios/', 
         dependencies=[Depends(jwt_bearer.JWTBearer())], 
         tags=["Usuarios"],
         response_model=List[schemas.DatosBase],
         description="Obtiene la lista de todos los usuarios. Requiere autenticación JWT.")
def show_users(db: Session = Depends(get_db)):
    usuarios = db.query(models.Datos).all()
    return usuarios

@app.post("/user/signup", 
          tags=["Autenticación"],
          response_model=schemas.TokenResponse,
          description="Registra un nuevo usuario y devuelve un token JWT.")
def create_user(user: schemas.UserSchema = Body(...)):
    users.append(user)
    return jwt_handler.signJWT(user.email)

@app.post("/user/login", 
          tags=["Autenticación"],
          response_model=schemas.TokenResponse,
          description="Inicia sesión y devuelve un token JWT.")
def user_login(user: schemas.UserLoginSchema = Body(...)):
    if check_user(user):
        return jwt_handler.signJWT(user.email)
    return {
        "error": "Wrong login details!"
    }

@app.get("/cargadb/", 
         dependencies=[Depends(jwt_bearer.JWTBearer())], 
         tags=["Base de Datos"],
         description="Carga datos desde una API externa. Requiere autenticación JWT.")
def call_extapi(db: Session = Depends(get_db)):
    url_destino = "https://62433a7fd126926d0c5d296b.mockapi.io/api/v1/usuarios/"
    respuesta = requests.get(url_destino)
    datos = respuesta.json()
    
    for usuario in datos:
        nuevo_dato = models.Datos(
            id=usuario['id'],
            fec_alta=datetime.datetime.strptime(usuario['fec_alta'], '%Y-%m-%dT%H:%M:%S.%fZ'),
            user_name=usuario['user_name'],
            codigo_zip=usuario['codigo_zip'],
            credit_car_num=usuario['credit_card_num'],
            credit_card_ccv=usuario['credit_card_ccv'],
            cuenta_numero=usuario['cuenta_numero'],
            direccion=usuario['direccion'],
            geo_latitud=usuario['geo_latitud'],
            geo_longitud=usuario['geo_longitud'],
            color_favorito=usuario['color_favorito'],
            foto_dni=usuario['foto_dni'],
            ip=usuario['ip'],
            auto=usuario['auto'],
            auto_modelo=usuario['auto_modelo'],
            auto_tipo=usuario['auto_tipo'],
            auto_color=usuario['auto_color'],
            cantidad_compras_realizadas=usuario['cantidad_compras_realizadas'],
            avatar=usuario['avatar'],
            fec_birthday=datetime.datetime.strptime(usuario['fec_birthday'], '%Y-%m-%dT%H:%M:%S.%fZ')
        )
        db.add(nuevo_dato)
    
    db.commit()
    return {"message": "Datos cargados exitosamente"}