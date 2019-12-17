# _Blockchain_: Estudo de Caso

## Cenário

Em uma universidade professores aplicam provas, cada uma delas composta por questões. Estudantes que realizam tais provas fornecem os resultados (respostas).

Quando uma prova é submetida por um estudante, o professor em questão é responsável pela correção de cada uma das questões submetidas. A correção pode ser contestada pelo estudante. A contestação pode ocorrer no máximo 2 dias após a divulgação do resultado.

O professor deve responder cada questionamento (feito por questão). O estudante terá 2 dias para, caso não satisfeito com a resposta do docente, reiterar sua posição. Neste caso, contudo, agora outra instância da universidade será responsável pela resposta ao questionamento do estudante. Independente do resultado apresentado pelo segundo revisor, a coordenação de curso deve ratificar a resposta do segundo revisor ou fornecer encaminhamento distinto e definitivo.

# Ambiente de desenvolvimento

O [script](./hyperledger-install.sh) visa criar o ambiente de desenvolvimento necessário para o desenvolvimento do estudo de caso. Este script atende os pré-requisitos (https://hyperledger-fabric.readthedocs.io/en/latest/prereqs.html) esperados e foi testado no Ubuntu 18.04.

## 1. Pré-requisitos

- Log no Ubuntu 18
- `git clone https://github.com/kyriosdata/blockchain`
- `blockchain/hyperledger-install.sh`

# 2. Instalar binários

- `curl -sSL https://bit.ly/2ysbOFE | bash -s`
- O comando acima cria o diretório **fabric-samples** no diretório em que é executado.

# 3. Configuração para a primeira aplicação

Este link (https://hyperledger-fabric.readthedocs.io/en/latest/build_network.html) fornece detalhes acerca de como criar sua própria rede, motivo pelo qual **first-network** é relevante.

- `cd fabric-samples/first-network` (onde **fabric-samples**) foi gerado pela instalação dos binários, passo acima.
- `./byfn.sh generate`

# 4. Escrevendo a primeira aplicação (chaincode in Javascript)

Veja detalhes em https://hyperledger-fabric.readthedocs.io/en/latest/write_first_app.html.

- `cd fabric-samples/fabcar`
- `./startFabric.sh javascript` (após este comando a rede estará montada e poderá ser exercidade).
- `cd java` (para exercitar código escrito em Java)
- `mvn test`
