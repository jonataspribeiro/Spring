use db_blogpessoal;

insert into tb_postagens(data, texto,titulo) 
values(current_timestamp(), "Meu 1º Post", "1º Post");

select * from tb_postagens;