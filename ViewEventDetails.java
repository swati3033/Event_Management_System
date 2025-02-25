import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;


class ViewEventsClass implements ActionListener
{
    JFrame profile;
    JPanel headerp,footerp,bar;
    Icon ip;
    JLabel imagep,namep,fp;
    JButton b;

    DefaultTableModel dtm;
    JTable jtbl;
    JScrollPane jpn;//end displayData
    ViewEventsClass()
    {
        profile=new JFrame();

        headerp=new JPanel();
        headerp.setLayout(null);
        headerp.setBackground(new Color(118,178,199));		//51,153,255
        headerp.setBounds(0,0,2000,180);
        profile.add(headerp);

        ip=new ImageIcon("D:/EventMgt/rit.png");
        imagep=new JLabel(ip);
        imagep.setBounds(10,10,200,160);
        headerp.add(imagep);

        namep=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
        namep.setFont(new Font("Times New Roman",Font.BOLD,50));
        namep.setForeground(Color.white);
        namep.setBounds(400,50,1400,60);
        headerp.add(namep);

        //for buttons
        bar=new JPanel();
        bar.setBounds(0,180,2000,50);
        bar.setBackground(new Color(111,199,202));
        profile.add(bar);
        //admin login
        b=new JButton("Back");
        b.setFont(new Font("Times New Roman",Font.BOLD,25));
        b.setBackground(Color.white);
        b.setBounds(550,185,100,70);
        b.addActionListener(this);
        bar.add(b);

        //Displaying data of participants

        dtm=new DefaultTableModel();

        jtbl=new JTable(dtm);
        jtbl.setBounds(100,270,1400,600);
        jtbl.setPreferredScrollableViewportSize(new Dimension(1400,600));
        jtbl.setFillsViewportHeight(true);
        jtbl.setBackground(new Color(204,204,204));
        jpn=new JScrollPane(jtbl);
        jpn.setBounds(100,270,1400,600);
        profile.add(jpn);

        //added column to table
        dtm.addColumn("Event_ID");
        dtm.addColumn("Event name");
        dtm.addColumn("Event type");
        dtm.addColumn("SubEvent name");
        dtm.addColumn("location");
        dtm.addColumn("amount");
        dtm.addColumn("date");
        dtm.addColumn("time");
        dtm.addColumn("department");


        try
        {
            //loads/register the driver in program
            Class.forName("com.mysql.jdbc.Driver");	//1

            //establish connection with the database
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

            //query for display data from database
            String displayQuery="select * from event_details";

            Statement stmt=con.createStatement(); 		//create query

            ResultSet rs=stmt.executeQuery(displayQuery);	//execute query

            //fetching data from database
            while(rs.next())
            {
                int ptid=rs.getInt("e_id");
                String namestr=rs.getString("e_name");
                String estr=rs.getString("e_type");
                String enamestr=rs.getString("subevent_name");
                String emailstr=rs.getString("location");
                int intamt=rs.getInt("amount");
                String inttid=rs.getString("date");
                String time=rs.getString("time");
                String dept=rs.getString("department");


                //adding row in table
                dtm.addRow(new Object[]{ptid, namestr, estr, estr, enamestr, emailstr, intamt, inttid, time, dept});
            }
        }
        catch(Exception exp)
        {
            System.out.println(exp);
        }


        //****************

        footerp=new JPanel();
        footerp.setBackground(new Color(118,178,199));
        footerp.setBounds(0,900,2000,30);
        profile.add(footerp);
        fp=new JLabel("Event Management System",JLabel.CENTER);
        fp.setFont(new Font("Times New Roman",Font.BOLD,15));
        fp.setForeground(Color.white);
        fp.setBounds(0,785,200,20);
        footerp.add(fp);

        profile.setLayout(null);
        profile.setSize(2000,1350); //1600,1000
        profile.setVisible(true);
        profile.setTitle("Update Profile");

    }



    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==b)
        {
            profile.setVisible(false);
            EventManagement et=new EventManagement();
            et.adminTask();
            //home.setVisible();
        }/*
        if(evt.getSource()==ABtn)
        {
            insertParticipantDetails();
        }*/
    }
}

public class ViewEventDetails
{
    public static void main(String[] args) {
        new ViewEventsClass();
    }
}



