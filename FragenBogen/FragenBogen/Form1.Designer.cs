namespace FragenBogen
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.startButton = new System.Windows.Forms.Button();
            this.nextButton = new System.Windows.Forms.Button();
            this.fragenLabel = new System.Windows.Forms.Label();
            this.answer3Label = new System.Windows.Forms.Label();
            this.answer2Label = new System.Windows.Forms.Label();
            this.answer1Label = new System.Windows.Forms.Label();
            this.answer4Label = new System.Windows.Forms.Label();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.checkBox2 = new System.Windows.Forms.CheckBox();
            this.checkBox3 = new System.Windows.Forms.CheckBox();
            this.checkBox4 = new System.Windows.Forms.CheckBox();
            this.restartButton = new System.Windows.Forms.Button();
            this.addFrageButton = new System.Windows.Forms.Button();
            this.istRichtigLabel = new System.Windows.Forms.Label();
            this.istFalschLabel = new System.Windows.Forms.Label();
            this.frgbID = new System.Windows.Forms.Label();
            this.frgNummerLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // startButton
            // 
            this.startButton.BackColor = System.Drawing.Color.DarkTurquoise;
            this.startButton.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.startButton.Font = new System.Drawing.Font("Jokerman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.startButton.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.startButton.Location = new System.Drawing.Point(514, 459);
            this.startButton.Name = "startButton";
            this.startButton.Size = new System.Drawing.Size(167, 60);
            this.startButton.TabIndex = 0;
            this.startButton.Text = "START";
            this.startButton.UseVisualStyleBackColor = false;
            this.startButton.Click += new System.EventHandler(this.startButton_Click);
            // 
            // nextButton
            // 
            this.nextButton.BackColor = System.Drawing.Color.Turquoise;
            this.nextButton.Font = new System.Drawing.Font("Palatino Linotype", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.nextButton.Location = new System.Drawing.Point(920, 459);
            this.nextButton.Name = "nextButton";
            this.nextButton.Size = new System.Drawing.Size(159, 60);
            this.nextButton.TabIndex = 1;
            this.nextButton.Text = "NEXT";
            this.nextButton.UseVisualStyleBackColor = false;
            this.nextButton.Visible = false;
            this.nextButton.Click += new System.EventHandler(this.nextButton_Click);
            // 
            // fragenLabel
            // 
            this.fragenLabel.AutoSize = true;
            this.fragenLabel.BackColor = System.Drawing.Color.LightBlue;
            this.fragenLabel.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fragenLabel.Location = new System.Drawing.Point(539, 111);
            this.fragenLabel.Name = "fragenLabel";
            this.fragenLabel.Size = new System.Drawing.Size(102, 22);
            this.fragenLabel.TabIndex = 2;
            this.fragenLabel.Text = "FragenLabel";
            this.fragenLabel.Visible = false;
            this.fragenLabel.Click += new System.EventHandler(this.fragenLabel_Click);
            // 
            // answer3Label
            // 
            this.answer3Label.AutoSize = true;
            this.answer3Label.BackColor = System.Drawing.Color.PowderBlue;
            this.answer3Label.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.answer3Label.Location = new System.Drawing.Point(539, 264);
            this.answer3Label.Name = "answer3Label";
            this.answer3Label.Size = new System.Drawing.Size(117, 22);
            this.answer3Label.TabIndex = 3;
            this.answer3Label.Text = "Answer3Label";
            this.answer3Label.Visible = false;
            this.answer3Label.Click += new System.EventHandler(this.answer3Label_Click);
            // 
            // answer2Label
            // 
            this.answer2Label.AutoSize = true;
            this.answer2Label.BackColor = System.Drawing.Color.PowderBlue;
            this.answer2Label.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.answer2Label.Location = new System.Drawing.Point(539, 218);
            this.answer2Label.Name = "answer2Label";
            this.answer2Label.Size = new System.Drawing.Size(117, 22);
            this.answer2Label.TabIndex = 4;
            this.answer2Label.Text = "Answer2Label";
            this.answer2Label.Visible = false;
            this.answer2Label.Click += new System.EventHandler(this.answerLabel2_Click);
            // 
            // answer1Label
            // 
            this.answer1Label.AutoSize = true;
            this.answer1Label.BackColor = System.Drawing.Color.PowderBlue;
            this.answer1Label.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.answer1Label.Location = new System.Drawing.Point(539, 176);
            this.answer1Label.Name = "answer1Label";
            this.answer1Label.Size = new System.Drawing.Size(117, 22);
            this.answer1Label.TabIndex = 5;
            this.answer1Label.Text = "Answer1Label";
            this.answer1Label.Visible = false;
            this.answer1Label.Click += new System.EventHandler(this.answer1Label_Click);
            // 
            // answer4Label
            // 
            this.answer4Label.AutoSize = true;
            this.answer4Label.BackColor = System.Drawing.Color.PowderBlue;
            this.answer4Label.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.answer4Label.Location = new System.Drawing.Point(539, 313);
            this.answer4Label.Name = "answer4Label";
            this.answer4Label.Size = new System.Drawing.Size(117, 22);
            this.answer4Label.TabIndex = 6;
            this.answer4Label.Text = "Answer4Label";
            this.answer4Label.Visible = false;
            this.answer4Label.Click += new System.EventHandler(this.answer4Label_Click);
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.Location = new System.Drawing.Point(514, 182);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(15, 14);
            this.checkBox1.TabIndex = 7;
            this.checkBox1.UseVisualStyleBackColor = true;
            this.checkBox1.Visible = false;
            // 
            // checkBox2
            // 
            this.checkBox2.AutoSize = true;
            this.checkBox2.Location = new System.Drawing.Point(514, 226);
            this.checkBox2.Name = "checkBox2";
            this.checkBox2.Size = new System.Drawing.Size(15, 14);
            this.checkBox2.TabIndex = 8;
            this.checkBox2.UseVisualStyleBackColor = true;
            this.checkBox2.Visible = false;
            // 
            // checkBox3
            // 
            this.checkBox3.AutoSize = true;
            this.checkBox3.Location = new System.Drawing.Point(514, 270);
            this.checkBox3.Name = "checkBox3";
            this.checkBox3.Size = new System.Drawing.Size(15, 14);
            this.checkBox3.TabIndex = 9;
            this.checkBox3.UseVisualStyleBackColor = true;
            this.checkBox3.Visible = false;
            // 
            // checkBox4
            // 
            this.checkBox4.AutoSize = true;
            this.checkBox4.Location = new System.Drawing.Point(514, 313);
            this.checkBox4.Name = "checkBox4";
            this.checkBox4.Size = new System.Drawing.Size(15, 14);
            this.checkBox4.TabIndex = 10;
            this.checkBox4.UseVisualStyleBackColor = true;
            this.checkBox4.Visible = false;
            // 
            // restartButton
            // 
            this.restartButton.BackColor = System.Drawing.Color.DarkTurquoise;
            this.restartButton.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center;
            this.restartButton.Font = new System.Drawing.Font("Jokerman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.restartButton.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.restartButton.Location = new System.Drawing.Point(514, 459);
            this.restartButton.Name = "restartButton";
            this.restartButton.Size = new System.Drawing.Size(167, 60);
            this.restartButton.TabIndex = 11;
            this.restartButton.Text = "RESTART";
            this.restartButton.UseVisualStyleBackColor = false;
            this.restartButton.Visible = false;
            this.restartButton.Click += new System.EventHandler(this.restartButton_Click);
            // 
            // addFrageButton
            // 
            this.addFrageButton.BackColor = System.Drawing.Color.Black;
            this.addFrageButton.Font = new System.Drawing.Font("Jokerman", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.addFrageButton.ForeColor = System.Drawing.Color.DarkTurquoise;
            this.addFrageButton.Location = new System.Drawing.Point(117, 459);
            this.addFrageButton.Name = "addFrageButton";
            this.addFrageButton.Size = new System.Drawing.Size(149, 60);
            this.addFrageButton.TabIndex = 12;
            this.addFrageButton.Text = "Neue Frage? ";
            this.addFrageButton.UseVisualStyleBackColor = false;
            this.addFrageButton.Click += new System.EventHandler(this.addFrageButton_Click);
            // 
            // istRichtigLabel
            // 
            this.istRichtigLabel.AutoSize = true;
            this.istRichtigLabel.BackColor = System.Drawing.Color.Turquoise;
            this.istRichtigLabel.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.istRichtigLabel.Location = new System.Drawing.Point(69, 133);
            this.istRichtigLabel.Name = "istRichtigLabel";
            this.istRichtigLabel.Size = new System.Drawing.Size(67, 22);
            this.istRichtigLabel.TabIndex = 13;
            this.istRichtigLabel.Text = "Richtig:";
            this.istRichtigLabel.Visible = false;
            this.istRichtigLabel.Click += new System.EventHandler(this.label1_Click);
            // 
            // istFalschLabel
            // 
            this.istFalschLabel.AutoSize = true;
            this.istFalschLabel.BackColor = System.Drawing.Color.Turquoise;
            this.istFalschLabel.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.istFalschLabel.Location = new System.Drawing.Point(69, 165);
            this.istFalschLabel.Name = "istFalschLabel";
            this.istFalschLabel.Size = new System.Drawing.Size(60, 22);
            this.istFalschLabel.TabIndex = 14;
            this.istFalschLabel.Text = "Falsch:";
            this.istFalschLabel.Visible = false;
            // 
            // frgbID
            // 
            this.frgbID.AutoSize = true;
            this.frgbID.BackColor = System.Drawing.Color.Turquoise;
            this.frgbID.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.frgbID.Location = new System.Drawing.Point(69, 248);
            this.frgbID.Name = "frgbID";
            this.frgbID.Size = new System.Drawing.Size(130, 22);
            this.frgbID.TabIndex = 15;
            this.frgbID.Text = "FragenbogenID:";
            this.frgbID.Visible = false;
            // 
            // frgNummerLabel
            // 
            this.frgNummerLabel.AutoSize = true;
            this.frgNummerLabel.BackColor = System.Drawing.Color.Turquoise;
            this.frgNummerLabel.Font = new System.Drawing.Font("Palatino Linotype", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.frgNummerLabel.Location = new System.Drawing.Point(69, 206);
            this.frgNummerLabel.Name = "frgNummerLabel";
            this.frgNummerLabel.Size = new System.Drawing.Size(179, 22);
            this.frgNummerLabel.TabIndex = 16;
            this.frgNummerLabel.Text = "FragenbogenNummer:";
            this.frgNummerLabel.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.AliceBlue;
            this.ClientSize = new System.Drawing.Size(1269, 692);
            this.Controls.Add(this.frgNummerLabel);
            this.Controls.Add(this.frgbID);
            this.Controls.Add(this.istFalschLabel);
            this.Controls.Add(this.istRichtigLabel);
            this.Controls.Add(this.addFrageButton);
            this.Controls.Add(this.checkBox4);
            this.Controls.Add(this.checkBox3);
            this.Controls.Add(this.checkBox2);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.answer4Label);
            this.Controls.Add(this.answer1Label);
            this.Controls.Add(this.answer2Label);
            this.Controls.Add(this.answer3Label);
            this.Controls.Add(this.fragenLabel);
            this.Controls.Add(this.nextButton);
            this.Controls.Add(this.startButton);
            this.Controls.Add(this.restartButton);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "Form1";
            this.Text = "FRAGENBOGEN";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button startButton;
        private System.Windows.Forms.Button nextButton;
        private System.Windows.Forms.Label fragenLabel;
        private System.Windows.Forms.Label answer3Label;
        private System.Windows.Forms.Label answer2Label;
        private System.Windows.Forms.Label answer1Label;
        private System.Windows.Forms.Label answer4Label;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.CheckBox checkBox2;
        private System.Windows.Forms.CheckBox checkBox3;
        private System.Windows.Forms.CheckBox checkBox4;
        private System.Windows.Forms.Button restartButton;
        private System.Windows.Forms.Button addFrageButton;
        private System.Windows.Forms.Label istRichtigLabel;
        private System.Windows.Forms.Label istFalschLabel;
        private System.Windows.Forms.Label frgbID;
        private System.Windows.Forms.Label frgNummerLabel;
    }
}

