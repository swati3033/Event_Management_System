import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class CoordinatorTask extends JFrame implements ActionListener {
    public JFrame cohome;
    JPanel login;
    JTextField coUname;

    JPasswordField coPasswd;

    JButton clogin, reset, create, cologin, vEvent, vSubEvent, vParticipant, backk;
    JButton cCampaign;

    CoordinatorTask() {
        cohome = new JFrame();

        //JFrame home;
        JLabel image;
        JPanel taskbar;


        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(118, 178, 199));
        header.setBounds(0, 0, 1900, 150);
        cohome.add(header);

        Icon i = new ImageIcon("G:\\sem 5 Btech\\java project\\rit.png");
        image = new JLabel(i);
        image.setBounds(10, 10, 200, 160);
        header.add(image);

        JLabel name = new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
        name.setFont(new Font("Times New Roman", Font.BOLD, 47));
        name.setForeground(Color.white);
        name.setBounds(400, 50, 1400, 60);
        header.add(name);

        JPanel footer = new JPanel();
        footer.setBackground(new Color(118, 178, 199));
        footer.setBounds(0, 750, 1600, 30);
        cohome.add(footer);
        JLabel f = new JLabel("Event Management System", JLabel.CENTER);
        f.setFont(new Font("Times New Roman", Font.BOLD, 15));
        f.setForeground(Color.white);
        f.setBounds(0, 785, 200, 20);
        footer.add(f);


        //for Menus
        taskbar = new JPanel();
        taskbar.setBounds(0, 150, 2000, 50);
        taskbar.setBackground(new Color(111, 199, 202));
        cohome.add(taskbar);

        //create campaign
        cCampaign = new JButton("Create Campaign");
        cCampaign.setFont(new Font("Times New Roman", Font.BOLD, 22));
        cCampaign.setBackground(Color.white);
        cCampaign.setBounds(0, 185, 100, 70);
        cCampaign.addActionListener(this);
        taskbar.add(cCampaign);

        //View Event
        vEvent = new JButton("View Event");
        vEvent.setFont(new Font("Times New Roman", Font.BOLD, 22));
        vEvent.setBackground(Color.white);
        vEvent.setBounds(250, 185, 100, 70);
        vEvent.addActionListener(this);
        taskbar.add(vEvent);

        //View SubEvent

        //View Participants
        vParticipant = new JButton("View Participants");
        vParticipant.setFont(new Font("Times New Roman", Font.BOLD, 22));
        vParticipant.setBackground(Color.white);
        vParticipant.setBounds(750, 185, 100, 70);
        vParticipant.addActionListener(this);
        taskbar.add(vParticipant);

        //login
        backk = new JButton("Logout");
        backk.setFont(new Font("Times New Roman", Font.BOLD, 22));
        backk.setBackground(Color.white);
        backk.setBounds(1300, 185, 100, 70);
        backk.addActionListener(this);
        taskbar.add(backk);

        cohome.setLayout(null);
        cohome.setSize(1600, 900); //1600,1000
        cohome.setVisible(true);
        cohome.setTitle("Home Page");

    }

    public void actionPerformed(ActionEvent evnt)
    {
        if(evnt.getSource()==backk)
        {
            cohome.setVisible(false);
            new EventManagement();
        }
        if(evnt.getSource()==vParticipant)
        {
            cohome.setVisible(false);
            new ViewParticipantCo();
        }
        if(evnt.getSource()==vEvent)
        {
            cohome.setVisible(false);
            new ViewEvents();
        }
        if(evnt.getSource()==cCampaign)
        {
            cohome.setVisible(false);
            new Campaign();
        }

    }
}

public class TaskOfCoordinator
{
    public static void main(String[] args) {
        new CoordinatorTask();
    }
}
