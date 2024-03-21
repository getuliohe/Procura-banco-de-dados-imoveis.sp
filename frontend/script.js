function pesquisar() {
    var termo = document.getElementById("termoPesquisa").value;

    fetch('http://localhost:8080/backend/pesquisa?termo=' + encodeURIComponent(termo))
        .then(response => {
            return response.text();
        })
        .then(data => {
            exibirResultado(data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });

        function exibirResultado(resultado) {
            var linhas = resultado.split('\n');
        
            var container = document.getElementById("resultadoPesquisa");

            container.innerHTML = '';

            linhas.forEach(function (linha) {
                var elementoLinha = document.createElement("div");
                elementoLinha.textContent = linha;
                elementoLinha.style.marginBottom = "10px";
                container.appendChild(elementoLinha);
            });
        }
}