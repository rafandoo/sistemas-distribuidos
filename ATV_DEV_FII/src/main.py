import sys
from server import Server
from integration import Integration

def exibirMenu(opcoes, titulo="Menu"):
    while True:
        print('\n', 10*'=', ' ', titulo, ' ', 10*'=')
        for i, opcao in enumerate(opcoes, start=1):
            print(f"{i}. {opcao[0]}")

        escolha = input("Escolha uma opção: ")

        if not escolha.isdigit() or int(escolha) < 1 or int(escolha) > len(opcoes):
            print("Opção inválida. Tente novamente.\n")
            continue

        opcaoSelecionada = opcoes[int(escolha) - 1]

        if callable(opcaoSelecionada[1]):
            opcaoSelecionada[1]()  # Chama a função associada à opção
        else:
            exibirMenu(opcaoSelecionada[1])  # Exibe o submenu

def close():
    sys.exit(0)
    
def webserver():
    server = Server()
    server.run()
    
def importacao():
    filename = input("Digite o nome do arquivo: ")
    importacao = Integration(filename)
    importacao.run()

### MENU PRINCIPAL ###
menuPrincipal = [
    ("WebServer", webserver),
    ("Importacao", importacao),
    ("Sair", close),
]

def main():
    exibirMenu(menuPrincipal)

main()
