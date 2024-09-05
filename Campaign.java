import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Campaign extends JFrame implements ActionListener, MouseListener {
    JFrame camp;
    JPanel leftPanel, rightPanel;
    JTextField campaignNo, clgName, date, city, memb1, memb2;
    JButton add, update, delete, back;
    JTable jtbl;
    JScrollPane jpn;
    DefaultTableModel dtm;

    Campaign() {
        //Heading of the Panel
        camp = new JFrame();
        leftPanel = new JPanel();

        JPanel taskbar;


        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(118, 178, 199));
        header.setBounds(0, 0, 1900, 150);
        camp.add(header);


        JLabel name = new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
        name.setFont(new Font("Times New Roman", Font.BOLD, 47));
        name.setForeground(Color.white);
        name.setBounds(400, 50, 1400, 60);
        header.add(name);


        taskbar = new JPanel();
        taskbar.setBounds(0, 150, 2000, 50);
        taskbar.setBackground(new Color(111, 199, 202));
        camp.add(taskbar);


        //login
        back = new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.BOLD, 22));
        back.setBackground(Color.white);
        back.setBounds(1300, 200, 100, 70);
        back.addActionListener(this);
        taskbar.add(back);

        JLabel title = new JLabel("Campaign");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setForeground(Color.BLACK);
        title.setBounds(300, 200, 800, 60);
        leftPanel.add(title);


        //campaign no
        JLabel camLabel = new JLabel("Campaign Group No.");
        camLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        camLabel.setForeground(Color.BLACK);
        camLabel.setBounds(120, 280, 400, 60);
        leftPanel.add(camLabel);

        campaignNo = new JTextField();
        campaignNo.setBounds(120, 320, 200, 30);
        leftPanel.add(campaignNo);

        //college Name
        JLabel clgLabel = new JLabel("College Name");
        clgLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        clgLabel.setForeground(Color.BLACK);
        clgLabel.setBounds(120, 385, 400, 60);
        leftPanel.add(clgLabel);

        clgName = new JTextField();
        clgName.setBounds(120, 435, 200, 30);
        leftPanel.add(clgName);

        //Date//day
        JLabel dayLabel = new JLabel("Date");
        dayLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dayLabel.setForeground(Color.BLACK);
        dayLabel.setBounds(420, 280, 400, 60);
        leftPanel.add(dayLabel);

        date = new JTextField();
        date.setBounds(420, 320, 200, 30);
        leftPanel.add(date);

        //City
        JLabel cityLabel = new JLabel("City");
        cityLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cityLabel.setForeground(Color.BLACK);
        cityLabel.setBounds(120, 510, 400, 60);
        leftPanel.add(cityLabel);

        city = new JTextField();
        city.setBounds(120, 555, 200, 30);
        leftPanel.add(city);


        //members
        JLabel membLabel = new JLabel("Member 1");
        membLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        membLabel.setForeground(Color.BLACK);
        membLabel.setBounds(420, 385, 400, 60);
        leftPanel.add(membLabel);

        memb1 = new JTextField();
        memb1.setBounds(420, 435, 200, 30);
        leftPanel.add(memb1);

        /*JLabel memb2Label = new JLabel("Member 2");
        memb2Label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        memb2Label.setForeground(Color.BLACK);
        memb2Label.setBounds(800, 515, 400, 60);
        leftPanel.add(memb2Label);*/

        JLabel mem2 = new JLabel("Member 2");
        mem2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        mem2.setForeground(Color.BLACK);
        mem2.setBounds(420, 510, 400, 60);
        leftPanel.add(mem2);

        memb2 = new JTextField();
        memb2.setBounds(420, 555, 200, 30);
        leftPanel.add(memb2);


        add = new JButton("Create");
        update = new JButton("Update");
        delete = new JButton("Delete");
        add.setBounds(120, 650, 140, 30);
        add.addActionListener(this);
        update.setBounds(300, 650, 140, 30);
        update.addActionListener(this);
        delete.setBounds(480, 650, 140, 30);
        delete.addActionListener(this);


        leftPanel.add(add);
        //leftPanel.add(update);
        leftPanel.add(delete);

        leftPanel.setLayout(null);
        //leftPanel.setBackground(new Color(1f, 0f, 0f, .5f));
        leftPanel.setBounds(0, 0, 800, 900);
        leftPanel.setVisible(true);
        camp.add(leftPanel);

        rightPanel = new JPanel();


        jtbl = new JTable();
        jtbl.setBounds(800, 200, 1400, 600);
        jtbl.setPreferredScrollableViewportSize(new Dimension(1400, 600));
        jtbl.setFillsViewportHeight(true);
        jtbl.setBackground(new Color(255,255,255));
        jpn = new JScrollPane(jtbl);
        jpn.setBounds(800, 200, 1400, 600);
        rightPanel.add(jpn);
        viewTable();

        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255,255,200));
        rightPanel.setBounds(800, 200, 800, 900);
        rightPanel.setVisible(true);
        camp.add(rightPanel);

        camp.setLayout(null);
        camp.setSize(1600, 900); //1600,1000
        camp.setVisible(true);
        camp.setTitle("Campaign");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (e.getSource()==add) {
            save();
            viewTable();
        }
        if (e.getSource()==back) {
            new CoordinatorTask();
        }
        /*if (e.getSource()==update) {
            updateCampaign();
            viewTable();
        }*/
        if (e.getSource()==delete) {
            deleteCampaign();
            viewTable();
        }
    }

    public void deleteCampaign() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management", "root", "");
            Statement stmt = con.createStatement();
            int r = JOptionPane.showConfirmDialog(this, "Are you sure delete selected row?");
            int no=Integer.parseInt(campaignNo.getText().toString());
            int status=stmt.executeUpdate("delete from campaign where cno=" + no);
            if(status==1){
                JOptionPane.showMessageDialog(null,"Record Deleted Successfully!!");
            }
        } catch (SQLException ev) {
            throw new RuntimeException(ev);
        } catch (ClassNotFoundException ev) {
            throw new RuntimeException(ev);
        }

    }

    public void updateCampaign() {

        // int no = Integer.parseInt(jtbl.getValueAt(jtbl.getSelectedRow(), 0).toString());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management", "root", "");
            Statement stmt = con.createStatement();
            ///need to change column
            String query="update event_details set clgname='"+clgName+"',city='"+city+"',date='"+date+"',member1='"+memb1+"',member2='"+memb2+"' where e_id="+campaignNo;
                int status= stmt.executeUpdate(query);
           // int status= stmt.executeUpdate("update campaign set clgName=" + clgName.getText() + "','" + city.getText() + "','" + date.getText() + "','" + memb1.getText() + "','" + memb2.getText()+"'where cno=no");
            if(status==1){
                JOptionPane.showMessageDialog(null,"Data Updated Successfully!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Campaign();
    }

    void save() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management", "root", "");
            String q = "insert into campaign (cno,clgname,city,day,member1,member2) values (?,?,?,?,?,?)";
            PreparedStatement stmt= con.prepareStatement(q);


            String college=clgName.getText().toString();
            String ct=city.getText().toString();
            String day=date.getText().toString();
            String mem1=memb1.getText().toString();
            String mem2=memb2.getText().toString();

            stmt.setInt(1,Integer.parseInt(campaignNo.getText().toString()));
            stmt.setString(2,college);
            stmt.setString(3, ct);
            stmt.setString(4, day);
            stmt.setString(5, mem1);
            stmt.setString(6, mem2);


            int status=stmt.executeUpdate();

            if(status==1){
                JOptionPane.showMessageDialog(null,"Campaign Created Successfully!!");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewTable() {

        try {
            dtm=new DefaultTableModel();
            jtbl=new JTable(dtm);
            jtbl.setBounds(801,200,800,600);
            jtbl.setPreferredScrollableViewportSize(new Dimension(800,600));
            jtbl.setFillsViewportHeight(true);
            jtbl.setBackground(new Color(204,204,204));
            jpn=new JScrollPane(jtbl);
            jpn.setBounds(801,200,800,600);
            jtbl.addMouseListener(this);
            camp.add(jpn);

            //added column to table
            dtm.addColumn("cid");
            dtm.addColumn("collegeName");
            dtm.addColumn("city");
            dtm.addColumn("date");
            dtm.addColumn("member1");
            dtm.addColumn("member2");



            try
            {
                //loads/register the driver in program
                Class.forName("com.mysql.jdbc.Driver");	//1

                //establish connection with the database
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

                //query for display data from database
                String displayQuery="select * from campaign";

                Statement stmt=con.createStatement(); 		//create query

                ResultSet rs=stmt.executeQuery(displayQuery);	//execute query

                //fetching data from database
                while(rs.next())
                {
                    int cid=rs.getInt("cno");
                    String clgstr=rs.getString("clgname");
                    String ct=rs.getString("city");
                    String date=rs.getString("day");
                    String mem1=rs.getString("member1");
                    String mem2=rs.getString("member2");



                    //adding row in table
                    dtm.addRow(new Object[]{cid,clgstr,ct,date,mem1,mem2});
                }
            }
            catch(Exception exp)
            {
                System.out.println(exp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int i = jtbl.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbl.getModel();
        campaignNo.setText(model.getValueAt(i, 0).toString());
        clgName.setText(model.getValueAt(i, 1).toString());
        city.setText(model.getValueAt(i, 2).toString());
        date.setText(model.getValueAt(i, 3).toString());
        memb1.setText(model.getValueAt(i, 4).toString());
        memb2.setText(model.getValueAt(i, 5).toString());

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


