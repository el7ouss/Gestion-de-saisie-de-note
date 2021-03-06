package tn.rnu.isetsf.dao;

import java.util.List;

import javax.ejb.Remote;

import tn.rnu.isetsf.model.Note;
import tn.rnu.isetsf.model.Valeur;

@Remote
public interface NoteDAORemote {
	public void save(Note note);

	public Note getById(Long id);

	public void delete(Note note);

	public List<Note> getAll();

	public List<Valeur> getAllValeur(Note note);

	public void edit(Note note);

}
