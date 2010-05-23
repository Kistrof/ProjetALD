package dao;

import java.util.ArrayList;

import metier.Pro;

public interface DAOPro
{
	public Pro get(String pseudo);
	public ArrayList<Pro> loadAll();
	public void save(Pro p);
	public void delete(Pro p);
	public void update(Pro p);
	public boolean verifLogin(String pseuo,String mdp);
	public ArrayList<Pro> loadDateInscription(int year, int month);
	public ArrayList<Pro> loadInactifs();
}
