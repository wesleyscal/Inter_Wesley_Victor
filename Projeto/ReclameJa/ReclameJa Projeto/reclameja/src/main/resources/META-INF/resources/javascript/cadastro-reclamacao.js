function cadastrar() {
    reclamacao = {};
    reclamacao.Status = "Aguardando Front";
    reclamacao.Titulo = "Aguardando Front";
    reclamacao.Descricao = "Aguardando Front";
    reclamacao.Data_Abertura = "Aguardando Front";
    reclamacao.Data_Finalizacao = "Aguardando Front";
    reclamacao.id_Consumidor = "Aguardando Front";
    reclamacao.id_Empresa = idEmpresa();

    if (reclamacao.id_Empresa == "") {
        return;
    }

    axios.post("http://localhost:8080/reclamacao", reclamacao)
        .then(function (response) {
            alert("Reclamacao realizado com sucesso");
        })
        .catch(function (error) {
            alert("Erro: " + error);
        });
}

function idEmpresa() {
    nomeEmpresa = document.getElementById("input-nome").value;

    axios.get('http://localhost:8080/empresa/busca?Nome_Fantasia=' + nomeEmpresa, {})
        .then(function (response) {
            return response.data.empresa.id;
        })
        .catch(function (error) {
            alert("Erro: " + error);
        });
}