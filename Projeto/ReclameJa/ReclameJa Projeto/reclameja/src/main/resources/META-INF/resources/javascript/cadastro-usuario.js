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

}