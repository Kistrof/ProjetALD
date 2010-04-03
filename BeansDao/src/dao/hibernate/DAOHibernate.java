package dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOHibernate
{

    private SessionFactory sessionFactory = null;
    
    /**
     * Crée une session et initialise une transaction qui devra être annulée (cancel) ou validée (close)
     * @return Session
     * @throws Exception
     */
    public Session connect() throws Exception
    {
    	if (this.sessionFactory == null)
    		this.sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = this.sessionFactory.openSession();
    	session.beginTransaction();
    	return session;
    }
    
    /**
     * Annule les modifications (rollback) et ferme le session
     * @param session Session
     */
    public void cancel(Session session)
    {
    	session.getTransaction().rollback();
    	session.close();
    }
    
    /**
     * Valide les modifications (commit) et ferme la session
     * @param session Session
     * @throws Exception
     */
    public void close(Session session) throws Exception
    {
    	session.getTransaction().commit();
    	session.close();
    }

}