FROM postgres:latest
RUN apk add posgretsql-client
RUN psql -h localhost -U postgres -c "CREATE TABLE ejemplo (id SERIAL PRIMARY KEY, nombre VARCHAR(50));"