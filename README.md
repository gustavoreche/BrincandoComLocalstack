# BrincandoComLocalstack

## Requisitos para executar o projeto:
- `Docker`
  - [Link para instalar DOCKER](https://docs.docker.com/docker-for-windows/install/)
- `AWS CLI`
  - [Link para instalar AWS CLI](https://docs.aws.amazon.com/pt_br/cli/v1/userguide/cli-chap-install.html)

### Executando o LocalStack:
- Copie o projeto do GitHub do LocalStack para seu ambiente:
  - [Link para copiar o LocalStack](https://github.com/localstack/localstack)
- No diretório raiz(onde está o arquivo `docker-compose.yml`), execute o comando:
  -  `docker-compose up`

### Configurando a "conta" na AWS(LocalStack):
- Abra um TERMINAL(ou CMD), e digite:
  - `aws configure`
- Para o AWS_ACCESS_KEY_ID, digite: 
  - `default_access_key`
- Para o AWS_SECRET_ACCESS_KEY, digite: 
  - `default_secret_key`
- Para o REGION, digite: 
  - `sa-east-1`