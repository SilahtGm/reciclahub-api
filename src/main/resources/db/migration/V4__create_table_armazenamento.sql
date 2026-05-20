CREATE SEQUENCE SEQ_ARMAZENAMENTO START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE TABLE tbl_armazenamento (
    id_armazenamento NUMBER PRIMARY KEY,
    id_ponto NUMBER NOT NULL,
    id_tipo NUMBER NOT NULL,
    quantidade_atual NUMBER,

    CONSTRAINT fk_armazenamento_ponto
        FOREIGN KEY (id_ponto)
        REFERENCES tbl_ponto_coleta (id_ponto),

    CONSTRAINT fk_armazenamento_tipo
        FOREIGN KEY (id_tipo)
        REFERENCES tbl_tipo_residuo (id_tipo)
);