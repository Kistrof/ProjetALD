package dao;

import java.util.ArrayList;

import metier.Recompense;

public interface DAORecompense
{
	public Recompense get(int id);
	public ArrayList<Recompense> loadAll();
	public void save(Recompense r);
	public void delete(Recompense r);
	public void update(Recompense r);
	public void saveOrUpdate(Recompense r);
}
