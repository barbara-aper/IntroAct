# Links úteis:
1. [Figma do projeto](https://www.figma.com/design/9x6Vid5HhN2tHv1BTIix64/IntroAct?node-id=69-114&t=rbmxGCHtWe81vCjM-0)
2. [Doc do projeto](https://docs.google.com/document/d/1AbIpTwdoQhO9LcvEFK6X2nOIlPTqKL4j0UVvDhPbMDU/edit?tab=t.0)
3. [Auxilio com bootstrap](https://getbootstrap.com/docs/5.3/getting-started/introduction/)
4. [Github do projeto](https://github.com/barbara-aper/IntroAct)
4. [Página local de testes](http://localhost:8080/)

5. [Template pag (aluno)](https://templatemo.com/tm-586-scholar)

6. [Template css](https://uiverse.io/)

7. [HTML/CSS baby steps](https://www.alura.com.br/artigos/primeiros-passos-spring?utm_term=&utm_campaign=topo-aon-search-gg-dsa-artigos_conteudos&utm_source=google&utm_medium=cpc&campaign_id=11384329873_164240702375_703853654617&utm_id=11384329873_164240702375_703853654617&hsa_acc=7964138385&hsa_cam=topo-aon-search-gg-dsa-artigos_conteudos&hsa_grp=164240702375&hsa_ad=703853654617&hsa_src=g&hsa_tgt=dsa-2276348409543&hsa_kw=&hsa_mt=&hsa_net=google&hsa_ver=3&gad_source=1&gad_campaignid=11384329873&gclid=CjwKCAjw7MLDBhAuEiwAIeXGIfDA56eA0FlvEXVWsa65CveFIBEzOVZEdqaV3EYdrTOrcwBSdnM0ahoClsgQAvD_BwE)

8. [Sobre H2](https://wpsilva.medium.com/utilizando-banco-de-dados-h2-com-spring-de-forma-r%C3%A1pida-e-simples-6d896e15a4af)


# Atividades:
1. Diagrama de classes do domínio do problema;
2. Ferramentas escolhidas (Git, build, testes, issue tracking, CI/CD, container);
3. Frameworks reutilizados;
4. Como gerar a documentação do código (ex.: JavaDoc);
5. Como executar o sistema.
6. Documente o seu projeto no README do repositório do projeto utilizando MarkDown.

# Brainstorm:
Classes: 
- Questão (com tratamento para questões discursivas e objetivas) (id, enunciado, resposta, tema, tipo [enum], alternativas, nivel de dificuldade)
- Atividade (conjunto de questões) (lista de questões, tema)
- Tema (contempla a explicação e a atividade de um mesmo tópico) (nome do tema, atividade, resumo do conteúdo)
- Comparator (compara a resposta enviada com a resposta correta)
- Classe do get e do post
- Classes do thymeleaf e outros

Ferramentas escolhidas:
- Git/GitHub
- Build: Spring Boot e Maven
- Testes: 
- Issue tracking: 
- CI/CD: 

Framework:
- Spring
- Bootstrap
- Thymeleaf

Documentação:
- JavaDoc
```
Rayssa:
pra gerar o javadoc, é mvn javadoc:javadoc
para ver, tem que abrir no navegador o index.html em:
    demoIntroAct/target/site/apidocs/index.html
``` 

Executar:
```
Rayssa: so p freezar sobre o comando de executar e dependencia
1. acredito q precise lembrar/tratar em instalar o maven ou algo assim
2. para rodar, usar o comando: mvn spring-boot:run 
```