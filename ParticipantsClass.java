import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class ParticipantRegisterClass implements ActionListener
{
    JFrame profile;
    JPanel headerp,footerp;
    JLabel imagep,namep,pt,up,um,ull,gt,cl,cd,mn,el,fp;
    JTextField fname,mname,lname,cn,cdt,mt,et;
    Icon ip;
    JComboBox jcb;
    JButton ABtn,backBtn,RBtn,UBtn;
    ParticipantRegisterClass()
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

        pt=new JLabel("Register for Event");
        pt.setFont(new Font("Rockwell",Font.BOLD,30));
        pt.setBounds(820,200,300,100);
        profile.add(pt);

        up=new JLabel("Participant name:",JLabel.LEFT);
        up.setBounds(720,310,200,45);
        up.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(up);

        fname=new JTextField();
        fname.setBounds(930,310,250,45);
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(fname);

        um=new JLabel("Collage Name:",JLabel.LEFT);
        um.setBounds(720,380,200,45);
        um.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(um);

        lname=new JTextField();
        lname.setBounds( 930,380,250,45);
        lname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(lname);


        ull=new JLabel("Event Type:",JLabel.LEFT);
        ull.setBounds(720,450,200,45);
        ull.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(ull);

        String types[]={"Conference", "Seminar", "Technical", "Non-technical"};
        jcb=new JComboBox(types);
        jcb.setFont(new Font("Times New Roman",Font.BOLD,18));
        jcb.setBounds(930,450,250,45 );
        profile.add(jcb);

        gt=new JLabel("Event Name:",JLabel.LEFT);
        gt.setFont(new Font("Times New Roman",Font.BOLD,25));
        gt.setBounds(720,520,150,40);
        profile.add(gt);

        mname=new JTextField();
        mname.setBounds(930,520,250,40);
        mname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(mname);

        cl=new JLabel("Email:",JLabel.LEFT);
        cl.setBounds(720,580,200,45);
        cl.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(cl);

        cn=new JTextField();
        cn.setBounds(930,580,250,45);
        cn.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(cn);

        cd=new JLabel("Amount paid:",JLabel.LEFT);
        cd.setBounds(720,650,200,45);
        cd.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(cd);

        cdt=new JTextField();
        cdt.setBounds(930,650,250,45);
        cdt.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(cdt);

        mn=new JLabel("Transaction id:",JLabel.LEFT);
        mn.setBounds(720,710,200,45);
        mn.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(mn);

        mt=new JTextField();
        mt.setBounds(930,710,250,45);
        mt.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(mt);

        /*el=new JLabel("Department:",JLabel.LEFT);
        el.setBounds(720,770,200,45);
        el.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(el);

        et=new JTextField();
        et.setBounds(900,770,250,45);
        et.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(et);*/

        ABtn=new JButton("Register");
        ABtn.setFont(new Font("Times New Roman",Font.BOLD,23));
        ABtn.setBackground(new Color(204,204,204));
        ABtn.setBounds(800,800,130,40);
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
        backBtn.setBounds(960,800,100,40);
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

        profile.setLayout(null);
        profile.setSize(2000,1350); //1600,1000
        profile.setVisible(true);
        profile.setTitle("Update Profile");

    }

    private static boolean isValidEmail(String email) {
        // Email validation using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void insertParticipantDetails()
    {
        String emailid=cn.getText();
        if(isValidEmail(emailid))
        {
            try
            {
                //loads/register the driver in program
                Class.forName("com.mysql.jdbc.Driver");	//1

                //establish connection with the database
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

                // (query for insertion operation)
                String insertQuery="insert into participants(pname,clgname,etype,ename,email,amt,tid)values(?,?,?,?,?,?,?)";

                //create statement using PreparedStatement
                PreparedStatement pstmt=con.prepareStatement(insertQuery);

                pstmt.setString(1,fname.getText());
                pstmt.setString(2,lname.getText());
                String cb=jcb.getSelectedItem().toString();
                pstmt.setString(3,cb);
                pstmt.setString(4,mname.getText());
                pstmt.setString(5,cn.getText());
                pstmt.setString(6,cdt.getText());
                pstmt.setString(7,mt.getText());

                int status=pstmt.executeUpdate();	//execute query using executeUpdate() method

                if(status==1)
                {
                    JOptionPane.showMessageDialog(null,"Registered Successfully");	//displays message to user
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
        else {
            JOptionPane.showMessageDialog(null,"Enter Valid email id!");
            cn.setText(" ");
        }


    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==backBtn)
        {
            profile.setVisible(false);
            EventManagement et=new EventManagement();
            //home.setVisible();
        }
        if(evt.getSource()==ABtn)
        {
            insertParticipantDetails();
        }
    }
}

public class ParticipantsClass
{
    public static void main(String[] args) {
        new ParticipantRegisterClass();
    }
}

