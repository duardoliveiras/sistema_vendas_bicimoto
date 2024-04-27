create user eduardo with password '123456';
grant all privileges on database bicimoto to eduardo;
ALTER ROLE eduardo SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN REPLICATION NOBYPASSRLS;

CREATE TABLE cliente (
	cd_cliente serial4 NOT NULL,
	nm_cliente varchar(100) NOT NULL,
	ds_telefone varchar NOT NULL,
	dt_nascimento date NULL,
	ds_cpf varchar NOT NULL,
	ds_email varchar(100) NULL,
	ds_cep varchar NULL,
	ds_endereco varchar(100) NOT NULL,
	ds_cidade varchar(100) NOT NULL,
	ds_bairro varchar(100) NOT NULL,
	ds_estado varchar(2) NOT NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (cd_cliente)
);

create type tipo_venda as ENUM('avista','prazo');
CREATE TABLE venda (
	cd_venda serial4 NOT NULL,
	cd_cliente int4 NOT NULL,
	dt_venda date NOT NULL,
	vl_total numeric(10, 2) NOT NULL,
	ds_pagamento varchar(50) NULL,
	ds_observacao varchar(255) NULL,
	tipo_venda tipo_venda,
	CONSTRAINT venda_pkey PRIMARY KEY (cd_venda),
	CONSTRAINT venda_cd_cliente_fkey FOREIGN KEY (cd_cliente) REFERENCES cliente(cd_cliente)
);

CREATE TABLE fornecedor (
	cd_fornecedor serial4 NOT NULL,
	nm_fornecedor varchar(100) NOT NULL,
	ds_telefone varchar NOT NULL,
	ds_endereco varchar(100) NULL,
	ds_cnpj varchar NOT NULL,
	ds_email varchar(100) NULL,
	ds_cep varchar NULL,
	ds_cidade varchar(100) NULL,
	ds_estado varchar NULL,
	ds_bairro varchar(100) NULL,
	CONSTRAINT fornecedor_pkey PRIMARY KEY (cd_fornecedor)
);

CREATE TABLE produto (
    cd_produto serial4 NOT NULL,
	nm_produto varchar(100) NOT NULL,
	ds_produto varchar(100) NOT NULL,
	vl_inicial numeric(10, 2) NOT NULL,
	vl_final numeric(10, 2) NOT NULL,
	qt_produto int4 NOT NULL,
	cd_fornecedor int4 NOT NULL,
	dt_atualizacao date NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (cd_produto),
	CONSTRAINT produto_cd_fornecedor_fkey FOREIGN KEY (cd_fornecedor) REFERENCES fornecedor(cd_fornecedor)
);

CREATE TABLE venda_item (
	cd_item serial4 NOT NULL,
	qt_produto int4 NOT NULL,
	vl_subtotal numeric(10, 2) NOT NULL,
	cd_produto int4 NOT NULL,
	cd_venda int4 NOT NULL,
	CONSTRAINT venda_item_pkey PRIMARY KEY (cd_item),
	CONSTRAINT venda_item_cd_produto_fkey FOREIGN KEY (cd_produto) REFERENCES produto(cd_produto),
	CONSTRAINT venda_item_cd_venda_fkey FOREIGN KEY (cd_venda) REFERENCES venda(cd_venda)
);

create type status_pagamento as enum('aberto','pago')
CREATE TABLE vendas_prazo(
    cd_venda_prazo serial4 NOT NULL,
    cd_venda INT NOT NULL,
    nm_parcela INTEGER NOT NULL,
    vl_parcela DECIMAL(8, 2) NOT NULL,
    dt_vencimento DATE NOT NULL,
    status_pagamento status_pagamento NOT NULL,
    CONSTRAINT venda_prazopkey PRIMARY KEY (cd_venda_prazo),
	CONSTRAINT venda_prazo_cd_venda_fkey FOREIGN KEY (cd_venda) REFERENCES venda(cd_venda)
);
