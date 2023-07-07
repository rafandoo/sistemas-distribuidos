import pymongo

# essa classe é responsável por fazer a conexão com o banco de dados
class Connection:
    def __init__(self):
        self.client = pymongo.MongoClient("mongodb://127.0.0.1:30001/?directConnection=true&serverSelectionTimeoutMS=2000&appName=mongosh+1.8.2")
        
        self.db = self.client["db"]
        self.collection = self.db["fii"]

    def connect(self):
        return self.client
    
    def disconnect(self):
        self.client.close()
        
    def collection(self):
        return self.collection
