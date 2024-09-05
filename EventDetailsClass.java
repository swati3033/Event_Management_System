import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

class EventClass implements ActionListener
{
    JFrame profile;
    JPanel headerp,footerp;
    JLabel imagep,namep,pt,up,um,ull,gt,cl,cd,mn,el,fp;
    JTextField fname,mname,lname,cn,cdt,mt,et;
    Icon ip;
    JComboBox jcb,jcbt;
    JButton ABtn,backBtn,RBtn,UBtn;
    JTable jtable;
    EventClass()
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

            //update profile form

            pt=new JLabel("Add Event Details");
            pt.setFont(new Font("Rockwell",Font.BOLD,30));
            pt.setBounds(820,200,300,100);
            profile.add(pt);

            up=new JLabel("Event name:",JLabel.LEFT);
            up.setBounds(720,310,200,45);
            up.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(up);

            fname=new JTextField();
            fname.setBounds(900,310,250,45);
            fname.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(fname);

            um=new JLabel("Event Type:",JLabel.LEFT);
            um.setBounds(720,380,200,45);
            um.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(um);

            String types[]={"Conference", "Seminar", "Technical", "Non-technical"};
            jcb=new JComboBox(types);
            jcb.setFont(new Font("Times New Roman",Font.BOLD,18));
            jcb.setBounds(900,380,250,45);
            profile.add(jcb);

            ull=new JLabel("SubEvent name:",JLabel.LEFT);
            ull.setBounds(720,450,200,45);
            ull.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(ull);

            lname=new JTextField();
            lname.setBounds(900,450,250,45);
            lname.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(lname);

            //gender
            gt=new JLabel("Location:",JLabel.LEFT);
            gt.setFont(new Font("Times New Roman",Font.BOLD,25));
            gt.setBounds(720,520,120,40);
            profile.add(gt);

            mname=new JTextField();
            mname.setBounds(900,520,250,40);
            mname.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(mname);

            cl=new JLabel("Amount to pay:",JLabel.LEFT);
            cl.setBounds(720,580,200,45);
            cl.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(cl);

            cn=new JTextField();
            cn.setBounds(900,580,250,45);
            cn.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(cn);

            cd=new JLabel("Date:",JLabel.LEFT);
            cd.setBounds(720,650,200,45);
            cd.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(cd);

            cdt=new JTextField();
            cdt.setBounds(900,650,250,45);
            cdt.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(cdt);

            mn=new JLabel("Time:",JLabel.LEFT);
            mn.setBounds(720,710,200,45);
            mn.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(mn);

            String time[]={"10:00 am","11:00 am","12:00 pm","01:00 pm","02:00 pm","03:00 pm","04:00 pm","05:00 pm"};
            jcbt=new JComboBox(time);
            jcbt.setFont(new Font("Times New Roman",Font.BOLD,18));
            jcbt.setBounds(900,710,250,45);
            profile.add(jcbt);

            /*mt=new JTextField();
            mt.setBounds(900,710,250,45);
            mt.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(mt);*/

            el=new JLabel("Department:",JLabel.LEFT);
            el.setBounds(720,770,200,45);
            el.setFont(new Font("Times New Roman",Font.BOLD,25));
            profile.add(el);

            et=new JTextField();
            et.setBounds(900,770,250,45);
            et.setFont(new Font("Times New Roman",Font.BOLD,20));
            profile.add(et);

            ABtn=new JButton("Add");
            ABtn.setFont(new Font("Times New Roman",Font.BOLD,23));
            ABtn.setBackground(new Color(204,204,204));
            ABtn.setBounds(800,840,100,40);
            ABtn.addActionListener(this);
            profile.add(ABtn);

            /*UBtn=new JButton("Update");
            UBtn.setFont(new Font("Times New Roman",Font.BOLD,23));
            UBtn.setBackground(new Color(204,204,204));
            UBtn.setBounds(850,840,130,40);
            UBtn.addActionListener(this);
            profile.add(UBtn);

            RBtn=new JButton("Delete");
            RBtn.setFont(new Font("Times New Roman",Font.BOLD,23));
            RBtn.setBackground(new Color(204,204,204));
            RBtn.setBounds(1000,840,130,40);
            RBtn.addActionListener(this);
            profile.add(RBtn);*/

