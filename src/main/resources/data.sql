CREATE TABLE account (id INT PRIMARY KEY auto_increment, nome varchar(200), regiao varchar(2), cpf varchar(14));

INSERT INTO account VALUES (1, 'Julio Silva', 'SP', '44813789147');

INSERT INTO account VALUES (2, 'Maria Pereira', 'RJ', '44277427982');

INSERT INTO account VALUES (3, 'Juliana Prado', 'MG', '42265847236');

CREATE TABLE book (id INT PRIMARY KEY auto_increment, titulo varchar(200), autor varchar(100), genero varchar(50), valor float(20));

INSERT INTO book VALUES (1, 'A Hora da Estrela', 'Clarice lispector', 'Romance', 59.99);

INSERT INTO book VALUES (2, 'Drácula', 'Bram Stoker', 'Terror', 49.99);

INSERT INTO book VALUES (3, 'O Homem de Giz', 'C.J. Tudor', 'Suspense', 49.99);