import requests
import json

# URL de acesso ao servidor
url = 'http://localhost:8000/inserir'

# Headers para indicar que o conteudo da requisicao eh um JSON
headers = {'content-type': 'application/json'}

# Payload com os dados da requisicao
payload = {
    'ticker': 'HGLG11',
    'nome': 'Cshg Logística',
    'setor': 'Logística',
    'preco': 200.00,
    'vpa': 100.00
}

# Faz a requisicao POST para o servidor com os dados
response = requests.post(url, data=json.dumps(payload), headers=headers)

# Tenta converter a resposta para JSON e imprime
try:
    print(response.json())
except Exception as e:
    print(response)
