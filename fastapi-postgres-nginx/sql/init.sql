
-- Eliminar la tabla si existe
DROP TABLE IF EXISTS datos;

-- Crear la tabla datos con la estructura exacta del JSON
CREATE TABLE datos
(
    id VARCHAR(50) PRIMARY KEY,
    -- Cambiado a VARCHAR ya que viene como string del JSON
    fec_alta TIMESTAMP,
    user_name VARCHAR(100),
    codigo_zip VARCHAR(10),
    credit_card_num VARCHAR(20),
    credit_card_ccv VARCHAR(4),
    -- Agregado nuevo campo
    cuenta_numero VARCHAR(20),
    direccion VARCHAR(200),
    geo_latitud VARCHAR(20),
    -- Cambiado a VARCHAR ya que viene como string
    geo_longitud VARCHAR(20),
    -- Cambiado a VARCHAR ya que viene como string
    color_favorito VARCHAR(50),
    foto_dni VARCHAR(200),
    ip VARCHAR(15),
    auto VARCHAR(100),
    auto_modelo VARCHAR(100),
    auto_tipo VARCHAR(50),
    auto_color VARCHAR(100),
    cantidad_compras_realizadas INTEGER,
    -- Nombre actualizado
    avatar VARCHAR(200),
    fec_birthday TIMESTAMP
    -- Nombre actualizado
);

-- Índices para mejorar el rendimiento
CREATE INDEX idx_datos_user_name ON datos(user_name);
CREATE INDEX idx_datos_fec_alta ON datos(fec_alta);

-- Permisos
--GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;
--GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO postgres;

-- Datos de prueba que coinciden con el formato JSON
INSERT INTO datos
VALUES
    (
        '1',
        '2021-07-31T00:11:06.741Z',
        'Junior39',
        '22139',
        '6767-2293-4172-5169',
        '357',
        '50099904',
        'Amelia Forks',
        '-40.0728',
        '-39.5073',
        'white',
        'http://placeimg.com/640/480',
        '224.140.175.223',
        'Bugatti Corvette',
        'Challenger',
        'Cargo Van',
        'Lamborghini PT Cruiser',
        30564,
        'https://cdn.fakercloud.com/avatars/franciscoamk_128.jpg',
        '2022-03-29T03:28:16.364Z'
);