            backBtn=new JButton("Back");
            backBtn.setFont(new Font("Times New Roman",Font.BOLD,23));
            backBtn.setBackground(new Color(204,204,204));
            backBtn.setBounds(960,840,100,40);
            backBtn.addActionListener(this);
            profile.add(backBtn);

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

            /*jtable.setBounds(100,100,133,455);
            profile.add(jtable);*/

            profile.setLayout(null);
            profile.setSize(2000,1350); //1600,1000
            profile.setVisible(true);
            profile.setTitle("Update Profile");

    }

        public void insertEventDetails()
        {
                try
                {
                        //loads/register the driver in program
                        Class.forName("com.mysql.jdbc.Driver");	//1

                        //establish connection with the database
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

                        // (query for insertion operation)
                        String insertQuery="insert into event_details( e_name,e_type,subevent_name,location,amount,date,time,department)values(?,?,?,?,?,?,?,?)";

                        //create statement using PreparedStatement
                        PreparedStatement pstmt=con.prepareStatement(insertQuery);

                        pstmt.setString(1,fname.getText());
                        String cb=jcb.getSelectedItem().toString();
                        pstmt.setString(2,cb);
                        pstmt.setString(3,lname.getText());
                        pstmt.setString(4,mname.getText());
                        pstmt.setString(5,cn.getText());
                        pstmt.setString(6,cdt.getText());
                        String tm=jcb.getSelectedItem().toString();
                        pstmt.setString(7,tm);
                        pstmt.setString(8,et.getText());

                        int status=pstmt.executeUpdate();	//execute query using executeUpdate() method

                        if(status==1)
                        {
                                JOptionPane.showMessageDialog(null,"Data Inserted Successfully");	//displays message to user
                        }
                        else
                        {
                                JOptionPane.showMessageDialog(null,"Data has not been Inserted Successfully");
                        }

                        con.close();
                }

                catch(Exception exp)
                {
                        System.out.println(exp);
                }

        }




               /* public ArrayList<User> userList() {
                        ArrayList<User> userList = new ArrayList<>();
                        try {
                                //loads/register the driver in program
                                Class.forName("com.mysql.jdbc.Driver");    //1

                                //establish connection with the database
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/event_management", "root", "");

                                String query="select * from event_details";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(query);

                                User user;
                                while(rs.next()){
                                        user=new User(rs.getInt("eid"),rs.getString("e_name"),rs.getString("e_type"),rs.getString("subevent_name"),rs.getString("location"),rs.getString("amount"),rs.getString("date"),rs.getString("time"),rs.getString("department"));
                                        userList.add(user);
                                }

                        } catch (Exception exp) {
                                System.out.println(exp);
                        }

                        return userList;
                }


        public void showEvents()
        {
               ArrayList<User> list=userList();
                DefaultTableModel model=(DefaultTableModel)jtable.getModel();
                Object[] row=new Object[9];
                for(int i=0;i<list.size();i++)
                {
                        row[0]=list.get(i).geteno();
                        row[1]=list.get(i).getname();
                        row[2]=list.get(i).gettype();
                        row[3]=list.get(i).getsub();
                        row[4]=list.get(i).getloc();
                        row[5]=list.get(i).getamt();
                        row[6]=list.get(i).getDatee();
                        row[7]=list.get(i).gettimee();
                        row[8]=list.get(i).getDept();
                        model.addRow(row);
                }
        }*/


    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==backBtn)
        {
            profile.setVisible(false);
            EventManagement et=new EventManagement();
            et.cmemberTask();
        }
        if(evt.getSource()==ABtn)
        {
                insertEventDetails();
        }
    }
}

public class EventDetailsClass
{
    public static void main(String[] args) {
        new EventClass();
    }
}
