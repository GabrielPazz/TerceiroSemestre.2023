var express = require('express');
var http = require('http');
var app = express();
var bodyParser = require('body-parser');
var path = require("path");

var server = http.createServer(app);
app.use(bodyParser.urlencoded({extended: false}));
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

// Esperando na porta 3333
server.listen(3333, function () {
    console.log("Server listening on port: 3333");
});
