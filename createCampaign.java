//package EventManagementSystem;

import com.sun.glass.events.ViewEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class createCampaign extends JFrame implements ActionListener{

    public JFrame cohome;
    JPanel campaign;
    JTextField campaignNo,clgName,memb1,memb2,date,city;
    JButton create,cCampaign,vParticipant,vEvent,vSubEvent,cologin;
    createCampaign(){
        cohome =new JFrame();

        //JFrame home;
        JLabel image;
        JPanel taskbar;
        JButton admin,cmember,cregister,coordinator,plogin;

        JPanel header=new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(118,178,199));
        header.setBounds(0,0,1900,150);
        cohome.add(header);

        Icon i=new ImageIcon("G:\\sem 5 Btech\\java project\\rit.png");
        image=new JLabel(i);
        image.setBounds(10,10,200,160);
        header.add(image);

        JLabel name=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
        name.setFont(new Font("Times New Roman",Font.BOLD,47));
        name.setForeground(Color.white);
        name.setBounds(400,50,1400,60);
        header.add(name);

        JPanel footer=new JPanel();
        footer.setBackground(new Color(118,178,199));
        footer.setBounds(0,750,1600,30);
        cohome.add(footer);
        JLabel f=new JLabel("Event Management System",JLabel.CENTER);
        f.setFont(new Font("Times New Roman",Font.BOLD,15));
        f.setForeground(Color.white);
        f.setBounds(0,785,200,20);
        footer.add(f);


        //for Menus
        taskbar=new JPanel();
        taskbar.setBounds(0,150,2000,50);
        taskbar.setBackground(new Color(111,199,202));
        cohome.add(taskbar);

        //create campaign
        cCampaign=new JButton("Create Campaign");
        cCampaign.setFont(new Font("Times New Roman",Font.BOLD,22));
        cCampaign.setBackground(Color.white);
        cCampaign.setBounds(0,185,100,70);
        //cCampaign.addActionListener(this);
        taskbar.add(cCampaign);

        //View Event
        vEvent=new JButton("View Event");
        vEvent.setFont(new Font("Times New Roman",Font.BOLD,22));
        vEvent.setBackground(Color.white);
        vEvent.setBounds(250,185,100,70);
        vEvent.addActionListener(this);
        taskbar.add(vEvent);

        //View SubEvent
        vSubEvent=new JButton("View SubEvent");
        vSubEvent.setFont(new Font("Times New Roman",Font.BOLD,22));
        vSubEvent.setBackground(Color.white);
        vSubEvent.setBounds(500,185,100,70);
        vSubEvent.addActionListener(this);
        taskbar.add(vSubEvent);

        //View Participants
        vParticipant=new JButton("View Participants");
        vParticipant.setFont(new Font("Times New Roman",Font.BOLD,22));
        vParticipant.setBackground(Color.white);
        vParticipant.setBounds(750,185,100,70);
        vParticipant.addActionListener(this);
        taskbar.add(vParticipant);

        //login
        cologin=new JButton("Login");
        cologin.setFont(new Font("Times New Roman",Font.BOLD,22));
        cologin.setBackground(Color.white);
        cologin.setBounds(1300,185,100,70);
        cologin.addActionListener(this);
        taskbar.add(cologin);


        cCampaign.addActionListener(new ActionListener() {
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
                new ViewEventsClass();
            }
        });*/
        vParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewParticipantClass();
            }
        });
        cologin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new coordinatorLogin();
            }
        });

        createCampaign();
        cohome.setLayout(null);
        cohome.setSize(1600,900); //1600,1000
        cohome.setVisible(true);
        cohome.setTitle("Home Page");

    }
    public void createCampaign(){
        //panel creation
        campaign=new JPanel();
        cohome=new JFrame();

        //Heading of the Panel
        JLabel title=new JLabel("Create Campaign");
        title.setFont(new Font("Times New Roman",Font.BOLD,40));
        title.setForeground(Color.BLACK);
        title.setBounds(600,50,800,60);
        campaign.add(title);


        //campaign no
        JLabel camLabel=new JLabel("Campaign No.");
        camLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        camLabel.setForeground(Color.BLACK);
        camLabel.setBounds(530,125,400,60);
        campaign.add(camLabel);

        campaignNo =new JTextField();
        campaignNo.setBounds(530,170,200,30);
        campaign.add(campaignNo);

        //college Name
        JLabel clgLabel=new JLabel("College Name");
        clgLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        clgLabel.setForeground(Color.BLACK);
        clgLabel.setBounds(530,235,400,60);
        campaign.add(clgLabel);

        clgName =new JTextField();
        clgName.setBounds(530,280,200,30);
        campaign.add(clgName);

        //Date//day
        JLabel dayLabel=new JLabel("Date");
        dayLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setBounds(800,125,400,60);
        campaign.add(dayLabel);

        date =new JTextField();
        date.setBounds(800,170,200,30);
        campaign.add(date);

        //City
        JLabel cityLabel=new JLabel("City");
        cityLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        cityLabel.setForeground(Color.BLACK);
        cityLabel.setBounds(530,345,400,60);
        campaign.add(cityLabel);

        city =new JTextField();
        city.setBounds(530,395,200,30);
        campaign.add(city);


        //members
        JLabel membLabel=new JLabel("Members");
        membLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        membLabel.setForeground(Color.BLACK);
        membLabel.setBounds(800,235,400,60);
        campaign.add(membLabel);

        memb1=new JTextField();
        memb1.setBounds(800,280,200,30);
        campaign.add(memb1);

        JLabel memb2Label=new JLabel("Members");
        memb2Label.setFont(new Font("Times New Roman",Font.BOLD,20));
        memb2Label.setForeground(Color.BLACK);
        memb2Label.setBounds(800,345,400,60);
        campaign.add(memb2Label);

        memb2 =new JTextField();
        memb2.setBounds(800,395,200,30);
        campaign.add(memb2);

        create=new JButton("Create");
        create.setBounds(690,480,140,30);

        campaign.add(create);

        campaign.setLayout(null);
        campaign.setBackground(new Color(1f,0f,0f,.5f));
        campaign.setBounds(0,180,1900,900);
        campaign.setVisible(true);
        cohome.add(campaign);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button=e.getActionCommand();
        String clgname,day,mem1,mem2,ct;
        int cno;

        if (button.equals(cologin)) {
            cohome.dispose();
            new coordinatorLogin();

        } else if (button.equals(cCampaign)) {
            cohome.dispose();
            new createCampaign();
        } else if (button.equals(vEvent)) {
            cohome.dispose();
            new ViewEventsClass();
        } /*else if (button.equals(vSubEvent)) {
            cohome.dispose();
            new ViewEvent();

        }*/ else if (button.equals(vParticipant)) {
            cohome.dispose();
            new ViewParticipantClass();

        } else if (button.equals(create)) {
            try{
                Class.forName("com.mysql,jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/EvenManagementSystem","root","");
                //Statement stmt=con.createStatement();
                String q="insert into campaign (cno,clgname,city,day,member1,member2) values (?,?,?,?)";
                PreparedStatement stmt=con.prepareStatement(q);

                cno= Integer.parseInt(campaignNo.getText().toString());
                clgname=clgName.getText().toString();
                ct=city.getText().toString();
                day=date.getText().toString();
                mem1=memb1.getText().toString();
                mem2=memb2.getText().toString();


                stmt.setInt(1, cno);
                stmt.setString(2,clgname );
                stmt.setString(3, ct);
                stmt.setString(4, day);
                stmt.setString(5, mem1);
                stmt.setString(6, mem2);
                stmt.executeUpdate();



            }catch (Exception ee){
                System.out.println(ee.getMessage());
            }
        }
    }
}
