// package EventManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class coordinatorLogin extends JFrame implements ActionListener {
    public JFrame cohome;
    JPanel login;
    JTextField coUname;

    JPasswordField coPasswd;

    JButton clogin, reset, create, cologin, vEvent, vSubEvent, vParticipant,backk;
    JButton cCampaign;

    coordinatorLogin() {
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
        /*cCampaign = new JButton("Create Campaign");
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
        vSubEvent = new JButton("View SubEvent");
        vSubEvent.setFont(new Font("Times New Roman", Font.BOLD, 22));
        vSubEvent.setBackground(Color.white);
        vSubEvent.setBounds(500, 185, 100, 70);
        vSubEvent.addActionListener(this);
        taskbar.add(vSubEvent);

        //View Participants
        vParticipant = new JButton("View Participants");
        vParticipant.setFont(new Font("Times New Roman", Font.BOLD, 22));
        vParticipant.setBackground(Color.white);
        vParticipant.setBounds(750, 185, 100, 70);
        vParticipant.addActionListener(this);
        taskbar.add(vParticipant);*/

        //login
        backk = new JButton("Back");
        backk.setFont(new Font("Times New Roman", Font.BOLD, 22));
        backk.setBackground(Color.white);
        backk.setBounds(1300, 185, 100, 70);
        backk.addActionListener(this);
        taskbar.add(backk);

        /*cCampaign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new createCampaign();
            }
        });
       vEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEventsClass();
            }
        });
        /*vSubEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ();
            }
        });
        vParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewParticipantClass();
            }
        });*/
        backk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new coordinatorLogin();
            }
        });
        coLogin();
        cohome.setLayout(null);
        cohome.setSize(1600, 900); //1600,1000
        cohome.setVisible(true);
        cohome.setTitle("Home Page");


    }

    public void coLogin() {
        //Login Panel
        login = new JPanel();

        //Heading of the Panel
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setForeground(Color.BLACK);
        title.setBounds(730, 100, 800, 60);
        login.add(title);

        //Username Label
        JLabel ulabel = new JLabel("Username");
        ulabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        ulabel.setForeground(Color.BLACK);
        ulabel.setBounds(690, 200, 400, 60);
        login.add(ulabel);

        //Textfield to take Username
        coUname = new JTextField();
        coUname.setBounds(690, 250, 200, 30);
        coUname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        login.add(coUname);

        //Password Label
        JLabel passlabel = new JLabel("Password");
        passlabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        passlabel.setForeground(Color.BLACK);
        passlabel.setBounds(690, 315, 400, 60);
        login.add(passlabel);

        //passwordfield to password
        coPasswd = new JPasswordField();
        coPasswd.setBounds(690, 365, 200, 30);
        coPasswd.setFont(new Font("Times New Roman", Font.BOLD, 20));
        login.add(coPasswd);

        //Button
        clogin = new JButton("Login");
        clogin.setBounds(690, 450, 90, 30);
        clogin.addActionListener(this);
        login.add(clogin);

        reset = new JButton("Reset");
        reset.setBounds(800, 450, 90, 30);
        reset.addActionListener(this);
        login.add(reset);


        login.setLayout(null);
        //login.setBackground(new Color(1f, 0f, 0f, .5f));
        login.setBounds(0, 180, 1900, 900);
        login.setVisible(true);
        cohome.add(login);
    }

    public void checkCoordinatorLogin()
    {
        try
        {
            //loads/register the driver in program
            Class.forName("com.mysql.jdbc.Driver");	//1

            //establish connection with the database
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

            // (query for authenticating commitee members)

            String cname=coUname.getText();
            String cpwd=coPasswd.getText();

            String selectQuery="select * from cregister where uname='"+cname+"' and pass='"+cpwd+"'";

            //create statement using PreparedStatement
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery(selectQuery);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Login Successfull!!");
                new CoordinatorTask();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid username or password !!");
                coUname.setText(" ");
                coPasswd.setText(" ");
            }

            con.close();
        }

        catch(Exception exp)
        {
            System.out.println(exp);
        }

    }


    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==backk)
        {
            cohome.setVisible(false);
            new EventManagement();
        }
        if(evt.getSource()==reset)
        {
            coUname.setText(" ");
            coPasswd.setText(" ");
        }
        if(evt.getSource()==clogin)
        {
            checkCoordinatorLogin();
            cohome.setVisible(false);
        }
    }

}

