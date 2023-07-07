from DAO.fiiDAO import FiiDAO
from DAO.conn import Connection
from DTO.fiiDTO import FiiDTO

# Instancia do DAO
fiiDAO = FiiDAO(Connection().collection)

# Metodos para inserir, remover, listar e buscar fiis, utilizando o DAO

def inserir(ticker: str, nome: str, setor: str, preco: float, vpa: float):
    fiiDTO = FiiDTO(ticker, nome, setor, preco, vpa)
    fiiDAO.insere(fiiDTO)

def remover(ticker: str):
    fiiDAO.remove(ticker)

def listar() -> list:
    return fiiDAO.lista()

def buscar(ticker: str) -> str:
    return fiiDAO.busca(ticker)
