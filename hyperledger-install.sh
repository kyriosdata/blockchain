# docker

sudo apt-get update
sudo apt-get -y remove docker docker-engine docker.io
sudo apt -y install docker.io
sudo systemctl start docker
sudo systemctl enable docker

# docker-compose

sudo apt -y install docker-compose

# Evita necessidade de sudo para docker

sudo usermod -a -G docker ubuntu

# node (e npm)
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.34.0/install.sh | bash
. ~/.nvm/nvm.sh
nvm install 10.15.3

# Make e g++
- `sudo apt -y install make`
- `sudo apt -y install g++`

# Requisitado em alguns cenários
- `npm rebuild`

# JAVA E MAVEN

sudo apt -y install openjdk-8-jdk-headless
sudo apt -y install maven

# GO lang
curl -O https://storage.googleapis.com/golang/go1.12.9.linux-amd64.tar.gz
tar -xvf go1.12.9.linux-amd64.tar.gz
sudo chown -R root:root ./go
sudo rm -fr /usr/local/go
sudo mv go /usr/local
rm -f go1.12.9.linux-amd64.tar.gz

mkdir $HOME/go
echo export GOPATH=$HOME/go >> $HOME/.bashrc
echo export PATH=$PATH:/usr/local/go/bin:$GOPATH/bin:$HOME/fabric-samples/bin >> $HOME/.bashrc

