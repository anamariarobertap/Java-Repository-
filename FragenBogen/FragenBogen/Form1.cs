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
    public partial class Form1 : Form
    {
        public repository.Repository repository = new repository.Repository();
        public controller.Controller controller = new controller.Controller();
        public model.Fragenbogen fragenBogen = new model.Fragenbogen();
        public int IstRichtig = 0;
        public int IstFalsch = 0;
        public int idNext = 1;
        public int idFragenbogen = 1;


        public Form1()
        {
   
        InitializeComponent();

        }

        private void startButton_Click(object sender, EventArgs e)
        {
            fragenLabel.Visible = true;
            answer1Label.Visible = true;
            answer2Label.Visible = true;
            answer3Label.Visible = true;
            answer4Label.Visible = true;
            checkBox1.Visible = true;
            checkBox2.Visible = true;
            checkBox3.Visible = true;
            checkBox4.Visible = true;
            addFrageButton.Visible = false;
            nextButton.Visible = true;
            istFalschLabel.Visible = true;
            istRichtigLabel.Visible = true;
            frgNummerLabel.Visible = true;
            frgbID.Visible = true;

            fragenBogen.fragen = controller.FindRandomFragen();
            fragenBogen.ID = idFragenbogen;
            fragenBogen.Fragebogennummer = controller.GenerateFragenbogenNummer();
            

            frgbID.Text = "FragenbogenID: " +Convert.ToString(fragenBogen.ID);
            frgNummerLabel.Text = "FragenbogenNummer: "+Convert.ToString(fragenBogen.Fragebogennummer);


            fragenLabel.Text = fragenBogen.fragen[0].FragetText;
            answer1Label.Text = fragenBogen.fragen[0].AntwortenListe[0].AntwortText;
            answer2Label.Text = fragenBogen.fragen[0].AntwortenListe[1].AntwortText;
            answer3Label.Text = fragenBogen.fragen[0].AntwortenListe[2].AntwortText;
            answer4Label.Text = fragenBogen.fragen[0].AntwortenListe[3].AntwortText;
            idFragenbogen++;

        }
       

        private void nextButton_Click(object sender, EventArgs e)
        {


            if (idNext < 27 && IstFalsch < 5)
            {
                fragenLabel.Text = fragenBogen.fragen[idNext].FragetText;
                answer1Label.Text = fragenBogen.fragen[idNext].AntwortenListe[0].AntwortText;
                answer2Label.Text = fragenBogen.fragen[idNext].AntwortenListe[1].AntwortText;
                answer3Label.Text = fragenBogen.fragen[idNext].AntwortenListe[2].AntwortText;
                answer4Label.Text = fragenBogen.fragen[idNext].AntwortenListe[3].AntwortText;
               

                if ((checkBox1.Checked.Equals(Convert.ToBoolean(fragenBogen.fragen[idNext].AntwortenListe[0].IstRichtig)))
                    && (checkBox2.Checked.Equals(Convert.ToBoolean(fragenBogen.fragen[idNext].AntwortenListe[1].IstRichtig)))
                    && (checkBox3.Checked.Equals(Convert.ToBoolean(fragenBogen.fragen[idNext].AntwortenListe[2].IstRichtig)))
                    && (checkBox4.Checked.Equals(Convert.ToBoolean(fragenBogen.fragen[idNext].AntwortenListe[3].IstRichtig))))
                {
                    IstRichtig++;
                    istRichtigLabel.Text = "Richtig: " + Convert.ToString(IstRichtig);

                }
                else
                {
                    IstFalsch++;
                    istFalschLabel.Text = "Falsch: " + Convert.ToString(IstFalsch);
                }

                checkBox1.Checked = false;
                checkBox2.Checked = false;
                checkBox3.Checked = false;
                checkBox4.Checked = false;
                idNext++;
            }
            else {
                fragenBogen.AnzahlFalsch = IstFalsch;
                fragenBogen.AnzahlRichtig = IstRichtig;
                startButton.Visible = false;
                restartButton.Visible = true;
                addFrageButton.Visible = true;
                nextButton.Visible = false;
                IstFalsch = 0;
                IstRichtig = 0;
                istFalschLabel.Text = "Falsch:";
                istRichtigLabel.Text = "Richtig:";
                frgbID.Text = "FragenbogenID: ";
                frgNummerLabel.Text = "FragenbogenNummer: ";

            }


        }

        private void fragenLabel_Click(object sender, EventArgs e)
        {

        }

        private void answer1Label_Click(object sender, EventArgs e)
        {

        }

        private void answerLabel2_Click(object sender, EventArgs e)
        {

        }

        private void answer3Label_Click(object sender, EventArgs e)
        {

        }

        private void answer4Label_Click(object sender, EventArgs e)
        {

        }

        private void restartButton_Click(object sender, EventArgs e)
        {
            fragenLabel.Visible = true;
            answer1Label.Visible = true;
            answer2Label.Visible = true;
            answer3Label.Visible = true;
            answer4Label.Visible = true;
            checkBox1.Visible = true;
            checkBox2.Visible = true;
            checkBox3.Visible = true;
            checkBox4.Visible = true;
            addFrageButton.Visible = false;
            nextButton.Visible = true;
            frgNummerLabel.Visible = true;
            frgbID.Visible = true;
            istFalschLabel.Visible = true;
            istRichtigLabel.Visible = true;

            fragenBogen.fragen = controller.FindRandomFragen();
            fragenBogen.ID = idFragenbogen;
            fragenBogen.Fragebogennummer = controller.GenerateFragenbogenNummer();

            frgbID.Text = "FragenbogenID: " + Convert.ToString(fragenBogen.ID);
            frgNummerLabel.Text = "FragenbogenNummer: " + Convert.ToString(fragenBogen.Fragebogennummer);


            fragenLabel.Text = fragenBogen.fragen[0].FragetText;
            answer1Label.Text = fragenBogen.fragen[0].AntwortenListe[0].AntwortText;
            answer2Label.Text = fragenBogen.fragen[0].AntwortenListe[1].AntwortText;
            answer3Label.Text = fragenBogen.fragen[0].AntwortenListe[2].AntwortText;
            answer4Label.Text = fragenBogen.fragen[0].AntwortenListe[3].AntwortText;
            idFragenbogen++;
        }

        private void addFrageButton_Click(object sender, EventArgs e)
        {
            AddForm addForm = new AddForm();
            addForm.Show();
            this.Visible = false;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
          
                Timer MyTimer = new Timer();
                MyTimer.Interval = (30 * 60 * 1000); 
                MyTimer.Tick += new EventHandler(MyTimer_Tick);
                MyTimer.Start();
            }

            private void MyTimer_Tick(object sender, EventArgs e)
            {
                MessageBox.Show("The form will now be closed.", "Time Elapsed");
                this.Close();
            }
        }
    
}
