insert into tb_perfil(id, papel) values (1,'COOPER');
insert into tb_perfil(id, papel) values (2,'ADMIN');

insert into tb_usuario(id, nome, perfil, senha, email) values (1, 'Cooperforte', 1, '$2a$10$OcR7cgVliPasiknwWkGEJe1lMZKsbtpTevciuvb/ph1s6ot9HiraK', 'cooper');
insert into tb_usuario(id, nome, perfil, senha, email) values (2, 'Administrador', 2, '$2a$10$OcR7cgVliPasiknwWkGEJe1lMZKsbtpTevciuvb/ph1s6ot9HiraK', 'admin');

insert into tb_torcedor (nome, cpf, cep, cidade, logradouro, bairro, uf, excluido, complemento, data_criacao, data_ultima_atualizacao) VALUES ('NELSON PIQUET', '02019330040', '72000000', 'CEILANDIA', 'RUA 30', 'SETOR O', 'MG', false, 'COMPLEMENTO ENDERECO 3', '2021-07-27', '2021-07-27');
insert into tb_torcedor (nome, cpf, cep, cidade, logradouro, bairro, uf, excluido, complemento, data_criacao, data_ultima_atualizacao) VALUES ('ALAIN PROST', '95086488052', '72140120', 'AGUAS CLARAS', 'RUA 31', 'AGUAS CLARAS', 'TO', false, 'COMPLEMENTO ENDERECO 4', '2021-07-27', '2021-07-27');

insert into tb_email(torcedor_id, email) VALUES (1, 'nelson@gmail.com');
insert into tb_email(torcedor_id, email) VALUES (2, 'prost@gmail.com');

insert into tb_telefone(telefone, tipo, torcedor_id) VALUES  ('61981626852', 'CELULAR', 1 );
insert into tb_telefone(telefone, tipo, torcedor_id) VALUES  ('6130251687', 'COMERCIAL', 2);