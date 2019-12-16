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
  - `sudo apt install maven`
  - `sudo apt install default-jdk`

# Instalar binários

- `curl -sSL https://bit.ly/2ysbOFE | bash -s`
- O comando acima cria o diretório **fabric-samples** no diretório em que é executado. 

# Configurar variáveis de ambiente (GOPATH e PATH)
O diretório criado pela instalação dos binários (passo acima) deve ser o diretório configurado na variável **\$GOPATH**. Adicionalmente, no diretório definido em **GOPATH** encontra-se o diretório **bin**, que deve fazer parte da variável **PATH**.

- `export GOPATH=dir-instalcao-binarios/fabric-samples**`
- `export PATH=$PATH:$GOPATH/bin`, onde o diretório **bin** foi gerado pelo comando acima, assim como o diretório **fabric-samples**.

# Criando a primeira rede

Este link (https://hyperledger-fabric.readthedocs.io/en/latest/build_network.html) fornece detalhes acerca de como criar sua própria rede, motivo pelo qual **first-network** é relevante. 

- `cd fabric-samples/first-network` (onde **fabric-samples**) foi gerado pela instalação dos binários, passo acima.
- `./byfn.sh generate`
- `./byfn.sh up` (Go), `./byfn.sh up -l java` (Java) ou `./byfn.sh up -l javascript` (JavaScript)

Por ora, você pode simplesmente "desmontar" a rede criada.

- `./byfn.sh down`

# Escrevendo a primeira aplicação

Veja detalhes em https://hyperledger-fabric.readthedocs.io/en/latest/write_first_app.html.

- `cd fabric-samples/first-network`
- `./byfn.sh down`
- `./byfn.sh generate` (exigido se nova linguagem é escolhida)
- `cd fabric-samples/fabcar`
- `./startFabric.sh` (após este comando a rede estará montada e poderá ser exercidade).
- `cd java` (para exercitar código escrito em Java)
- `mvn test`
