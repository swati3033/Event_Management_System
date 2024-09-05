import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

class DisplayEvent implements ActionListener, MouseListener
{
    JFrame profile;
    JPanel headerp,footerp,bar;
    Icon ip;
    JLabel imagep,namep,fp,idd;
    JButton b,dBtn;

    DefaultTableModel dtm;
    JTable jtbl;
    JScrollPane jpn;//end displayData
    //JFrame profile;
    //JPanel headerp,footerp;
    JLabel pt,up,um,ull,gt,cl,cd,mn,el;
    JTextField fname,mname,lname,cn,cdt,mt,et,jid,loname;
    //Icon ip;
    JComboBox jcb;
    JButton ABtn,backBtn,RBtn,UBtn;
    DisplayEvent()
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

        idd=new JLabel("Event id:",JLabel.LEFT);
        idd.setBounds(1350,240,200,45);
        idd.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(idd);

        jid=new JTextField();
        jid.setBounds(1550,240,250,45);
        jid.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(jid);

        up=new JLabel("Event name:",JLabel.LEFT);
        up.setBounds(1350,310,200,45);
        up.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(up);

        fname=new JTextField();
        fname.setBounds(1550,310,250,45);
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(fname);

        um=new JLabel("Event Type:",JLabel.LEFT);
        um.setBounds(1350,380,200,45);
        um.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(um);

        mname=new JTextField();
        mname.setBounds(1550,380,250,45);
        mname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(mname);

        /*String types[]={"Conference", "Seminar", "Technical", "Non-technical"};
        jcb=new JComboBox(types);
        jcb.setFont(new Font("Times New Roman",Font.BOLD,18));
        jcb.setBounds(900,380,250,45);
        profile.add(jcb);*/

        ull=new JLabel("SubEvent name:",JLabel.LEFT);
        ull.setBounds(1350,450,200,45);
        ull.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(ull);

        lname=new JTextField();
        lname.setBounds(1550,450,250,45);
        lname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(lname);

        //gender
        gt=new JLabel("Location:",JLabel.LEFT);
        gt.setFont(new Font("Times New Roman",Font.BOLD,25));
        gt.setBounds(1350,520,120,40);
        profile.add(gt);

        loname=new JTextField();
        loname.setBounds(1550,520,250,40);
        loname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(loname);

        cl=new JLabel("Amount to pay:",JLabel.LEFT);
        cl.setBounds(1350,580,200,45);
        cl.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(cl);

        cn=new JTextField();
        cn.setBounds(1550,580,250,45);
        cn.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(cn);

        cd=new JLabel("Date:",JLabel.LEFT);
        cd.setBounds(1350,650,200,45);
        cd.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(cd);

        cdt=new JTextField();
        cdt.setBounds(1550,650,250,45);
        cdt.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(cdt);

        mn=new JLabel("Time:",JLabel.LEFT);
        mn.setBounds(1350,710,200,45);
        mn.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(mn);

        mt=new JTextField();
        mt.setBounds(1550,710,250,45);
        mt.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(mt);

        el=new JLabel("Department:",JLabel.LEFT);
        el.setBounds(1350,770,200,45);
        el.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(el);

        et=new JTextField();
        et.setBounds(1550,770,250,45);
        et.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(et);

        ABtn=new JButton("Update");
        ABtn.setFont(new Font("Times New Roman",Font.BOLD,23));
        ABtn.setBackground(new Color(204,204,204));
        ABtn.setBounds(1350,840,130,40);
        ABtn.addActionListener(this);
        profile.add(ABtn);

        dBtn=new JButton("Delete");
        dBtn.setFont(new Font("Times New Roman",Font.BOLD,23));
        dBtn.setBackground(new Color(204,204,204));
        dBtn.setBounds(1550,840,100,40);
        dBtn.addActionListener(this);
        profile.add(dBtn);

        //Displaying data of participants

        dtm=new DefaultTableModel();

        jtbl=new JTable(dtm);
        jtbl.setBounds(100,270,100,100);
        jtbl.setPreferredScrollableViewportSize(new Dimension(1100,600));
        jtbl.setFillsViewportHeight(true);
        jtbl.setBackground(new Color(204,204,204));
        jpn=new JScrollPane(jtbl);
        jpn.setBounds(100,270,1100,600);
        jtbl.addMouseListener(this);
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
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

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
                dtm.addRow(new Object[]{ptid, namestr, estr,enamestr, emailstr, intamt, inttid, time, dept});
            }
        }
        catch(Exception exp)
        {
            System.out.println(exp);
        }



        /*private void jtblMouseClicked(java.awt.event.MouseEvent evtt)
        {
            int i = jtbl.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) jtbl.getModel();
            name.setText(model.getValueAt(i, 0).toString());
            quantity.setText(model.getValueAt(i, 1).toString());
            price.setText(model.getValueAt(i, 2).toString());

    }*/


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
            et.cmemberTask();
            //home.setVisible();
        }
        if(evt.getSource()==dBtn)
        {
            deleteCampaign();
            new DisplayEvent();
        }
        if(evt.getSource()==ABtn)
        {
            updateRecords();
            new DisplayEvent();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int i = jtbl.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbl.getModel();
        jid.setText(model.getValueAt(i, 0).toString());
        fname.setText(model.getValueAt(i, 1).toString());
        mname.setText(model.getValueAt(i, 2).toString());
        lname.setText(model.getValueAt(i, 3).toString());
        loname.setText(model.getValueAt(i, 4).toString());
        cn.setText(model.getValueAt(i, 5).toString());
        cdt.setText(model.getValueAt(i, 6).toString());
        mt.setText(model.getValueAt(i, 7).toString());
        et.setText(model.getValueAt(i, 8).toString());

    }

    public void updateRecords()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management", "root", "");
            Statement stmt = con.createStatement();
            ///need to change column
            String eid=jid.getText();
            String ename=fname.getText();
            String etype=mname.getText();
            String esub=lname.getText();
            String loc=loname.getText();
            String amt=cn.getText();
            String datee=cdt.getText();
            String timee=mt.getText();
            String departt=et.getText();


            String query="update event_details set e_name='"+ename+"',e_type='"+etype+"',subevent_name='"+esub+"',location='"+loc+"',amount='"+amt+"',date='"+datee+"',time='"+timee+"',department='"+departt+"' where e_id="+eid;
            //int status= stmt.executeUpdate("update campaign set clgName=" + clgName.getText() + "','" + city.getText() + "','" + date.getText() + "','" + memb1.getText() + "','" + memb2.getText()+"'where cno=no");
            int status=stmt.executeUpdate(query);
            if(status==1){
                JOptionPane.showMessageDialog(null,"Data Updated Successfully!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCampaign() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management", "root", "");
            Statement stmt = con.createStatement();
            int r = JOptionPane.showConfirmDialog(null, "Are you sure delete selected row?");
            int no=Integer.parseInt(jid.getText().toString());
            int status=stmt.executeUpdate("delete from event_details where e_id=" + no);
            if(status==1){
                JOptionPane.showMessageDialog(null,"Record Deleted Successfully!!");
            }
        } catch (SQLException ev) {
            throw new RuntimeException(ev);
        } catch (ClassNotFoundException ev) {
            throw new RuntimeException(ev);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

public class EventDisplay
{
    public static void main(String[] args) {
        new DisplayEvent();
    }
}




