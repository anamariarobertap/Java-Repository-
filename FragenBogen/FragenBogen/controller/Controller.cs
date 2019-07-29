using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FragenBogen.controller
{
    public class Controller
    {
        repository.Repository repository = new repository.Repository();
        public List<model.Frage> FindRandomFragen()
        {
            Random rand = new Random();
            List<model.Frage> fragen = new List<model.Frage>();


            for (int i =0; i<26; i++)
            {
                fragen.Add(repository.FindFrage(rand.Next(0, 41)));
                
            }

            return fragen;
        }

        public int GenerateFragenbogenNummer()
        {
            Random rand = new Random();
            return rand.Next(10000, 99999);
        }


    }
}
