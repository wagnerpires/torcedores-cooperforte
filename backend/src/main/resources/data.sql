insert into tb_perfil(id, papel) values (2,'ADMIN');
insert into tb_usuario(id, nome, perfil, senha, email) values (1, 'Admin', 2, '$2a$10$OcR7cgVliPasiknwWkGEJe1lMZKsbtpTevciuvb/ph1s6ot9HiraK', 'admin');

insert into tb_torcedor (nome, cpf, cep, cidade, logradouro, bairro, uf, excluido, complemento, data_criacao, data_ultima_atualizacao) VALUES ('WAGNER ALVES', '58239880525', '72870237', 'VALPARAISO', 'RUA 24', 'JARDIM ORIENTE', 'GO', false, 'COMPLEMENTO', '2021-07-27', '2021-07-27');