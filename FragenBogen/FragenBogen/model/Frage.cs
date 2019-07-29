using MongoDB.Bson.Serialization.Attributes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FragenBogen.model
{
    [BsonIgnoreExtraElements]
    public class Frage
    {
        public List<model.Antwort> AntwortenListe = new List<model.Antwort>();
        public int ID { get; set; }
        public String FragetText { get; set; }
        public Frage(int ID, string FragenText, List<model.Antwort> AntwortenListe)
        {
            this.ID = ID;
            this.FragetText = FragenText;
            this.AntwortenListe = AntwortenListe;
        }
      
    }
}
