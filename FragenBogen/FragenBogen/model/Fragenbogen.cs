using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FragenBogen.model
{
    public class Fragenbogen
    {
        public List<model.Frage> fragen = new List<model.Frage>();
        public int AnzahlRichtig { get; set; }
        public int AnzahlFalsch { get; set; }
        public int ID {get; set;}
        public Double Fragebogennummer { get; set; }
        
    }
}
