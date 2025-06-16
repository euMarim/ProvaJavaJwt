# API - Gerenciamento de Usuários
```
Marcelo de Souza Silva Junior - 23028117-2
Diogo Caua Da Silva Siqueira - 23307719-2
Gustavo Henrique de Oliveira - 23152090-2
Alan Biazebeti Balan - 23350038-2
Lucas Marim Freitas - 23190348-2
Leonardo Oliveira Stefano - 23202896-2
```
## Endpoint: 
### Registrar Usuário
 
`POST http://localhost:8080/auth/register`
```json
{
  "login": "admin",
  "email": "teste@teste.com",
  "password": "123",
  "role": "USER"
}
```
### Login
`POST http://localhost:8080/auth/login`
```json
{
  "login": "admin",
  "password": "123"
}
```
Resposta:
Retorna um token JWT. Use este token para autenticação nas requisições seguintes:

### Editar Pessoa (Somente Admins)
`PUT http://localhost:8080/pessoa/editarPessoa/{id}`
```json
{
  "login": "admin2",
  "password": "1234"
}
```
### Editar Perfil (Apenas Usuários)
`PUT http://localhost:8080/pessoa/editarPerfil`
```json
{
  "login": "user",
  "password": "1234"
}
```
### Buscar Usuário por ID (Somente Admins)
`GET http://localhost:8080/pessoa/{id}`

Retorna os dados do usuário especificado.

### Remover Usuário (Somente Admins)
`DELETE http://localhost:8080/pessoa/{id}`

Remove o usuário com o ID informado.

### Visualizar Perfil (Apenas Usuários)
`GET http://localhost:8080/pessoa/visualizarPerfil`

Retorna os dados do usuário atualmente autenticado.

### Listar Todos os Usuários (Somente Admins)
`GET http://localhost:8080/pessoa/listarTodosUsuarios`

Retorna a lista de todos os usuários cadastrados.
