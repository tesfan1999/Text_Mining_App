import java.io.FileInputStream;  
import java.util.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;


public class Filesearch
	extends JFrame
	implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel add;
	private JTextArea tadd;
	private JCheckBox term;
	private JButton sub;
	private JButton submit;
	private JLabel res;

	JFileChooser fileChooser = new JFileChooser();
	File file;
	// constructor, to initialize the components
	// with default values.
	public Filesearch()
	{
		setTitle("Text Mining");
		setBounds(300, 90, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Text Mining");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(200, 30);
		c.add(title);

		name = new JLabel("Input Text");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		c.add(tname);

		mno = new JLabel("Output");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setSize(100, 20);
		mno.setLocation(100, 150);
		c.add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setSize(190, 20);
		tmno.setLocation(200, 150);
		c.add(tmno);

		sub = new JButton("Upload File");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(250, 30);
		sub.setLocation(100, 200);
		sub.addActionListener(this);
		c.add(sub);

		submit = new JButton("Submit");
		submit.setFont(new Font("Arial", Font.PLAIN, 15));
		submit.setSize(250, 30);
		submit.setLocation(100, 250);
		submit.addActionListener(this);
		c.add(submit);
                //setContentPane(new JLabel(new ImageIcon("C:\\Users\\dipan\\Hackathon\\image.jpg")));
		

		setVisible(true);
	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) 
		{
			
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION)
			{
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
			}
		
    		}

		else if (e.getSource() == submit)
		{
		    String wr=tname.getText();
		    Scanner sc=new Scanner(System.in);
		    try
		    {
        		    sc=new Scanner(file);
            	    }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                    String st=file.getAbsolutePath();
                    if(st.contains(".txt")||st.contains(".doc")||st.contains(".ppt"))
                    {
                        tmno.setText("Valid File");
                    }
                    else
                    {
                        tmno.setText("Invalid File");
                    }
                    int flag=0;
                    while(sc.hasNextLine())
                    {
                    String s=sc.nextLine();
                    //s=s+" ";
                    //words=s.split(" ");
                    if(s.contains(wr))
                    {
                    flag=1;
                    }
                    }
                    if(flag==1)
                    tmno.setText("Word Found");
                    else
                    tmno.setText("Word Not found!!");
                    
                }
	}
	public static void main(String args[])throws Exception
        {
            Filesearch f = new Filesearch();
        }
}