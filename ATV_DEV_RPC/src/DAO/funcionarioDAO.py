from ..DTO.funcionarioDTO import FuncionarioDTO, Cargo


class FuncionarioDAO:
    def __init__(self):
        self.filename = 'funcionarios.txt'

    def insere(self, funcionarioDTO: FuncionarioDTO):
        try:
            with open(self.filename, 'a') as f:
                f.write(funcionarioDTO.exportComma() + '\n')
        except Exception as e:
            print(e)

    def remove(self, matricula: int):
        try:
            with open(self.filename, 'r') as fr:
                lines = fr.readlines()
            with open(self.filename, 'w') as fw:
                for line in lines:
                    if not int(line[0]) == matricula:
                        fw.write(line)
        except Exception as e:
            print(e)

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
