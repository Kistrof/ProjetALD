package test;

import java.sql.Date;

import metier.*;
import dao.*;
import dao.hibernate.*;

public class DAO
{
	public static void main(String[] args)
	{
		DAOPrix daoPrix = new DAOPrixHbn();
		
		DAOPersonne daoPersonne = new DAOPersonneHbn();
		DAOFilm daoFilm = new DAOFilmHbn();
		DAORecompense daoRecompense = new DAORecompenseHbn();
		
		Personne clintEastwood = new Personne(-1, "Eastwood", "Clint", new Date(1930, 5, 31), null, null, -1);
		daoPersonne.save(clintEastwood);
		
		Film granTorino = new Film(-1, "Gran Torino", 2008, -1, null, "", null, -1, null, null, null, null);
		granTorino.addActeur(clintEastwood);
		granTorino.addProducteur(clintEastwood);
		daoFilm.save(granTorino);
		
		Prix p = daoPrix.get(1);
		Recompense r = new Recompense(-1, p, 2009, null);
		granTorino.addRecompense(r);
		daoRecompense.save(r);
		
		
		
		
		
	}
}
