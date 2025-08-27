//exibe as alternativas na tela de exercícios
function atualizaTelaExercicio(listaExercicios, idEx) {
    const alternativasList = document.getElementById("alternativas");
    const alternativas2List = document.getElementById("alternativas2");
    
    //adiciona as alternativas em botões
    if (listaExercicios[idEx].tipo == "MULTIPLA_ESCOLHA") {
        const alternativasText = listaExercicios[idEx].alternativas;
        alternativasText.forEach(alternativa => {
            const itemAlternativa = document.createElement("li");
            itemAlternativa.className += "animated-button";
            itemAlternativa.textContent = alternativa;
            alternativasList.appendChild(itemAlternativa);
        });
    }

    //adiciona as alternativas em botões em duas colunas diferentes
    if (listaExercicios[idEx].tipo == "CORRELACAO") {
        const alternativasText = listaExercicios[idEx].alternativas;
        const tamanho = alternativasText.length;

        for (let i = 0; i < (tamanho / 2); i++) {
            const itemAlternativa = document.createElement("li");
            itemAlternativa.className += "animated-button";
            itemAlternativa.textContent = alternativasText[i];
            alternativasList.appendChild(itemAlternativa);
            if (i == 0) {
                itemAlternativa.style.border = '2px solid #F8F9FA';
            }
        }

        for (let i = (tamanho / 2); i < tamanho; i++) {
            const itemAlternativa = document.createElement("li");
            itemAlternativa.className += "animated-button-yellow";
            itemAlternativa.textContent = alternativasText[i];
            alternativas2List.appendChild(itemAlternativa);
        }
    }

    //adiciona as alternativas em botões
    if (listaExercicios[idEx].tipo == "PREENCHIMENTO_DE_LACUNAS"){
        const alternativasText = listaExercicios[idEx].alternativas;
        const tamanho = alternativasText.length;

        for (let i = 0; i < (tamanho / 2); i++) {
            const itemAlternativa = document.createElement("li");
            itemAlternativa.className += "lacuna-button";
            itemAlternativa.textContent = alternativasText[i];
            alternativasList.appendChild(itemAlternativa);
        }

        for (let i = (tamanho / 2); i < tamanho; i++) {
            const itemAlternativa = document.createElement("li");
            itemAlternativa.className += "lacuna-button";
            itemAlternativa.textContent = alternativasText[i];
            alternativas2List.appendChild(itemAlternativa);
        }
    }
}

//limpa a tela de exercício para receber um próximo
function limpaTelaExercicio() {
    titulo.textContent = "";

    const alternativasList = document.getElementById("alternativas");
    alternativasList.replaceChildren();

    const respostasList = document.getElementById("alternativas2");
    respostasList.replaceChildren();
    
    respostaAluno.splice(0, respostaAluno.length);

    idAlternativa = 0;
}

//confere se a resposta enviada está igual ao gabarito
function confereResposta(respostaAluno, gabarito, tipo) {
    let respostaCorreta = true;

    if(tipo == 'ESCRITA'){
        escritaInput = document.getElementsByClassName("input-resposta");
        for (let input of escritaInput){
            respostaAluno.push(input.value);
        }
    }

    if (respostaAluno.length != gabarito.length) {
        respostaCorreta = false;
    }
    else{
        for (let i = 0; i < respostaAluno.length; i++) {
            if (respostaAluno[i] != gabarito[i]) {
                respostaCorreta = false;
            }
        }
    }

    return respostaCorreta;
}

//exibe quantidade de acertos e o gabarito das questões que o usuário errou
function exibeGabarito(){
    const botao = document.getElementById('next-exercise-div');
    botao.remove();
 
    const alternativasList = document.getElementById("alternativas");
    const alternativas2List = document.getElementById("alternativas2");
    alternativasList.remove();
    alternativas2List.remove();
 
    const porcentAcerto = parseFloat(listaExercicios.length - listaErros.length)/listaExercicios.length;
    if(porcentAcerto>=0.75){
        titulo.textContent = "Parabéns!! Você acertou " + (listaExercicios.length - listaErros.length) + "/" + (listaExercicios.length) + " questões"
    }
    else if(porcentAcerto>=0.5){
        titulo.textContent = "Você acertou " + (listaExercicios.length - listaErros.length) + "/" + (listaExercicios.length) + " questões"
    }
    else{
        titulo.textContent = "Que tal revisar mais um pouco? Você acertou " + (listaExercicios.length - listaErros.length) + "/" + (listaExercicios.length) + " questões"
    }

    if(listaErros.length>0){
        const divGabarito = document.getElementById("divGabarito");
        divGabarito.className += " card-exercicio";
    
        let gabaritoTitulo = document.getElementById("gabaritoTitulo");
        let gabarito = document.getElementById("gabaritoExercicio");
        let txtGabarito = "";
        
        gabaritoTitulo.textContent = "Gabarito"

        for(let i = 0; i < listaErros.length; i++){
            let id = listaErros[i];
            let num = parseInt(id)+1;
            txtGabarito += "Exercício " + num + ":<br>Enunciado: ";
            txtGabarito += listaExercicios[id].enunciado;
            if(listaExercicios[id].tipo != "ESCRITA"){
                txtGabarito += "<br>Alternativas: " + listaExercicios[id].alternativas;
            }
            txtGabarito += "<br>Gabarito: " + listaExercicios[id].gabarito;
            txtGabarito += "<br><br>";
        }
        gabarito.innerHTML = txtGabarito;
    }
} 
 
