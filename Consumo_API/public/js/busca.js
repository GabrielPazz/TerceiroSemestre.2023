function preencherDivFuncionarios(funcionarios) {
    // Coloca cada funcionário em um parágrafo
    funcionariosParagrafos = "<p>" + funcionarios.join("</p> <p>") + "</p>";
    divResultados = document.getElementById("divResultados");
    divResultados.innerHTML = funcionariosParagrafos;
}

function listarFuncionarios() {
    const url = '/listartodos';
    // A função fetch recupera alguma informação do back-end
    // que deve ser fornecida em formato json
    fetch(url
    ).then( function(response) {
        return response.json();
    }).then( function(funcionarios) {
        preencherDivFuncionarios(funcionarios);
    });
}
