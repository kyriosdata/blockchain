# _Blockchain_: Correção de Prova

Em uma universidade professores aplicam provas, cada uma delas composta por questões. Estudantes que realizam tais provas fornecem os resultados (respostas). 

Quando uma prova é submetida por um estudante, o professor em questão é responsável pela correção de cada uma das questões submetidas. A correção pode ser contestada pelo estudante. A contestação pode ocorrer no máximo 2 dias após a divulgação do resultado. 

O professor deve responder cada questionamento (feito por questão). O estudante terá 2 dias para, caso não satisfeito com a resposta do docente, reiterar sua posição. Neste caso, contudo, agora outra instância da universidade será responsável pela resposta ao questionamento do estudante. Independente do resultado apresentado pelo segundo revisor, a coordenação de curso deve ratificar a resposta do segundo revisor ou fornecer encaminhamento distinto e definitivo. 

# AWS (passos)

- Criada instância para experimentação.
- sudo yum update -y
- `sudo amazon-linux-extras install docker`
- `sudo service docker start`
- `sudo yum install git`
- Docker composer
  - ```sudo curl -L https://github.com/docker/compose/releases/download/1.21.0/docker-compose-`uname -s`-`uname -m` | sudo tee /usr/local/bin/docker-compose > /dev/null```
  - `sudo chmod +x /usr/local/bin/docker-compose`
  - `sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose`
- Nodejs
  - `curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.34.0/install.sh | bash`
  - `. ~/.nvm/nvm.sh`
  - `nvm install node`
- Defina GOPATH (independente da linguagem que está empregando)
  - `vi ~/.bash_profile`
  - Acrescente `export GOPATH=$HOME/go`
  - Crie o diretório indicado pela variável `GOPATH`
- Crie diretório onde exemplos serão depositados
  - `mkdir -p $GOPATH/src/github.com/hyperledger/`
  - `cd $GOPATH/src/github.com/hyperledger/`
  - `git clone https://github.com/hyperledger/fabric-samples.git`
  
