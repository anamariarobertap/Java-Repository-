using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FragenBogen
{
    public partial class AddForm : Form
    {
        repository.Repository repository = new repository.Repository();
        public List<model.Antwort> AntwortenListe = new List<model.Antwort>();
        public AddForm()
        {
            InitializeComponent();
        }

        private void addFormFrageButton_Click(object sender, EventArgs e)
        {
            /*
             * Addiere ich eine neue Frage in meiner Fragenbogen
             */

            this.Visible = false;
            Form1 form1 = new Form1();
            form1.Visible = true;
            int ID = Convert.ToInt32(textBox11.Text);
            String FrageText = textBox1.Text;
            Boolean isRichtig1 = Convert.ToBoolean(textBox9.Text);
            String Antwort1Text = textBox10.Text;
            Boolean isRichtig2 = Convert.ToBoolean(textBox7.Text);
            String Antwort2Text = textBox8.Text;
            Boolean isRichtig3 = Convert.ToBoolean(textBox5.Text);
            String Antwort3Text = textBox6.Text;
            Boolean isRichtig4 = Convert.ToBoolean(textBox3.Text);
            String Antwort4Text = textBox4.Text;
            AntwortenListe.Add(new model.Antwort(isRichtig1, Antwort1Text));
            AntwortenListe.Add(new model.Antwort(isRichtig2, Antwort2Text));
            AntwortenListe.Add(new model.Antwort(isRichtig3, Antwort3Text));
            AntwortenListe.Add(new model.Antwort(isRichtig4, Antwort4Text));
            repository.AddFrage(ID,FrageText,AntwortenListe);
        }

        private void AddForm_Load(object sender, EventArgs e)
        {

        }
    }
}
