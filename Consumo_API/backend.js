var http = require('http');
var sqlite3 = require('sqlite3');
var bodyParser = require('body-parser');
var path = require('path');
var express = require('express');
var app = express();

var server = http.createServer(app);
// Conectar com banco
var db = new sqlite3.Database('./database/Empresa.db');

app.use(bodyParser.urlencoded({extended: false}));

// Isso é utilizado para que o servidor em node saiba
// a localização dos arquivos estáticos (css, js, imagens etc).
// Esses arquivos ficarão dentro de uma pasta chamada public.
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', function(req, res) {
    res.sendFile(path.join(__dirname, 'listagem.html'));
});

app.get('/listartodos', function(req,res){
    db.serialize(()=>{
        //db.all() inclui todos os funcionarios
        db.all('SELECT id, nome FROM Funcionario', function(err, rows){
            if(err){
                res.send("Erro ao encontrar funcionarios.");
                return console.error(err.message);
            }
            // Adiciona todos os funcionários em um array list
            let nomesFuncionarios = [];
            for (const row of rows) {
                nomesFuncionarios.push(row.nome);
            }
            res.send(nomesFuncionarios);
            console.log("Funcionarios encontrados");
        });
    });
});

server.listen(3333, function() {
    console.log("Servidor ouvindo na porta 3333.");
})
