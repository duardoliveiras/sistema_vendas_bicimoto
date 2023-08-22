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


select currval('cliente_cd_cliente_seq'); 