package nota.model;

import java.util.ArrayList;

import nota.dao.NotaDao;

public class Nota {
	private int idGrade;
	private String idCourse;
	private String name;
	private String grade;
	private String idUser;

	public Nota() {
	
	}
	
	public Nota(String idCourse, String name, String grade, String idUser) {
		super();
		this.idCourse = idCourse;
		this.name = name;
		this.grade = grade;
		this.idUser = idUser;
	} 

	public Nota(int idGrade, String idCourse, String name, String grade, String idUser) {
		this.idGrade = idGrade;
		this.idCourse = idCourse;
		this.name = name;
		this.grade = grade;
		this.idUser = idUser;
	}

	public int getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(int idGrade) {
		this.idGrade = idGrade;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	public void salvar() {
		new NotaDao().cadastrarNota(this);
	}
	
	public void excluir(int idGrade) {
		new NotaDao().ExcluirNota(idGrade);
	}
	
	public Nota buscarNotaPorId(int idGrade) {
		return new NotaDao().BuscarNotaPorId(idGrade);
	}
	
	public ArrayList<Nota> BuscarNotasPorNome(String name, String idUser) {
		return new NotaDao().BuscarNotasPorNome(name, idUser);
	}
	
	public void alterarNota() {
		new NotaDao().alterarNota(this);
	}

}
