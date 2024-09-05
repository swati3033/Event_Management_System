//package EventManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class coordinatorRegistration extends JFrame implements ActionListener{
    public JFrame cohome;
    JPanel coregister;
    JTextField coUname,fname,mname,lname,mobNo,email;
    JComboBox classname, designation,dept;
    JPasswordField coPasswd;

    JRadioButton male,female;
    ButtonGroup gender;
    JButton register,cologin,vEvent,vSubEvent,vParticipant,cCampaign;
    coordinatorRegistration(){
        //Frame
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
        /*cCampaign=new JButton("Create Campaign");
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
        taskbar.add(vParticipant);*/

        //login
        cologin=new JButton("Back");
        cologin.setFont(new Font("Times New Roman",Font.BOLD,22));
        cologin.setBackground(Color.white);
        cologin.setBounds(1300,185,100,70);
        cologin.addActionListener(this);
        taskbar.add(cologin);

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
        vSubEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new ViewParticipants();
            }
        });
        vParticipant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewParticipants();
            }
        });
        cologin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new coordinatorLogin();
            }
        });*/
        CoordinatorRegistration();
        cohome.setLayout(null);
        cohome.setSize(1600,900); //1600,1000
        cohome.setVisible(true);
        cohome.setTitle("Home Page");


    }

    public void CoordinatorRegistration(){
        coregister=new JPanel();

        ///Heading of the Panel
        JLabel title=new JLabel("Registration");
        title.setFont(new Font("Times New Roman",Font.BOLD,40));
        title.setForeground(Color.BLACK);
        title.setBounds(650,50,800,60);
        coregister.add(title);

        //Username Label
        JLabel ulabel=new JLabel("Username");
        ulabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        ulabel.setForeground(Color.BLACK);
        ulabel.setBounds(150,235,400,60);
        coregister.add(ulabel);

        //Textfield to take Username
        coUname=new JTextField();
        coUname.setBounds(150,280,200,30);
        coUname.setFont(new Font("Times New Roman",Font.BOLD,20));
        coregister.add(coUname);

        //Password Label
        JLabel passlabel=new JLabel("Password");
        passlabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        passlabel.setForeground(Color.BLACK);
        passlabel.setBounds(150,345,400,60);
        coregister.add(passlabel);

        //passwordfield to password
        coPasswd=new JPasswordField();
        coPasswd.setBounds(150,390,200,30);
        coPasswd.setFont(new Font("Times New Roman",Font.BOLD,20));
        coregister.add(coPasswd);



        //First Name
        JLabel fnamelabel=new JLabel("First Name");
        fnamelabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        fnamelabel.setForeground(Color.BLACK);
        fnamelabel.setBounds(150,125,400,60);
        coregister.add(fnamelabel);

        fname=new JTextField();
        fname.setBounds(150,170,200,30);
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        coregister.add(fname);


        //Last Name
        JLabel mnamelabel=new JLabel("Middle Name");
        mnamelabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        mnamelabel.setForeground(Color.BLACK);
        mnamelabel.setBounds(470,125,400,60);
        coregister.add(mnamelabel);

        mname=new JTextField();
        mname.setBounds(470,170,200,30);
        mname.setFont(new Font("Times New Roman",Font.BOLD,20));
        coregister.add(mname);

        //LastName
        JLabel lnamelabel=new JLabel("Last Name");
        lnamelabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        lnamelabel.setForeground(Color.BLACK);
        lnamelabel.setBounds(790,125,400,60);
        coregister.add(lnamelabel);

        lname=new JTextField();
        lname.setBounds(790,170,200,30);
        lname.setFont(new Font("Times New Roman",Font.BOLD,20));
        coregister.add(lname);

        //gender label
        JLabel genderlabel=new JLabel("Gender");
        genderlabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        genderlabel.setForeground(Color.BLACK);
        genderlabel.setBounds(470,235,400,60);
        coregister.add(genderlabel);
        male=new JRadioButton("Male");

        male.setBounds(470,280,90,30);
        female=new JRadioButton("Female");
        female.setBounds(580,280,90,30);
        gender=new ButtonGroup();
        gender.add(male);
        gender.add(female);

        coregister.add(male);
        coregister.add(female);
        //coregister.add(gender);

        //Department
        JLabel deptlabel=new JLabel("Department");
        deptlabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        deptlabel.setForeground(Color.BLACK);
        deptlabel.setBounds(470,345,400,60);
        coregister.add(deptlabel);

        String department[]={"Computer Science And Information Technology","Computer Science Engineering","Artificial Intelligence and Machine Language","Electrical Engineering","Electronics and Telecommunication","Mechanical Engineering","Civil Engineering"};

        dept =new JComboBox(department);
        dept.setBounds(470,390,200,30);
        coregister.add(dept);

        //Designation
        JLabel desilabel=new JLabel("Designation");
        desilabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        desilabel.setForeground(Color.BLACK);
        desilabel.setBounds(790,235,400,60);
        coregister.add(desilabel);

        String desig[]={"Head","Co-lead","Technical head","Non-Technical Head"};

        designation =new JComboBox(desig);
        designation.setBounds(790,280,200,30);
        coregister.add(designation);

        //Class
        JLabel classLabel=new JLabel("Class");
        classLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        classLabel.setForeground(Color.BLACK);
        classLabel.setBounds(790,345,400,60);
        coregister.add(classLabel);


        String classn[]={"FY","SY","TY"};
        classname =new JComboBox(classn);
        classname.setBounds(790,390,200,30);
        coregister.add(classname);

        //Mob no
        JLabel moblabel=new JLabel("Mobile No");
        moblabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        moblabel.setForeground(Color.BLACK);
        moblabel.setBounds(1110,125,400,60);
        coregister.add(moblabel);

        mobNo =new JTextField();
        mobNo.setBounds(1110,170,200,30);
        coregister.add(mobNo);

        //email
        JLabel emailLabel=new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setBounds(1110,235,400,60);
        coregister.add(emailLabel);

        email =new JTextField();
        email.setBounds(1110,280,200,30);
        coregister.add(email);

        //Button
        register=new JButton("Register");
        register.setBounds(520,490,400,30);
        register.setBackground(new Color(204,204,204));
        register.addActionListener(this);
        coregister.add(register);

        coregister.setLayout(null);
        //coregister.setBackground(new Color(1f,0f,0f,.5f));
        coregister.setBounds(0,180,1900,900);
        coregister.setVisible(true);
        cohome.add(coregister);
    }

    private static boolean isValidEmail(String email) {
        // Email validation using regular expression
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidMobileNumber(String mobileNumber) {
        // Define a regular expression for a valid mobile number
        String regex = "^[1-9]\\d{9}$"; // Assumes a 10-digit number starting with a digit from 1 to 9

        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(mobileNumber);

        // Return true if the mobile number matches the pattern
        return matcher.matches();
    }

    public void insertCoordinators()
    {
        String mobileNumber=mobNo.getText();
        String emailid=email.getText();
        if(isValidMobileNumber(mobileNumber) && isValidEmail(emailid))
        {
            try
            {
                //loads/register the driver in program
                Class.forName("com.mysql.jdbc.Driver");	//1

                //establish connection with the database
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

                // (query for insertion operation)
                String insertQuery="insert into cregister(uname,pass,fname,mname,lname,gender,dept,designation,class,mobile_no,email)values(?,?,?,?,?,?,?,?,?,?,?)";

                //create statement using PreparedStatement
                PreparedStatement pstmt=con.prepareStatement(insertQuery);

                pstmt.setString(1,coUname.getText());
                pstmt.setString(2,coPasswd.getText());
                pstmt.setString(3,fname.getText());
                pstmt.setString(4,mname.getText());
                pstmt.setString(5,lname.getText());
                String genderString="";
                if(male.isSelected())
                {
                    genderString="Male";
                }
                if(female.isSelected())
                {
                    genderString="Female";
                }

                pstmt.setString(6,genderString);
                String cb=dept.getSelectedItem().toString();
                pstmt.setString(7,cb);
                String dsgn=designation.getSelectedItem().toString();
                pstmt.setString(8,dsgn);
                String clss=classname.getSelectedItem().toString();
                pstmt.setString(9,clss);
                pstmt.setString(10,mobNo.getText());
                pstmt.setString(11,email.getText());


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
        else {
            JOptionPane.showMessageDialog(null,"Enter Valid Mobile Number or email id!");
            mobNo.setText(" ");
            email.setText(" ");
        }


    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==cCampaign)
        {
            cohome.dispose();
            new createCampaign();

        }
        if(evt.getSource()==vEvent)
        {
            new ViewEventsClass();
        }
        if(evt.getSource()==vParticipant)
        {
            cohome.dispose();
            new ParticipantClass();
        }
        if(evt.getSource()==register)
        {
            insertCoordinators();
        }
        if(evt.getSource()==cologin)
        {
            cohome.setVisible(false);
            new EventManagement();
        }

    }


    public static void main(String args[])
    {
        new coordinatorRegistration();
    }



    /*public void actionPerformed(ActionEvent e) {
        String button=e.getActionCommand();
        if (button.equals(cologin)) {
            cohome.dispose();
            new coordinatorLogin();

        } else if (button.equals(cCampaign)) {
            cohome.dispose();
            new createCampaign();
        } else if (button.equals(vEvent)) {
            cohome.dispose();
            new ViewEventsClass();
        } else if (button.equals(vSubEvent)) {
            cohome.dispose();
            new ViewEventsClass();

        } else if (button.equals(vParticipant)) {
            cohome.dispose();
            new ViewParticipantClass();

        }
        else if (button.equals(register))
        {
            insertCoordinators();

        }
    }*/
}

