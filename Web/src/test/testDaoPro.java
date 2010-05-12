package test;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import metier.Pro;
import dao.hibernate.DAOProHbn;
public class testDaoPro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			DAOProHbn daoPro= new DAOProHbn();
			Pro p=daoPro.get("ben");
			System.out.println(p.getDate_inscription());
			p.setPass("toto");
			daoPro.update(p);
			Timestamp t=new Timestamp(java.util.Calendar.getInstance().getTimeInMillis());
			Pro p2=new Pro("bastien", "coucou",t, t);
			daoPro.delete(p2);
			
	}

}
