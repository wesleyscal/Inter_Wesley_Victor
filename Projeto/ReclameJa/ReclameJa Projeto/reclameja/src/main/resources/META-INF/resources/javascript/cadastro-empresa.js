function cadastrar(){
    empresa = {};
    empresa.Nome_Fantasia = "Aguardando Front";
    empresa.Razao_Social = "Aguardando Front";
    empresa.CNPJ = "Aguardando Front";
    empresa.Telefone = "Aguardando Front";
    empresa.Pais = "Aguardando Front";
    empresa.Estado = "Aguardando Front";
    empresa.Cidade = "Aguardando Front";

    axios.post("http://localhost:8080/reclamacao", reclamacao)
    .then(function (response) {
        alert("Reclamacao realizado com sucesso");
    })
    .catch(function (error) {
        alert("Erro: " + error);
    });    
}