CREATE TABLE Autor
(
    autor_id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    nombre VARCHAR(255),
    version INT NOT NULL
);
CREATE TABLE Mensaje
(
    mensaje_id SERIAL PRIMARY KEY,
    fecha DATE,
    texto VARCHAR(255) NOT NULL,
    version INT NOT NULL,
    autor BIGINT NOT NULL
);
CREATE UNIQUE INDEX UK_b9rqydwsclpsfivfgus4rq227 ON Autor (email);
ALTER TABLE Mensaje ADD FOREIGN KEY (autor) REFERENCES Autor (autor_id);
CREATE INDEX FK_1n8x4ku41yquct34o1yjs5ud0 ON Mensaje (autor);