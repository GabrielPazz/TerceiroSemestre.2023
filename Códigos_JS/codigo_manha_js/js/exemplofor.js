// Cria um menu com Home, Contato e Sobre
let itens_menu = ["Home", "Contato", "Sobre"];

document.write("<ul>");
for (const item of itens_menu) {
    document.write("<li>" + item + "</li>");
}
document.write("</ul>");


const populacoes = {
    "Sao Paulo": 10000000,
    "Santo Andre": 700000,
    "Guarulhos": 1300000,
};
for (const cidade in populacoes) {
    console.log(`${cidade} tem ${populacoes[cidade]} habitantes.`);
}
    