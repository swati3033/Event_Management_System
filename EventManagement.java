import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EventManagement implements ActionListener
{
    JFrame home,alogin,atask,member,profile,cframe,mlogin;
    JLabel image,imagea,namea,fa,text,uname,pwd,ul,imaget,namet,ft,imagem,imagec;
	JLabel imagemm,namemm,textcm,unamecm,pwdcm;
    JPanel bar,bara,headera,footera,headert,footert,bart,headerm,footerm,barm,barh;
	JPanel headermm,footercm,barmm;
    JButton admin,cmember,cregister,coordinator,pregister,plogin,login,reset,addbtn,ha,clogin,hm;
    Icon ia,user,it,im,ip,ic,imm;
    JTextField utext,utextm,ptext,fname,mname,lname,cn,cdt,mt,et,utextcm;
    JPasswordField pfield,pfieldcm;
    JDialog jdlog;
    JLabel jlbl,jdlogl2,jdlogl,fm,namem,unamem,pwdm,textm,fcm;
    JButton okbtn,amembers,vevnt,vco,ahome,logout,space,resetcm,add_event,add_cooridators,view_participants,profilebtn,lg;
    //profile
	JButton backBtn,ABtn,UBtn;
    JPanel headerp,footerp,headerc,footerc,barcc;
    JLabel namep,imagep,fp,pt,up,um,ull,gt,cl,cd,mn,el,namec,fc;
    ButtonGroup grp;
    JRadioButton male,female;

    EventManagement()
    {
		home=new JFrame();

		JPanel header=new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(118,178,199));		//51,153,255
		header.setBounds(0,0,2000,180);
		home.add(header);

		Icon i=new ImageIcon("D:/EventMgt/rit.png");
		image=new JLabel(i);
		image.setBounds(10,10,200,160);
		header.add(image);

		JLabel name=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
		name.setFont(new Font("Times New Roman",Font.BOLD,50));
		name.setForeground(Color.white);
		name.setBounds(400,50,1400,60);
		header.add(name);

		JPanel footer=new JPanel();
		footer.setBackground(new Color(118,178,199));
		footer.setBounds(0,900,2000,30);
		home.add(footer);
		JLabel f=new JLabel("Event Management System",JLabel.CENTER);
		f.setFont(new Font("Times New Roman",Font.BOLD,15));
		f.setForeground(Color.white);
		f.setBounds(0,785,200,20);
		footer.add(f);

		//for buttons
		bar=new JPanel();
		bar.setBounds(0,180,2000,50);
		bar.setBackground(new Color(111,199,202));
		home.add(bar);
		//admin login
		admin=new JButton("admin login");
		admin.setFont(new Font("Times New Roman",Font.BOLD,25));
		admin.setBackground(Color.white);
		admin.setBounds(550,185,100,70);
		admin.addActionListener(this);
		bar.add(admin);
		//commitee member login
		cmember=new JButton("commitee member login");
		cmember.setFont(new Font("Times New Roman",Font.BOLD,25));
		cmember.setBackground(Color.white);
		cmember.setBounds(550,185,100,70);
		cmember.addActionListener(this);
		bar.add(cmember);

		//coordinator registration
		cregister=new JButton("coordinator registration");
		cregister.setFont(new Font("Times New Roman",Font.BOLD,22));
		cregister.setBackground(Color.white);
		cregister.setBounds(550,185,100,70);
		cregister.addActionListener(this);
		bar.add(cregister);

		//coordinator login
		coordinator=new JButton("coordinator login");
		coordinator.setFont(new Font("Times New Roman",Font.BOLD,22));
		coordinator.setBackground(Color.white);
		coordinator.setBounds(550,185,100,70);
		coordinator.addActionListener(this);
		bar.add(coordinator);


		plogin=new JButton("view event details");
		plogin.setFont(new Font("Times New Roman",Font.BOLD,22));
		plogin.setBackground(Color.white);
		plogin.setBounds(550,185,100,70);
		plogin.addActionListener(this);
		bar.add(plogin);

		//partipants registration
		pregister=new JButton("Register for events");
		pregister.setFont(new Font("Times New Roman",Font.BOLD,22));
		pregister.setBackground(Color.white);
		pregister.setBounds(550,185,100,70);
		pregister.addActionListener(this);
		bar.add(pregister);

		home.setLayout(null);
		home.setSize(2000,1350); //1600,1000
		home.setVisible(true);
		home.setTitle("Home Page");
	}

	public void adminLogin()
	{
		alogin=new JFrame();

		headera=new JPanel();
		headera.setLayout(null);
		headera.setBackground(new Color(118,178,199));		//51,153,255
		headera.setBounds(0,0,2000,180);
		alogin.add(headera);

		ia=new ImageIcon("D:/EventMgt/rit.png");
		imagea=new JLabel(ia);
		imagea.setBounds(10,10,200,160);
		headera.add(imagea);

		namea=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
		namea.setFont(new Font("Times New Roman",Font.BOLD,50));
		namea.setForeground(Color.white);
		namea.setBounds(400,50,1400,60);
		headera.add(namea);

		//menu bar
		barh=new JPanel();
		barh.setBounds(0,180,2000,50);
		barh.setBackground(new Color(111,199,202));
		alogin.add(barh);
		//home
		ha=new JButton("Home");
		ha.setFont(new Font("Times New Roman",Font.BOLD,25));
		ha.setBackground(Color.white);
		ha.setBounds(550,185,100,70);
		ha.addActionListener(this);
		barh.add(ha);

		space=new JButton("     ");
		space.setFont(new Font("Times New Roman",Font.BOLD,25));
		space.setBackground(new Color(111,199,202));
		space.setBounds(550,185,100,70);
		space.addActionListener(this);
		barh.add(space);


		//...............
		user=new ImageIcon("D:/EventMgt/iconuser.png");
		ul=new JLabel(user);
		ul.setBounds(770,250,130,110);
		alogin.add(ul);

		text=new JLabel("Login");
		text.setFont(new Font("Rockwell",Font.BOLD,50));
		text.setBounds(890,250,200,100);
		alogin.add(text);

		uname=new JLabel("Username",JLabel.CENTER);
		uname.setBounds(800,410,250,50);
		uname.setFont(new Font("Times New Roman",Font.BOLD,25));
		alogin.add(uname);

		utext=new JTextField();
		utext.setBounds(800,460,250,50);
		utext.setFont(new Font("Times New Roman",Font.BOLD,20));
		alogin.add(utext);

		pwd=new JLabel("Password",JLabel.CENTER);
		pwd.setBounds(800,540,250,50);
		pwd.setFont(new Font("Times New Roman",Font.BOLD,25));
		alogin.add(pwd);

		pfield=new JPasswordField();
		pfield.setBounds(800,590,250,50);
		pfield.setFont(new Font("Times New Roman",Font.BOLD,25));
		alogin.add(pfield);

		login=new JButton("Login");
		login.addActionListener(this);	//added addActionListener to jbutton object
		login.setBounds(810,680,100,50);
		login.setFont(new Font("Times New Roman",Font.BOLD,25));
		alogin.add(login);

		reset=new JButton("Reset");
		reset.addActionListener(this);	//added addActionListener to jbutton object
		reset.setBounds(940,680,100,50);
		reset.setFont(new Font("Times New Roman",Font.BOLD,25));
		alogin.add(reset);


		//...............

		//alert message
		jdlog=new JDialog(alogin,"User Authentication",false);			//for printing message to user
		jdlog.setLayout(new FlowLayout());
		jdlog.setBounds(1090,510,350,150);
		jlbl=new JLabel("Your Login has failed ! Please try again.");
		jlbl.setFont(new Font("Times New Roman",Font.BOLD,20));
		jdlog.add(jlbl);
		//jlbl.setBounds(1100,510,200,40);
		jdlogl2=new JLabel("                                                      ");
		jdlog.add(jdlogl2);
		jdlogl=new JLabel("                                         ");
		jdlog.add(jdlogl);		//label added on dialog box
		okbtn=new JButton("Ok");
		okbtn.setFont(new Font("Times New Roman",Font.BOLD,17));
		//okbtn.setBounds(1100,550,10,10);
		okbtn.addActionListener(this);
		jdlog.add(okbtn);		//button added on dialog box

		footera=new JPanel();
		footera.setBackground(new Color(118,178,199));
		footera.setBounds(0,900,2000,30);
		alogin.add(footera);
		fa=new JLabel("Event Management System",JLabel.CENTER);
		fa.setFont(new Font("Times New Roman",Font.BOLD,15));
		fa.setForeground(Color.white);
		fa.setBounds(0,785,200,20);
		footera.add(fa);

		alogin.setLayout(null);
		alogin.setSize(2000,1350); //1600,1000
		alogin.setVisible(true);
		alogin.setTitle("Admin Login");
	}

	//admin task

	public void adminTask()
	{
		atask=new JFrame();

		headert=new JPanel();
		headert.setLayout(null);
		headert.setBackground(new Color(118,178,199));		//51,153,255
		headert.setBounds(0,0,2000,180);
		atask.add(headert);

		it=new ImageIcon("D:/EventMgt/rit.png");
		imaget=new JLabel(it);
		imaget.setBounds(10,10,200,160);
		headert.add(imaget);

		namet=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
		namet.setFont(new Font("Times New Roman",Font.BOLD,50));
		namet.setForeground(Color.white);
		namet.setBounds(400,50,1400,60);
		headert.add(namet);

		//for buttons
		bart=new JPanel();
		bart.setBounds(0,180,2000,50);
		bart.setBackground(new Color(111,199,202));
		atask.add(bart);
		//admin tasks buttons
		amembers=new JButton("add commitee members");
		amembers.setFont(new Font("Times New Roman",Font.BOLD,25));
		amembers.setBackground(Color.white);
		amembers.setBounds(550,185,100,70);
		amembers.addActionListener(this);
		bart.add(amembers);

		vevnt=new JButton("view event details");
		vevnt.setFont(new Font("Times New Roman",Font.BOLD,25));
		vevnt.setBackground(Color.white);
		vevnt.setBounds(550,185,100,70);
		vevnt.addActionListener(this);
		bart.add(vevnt);

		vco=new JButton("view participants");
		vco.setFont(new Font("Times New Roman",Font.BOLD,25));
		vco.setBackground(Color.white);
		vco.setBounds(550,185,100,70);
		vco.addActionListener(this);
		bart.add(vco);

		ahome=new JButton("Logout");
		ahome.setFont(new Font("Times New Roman",Font.BOLD,25));
		ahome.setBackground(Color.white);
		ahome.setBounds(550,185,100,70);
		ahome.addActionListener(this);
		bart.add(ahome);

		footert=new JPanel();
		footert.setBackground(new Color(118,178,199));
		footert.setBounds(0,900,2000,30);
		atask.add(footert);
		ft=new JLabel("Event Management System",JLabel.CENTER);
		ft.setFont(new Font("Times New Roman",Font.BOLD,15));
		ft.setForeground(Color.white);
		ft.setBounds(0,785,200,20);
		footert.add(ft);

		atask.setLayout(null);
		atask.setSize(2000,1350); //1600,1000
		atask.setVisible(true);
		atask.setTitle("Admin Task");
	}

	public void addMembers()
	{
		member=new JFrame();

		headerm=new JPanel();
		headerm.setLayout(null);
		headerm.setBackground(new Color(118,178,199));		//51,153,255
		headerm.setBounds(0,0,2000,180);
		member.add(headerm);

		im=new ImageIcon("D:/EventMgt/rit.png");
		imagem=new JLabel(im);
		imagem.setBounds(10,10,200,160);
		headerm.add(imagem);

		namem=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
		namem.setFont(new Font("Times New Roman",Font.BOLD,50));
		namem.setForeground(Color.white);
		namem.setBounds(400,50,1400,60);
		headerm.add(namem);

		//menu bar
		barm=new JPanel();
		barm.setBounds(0,180,2000,50);
		barm.setBackground(new Color(111,199,202));
		member.add(barm);
		//admin tasks buttons
		logout=new JButton("Logout");
		logout.setFont(new Font("Times New Roman",Font.BOLD,25));
		logout.setBackground(Color.white);
		logout.setBounds(550,185,100,70);
		logout.addActionListener(this);
		barm.add(logout);

		//add members

		textm=new JLabel("Add members");
		textm.setFont(new Font("Rockwell",Font.BOLD,40));
		textm.setBounds(800,250,300,100);
		member.add(textm);

		unamem=new JLabel("Enter Username",JLabel.CENTER);
		unamem.setBounds(800,410,250,50);
		unamem.setFont(new Font("Times New Roman",Font.BOLD,25));
		member.add(unamem);

		utextm=new JTextField();
		utextm.setBounds(800,460,250,50);
		utextm.setFont(new Font("Times New Roman",Font.BOLD,20));
		member.add(utextm);

		pwdm=new JLabel("Enter Password",JLabel.CENTER);
		pwdm.setBounds(800,540,250,50);
		pwdm.setFont(new Font("Times New Roman",Font.BOLD,25));
		member.add(pwdm);

		ptext=new JTextField();
		ptext.setBounds(800,590,250,50);
		ptext.setFont(new Font("Times New Roman",Font.BOLD,25));
		member.add(ptext);

		addbtn=new JButton("Add");
		addbtn.addActionListener(this);	//added addActionListener to jbutton object
		addbtn.setBounds(870,680,100,50);
		addbtn.setFont(new Font("Times New Roman",Font.BOLD,25));
		member.add(addbtn);

		//..........................



		footerm=new JPanel();
		footerm.setBackground(new Color(118,178,199));
		footerm.setBounds(0,900,2000,30);
		member.add(footerm);
		fm=new JLabel("Event Management System",JLabel.CENTER);
		fm.setFont(new Font("Times New Roman",Font.BOLD,15));
		fm.setForeground(Color.white);
		fm.setBounds(0,785,200,20);
		footerm.add(fm);

		member.setLayout(null);
		member.setSize(2000,1350); //1600,1000
		member.setVisible(true);
		member.setTitle("Add members");
	}

	//add events


	//commitee members profile
	public void updateProfile()
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

        pt=new JLabel("Update Profile");
        pt.setFont(new Font("Rockwell",Font.BOLD,30));
        pt.setBounds(820,200,300,100);
        profile.add(pt);

        up=new JLabel("First name:",JLabel.LEFT);
        up.setBounds(720,310,200,45);
        up.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(up);

        fname=new JTextField();
        fname.setBounds(900,310,250,45);
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(fname);

        um=new JLabel("Middle name:",JLabel.LEFT);
        um.setBounds(720,380,200,45);
        um.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(um);

        mname=new JTextField();
        mname.setBounds(900,380,250,45);
        mname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(mname);

        ull=new JLabel("Last name:",JLabel.LEFT);
        ull.setBounds(720,450,200,45);
        ull.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(ull);

        lname=new JTextField();
        lname.setBounds(900,450,250,45);
        lname.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(lname);

        //gender
        gt=new JLabel("Gender:",JLabel.LEFT);
        gt.setFont(new Font("Times New Roman",Font.BOLD,25));
        gt.setBounds(720,520,100,40);
        profile.add(gt);

        grp=new ButtonGroup();
        //Dimension dmn=new Dimension(80,80);
        male=new JRadioButton("Male");
        male.setFont(new Font("Times New Roman",Font.BOLD,20));
        male.setBounds(900,520,100,40);
        //jrd1.setSize(dmn);
        female=new JRadioButton("female");
        female.setFont(new Font("Times New Roman",Font.BOLD,20));
        female.setBounds(1020,520,120,40);
        //jrd2.setSize(dmn);
        grp.add(male);
        grp.add(female);
        profile.add(male);
        profile.add(female);

        cl=new JLabel("Class:",JLabel.LEFT);
        cl.setBounds(720,580,200,45);
        cl.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(cl);

        cn=new JTextField();
        cn.setBounds(900,580,250,45);
        cn.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(cn);

        cd=new JLabel("Designation:",JLabel.LEFT);
        cd.setBounds(720,650,200,45);
        cd.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(cd);

        cdt=new JTextField();
        cdt.setBounds(900,650,250,45);
        cdt.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(cdt);

        mn=new JLabel("Mobile No:",JLabel.LEFT);
        mn.setBounds(720,710,200,45);
        mn.setFont(new Font("Times New Roman",Font.BOLD,25));
        profile.add(mn);

        mt=new JTextField();
        mt.setBounds(900,710,250,45);
        mt.setFont(new Font("Times New Roman",Font.BOLD,20));
        profile.add(mt);

        el=new JLabel("Email ID:",JLabel.LEFT);
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
        ABtn.setBounds(900,840,100,40);
        ABtn.addActionListener(this);
        profile.add(ABtn);

		/*UBtn=new JButton("Update");
        UBtn.setFont(new Font("Times New Roman",Font.BOLD,23));
        UBtn.setBackground(new Color(204,204,204));
        UBtn.setBounds(930,840,130,40);
        UBtn.addActionListener(this);
        profile.add(UBtn);*/

		backBtn=new JButton("Back");
		backBtn.setFont(new Font("Times New Roman",Font.BOLD,23));
		backBtn.setBackground(new Color(204,204,204));
		backBtn.setBounds(1090,840,100,40);
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

	public void cmemberTask()
	{
		cframe=new JFrame();

		headerc=new JPanel();
		headerc.setLayout(null);
		headerc.setBackground(new Color(118,178,199));		//51,153,255
		headerc.setBounds(0,0,2000,180);
		cframe.add(headerc);

		ic=new ImageIcon("D:/EventMgt/rit.png");
		imagec=new JLabel(ic);
		imagec.setBounds(10,10,200,160);
		headerc.add(imagec);

		namec=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
		namec.setFont(new Font("Times New Roman",Font.BOLD,50));
		namec.setForeground(Color.white);
		namec.setBounds(400,50,1400,60);
		headerc.add(namec);
		//***************
		barcc=new JPanel();
		barcc.setBounds(0,180,2000,50);
		barcc.setBackground(new Color(111,199,202));
		cframe.add(barcc);
		// For buttons


		// Admin login
		add_event = new JButton("Add Events");
		add_event.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add_event.setBackground(Color.white);
		add_event.addActionListener(this);
		add_event.setBounds(550,185,100,70);
		barcc.add(add_event);

		// Committee member login
		add_cooridators = new JButton("view events");
		add_cooridators.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add_cooridators.setBackground(Color.white);
		add_cooridators.addActionListener(this);
		add_cooridators.setBounds(550,185,100,70);
		barcc.add(add_cooridators);

		// Coordinator registration
		view_participants = new JButton("View Participants");
		view_participants.setFont(new Font("Times New Roman", Font.BOLD, 18));
		view_participants.setBackground(Color.white);
		view_participants.addActionListener(this);
		view_participants.setBounds(550,185,100,70);
		barcc.add(view_participants);


		// Coordinator login
		profilebtn = new JButton("Profile");
		profilebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		profilebtn.setBackground(Color.white);
		profilebtn.addActionListener(this);
		profilebtn.setBounds(550,185,100,70);
		barcc.add(profilebtn);

		lg = new JButton("Logout");
		lg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lg.setBackground(Color.white);
		lg.addActionListener(this);
		lg.setBounds(550,185,100,70);
		barcc.add(lg);
		//***********

		footerc=new JPanel();
		footerc.setBackground(new Color(118,178,199));
		footerc.setBounds(0,900,2000,30);
		cframe.add(footerc);
		fc=new JLabel("Event Management System",JLabel.CENTER);
		fc.setFont(new Font("Times New Roman",Font.BOLD,15));
		fc.setForeground(Color.white);
		fc.setBounds(0,785,200,20);
		footerc.add(fc);

		cframe.setLayout(null);
		cframe.setSize(2000,1350); //1600,1000
		cframe.setVisible(true);
		cframe.setTitle("Update Profile");

	}

	public void cmemberLogin()
	{
		mlogin=new JFrame();

		headermm=new JPanel();
		headermm.setLayout(null);
		headermm.setBackground(new Color(118,178,199));		//51,153,255
		headermm.setBounds(0,0,2000,180);
		mlogin.add(headermm);

		imm=new ImageIcon("D:/EventMgt/rit.png");
		imagemm=new JLabel(imm);
		imagemm.setBounds(10,10,200,160);
		headermm.add(imagemm);

		namemm=new JLabel("Rajarambapu Institute of Technology,Rajaramnagar");
		namemm.setFont(new Font("Times New Roman",Font.BOLD,50));
		namemm.setForeground(Color.white);
		namemm.setBounds(400,50,1400,60);
		headermm.add(namemm);

		//menu bar
		barmm=new JPanel();
		barmm.setBounds(0,180,2000,50);
		barmm.setBackground(new Color(111,199,202));
		mlogin.add(barmm);
		//home
		hm=new JButton("Home");
		hm.setFont(new Font("Times New Roman",Font.BOLD,25));
		hm.setBackground(Color.white);
		hm.setBounds(550,185,100,70);
		hm.addActionListener(this);
		barmm.add(hm);

		space=new JButton("     ");
		space.setFont(new Font("Times New Roman",Font.BOLD,25));
		space.setBackground(new Color(111,199,202));
		space.setBounds(550,185,100,70);
		space.addActionListener(this);
		barmm.add(space);


		//...............
		user=new ImageIcon("D:/EventMgt/iconuser.png");
		ul=new JLabel(user);
		ul.setBounds(770,250,130,110);
		mlogin.add(ul);

		textcm=new JLabel("Login");
		textcm.setFont(new Font("Rockwell",Font.BOLD,50));
		textcm.setBounds(890,250,200,100);
		mlogin.add(textcm);

		unamecm=new JLabel("Username",JLabel.CENTER);
		unamecm.setBounds(800,410,250,50);
		unamecm.setFont(new Font("Times New Roman",Font.BOLD,25));
		mlogin.add(unamecm);

		utextcm=new JTextField();
		utextcm.setBounds(800,460,250,50);
		utextcm.setFont(new Font("Times New Roman",Font.BOLD,20));
		mlogin.add(utextcm);

		pwdcm=new JLabel("Password",JLabel.CENTER);
		pwdcm.setBounds(800,540,250,50);
		pwdcm.setFont(new Font("Times New Roman",Font.BOLD,25));
		mlogin.add(pwdcm);

		pfieldcm=new JPasswordField();
		pfieldcm.setBounds(800,590,250,50);
		pfieldcm.setFont(new Font("Times New Roman",Font.BOLD,25));
		mlogin.add(pfieldcm);

		clogin=new JButton("Login");
		clogin.addActionListener(this);	//added addActionListener to jbutton object
		clogin.setBounds(810,680,100,50);
		clogin.setFont(new Font("Times New Roman",Font.BOLD,25));
		mlogin.add(clogin);

		resetcm=new JButton("Reset");
		resetcm.addActionListener(this);	//added addActionListener to jbutton object
		resetcm.setBounds(940,680,100,50);
		resetcm.setFont(new Font("Times New Roman",Font.BOLD,25));
		mlogin.add(resetcm);


		//...............

		//alert message
		jdlog=new JDialog(alogin,"User Authentication",false);			//for printing message to user
		jdlog.setLayout(new FlowLayout());
		jdlog.setBounds(1090,510,350,150);
		jlbl=new JLabel("Your Login has failed ! Please try again.");
		jlbl.setFont(new Font("Times New Roman",Font.BOLD,20));
		jdlog.add(jlbl);
		//jlbl.setBounds(1100,510,200,40);
		jdlogl2=new JLabel("                                                      ");
		jdlog.add(jdlogl2);
		jdlogl=new JLabel("                                         ");
		jdlog.add(jdlogl);		//label added on dialog box
		okbtn=new JButton("Ok");
		okbtn.setFont(new Font("Times New Roman",Font.BOLD,17));
		//okbtn.setBounds(1100,550,10,10);
		okbtn.addActionListener(this);
		jdlog.add(okbtn);		//button added on dialog box

		footercm=new JPanel();
		footercm.setBackground(new Color(118,178,199));
		footercm.setBounds(0,900,2000,30);
		mlogin.add(footercm);
		fcm=new JLabel("Event Management System",JLabel.CENTER);
		fcm.setFont(new Font("Times New Roman",Font.BOLD,15));
		fcm.setForeground(Color.white);
		fcm.setBounds(0,785,200,20);
		footercm.add(fcm);

		mlogin.setLayout(null);
		mlogin.setSize(2000,1350); //1600,1000
		mlogin.setVisible(true);
		mlogin.setTitle("Commitee Member Login");
	}

	//adding commitee members into database
	public void addCmembers()
	{
        try
        {
            //loads/register the driver in program
            Class.forName("com.mysql.jdbc.Driver");	//1

            //establish connection with the database
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

            // (query for insertion operation)
            String insertQuery="insert into commitee_mem_login(uname,passwd)values(?,?)";

            //create statement using PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(insertQuery);

            pstmt.setString(1,utextm.getText());
            pstmt.setString(2,ptext.getText());

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

	//authenticating commitee members
	public void checkCmemberLogin()
	{
		try
		{
			//loads/register the driver in program
			Class.forName("com.mysql.jdbc.Driver");	//1

			//establish connection with the database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

			// (query for authenticating commitee members)

			String cname=utextcm.getText();
			String cpwd=pfieldcm.getText();

			String selectQuery="select * from commitee_mem_login where uname='"+cname+"' and passwd='"+cpwd+"'";

			//create statement using PreparedStatement
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery(selectQuery);
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null,"Login Successfull!!");
				cmemberTask();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid username or password !!");
				utextcm.setText(" ");
				pfieldcm.setText(" ");
			}

			con.close();
		}

		catch(Exception exp)
		{
			System.out.println(exp);
		}

	}

	public void addProfile()
	{
		try
		{
			//loads/register the driver in program
			Class.forName("com.mysql.jdbc.Driver");	//1

			//establish connection with the database
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/event_management","root","");

			// (query for insertion operation)
			String insertQuery="insert into cprofile(fname,mnane,lname,gender,class,designation,mob_no,email)values(?,?,?,?,?,?,?,?)";

			//create statement using PreparedStatement
			PreparedStatement pstmt=con.prepareStatement(insertQuery);

			pstmt.setString(1,fname.getText());
			//String cb=jcb.getSelectedItem().toString();
			//pstmt.setString(2,cb);
			pstmt.setString(2,mname.getText());
			pstmt.setString(3,lname.getText());
			String g="";
			if(male.isSelected())
			{
				g="Male";
			}
			else
			{
				g="Female";
			}
			pstmt.setString(4,g);
			pstmt.setString(5,cl.getText());
			pstmt.setString(6,cdt.getText());
			pstmt.setString(7,mt.getText());
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

	//overriden method
	public void actionPerformed(ActionEvent aevnt)
    {
		if(aevnt.getSource()==admin)
		{
			home.setVisible(false);
			adminLogin();
		}
		if(aevnt.getSource()==login)
		{
			String str1=utext.getText();
			String str2=pfield.getText();

			if((str1.equals("admin")) && (str2.equals("itdept")))
			{
				alogin.setVisible(false);
				adminTask();
			}
			else
			{
				jdlog.setVisible(true);
			}
		}
		if(aevnt.getSource()==okbtn)
		{
			alogin.setVisible(false);
			adminLogin();
		}
		if(aevnt.getSource()==reset)
		{
			utext.setText(" ");
			pfield.setText(" ");
		}
		if(aevnt.getSource()==ahome)
		{
			atask.setVisible(false);
			home.setVisible(true);
		}
		if(aevnt.getSource()==amembers)
		{
			atask.setVisible(false);
			addMembers();
		}
		if(aevnt.getSource()==logout)
		{
			member.setVisible(false);
			home.setVisible(true);
		}
		if(aevnt.getSource()==ha)
		{
			alogin.setVisible(false);
			home.setVisible(true);
		}
        if(aevnt.getSource()==addbtn)
        {
            addCmembers();
        }
		if(aevnt.getSource()==cmember)
		{
			home.setVisible(false);
			//cmemberLogin();
			cmemberLogin();
		}
		if(aevnt.getSource()==hm)
		{
			mlogin.setVisible(false);
			home.setVisible(true);
		}
		if(aevnt.getSource()==clogin)
		{
			checkCmemberLogin();
			//mlogin.setVisible(false);
			//cmemberTask();
		}
		if(aevnt.getSource()==add_event)
		{
			cframe.setVisible(false);
			//addEvent();
			//new EventManagementSystem();
			new EventClass();
		}
		if(aevnt.getSource()==resetcm)
		{
			utextcm.setText(" ");
			pfieldcm.setText(" ");
		}
		if(aevnt.getSource()==lg)
		{
			cframe.setVisible(false);
			home.setVisible(true);
		}
		if(aevnt.getSource()==profilebtn)
		{
			cframe.setVisible(false);
			updateProfile();
		}
		if(aevnt.getSource()==backBtn)
		{
			profile.setVisible(false);
			cmemberTask();
		}
		if(aevnt.getSource()==pregister)
		{
			home.setVisible(false);
			new ParticipantRegisterClass();
		}
		if(aevnt.getSource()==vco)
		{
			new ViewParticipantClass();
		}
		if(aevnt.getSource()==vevnt)
		{
			new CoViewEvents();
			//new DisplayEvent();
		}
		if(aevnt.getSource()==cregister)
		{
			new coordinatorRegistration();
		}
		if(aevnt.getSource()==coordinator)
		{
			new coordinatorLogin();
		}
		if(aevnt.getSource()==ABtn)
		{
			addProfile();
		}
		//subevent_name
		if(aevnt.getSource()==view_participants)
		{
			new ViewPart();
		}
		if(aevnt.getSource()==add_cooridators)
		{
			new DisplayEvent();
		}


    }

    public static void main(String args[])
    {
        new EventManagement();
    }

}
