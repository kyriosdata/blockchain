# _Blockchain_: Estudo de Caso

## Cenário

Em uma universidade professores aplicam provas, cada uma delas composta por questões. Estudantes que realizam tais provas fornecem os resultados (respostas).

Quando uma prova é submetida por um estudante, o professor em questão é responsável pela correção de cada uma das questões submetidas. A correção pode ser contestada pelo estudante. A contestação pode ocorrer no máximo 2 dias após a divulgação do resultado.

O professor deve responder cada questionamento (feito por questão). O estudante terá 2 dias para, caso não satisfeito com a resposta do docente, reiterar sua posição. Neste caso, contudo, agora outra instância da universidade será responsável pela resposta ao questionamento do estudante. Independente do resultado apresentado pelo segundo revisor, a coordenação de curso deve ratificar a resposta do segundo revisor ou fornecer encaminhamento distinto e definitivo.

# Iniciando por...

- https://hyperledger-fabric.readthedocs.io/en/release-1.4/write_first_app.html

# 1. Preparando o ambiente

- Amazon AMI (install Docker)

  - `sudo yum update -y`
  - `sudo amazon-linux-extras install docker`
  - `sudo service docker start`

- Ubuntu (install Docker)

  - `sudo apt-get update`
  - `sudo apt-get remove docker docker-engine docker.io` (remove versão existente)
  - `sudo apt install docker.io`
  - `sudo systemctl start docker`
  - `sudo systemctl enable docker`

- Ubuntu (install docker-compose)

  - `sudo apt install docker-compose`

- Docker composer (alternativa)

  - `` sudo curl -L https://github.com/docker/compose/releases/download/1.21.0/docker-compose-`uname -s`-`uname -m` | sudo tee /usr/local/bin/docker-compose > /dev/null ``
  - `sudo chmod +x /usr/local/bin/docker-compose`
  - `sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose`

- Ubuntu (node e npm) (versão rápida)

  - `sudo apt install nodejs`
  - `sudo apt install npm`

- Nodejs (e npm) (via nvm que oferece controle de versão)

  - `curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.34.0/install.sh | bash`
  - `. ~/.nvm/nvm.sh`
  - `nvm install node`

- Java e Maven

  - `sudo apt install openjdk-8-jdk-headless`
  - `sudo apt install maven`

- Go
  Detalhes acerca da instalação da linguagem Go no ubuntu (https://www.linode.com/docs/development/go/install-go-on-ubuntu/)

  - `curl -O https://storage.googleapis.com/golang/go1.12.9.linux-amd64.tar.gz`
  - `tar -xvf go1.12.9.linux-amd64.tar.gz`
  - `sudo chown -R root:root ./go`
  - `sudo mv go /usr/local`
  - `mkdir go`
  - `export GOPATH=$HOME/go`
  - `export PATH=$PATH:/usr/local/go/bin:$GOPATH/bin:$HOME/fabric-samples/bin`

  As definições das variáveis podem ser depositadas
  no arquivo **.bashrc**.

* Executar Docker (sem necessidade de sudo)

  - `sudo usermod -a -G docker ec2-user` para executar o docker sem necessidade de sudo. Isto terá efeito em toda nova _shell_ que for aberta.

# 2. Instalar binários

- `curl -sSL https://bit.ly/2ysbOFE | bash -s`
- O comando acima cria o diretório **fabric-samples** no diretório em que é executado.

# 3. Criando a primeira rede

Este link (https://hyperledger-fabric.readthedocs.io/en/latest/build_network.html) fornece detalhes acerca de como criar sua própria rede, motivo pelo qual **first-network** é relevante.

- `cd fabric-samples/first-network` (onde **fabric-samples**) foi gerado pela instalação dos binários, passo acima.
- `./byfn.sh generate`
- `./byfn.sh up` além das opções `./byfn.sh up -l java` (Java) ou `./byfn.sh up -l javascript` (JavaScript) que, contudo, produzem erro.
- `./byfn.sh down`

# 4. Escrevendo a primeira aplicação (chaincode in Javascript)

Veja detalhes em https://hyperledger-fabric.readthedocs.io/en/latest/write_first_app.html.

- `cd fabric-samples/fabcar`
- `./startFabric.sh javascript` (após este comando a rede estará montada e poderá ser exercidade).
- `cd java` (para exercitar código escrito em Java)
- `mvn test`
