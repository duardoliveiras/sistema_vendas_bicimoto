select * from cliente;

INSERT INTO CLIENTE
(nm_cliente,ds_telefone,ds_cpf,ds_email,ds_cep,ds_endereco,
ds_cidade,ds_bairro,ds_estado)
 VALUES ('eduardo','95959595','45454545','duardo@gmail.com',
 '7878787','dadadad','dadadad','adad','MT');
 
SELECT last_value+1
FROM cliente_cd_cliente_seq;

SELECT *
FROM public.cliente_cd_cliente_seq;


truncate  table cliente cascade;

select * from cliente
where nm_cliente like '%eduardo%';


SELECT last_value+1
FROM public.cliente_cd_cliente_seq;


select * from fornecedor;

select cd_fornecedor, nm_fornecedor, ds_telefone, ds_endereco, ds_cnpj, ds_email, ds_cep, ds_cidade, ds_estado, ds_bairro from fornecedor;

select * from produto;
select * from venda_item;
select * from venda;

update produto set qt_produto=qt_produto-? where cd_produto =?;
delete from produto where cd_produto  = 2;
commit;

select a.cd_produto, a.nm_produto, b.nm_fornecedor, a.qt_produto, a.dt_atualizacao, a.vl_inicial, a.vl_final, a.ds_produto from produto a inner join fornecedor b on a.cd_fornecedor = b.cd_fornecedor;

select now()


truncate produto cascade;
truncate fornecedor  cascade;

select max(cd_produto) from produto;

select a.cd_venda, b.nm_cliente, a.dt_venda, a.vl_total, a.ds_observacao, a.ds_pagamento  from venda a inner join cliente b on a.cd_cliente = b.cd_cliente;

select a.cd_item, a.qt_produto, a.vl_subtotal, c.nm_produto, b.dt_venda, b.vl_total 
from venda_item a left join venda b on a.cd_venda  = b.cd_venda 
inner join  produto c on a.cd_produto  = c.cd_produto ;