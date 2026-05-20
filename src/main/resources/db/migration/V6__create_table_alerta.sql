CREATE SEQUENCE SEQ_ALERTA START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE TABLE tbl_alerta (
    id_alerta NUMBER PRIMARY KEY,
    id_armazenamento NUMBER NOT NULL,
    id_empresa NUMBER NOT NULL,
    descricao VARCHAR2(255),
    data_alerta DATE,
    status VARCHAR2(50),

    CONSTRAINT fk_alerta_armazenamento
        FOREIGN KEY (id_armazenamento)
        REFERENCES tbl_armazenamento (id_armazenamento),

    CONSTRAINT fk_alerta_empresa
        FOREIGN KEY (id_empresa)
        REFERENCES tbl_empresa (id_empresa)
);