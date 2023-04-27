from ..DAO.funcionarioDAO import FuncionarioDAO
from ..DTO.funcionarioDTO import FuncionarioDTO


class FuncionarioBO:
    def __init__(self):
        self.funcionarioDAO = FuncionarioDAO()

    def inserir(self, funcionarioDTO: FuncionarioDTO):
        self.funcionarioDAO.insere(funcionarioDTO)

    def remover(self, matricula: int):
        self.funcionarioDAO.remove(matricula)

    def listar(self) -> list:
        return self.funcionarioDAO.lista()

    def buscar(self, matricula: int) -> FuncionarioDTO:
        return self.funcionarioDAO.busca(matricula)
