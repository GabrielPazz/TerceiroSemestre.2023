function preencherDivPessoas(pessoas) {
    let infoPessoas = [];
    // Coloca cada pessoa em um parágrafo
    for (let p of pessoas) {
        infoPessoas.push( "Id: " + p["id"] + " - Nome: " + p["nome"] );
    }
    pessoasParagrafos = "<p>" + infoPessoas.join("</p> <p>") + "</p>";
    divResultados = document.getElementById("divResultados");
    divResultados.innerHTML = pessoasParagrafos;
}

function listarPessoas() {
    const url = '/usuarios';
    // A função fetch recupera alguma informação do backend
    // que deve ser fornecida em formato json
    fetch(url // response é o resultado do que ele pediu para o backend
    ).then( function(response) {
        return response.json(); // pessoas é o resultado desse retorno
    }).then( function(pessoas) {
        preencherDivPessoas(pessoas);
    });
}
