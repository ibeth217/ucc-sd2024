from sqlalchemy import Column, Integer, String, DateTime
from .database import Base

class Datos(Base):
    __tablename__ = "datos"

    id = Column(String(50), primary_key=True)
    fec_alta = Column(DateTime)
    user_name = Column(String(100))
    codigo_zip = Column(String(10))
    credit_card_num = Column(String(20))
    credit_card_ccv = Column(String(4))
    cuenta_numero = Column(String(20))
    direccion = Column(String(200))
    geo_latitud = Column(String(20))
    geo_longitud = Column(String(20))
    color_favorito = Column(String(50))
    foto_dni = Column(String(200))
    ip = Column(String(15))
    auto = Column(String(100))
    auto_modelo = Column(String(100))
    auto_tipo = Column(String(50))
    auto_color = Column(String(100))
    cantidad_compras_realizadas = Column(Integer)
    avatar = Column(String(200))
    fec_birthday = Column(DateTime)