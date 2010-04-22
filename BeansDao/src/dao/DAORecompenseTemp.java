package dao;

import java.util.ArrayList;

import metier.RecompenseTemp;

public interface DAORecompenseTemp
{
	public RecompenseTemp get(int id);
	public ArrayList<RecompenseTemp> loadAll();
	public void save(RecompenseTemp r);
	public void delete(RecompenseTemp r);
	public void update(RecompenseTemp r);
}
