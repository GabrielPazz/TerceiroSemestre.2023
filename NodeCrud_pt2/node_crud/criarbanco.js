var sqlite3 = require('sqlite3').verbose();

// Cria um novo banco de dados
var db = new sqlite3.Database('./database/Empresa.db');

// Cria a tabela funcionário mostrada anteriormente, se ela não existir já
db.run("CREATE TABLE IF NOT EXISTS Funcionario " +
       "(id INT NOT NULL," + // campo chamado id, que aceita inteiro e não pode ser nulo
       " nome VARCHAR (200) NOT NULL," + // campo chamado nome com até 200 caracteres, que não pode ser nulo
       " idade INT NOT NULL," + 
       " endereco VARCHAR (250)," +
       " PRIMARY KEY (id) )"
       // Primary key é o identificador único da tabela que não pode ter repetições
       );
console.log("Tabela Criada com sucesso");

