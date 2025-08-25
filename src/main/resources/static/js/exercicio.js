// Funções e lógica do exercício
function atualizaTelaExercicio(listaExercicios, idEx) {
    const alternativasList = document.getElementById("alternativas");
    const alternativas2List = document.getElementById("alternativas2");

    if (listaExercicios[idEx].tipo == "MULTIPLA_ESCOLHA") {
        const alternativasText = listaExercicios[idEx].alternativas;
        alternativasText.forEach(alternativa => {
            const itemAlternativa = document.createElement("li");
            itemAlternativa.className += "animated-button";
            itemAlternativa.textContent = alternativa;
            alternativasList.appendChild(itemAlternativa);
        });
    }

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
            itemAlternativa.className += "animated-button";
            itemAlternativa.textContent = alternativasText[i];
            itemAlternativa.style.backgroundColor = '#f4c708';
            itemAlternativa.style.border = '1px solid #f7e077';
            alternativas2List.appendChild(itemAlternativa);
        }
    }

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

function limpaTelaExercicio() {
    const alternativasList = document.getElementById("alternativas");
    alternativasList.replaceChildren();

    const respostasList = document.getElementById("alternativas2");
    respostasList.replaceChildren();
    
    respostaAluno.splice(0, respostaAluno.length);

    idAlternativa = 0;
}

function confereResposta(respostaAluno, gabarito, tipo) {
    let respostaCorreta = true;
    console.log(respostaAluno);
    if (tipo == "MULTIPLA_ESCOLHA") { //acho que esse ta igual ao else
        if (respostaAluno.length !== gabarito.length) return false;
        respostaAluno.forEach(resposta => {
            if (gabarito.includes(resposta) == false) {
                respostaCorreta = false;
            }
        });
        return respostaCorreta;
    } else { // CORRELACAO E ESCRITA
        if(tipo == 'ESCRITA'){
            escritaInput = document.getElementsByClassName("input-resposta");
            console.log(escritaInput);
            for (let input of escritaInput){
                respostaAluno.push(input.value);
            }
        }
        if (respostaAluno.length != gabarito.length) {
            respostaCorreta = false;
        } else {
            for (let i = 0; i < respostaAluno.length; i++) {
                if (respostaAluno[i] != gabarito[i]) {
                    respostaCorreta = false;
                }
            }
        }
        return respostaCorreta;
    }
}

function insereEnunciado(){
    if(listaExercicios[idEx].tipo == 'ESCRITA'){
        enunciado = listaExercicios[idEx].enunciado.replaceAll(/___/g, `<input type="text" class="input-resposta" placeholder="  Digite aqui sua resposta">`); //3 underscore como input texto
        titulo.innerHTML = enunciado;
    }
    else if(listaExercicios[idEx].tipo == 'PREENCHIMENTO_DE_LACUNAS'){
        enunciado = listaExercicios[idEx].enunciado.replaceAll(/___/g, `<span class="lacuna"></span>`); //3 underscore como espaço vazio
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

document.getElementById('next-exercise-btn').addEventListener('click', function () {
    if (confereResposta(respostaAluno, listaExercicios[idEx].gabarito, listaExercicios[idEx].tipo)) {
        botoesExercicios[idEx].style.backgroundColor = '#32a155';
    } else {
        botoesExercicios[idEx].style.backgroundColor = '#f2351f';
    }
    if (idEx + 1 != qtdExercicios) {
        limpaTelaExercicio();
        idEx++;
        //enunciado
        insereEnunciado();
        botoesExercicios[idEx].style.backgroundColor = '#f4c708';
        atualizaTelaExercicio(listaExercicios, idEx);
    }
});