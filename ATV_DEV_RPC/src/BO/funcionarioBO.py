from ..DAO.funcionarioDAO import FuncionarioDAO
from ..DTO.funcionarioDTO import FuncionarioDTO, Cargo

# Instancia do DAO
funcionarioDAO = FuncionarioDAO()

# Metodos para inserir, remover, listar e buscar funcionarios, utilizando o DAO


def inserir(matricula: int, nome: str, email: str, cargo: int, salario: float):
    funcionarioDTO = FuncionarioDTO(matricula, nome, email, Cargo(cargo), salario)
    funcionarioDAO.insere(funcionarioDTO)


def remover(matricula: int):
    funcionarioDAO.remove(matricula)


def listar() -> list:
    return funcionarioDAO.lista()


def buscar(matricula: int) -> str:
    return funcionarioDAO.busca(matricula).__repr__()
