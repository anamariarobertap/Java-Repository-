using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FragenBogen.model
{
    public class Antwort
    {
        /*
         * eine Antwort kann entweder richtig oder falsch sein 
         */
        public Boolean IstRichtig { get; set; }
        public String AntwortText { get; set; }
        public Antwort (Boolean IstRichtig, String AntwortText)
        {
            this.IstRichtig = IstRichtig;
            this.AntwortText = AntwortText;
        }
    }
}
