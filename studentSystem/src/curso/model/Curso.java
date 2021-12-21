package curso.model;

import java.util.ArrayList;

import curso.dao.CourseDao;

public class Curso {
	private int idCourse;
	public String name;
	private String semester;
	private String idUser;
	
	public Curso() {

	}

	public Curso(String name, String semester, String idUser) {
		super();
		this.name = name;
		this.semester = semester;
		this.idUser = idUser;
	}

	public Curso(int idCourse, String name, String semester, String idUser) {
		this.idCourse = idCourse;
		this.name = name;
		this.semester = semester;
		this.idUser = idUser;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public void salvar() {
		new CourseDao().cadastrarCourse(this);
	}
	
	public void excluir(int idCourse) {
		new CourseDao().ExcluirCurso(idCourse);
	}
	
	public Curso buscarCursoPorId(int idCourse) {
		return new CourseDao().BuscarCursoPorId(idCourse);
	}
	
	public ArrayList<Curso> BuscarCursosPorNome(String name, String idUser) {
		return new CourseDao().BuscarCursosPorNome(name, idUser);
	}

	public void alterarCurso() {
		new CourseDao().alterarCurso(this);
	}
	
}
