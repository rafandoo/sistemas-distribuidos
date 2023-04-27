from enum import Enum

class Cargo(Enum):
    ADMINISTRATIVO: int
    COMERCIAL: int
    SUPORTE: int

class FuncionarioDTO:
    def __init__(self, matricula: int, nome: str, email: str, cargo: Cargo, salario: float) -> None: ...
    def exportComma(self): ...
