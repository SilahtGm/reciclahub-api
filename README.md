
# ReciclaHub

**Plataforma Inteligente de Gestão Empresarial de Resíduos e Coletas Sustentáveis**

---

# 1. Visão Geral do Projeto

O **ReciclaHub** é uma plataforma empresarial voltada para a gestão inteligente de resíduos recicláveis, criada para atender empresas responsáveis pelo armazenamento e coleta de resíduos.

O objetivo do sistema é automatizar o monitoramento de resíduos, melhorar a eficiência operacional das coletas, reduzir desperdícios e fortalecer práticas ESG relacionadas à sustentabilidade ambiental.

A solução permitirá que empresas acompanhem em tempo real os níveis de armazenamento dos pontos de coleta, recebam alertas automáticos de capacidade excedida, acompanhem históricos de coletas e organizem operações logísticas de reciclagem de maneira segura e centralizada.

O projeto se enquadra no tema ESG: **Gestão de resíduos e reciclagem**

com foco em:

* rastreamento da coleta seletiva;
* descarte correto de resíduos;
* monitoramento de limites de armazenamento;
* automação de alertas ambientais;
* otimização da logística de coleta.

---

# 2. Problema Identificado

Atualmente, muitas empresas e centros de armazenamento de resíduos enfrentam dificuldades relacionadas ao controle operacional dos materiais recicláveis.

Entre os principais problemas observados estão:

* falta de monitoramento do volume armazenado;
* ausência de controle centralizado dos pontos de coleta;
* atrasos na coleta de resíduos;
* desperdício por excesso de armazenamento;
* baixa rastreabilidade sobre quais empresas realizaram as coletas;
* dificuldade de acompanhamento dos resíduos por categoria.

Além disso, empresas coletoras frequentemente não possuem uma visão clara dos locais prioritários para coleta, o que reduz a eficiência logística e pode gerar acúmulo excessivo de resíduos.

---

# 3. Solução Proposta

O ReciclaHub será uma API RESTful construída em Java com Spring Boot para gerenciar o ciclo operacional dos resíduos recicláveis.

O sistema conectará dois tipos principais de empresas:

## Empresa de Armazenamento

Responsável pelos pontos de coleta e pelo armazenamento temporário dos resíduos.

Essas empresas poderão:

* visualizar apenas os pontos pertencentes à sua organização;
* acompanhar níveis de armazenamento;
* visualizar alertas automáticos;
* acompanhar histórico de coletas realizadas;
* monitorar resíduos por categoria.

Por questões de segurança operacional, essas empresas **não poderão registrar coletas**, apenas acompanhá-las.

## Empresa Coletora

Responsável pela retirada dos resíduos recicláveis.

Essas empresas poderão:

* consultar resíduos disponíveis para coleta;
* visualizar armazenamento atual dos pontos;
* filtrar pontos por categoria de resíduo;
* registrar coletas;
* localizar pontos prioritários para retirada.

As empresas coletoras só poderão atuar nos tipos de resíduos autorizados em seu cadastro.

---

# 4. Como o Sistema Funcionará

## Etapa 1 — Cadastro e organização

A organização efetua um cadastro, e após efetuar login, implementa seus pontos de armazenamento para coleta:

* empresas de armazenamento;
* empresas coletoras;
* tipos de resíduos;
* pontos de coleta.

Cada ponto de coleta será vinculado a uma empresa responsável pelo armazenamento.

---

## Etapa 2 — Armazenamento de resíduos

Os resíduos são armazenados em pontos específicos.

Cada ponto possuirá:

* categoria de resíduo;
* quantidade atual armazenada;
* limite máximo permitido.

O sistema monitorará automaticamente os níveis de armazenamento.

---

## Etapa 3 — Geração automática de alertas

Quando um armazenamento ultrapassar o limite permitido da categoria de resíduo, o sistema gerará automaticamente um alerta.

Esse processo será realizado através de regras automatizadas no banco Oracle utilizando triggers.

Exemplo:

> Limite excedido para plástico no ponto Zona Norte.

A empresa responsável pelo ponto poderá visualizar imediatamente o problema.

---

## Etapa 4 — Consulta pelas empresas coletoras

As empresas coletoras visualizarão locais disponíveis para coleta com base nos tipos de resíduos autorizados.

Exemplo:

Uma empresa especializada em plástico verá apenas pontos com resíduos plásticos.

O sistema poderá priorizar locais com maior urgência de coleta.

---

## Etapa 5 — Registro da coleta

Após realizar a retirada do resíduo, a empresa coletora registrará a coleta no sistema.

O sistema automaticamente:

* registrará a operação;
* atualizará o armazenamento do ponto;
* reduzirá a quantidade armazenada.

Essa atualização ocorrerá automaticamente via trigger no Oracle.

---

## Etapa 6 — Histórico e auditoria

Todas as coletas ficarão registradas.

Será possível consultar:

* data da coleta;
* quantidade coletada;
* empresa responsável;
* categoria do resíduo;
* ponto de coleta.

