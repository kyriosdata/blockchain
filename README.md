# _Blockchain_: Correção de Prova

Em uma universidade professores aplicam provas, cada uma delas composta por questões. Estudantes que realizam tais provas fornecem os resultados (respostas).

Quando uma prova é submetida por um estudante, o professor em questão é responsável pela correção de cada uma das questões submetidas. A correção pode ser contestada pelo estudante. A contestação pode ocorrer no máximo 2 dias após a divulgação do resultado.

O professor deve responder cada questionamento (feito por questão). O estudante terá 2 dias para, caso não satisfeito com a resposta do docente, reiterar sua posição. Neste caso, contudo, agora outra instância da universidade será responsável pela resposta ao questionamento do estudante. Independente do resultado apresentado pelo segundo revisor, a coordenação de curso deve ratificar a resposta do segundo revisor ou fornecer encaminhamento distinto e definitivo.

# Iniciando por...

- https://hyperledger-fabric.readthedocs.io/en/release-1.4/write_first_app.html

# Preparando o ambiente

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

- Executar Docker (sem necessidade de sudo)

  - `sudo usermod -a -G docker ec2-user` para executar o docker sem necessidade de sudo.

- `sudo yum install git`
- Docker composer
  - `` sudo curl -L https://github.com/docker/compose/releases/download/1.21.0/docker-compose-`uname -s`-`uname -m` | sudo tee /usr/local/bin/docker-compose > /dev/null ``
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

# Outros (notas)

- Foi necessário instalar make e g++
- npm install --global grpc
- npm rebuild
- GOPATH deve indicar diretório contendo o código de teste
- PATH deve incluir GOPATH/bin (em GOPATH/bin deve existir configtxlator e outros).

# Instalar binários

- `curl -sSL https://bit.ly/2ysbOFE | bash -s`
- O comando acima cria o diretório **fabric-samples** no diretório em que é executado. Este deve ser
  o diretório configurado na variável **\$GOPATH**.
- Acrescentar ao PATH, `export PATH=$PATH:$GOPATH/bin`, onde o diretório **bin** foi gerado pelo comando acima, assim como o diretório **fabric-samples**.

# Criando a primeira rede

Veja detalhes em https://hyperledger-fabric.readthedocs.io/en/latest/build_network.html

- `cd fabric-samples/first-network` (onde **fabric-samples**) foi gerado pela instalação dos binários, passo acima.
- `./byfn.sh generate`
- `./byfn.sh up` (Go), `./byfn.sh up -l java` (Java) ou `./byfn.sh up -l javascript` (JavaScript)

O link fornecido acima fornece detalhes acerca de como criar sua própria rede, motivo pelo qual **first-network** é relevante. Por ora, você pode simplesmente "desmontar" a rede criada.

- `./byfn.sh down`
