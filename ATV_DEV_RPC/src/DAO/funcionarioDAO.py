from ..DTO.funcionarioDTO import FuncionarioDTO, Cargo


class FuncionarioDAO:
    def __init__(self):
        # Nome do arquivo que armazena os dados dos funcionarios
        self.filename = 'funcionarios.txt'

    """
    Metodo para inserir um funcionario no arquivo
    
    :param funcionarioDTO: FuncionarioDTO
    :return: None
    """
    def insere(self, funcionarioDTO: FuncionarioDTO) -> None:
        try:
            with open(self.filename, 'a') as f:
                f.write(funcionarioDTO.exportComma() + '\n')
        except Exception as e:
            print(e)

    """
    Metodo para remover um funcionario do arquivo
    
    :param matricula: int
    :return: None
    """
    def remove(self, matricula: int) -> None:
        try:
            with open(self.filename, 'r') as fr:
                lines = fr.readlines()
            with open(self.filename, 'w') as fw:
                for line in lines:
                    if not int(line[0]) == matricula:
                        fw.write(line)
        except Exception as e:
            print(e)

    """
    Metodo para listar todos os funcionarios do arquivo
    
    :return: list
    """
    def lista(self) -> list:
        try:
            funcionarios = []
            with open(self.filename, 'r') as f:
                lines = f.readlines()
                for line in lines:
                    cl = line.split(',')
                    funcionarioDTO = FuncionarioDTO(
                        int(cl[0]),
                        cl[1],
                        cl[2],
                        Cargo(int(cl[3])),
                        float(cl[4])
                    )
                    funcionarios.append(funcionarioDTO.__repr__())
            return funcionarios
        except Exception as e:
            print(e)

    """
    Metodo para buscar um funcionario no arquivo
    
    :param matricula: int
    :return: FuncionarioDTO
    """
    def busca(self, matricula: int) -> FuncionarioDTO:
        try:
            with open(self.filename, 'r') as f:
                lines = f.readlines()
                for line in lines:
                    cl = line.split(',')
                    if int(cl[0]) == matricula:
                        funcionario = FuncionarioDTO(
                            int(cl[0]),
                            cl[1],
                            cl[2],
                            Cargo(int(cl[3])),
                            float(cl[4])
                        )
                return funcionario
        except Exception as e:
            print(e)