Esse histórico servirá para auditoria e métricas ESG.

---

# 5. Diferenciais do Projeto

O sistema contará com:

### Controle de acesso por perfil

Cada empresa terá permissões específicas.

### Multiempresa

Cada organização visualizará apenas seus próprios dados.

### Segurança com Spring Security + JWT

Rotas protegidas com autenticação.

### Banco Oracle

Persistência robusta de dados.

### Flyway

Versionamento das migrações do banco.

### Docker

Execução padronizada em qualquer ambiente.

### Automação no banco

Uso de triggers para:

* validação de dados;
* atualização automática do armazenamento;
* geração automática de alertas.

---

# 6. Tecnologias do Projeto

* Java 21
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Bean Validation
* Oracle Database
* Flyway
* Docker
* Maven
* Postman / Insomnia

---

# 7. Objetivo Final do Produto

O objetivo do ReciclaHub é fornecer uma plataforma corporativa capaz de tornar o processo de armazenamento e coleta de resíduos mais eficiente, rastreável e sustentável.

Com isso, empresas poderão reduzir desperdícios, melhorar a logística de reciclagem e fortalecer práticas ESG através do monitoramento inteligente dos resíduos recicláveis.

---

# 8. Segurança (Spring Security + JWT)

A API é protegida por **Spring Security** com autenticação baseada em **JWT**. As senhas são armazenadas com **BCrypt**.

## Endpoints públicos

| Método | Endpoint                | Descrição                         |
|--------|-------------------------|-----------------------------------|
| POST   | `/api/cadastro/empresa` | Cadastra uma nova empresa         |
| POST   | `/api/auth/login`       | Realiza login e retorna token JWT |

Todos os demais endpoints exigem o cabeçalho:

```
Authorization: Bearer <token-jwt>
```

## Fluxo de uso

1. **Cadastrar empresa** (`POST /api/cadastro/empresa`):

```json
{
  "cnpj": "12345678000199",
  "nome": "Empresa Exemplo",
  "email": "empresa@exemplo.com",
  "senha": "senhaSegura123",
  "tipo": "ARMAZENAMENTO"
}
```

2. **Realizar login** (`POST /api/auth/login`):

```json
{
  "email": "empresa@exemplo.com",
  "senha": "senhaSegura123"
}
```

Resposta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "tipoToken": "Bearer",
  "expiracaoMs": 3600000,
  "idEmpresa": 1,
  "nome": "Empresa Exemplo",
  "email": "empresa@exemplo.com",
  "tipo": "ARMAZENAMENTO"
}
```

3. **Usar o token** nas demais chamadas via cabeçalho `Authorization: Bearer <token>`.

## Roles (perfis)

O campo `tipo` da empresa é mapeado como uma role do Spring Security:

- `ARMAZENAMENTO` → `ROLE_ARMAZENAMENTO`
- `COLETORA`     → `ROLE_COLETORA`

Restrições adicionais podem ser definidas por endpoint usando `@PreAuthorize` (já habilitado via `@EnableMethodSecurity`).

---

# 9. Execução com Docker

O projeto possui `Dockerfile` (multi-stage) e `docker-compose.yml` com **Oracle Free 23c** + API.

## Pré-requisitos

- Docker
- Docker Compose

## Passo a passo

1. (Opcional) Copie o arquivo de exemplo de variáveis de ambiente:

```bash
cp .env.example .env
```

Edite os valores conforme necessário (em produção, **sempre** redefina o `JWT_SECRET`).

2. Suba os contêineres:

```bash
docker compose up -d --build
```

3. Acompanhe os logs (o Oracle leva ~1-2 min na primeira inicialização):

```bash
docker compose logs -f api
```

4. A API estará disponível em `http://localhost:8080`.

5. Para encerrar:

```bash
docker compose down
```

Para remover também o volume com os dados do banco:

```bash
docker compose down -v
```

## Variáveis de ambiente principais

| Variável                  | Padrão                                | Descrição                                  |
|---------------------------|---------------------------------------|--------------------------------------------|
| `SPRING_DATASOURCE_URL`   | jdbc:oracle:thin:@oracle-db:1521/FREEPDB1 | URL JDBC do Oracle                     |
| `SPRING_DATASOURCE_USERNAME` | reciclahub                         | Usuário do banco                           |
| `SPRING_DATASOURCE_PASSWORD` | reciclahub                         | Senha do banco                             |
| `JWT_SECRET`              | (valor de exemplo em Base64)          | Chave HMAC para assinar tokens (≥ 256 bits)|
| `JWT_EXPIRATION_MS`       | 3600000                               | Validade do token em milissegundos         |
| `SERVER_PORT`             | 8080                                  | Porta exposta pela API                     |

---

# 10. Execução local (sem Docker)

```bash
./mvnw spring-boot:run
```

Por padrão a aplicação utiliza o Oracle da FIAP (`oracle.fiap.com.br`). Para apontar para outro banco, defina as variáveis `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME` e `SPRING_DATASOURCE_PASSWORD`.
