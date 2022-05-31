# desafio_backend

Primeiro passo startar a aplicação.

Em seguida procure na pasta resources o data.sql e popule o banco h2

JDBC URL - 	
jdbc:h2:mem:ficticius-database?serverTimezone=America/Sao_Paulo

exemplos de chamadas ao postman:

calculo - http://localhost:8080/v2/calculo/lista

JSON - {
    "gasolinaPreco":4.00,
    "totalKmRodadoCidade": 20,
    "totalKmRodadoRodovia" : 15
}

cadastro - http://localhost:8080/v2/cadastro

JSON - {
    "nome":"teste3",
    "marca": "teste4",
    "modelo" : "teste5",
    "dataFabricao" : "13-11-2014",
    "consumoMedioKmDentroCidade" : 60.0,
    "consumoMedioKmRodovias" : 120.0
}