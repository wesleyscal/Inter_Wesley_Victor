function cadastrar(){
    consumidor = {};
    consumidor.Nome_Completo = document.getElementById("input-nome").value;
    consumidor.CPF = document.getElementById("input-cpf").value;
    consumidor.Genero = document.querySelector('input[name="genero"]:checked').value;
    consumidor.Data_Nacimento = document.getElementById("input-nascimento").value;
    consumidor.Celular = document.getElementById("input-celular").value;
    consumidor.CEP = document.getElementById("input-cep").value;
    consumidor.Estado = document.getElementById("input-estado").value;
    consumidor.Cidade = document.getElementById("input-cidade").value;

    axios.post("http://localhost:8080/consumidor", consumidor)
    .then(function (response) {
        alert("Cadastro realizado com sucesso");
    })
    .catch(function (error) {
        alert("Erro: " + error);
    });    
}