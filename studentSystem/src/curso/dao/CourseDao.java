package curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import curso.model.Curso;

public class CourseDao {
	
	public void cadastrarCourse(Curso course) {
		String sql = "INSERT INTO courses VALUES (null,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn= null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, course.getName());
			pStatement.setString(2, course.getSemester());
			pStatement.setString(3, course.getIdUser());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public Curso BuscarCursoPorId(int idCourse) {
		String sql = "SELECT * FROM courses WHERE idCourse = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Curso curso = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idCourse);
			rs = pStatement.executeQuery();
			if (rs != null && rs.next()) {
				curso = new Curso();
				curso.setIdCourse(rs.getInt("idCourse"));
				curso.setName(rs.getString("name"));
				curso.setSemester(rs.getString("semester"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null) {
					pStatement.close();
					}
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			 
			try {
				if(conn!=null) {
					conn.close();
					}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return curso;
	}
	
	public ArrayList<Curso> BuscarCursosPorNome(String name, String idUser) {
		String sql = "SELECT * FROM courses WHERE name LIKE '%" + name + "%' AND idUser = '" + idUser + "'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Curso curso = null;		
		ArrayList<Curso> cursos = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if(rs != null) {
				cursos = new ArrayList<Curso>();		
				while (rs.next()) {
					curso = new Curso();
					curso.setIdCourse(rs.getInt("idCourse"));
					curso.setName(rs.getString("name"));
					curso.setSemester(rs.getString("semester"));
					curso.setIdUser(rs.getString("idUser"));
					cursos.add(curso);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null) {
					pStatement.close();
					}
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		
		return cursos;
	}	
	
	public void ExcluirCurso(int idCourse) {
		String sql = "DELETE FROM courses WHERE idCourse = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idCourse);
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
	}
	
	public void alterarCurso(Curso curso) {
		String sql = "UPDATE courses SET name = ?, semester = ? WHERE idCourse = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, curso.getName());
			pStatement.setString(2, curso.getSemester());
			pStatement.setInt(3, curso.getIdCourse());
			pStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null)
					pStatement.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			 
			try {
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<Curso> buscarTodosCursos(String idUser) {
		String sql = "SELECT * FROM courses WHERE idUser = '" + idUser + "'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Curso curso = null;		
		ArrayList<Curso> cursos = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if(rs != null) {
				cursos = new ArrayList<Curso>();		
				while (rs.next()) {
					curso = new Curso();
					curso.setIdCourse(rs.getInt("idCourse"));
					curso.setName(rs.getString("name"));
					curso.setSemester(rs.getString("semester"));
					curso.setIdUser(rs.getString("idUser"));
					cursos.add(curso);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pStatement != null) {
					pStatement.close();
					}
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		
		return cursos;
	}	
}
