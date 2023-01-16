using PetClinicServiceNamespace;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PetClinicDesctop
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void buttonLoadClients_Click(object sender, EventArgs e)
        {
            PetClinicServiceClient petClinicServiceClient = new PetClinicServiceClient("http://localhost:5083", new System.Net.Http.HttpClient());
            ICollection<Client> clients = petClinicServiceClient.GetAllAllAsync().Result;
            
            listViewClients.Items.Clear();
            foreach (Client client in clients)
            {
                ListViewItem item = new ListViewItem();
                item.Text = client.ClientId.ToString();
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                { 
                    Text = client.SurName                
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.FirstName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Patronymic
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Birthday.ToString()
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Document
                });
                listViewClients.Items.Add(item);
            }
        }
    }
}
