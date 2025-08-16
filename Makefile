# executa o sistema
run:
	mvn spring-boot:run

# abre a pagina web do projeto
opsys:
	xdg-open http://localhost:8080/ &
	clear

# gera a documentacao do projeto
doc:
	mvn javadoc:javadoc

# abre a documentacao do projeto
opdoc:
	open target/site/apidocs/index.html

# executa os testes automaticos
test:
	mvn test

# atualiza a branch atual com a main
pull:
	git pull origin main