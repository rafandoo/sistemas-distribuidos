class FiiDTO:
    def __init__(self, ticker: str, nome: str, setor: str, preco: float, vpa: float):
        self._ticker = ticker
        self._nome = nome
        self._setor = setor
        self._preco = preco
        self._vpa = vpa
    
    def __str__(self):
        return f"Fii [" \
            f"Ticker: {self._ticker} | " \
            f"Nome: {self._nome} | " \
            f"Setor: {self._setor} | " \
            f"Preço: {self._preco} | " \
            f"VPA: {self._vpa} | " 

    def dict(self):
        return {
            "ticker": self._ticker,
            "nome": self._nome,
            "setor": self._setor,
            "preco": self._preco,
            "vpa": self._vpa
        }
