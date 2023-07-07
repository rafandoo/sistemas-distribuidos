import BO.fiiBO as fbo

class Integration:
    
    def __init__(self, filename):
        self.filename = filename
        
    def run(self): 
        with open(self.filename, 'r') as file:
            for line in file:
                data = line.split('|')
                fbo.inserir(data[0], data[1], data[2], data[3], data[4])
        print('Importação concluída com sucesso!')