//insere o enunciado na tela
function insereEnunciado(){
    if(listaExercicios[idEx].tipo == 'ESCRITA'){ //trata a existencia de input
        enunciado = listaExercicios[idEx].enunciado.replaceAll(/___/g, `<input type="text" class="input-resposta" placeholder="Digite aqui sua resposta">`); //3 underscore como input texto
        titulo.innerHTML = enunciado;
    }
    else if(listaExercicios[idEx].tipo == 'PREENCHIMENTO_DE_LACUNAS'){ //trata a existencia de espaço para lacunas
        enunciado = listaExercicios[idEx].enunciado.replaceAll(/___/g, `<span class="lacuna" style="color: var(--dark-orange);"></span>`); //3 underscore como espaço vazio
        titulo.innerHTML = enunciado;
        lacunas = document.getElementsByClassName("lacuna");
        for (let lacuna of lacunas){
                lacuna.textContent = "________";
            }
    }
    else{
        titulo.innerHTML = listaExercicios[idEx].enunciado;
    }
}


// --- Lógica Principal ---
const respostaAluno = [];
let qtdExercicios = listaExercicios.length;
let idEx = 0;
let idAlternativa = 0;

let ulExercicios = document.getElementById("numeros-exercicios-btn");
const botoesExercicios = ulExercicios.querySelectorAll('.smaller-btn');
let enunciado;
let titulo = document.getElementById("enunciadoExercicio");

insereEnunciado();

botoesExercicios[idEx].style.backgroundColor = '#f4c708';

atualizaTelaExercicio(listaExercicios, idEx);

// --- Event Listeners ---
//clique na alternativa comum (= coluna 1 de alternativas)
document.getElementById('alternativas').addEventListener('click', function (event) {
    const alternativaClick = event.target;
    if (listaExercicios[idEx].tipo == "MULTIPLA_ESCOLHA") {
        respostaAluno.splice(0, respostaAluno.length);

        const alternativasList = document.getElementById("alternativas");
        const itensDaLista = alternativasList.querySelectorAll('li');

        itensDaLista.forEach(button => {
            button.style.backgroundColor = '#f07e24';
        });

        if (alternativaClick.tagName === 'LI') {
            alternativaClick.style.setProperty("background-color", '#c26018', "important");
            respostaAluno.push(alternativaClick.textContent);
        }
    }
    else if(listaExercicios[idEx].tipo == "PREENCHIMENTO_DE_LACUNAS"){
        lacunas = document.getElementsByClassName("lacuna");

        if(idAlternativa < lacunas.length){
            respostaAluno.push(alternativaClick.textContent);
            alternativaClick.classList.add('used');
            lacunas[idAlternativa].textContent = alternativaClick.textContent;
            idAlternativa++;
        }
    }
});

//clique na alternativa de correlação ou lacuna (= coluna 2 de alternativas)
document.getElementById('alternativas2').addEventListener('click', function (event) {
    const alternativaClick = event.target;
    if(listaExercicios[idEx].tipo == "CORRELACAO"){
        if (alternativaClick.tagName === 'LI') {
            alternativaClick.classList.add('used');
            alternativaClick.style.setProperty("background-color", '#deb607', "important");
            respostaAluno.push(alternativaClick.textContent);

            const alternativasList = document.getElementById("alternativas");
            const itensDaLista = alternativasList.querySelectorAll('li');
            
            if(idAlternativa < itensDaLista.length) {
                itensDaLista[idAlternativa].classList.add('used');
                idAlternativa++;
                if(idAlternativa < itensDaLista.length){
                    itensDaLista[idAlternativa].style.border = '2px solid #F8F9FA';
                }
            }
        }
    }
    else if(listaExercicios[idEx].tipo == "PREENCHIMENTO_DE_LACUNAS"){
        lacunas = document.getElementsByClassName("lacuna");

        if(idAlternativa < lacunas.length){
            respostaAluno.push(alternativaClick.textContent);
            alternativaClick.classList.add('used');
            lacunas[idAlternativa].textContent = alternativaClick.textContent;
            idAlternativa++;
        }
    }
});

//clique para próximo exercício
document.getElementById('next-exercise-btn').addEventListener('click', function () {
    //muda cor de bolinha do exercício com base em acerto ou erro
    if (confereResposta(respostaAluno, listaExercicios[idEx].gabarito, listaExercicios[idEx].tipo)) {
        botoesExercicios[idEx].style.backgroundColor = '#32a155';
    } 
    else {
        botoesExercicios[idEx].style.backgroundColor = '#f2351f';
    }
    //verifica se há um próximo exercício e o exibe caso exista
    if(idEx + 1 != qtdExercicios){
        limpaTelaExercicio();
        idEx++;
        insereEnunciado();
        botoesExercicios[idEx].style.backgroundColor = '#f4c708';
        atualizaTelaExercicio(listaExercicios, idEx);
    }
    else{
        limpaTelaExercicio();
        listaErros = [];
        for (let i = 0; i < botoesExercicios.length; i++){
            if(botoesExercicios[i].style.backgroundColor === 'rgb(242, 53, 31)'){
                listaErros.push(i);
            }
        }
        exibeGabarito();
    }
});