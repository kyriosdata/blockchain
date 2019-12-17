# docker

sudo apt-get update
sudo apt-get -y remove docker docker-engine docker.io
sudo apt -y install docker.io
sudo systemctl start docker
sudo systemctl enable docker

# docker-compose

sudo apt -y install docker-compose

# node (e npm)
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.34.0/install.sh | bash
. ~/.nvm/nvm.sh
nvm install node

# JAVA E MAVEN

sudo apt -y install openjdk-8-jdk-headless
sudo apt -y install maven

# GO lang
curl -O https://storage.googleapis.com/golang/go1.12.9.linux-amd64.tar.gz
tar -xvf go1.12.9.linux-amd64.tar.gz
sudo chown -R root:root ./go
sudo mv go /usr/local
mkdir go
echo export GOPATH=$HOME/go >> .bashrc
echo export PATH=$PATH:/usr/local/go/bin:$GOPATH/bin:$HOME/fabric-samples/bin >> .bashrc

