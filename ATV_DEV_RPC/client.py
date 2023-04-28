import requests
import json

# URL de acesso ao servidor
url = 'http://localhost:8000/buscar'

# Headers para indicar que o conteudo da requisicao eh um JSON
headers = {'content-type': 'application/json'}

# Payload com os dados da requisicao
payload = {
    'matricula': 5602
}

# Faz a requisicao POST para o servidor com os dados
response = requests.post(url, data=json.dumps(payload), headers=headers)

# Tenta converter a resposta para JSON e imprime
try:
    print(response.json())
except Exception as e:
    print(response)
