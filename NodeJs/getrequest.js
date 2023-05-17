var express = require('express');
var http = require('http');
var app = express();
var server = http.createServer(app);

// Se digitarmos no navegador localhost:3333, faremos uma requisição GET
app.get('/', function (req, res) {
    // Servidor manda a resposta da requisição de volta para o cliente
    res.send("<h1>Você se conectou com sucesso</h1>");
});

app.get('/metodoget', function (req, res) {
    // Servidor manda a resposta da requisição de volta para o cliente
    res.send("<h1>Você está na rota /metodoget</h1>");
});

// Quando eu enviar uma requisição do tipo POST
app.post('/metodopost', function (req, res) {
    // Servidor manda a resposta da requisição de volta para o cliente
    res.send("<h1>Você mandou uma requisição POST.</h1>");
});


// Esperando na porta 3333
server.listen(3333, function () {
    console.log("Server listening on port: 3333");
});