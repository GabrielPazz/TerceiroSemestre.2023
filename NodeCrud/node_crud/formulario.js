var express = require('express');
var http = require('http');
var app = express();
var bodyParser = require('body-parser');
var path = require("path");

//////////////////////////////////////////////////////
var sqlite3 = require('sqlite3').verbose();

// Cria um novo banco de dados
var db = new sqlite3.Database('./database/Empresa.db');
//////////////////////////////////////////////////////

var server = http.createServer(app);
app.use(bodyParser.urlencoded({extended: false}));

// Abrimos o formulário aqui
app.get('/', function(req,res){
    /* Envia como resposta o formulário html.
     * __dirname éa pasta do arquivo atual.
     */
    res.sendFile(path.join(__dirname,'./formulario.html'));
});

// Se digitarmos no navegador localhost:3333, faremos uma requisição POST
app.post('/mostrar', function(req, res){
    res.send("<p>Nome: " + req.body.nome + "</p>" +
             "<p>Idade: " + req.body.idade + "</p>" +
             "<p>Endereço: " + req.body.endereco + "</p>"
    );
});


// Rota POST para adicionar no banco
app.post('/add', function(req,res){
    db.serialize(()=>{
        db.run(
            // Adicionar um novo funcionário no banco
            "INSERT INTO Funcionario (id, nome, idade, endereco) " +
                "VALUES(?, ?, ?, ?)",

            // Aqui são os valores dos ?, que correspondem ao formulário
            [req.body.id, req.body.nome, req.body.idade, req.body.endereco],

            // Depois de rodar a instrução sql, essa função é executada
            function(err) {
                // Se houver algum problema na inserção, mostre um erro
                if (err) {
                    return console.log(err.message);
                }
                console.log("Novo funcionário adicionado com sucesso");
                // Se der tudo certo, ele devolve para o cliente essa mensagem
                res.send( "Novo funcionário com ID = " + req.body.id +
                          " e nome = "+req.body.nome);
            }
        );
    });
});

// Criamos uma rota nova /ver para mostrar o resultado da busca
app.post('/ver', function(req, res){
    db.serialize(()=>{
        db.each('SELECT id, nome FROM Funcionario WHERE id = ?',
        // encontre o funciońario com o id preenchido
        [req.body.id],
        // A função recebe um row que corresponde a uma linha da tabela
        function(err, row){
            // row corresponde à linha encontrada
            // Erro caso o funcionário não seja encontrado
            if(err){
                res.send("Erro ao encontrar funcionário");
                return console.error(err.message);
            }
            // Envia para o cliente o nome e o id do funcionário caso ele seja encontrado
            res.send(`<p>Id: ${row.id}</p> <p> Nome: ${row.nome}</p><hr>`);
            console.log("Funcionário encontrado");
        });
    });
});

app.get('/funcionarios', function(req,res){
    db.serialize(()=>{
        //db.all() inclui todos os funcionarios
        db.all('SELECT id, nome FROM Funcionario',
        function(err, rows){
            if(err){
                res.send("Erro ao encontrar funcionario");
                return console.error(err.message);
            }
            var resultado = "";
            for (var row of rows) {
                resultado += `<p>Id: ${row.id}</p> <p> Nome: ${row.nome}</p><hr>`;
            }
            res.send(resultado);
        console.log("Funcionarios encontrados");
        });
    });
});

// Esperando na porta 3333
server.listen(3333, function () {
    console.log("Server listening on port: 3333");
});
