insert into authorities (authority)
values ('ROLE_USER');
insert into authorities (authority)
values ('ROLE_ADMIN');

insert into users (username, password, enabled, authority_id)
values ('admin', '$2a$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W', true,
        (select id from authorities where authority = 'ROLE_ADMIN'));

insert into topics (name, description)
VALUES ('Обсуждение', 'Говорите о спорте, развлечениях, музыке, фильмах, о своем любимом цвете, говорите обо всем');

insert into topics (name, description)
VALUES ('Работа', 'Здесь можете разместить вакансии');

insert into topics (name, description)
VALUES ('Барахолка', 'Здесь можно продать\найти что нибудь');