create user eduardo with password '123456';
grant all privileges on database bicimoto to eduardo;

CREATE TABLE cliente (
    cd_cliente SERIAL PRIMARY KEY,
    nm_cliente VARCHAR(100) NOT NULL,
    ds_telefone VARCHAR(11) NOT NULL,
    dt_nascimento DATE NOT NULL,
    ds_cpf VARCHAR(11) NOT NULL,
    ds_email VARCHAR(100),
    ds_cep VARCHAR(8),
    ds_endereco VARCHAR(100) NOT NULL,
    ds_cidade VARCHAR(100) NOT NULL,
    ds_bairro VARCHAR(100) NOT NULL,
    ds_estado VARCHAR(2) NOT NULL
);

CREATE TABLE venda (
    cd_venda SERIAL PRIMARY KEY,
    cd_cliente INT NOT NULL,
    dt_venda DATE NOT NULL,
    vl_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (cd_cliente) REFERENCES cliente(cd_cliente)
);

CREATE TABLE fornecedor (
    cd_fornecedor SERIAL PRIMARY KEY,
    nm_fornecedor VARCHAR(100) NOT NULL,
    ds_telefone VARCHAR(11) NOT NULL,
    ds_endereco VARCHAR(100),
    ds_cnpj VARCHAR(14) NOT NULL,
    ds_email VARCHAR(100),
    ds_cep VARCHAR(8),
    ds_cidade VARCHAR(100),
    ds_estado VARCHAR(2),
    ds_bairro VARCHAR(100)
);

CREATE TABLE produto (
    cd_produto SERIAL PRIMARY KEY,
    nm_produto VARCHAR(100) NOT NULL,
    ds_produto VARCHAR(100) NOT NULL,
    vl_inicial DECIMAL(10,2) NOT NULL,
    vl_final DECIMAL(10,2) NOT NULL,
    qt_produto INT NOT NULL,
    cd_fornecedor INT NOT NULL,
    FOREIGN KEY (cd_fornecedor) REFERENCES fornecedor(cd_fornecedor)
);

CREATE TABLE venda_item (
    cd_item SERIAL PRIMARY KEY,
    qt_produto INT NOT NULL,
    vl_subtotal DECIMAL(10,2) NOT NULL,
    cd_produto INT NOT NULL,
    cd_venda INT NOT NULL,
    FOREIGN KEY (cd_produto) REFERENCES produto(cd_produto),
    FOREIGN KEY (cd_venda) REFERENCES venda(cd_venda)
);