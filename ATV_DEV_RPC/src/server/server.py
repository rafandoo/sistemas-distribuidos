from lumi import Lumi
import src.BO.funcionarioBO as fbo


class Server:

    def __init__(self):
        # Cria uma instancia do servidor
        self.app = Lumi()

        # Registra as funcoes do BO no servidor para que possam ser acessadas remotamente
        self.app.register(fbo.inserir, route='/inserir')
        self.app.register(fbo.remover, route='/remover')
        self.app.register(fbo.listar, route='/listar')
        self.app.register(fbo.buscar, route='/buscar')

    # Inicia o servidor
    def run(self):
        self.app.runServer(host='localhost', port=8000)
