package dao;

import java.util.ArrayList;

import metier.ModifRelationFilmPers;

public interface DAOModifRelationFilmPers
{
	public ModifRelationFilmPers get(int id);
	public ArrayList<ModifRelationFilmPers> loadAll();
	public void save(ModifRelationFilmPers obj);
	public void delete(ModifRelationFilmPers obj);
	public void update(ModifRelationFilmPers obj);
	public void saveOrUpdate(ModifRelationFilmPers obj);
}
