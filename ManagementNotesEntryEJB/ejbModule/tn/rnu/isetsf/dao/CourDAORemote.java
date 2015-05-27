package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Cour;
import tn.rnu.isetsf.model.Note;

@Remote
public interface CourDAORemote {
	public void save(Cour cour);

	public Cour getById(Long id);

	public void delete(Cour cour);

	public List<Cour> getAll();

	public List<Note> getAllNote(Cour cour);

	public void edit(Cour cour);

}
