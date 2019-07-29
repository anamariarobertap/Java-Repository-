using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FragenBogen.repository
{
    public class Repository
    {
        MongoClient mongoClient = new MongoClient("mongodb://localhost");
        IMongoDatabase db;
        IMongoCollection<model.Frage> Fragen;
        public Repository()
        {
           db = mongoClient.GetDatabase("FragenbogenDatabase");
           Fragen = db.GetCollection<model.Frage>("Fragen");
        }

        public void AddFrage (int ID, string FragenText, List<model.Antwort> AntwortenListe)
        {
          
            model.Frage frage = new model.Frage(ID,FragenText,AntwortenListe);
            Fragen.InsertOne(frage);
        }

        public model.Frage FindFrage(int ID)
        {
            return Fragen.Find(x=>x.ID==ID).FirstOrDefault(); 
        }

    }
}
