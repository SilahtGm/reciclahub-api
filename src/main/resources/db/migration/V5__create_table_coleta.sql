CREATE SEQUENCE SEQ_COLETA START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE TABLE tbl_coleta (
    id_coleta NUMBER PRIMARY KEY,
    id_armazenamento NUMBER NOT NULL,
    id_empresa NUMBER NOT NULL,
    data_coleta DATE,
    quantidade_coletada NUMBER,

    CONSTRAINT fk_coleta_armazenamento
        FOREIGN KEY (id_armazenamento)
        REFERENCES tbl_armazenamento (id_armazenamento),

    CONSTRAINT fk_coleta_empresa
        FOREIGN KEY (id_empresa)
        REFERENCES tbl_empresa (id_empresa)
);