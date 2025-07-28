# IntroAct
Aline Mendonça Mayerhofer Manhães, Bárbara Alencar de Araujo Pereira e Raony Togneri Gomes

## Descrição
O IntroAct, Introcomp Activities, foi idealizado como uma plataforma de atividades complementar e auxiliar ao curso Introcomp, oferecido gratuitamente por alunos da Ufes anualmente, cujo objetivo é democratizar o acesso ao mundo da programação por meio de aulas de Python. Por ser uma plataforma online, o IntroAct possibilita que não somente os alunos do Introcomp sejam beneficiados com tais atividades, mas também qualquer pessoa que queira aprender Python de forma descontraída. 

O IntroAct disponibiliza exercícios curtos e objetivos em Python, para tornar o aprendizado constante. O objetivo é ser uma “revisão de bolso” que mantenha conhecimentos essenciais de programação frescos na mente do usuário a todo e qualquer momento que ele quiser, servindo como complemento de um curso mais intensivo, como o Introcomp. As atividades do IntroAct possuem perguntas de múltipla escolha, exercícios de correlação, escrita e preenchimento de lacunas sobre conceitos fundamentais da programação, como estruturas condicionais e loops.

## Links úteis
1. [Figma](https://www.figma.com/design/9x6Vid5HhN2tHv1BTIix64/IntroAct?node-id=0-1&p=f)
2. [Proposta de Projeto](https://docs.google.com/document/d/1AbIpTwdoQhO9LcvEFK6X2nOIlPTqKL4j0UVvDhPbMDU/edit?tab=t.0)
3. [Github do projeto](https://github.com/barbara-aper/IntroAct)
4. [Página local de testes](http://localhost:8080/)

## Diagrama de classes do domínio do problema
[Link para o diagrama UML](https://lucid.app/lucidchart/e15a0e4a-b9d1-4d91-9ed9-484bec151f37/edit?viewport_loc=6%2C-346%2C2543%2C1395%2CHWEp-vi-RSFO&invitationId=inv_0ec62674-0150-4273-a4f9-12168637931c)
ACRESCENTAR FOTO

## Ferramentas escolhidas
- Git: Git e GitHub
- Build: Spring Boot e Maven
- Testes: 
- CI/CD:

## Frameworks reutilizados
- Spring Boot
- Bootstrap
- Thymeleaf

## Como gerar a documentação do código
- JavaDoc:

Execute o comando
```
mvn javadoc:javadoc
```
Depois, para visualizá-lo, abra
```
demoIntroAct/target/site/apidocs/index.html
```

## Como executar o sistema
### Requisito
Instalar o Maven:
Baixe pelo site
```
https://maven.apache.org/download.cgi
```
Ou, se você tiver Ubuntu, execute o comando
```
sudo apt install maven
```
### Instruções de Execução
1. Clone o repositório:
```
git clone https://github.com/barbara-aper/IntroAct.git
```
2. Execute:
```
mvn spring-boot:run
```
3. Abra o server no seu navegador com o link para a porta 8080:
```
http://localhost:8080/
```

