import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToe 
{
	JFrame fr=new JFrame();
	JLabel la=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
	JPanel[] pa=new JPanel[3]; 
	JLabel msg=new JLabel("First player turn...");
	JButton[] bt=new JButton[9];
	JButton reset=new JButton("RESET");
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=1;
	public TicTacToe()
	{
		fr.setSize(500,630);
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(3);
		fr.add(la);
		addPanels();
		fr.setVisible(true);
	}
	private void addPanels()
	{
		la.setLayout(null);
		for(int i=0;i<pa.length;i++)
		{
			pa[i]=new JPanel();
			la.add(pa[i]);
		}
		pa[0].setBounds(50,30,400,40);
		pa[1].setBounds(50,100,400,400);
		pa[2].setBounds(50,530,400,40);
		addMsg();
	}
	private void addMsg()
	{
		pa[0].add(msg);
		msg.setFont(new Font("elephant",0,30));
		msg.setForeground(Color.blue);
		//pa[0].setBackground(Color.magenta);
		addButtons();
	}
	private void addButtons()
	{
		pa[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<bt.length;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.yellow);
			pa[1].add(bt[i]);
		}
		addResetButton();
	}
	private void addResetButton()
	{
		pa[2].add(reset);
		reset.setFont(new Font("arial",0,20));
		pa[2].setOpaque(false);
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			//Here getSource() method will return button(reference of button) that would be clicked by user
			//bb will store reference of button clicked
			JButton bb=(JButton)evt.getSource();
			if(bb.getIcon()!=null)//When click button would have already image
			{
				JOptionPane.showMessageDialog(fr,"Wrong clicked");
				return;//Terminates execution of current method
			}
			if(player==1)
			{
				bb.setIcon(icon1);
				player=2;
				msg.setText("Second player turn");
				msg.setForeground(Color.magenta);
			}
			else if(player==2)
			{
				bb.setIcon(icon2);
				player=1;
				msg.setText("First player turn");
				msg.setForeground(Color.blue);
			}
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe();
	}
}
