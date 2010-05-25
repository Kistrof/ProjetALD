package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.Config;

import metier.Pro;

import dao.DAOPro;

public class Connexion extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			System.out.println("*** Erreur : ClassNotFound");
		} catch (InstantiationException e) {
			System.out.println("*** Erreur : Instantiation");
		} catch (IllegalAccessException e) {
			System.out.println("*** Erreur : IllegalAccess");
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("*** Erreur : UnsupportedLookAndFeel");
		}
		new Connexion();
	}
	
	private JPanel panel;
	private JLabel l_login, l_pass;
	private JTextField t_login;
	private JPasswordField t_pass;
	private JButton b_cnx;
	
	public Connexion()
	{
		super("BackOffice IMDB");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.l_login = new JLabel("Login : ");
		this.l_pass = new JLabel("Mot de passe : ");
		
		this.t_login = new JTextField();
		this.t_login.addActionListener(this);
		this.t_pass = new JPasswordField();
		this.t_pass.addActionListener(this);
		
		this.panel = new JPanel(new GridLayout(2, 2));
		this.panel.add(this.l_login);
		this.panel.add(this.t_login);
		this.panel.add(this.l_pass);
		this.panel.add(this.t_pass);
		
		this.b_cnx = new JButton("Connexion");
		this.b_cnx.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(this.panel, BorderLayout.CENTER);
		this.add(this.b_cnx, BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		DAOPro daoPro = Config.beanFactory.getBean("daoPro", DAOPro.class);
		if (daoPro.verifLogin(this.t_login.getText(), new String(this.t_pass.getPassword())))
		{
			Pro p = daoPro.get(this.t_login.getText());
			if (p != null)
			{
				if (p.isAdmin())
				{
					this.dispose();
					Principale.getInstance();
				}
				else
				{
					// Pas un admin
					System.out.println("*** Erreur : droits");
				}
			}
		}
		else
		{
			// Erreur d'identification
			System.out.println("*** Erreur : identification");
		}
	}
	
}
