# app/schemas.py
from pydantic import BaseModel, EmailStr
from typing import Optional
from datetime import datetime

class UserSchema(BaseModel):
    fullname: str
    email: EmailStr
    password: str

class UserLoginSchema(BaseModel):
    email: EmailStr
    password: str

class TokenResponse(BaseModel):
    access_token: str

class DatosBase(BaseModel):
    id: str
    fec_alta: datetime
    user_name: str
    codigo_zip: str
    credit_car_num: str
    credit_card_ccv: str
    cuenta_numero: str
    direccion: str
    geo_latitud: str
    geo_longitud: str
    color_favorito: str
    foto_dni: str
    ip: str
    auto: str
    auto_modelo: str
    auto_tipo: str
    auto_color: str
    cantidad_compras_realizadas: int
    avatar: str
    fec_birthday: datetime

    class Config:
        orm_mode = True