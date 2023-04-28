from enum import Enum

class Cargo(Enum):
    ADMINISTRATIVO: int
    COMERCIAL: int
    SUPORTE: int

class FuncionarioDTO:
    def __init__(self, matricula: int, nome: str, email: str, cargo: Cargo, salario: float) -> None:
        self._matricula = matricula
        self._nome = nome
        self._email = email
        self._cargo = cargo
        self._salario = salario
        ...

    def exportComma(self): ...
