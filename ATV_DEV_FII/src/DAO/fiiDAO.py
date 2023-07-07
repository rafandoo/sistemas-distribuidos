from DTO.fiiDTO import FiiDTO

class FiiDAO:
    def __init__(self, collection):
        # onde sera armazenado os dados
        self.collection = collection
    
    # Metodos para inserir, remover, listar e buscar fiis
    def insere(self, fiiDTO: FiiDTO) -> None:
        try:
            self.collection.insert_one(fiiDTO.dict())
            print("Fii inserido com sucesso!")
        except Exception as e:
            print(e)

    def remove(self, ticker: str) -> None:
        try:
            self.collection.delete_one({"ticker": ticker})
        except Exception as e:
            print(e)
    
    def lista(self) -> list:
        try:
            fiis = []
            for fii in self.collection.find():
                fiis.append(FiiDTO(fii["ticker"], fii["nome"], fii["setor"], fii["preco"], fii["vpa"]).__str__())
            return fiis
        except Exception as e:
            print(e)
            
    def busca(self, ticker: str) -> str:
        try:
            fii = self.collection.find_one({"ticker": ticker})
            fii = FiiDTO(fii["ticker"], fii["nome"], fii["setor"], fii["preco"], fii["vpa"]).__str__()
            return fii if fii else "Fii não encontrado"
        except Exception as e:
            print(e)
