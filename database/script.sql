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
delete from produto where cd_produto  = 2;
commit;

select a.cd_produto, a.nm_produto, b.nm_fornecedor, a.qt_produto, a.dt_atualizacao, a.vl_inicial, a.vl_final, a.ds_produto from produto a inner join fornecedor b on a.cd_fornecedor = b.cd_fornecedor;




truncate produto cascade;
truncate fornecedor  cascade;