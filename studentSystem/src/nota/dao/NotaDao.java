package nota.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import nota.dao.MySqlConnection;
import nota.model.Nota;

public class NotaDao {
	public void cadastrarNota(Nota nota) {
		String sql = "INSERT INTO grades VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn= null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, nota.getIdCourse());
			pStatement.setString(2, nota.getName());
			pStatement.setString(3, nota.getGrade());
			pStatement.setString(4, nota.getIdUser());
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
	
	public Nota BuscarNotaPorId(int idGrade) {
		String sql = "SELECT * FROM grades WHERE idGrade = ?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Nota nota = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idGrade);
			rs = pStatement.executeQuery();
			if (rs != null && rs.next()) {
				nota = new Nota();
				nota.setIdGrade(rs.getInt("idGrade"));
				nota.setIdCourse(rs.getString("idCourse"));
				nota.setName(rs.getString("name"));
				nota.setGrade(rs.getString("grade"));
				nota.setIdUser(rs.getString("idUser"));
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
		return nota;
	}
	
	public ArrayList<Nota> BuscarNotasPorNome(String name, String idUser) {
		String sql = "SELECT * FROM grades WHERE name LIKE '%" + name + "%' AND idUser = '" + idUser + "'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Nota nota = null;		
		ArrayList<Nota> notas = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if(rs != null) {
				notas = new ArrayList<Nota>();		
				while (rs.next()) {
					nota = new Nota();
					nota.setIdGrade(rs.getInt("idGrade"));
					nota.setIdCourse(rs.getString("idCourse"));
					nota.setName(rs.getString("name"));
					nota.setGrade(rs.getString("grade"));
					nota.setIdUser(rs.getString("idUser"));
					notas.add(nota);
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
		
		return notas;
	}	
	
	public void ExcluirNota(int idGrade) {
		String sql = "DELETE FROM grades WHERE idGrade = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idGrade);
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
	
	public void alterarNota(Nota nota) {
		String sql = "UPDATE grades SET idCourse = ?, name = ?, grade = ? WHERE idGrade = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, nota.getIdCourse());
			pStatement.setString(2, nota.getName());
			pStatement.setString(3, nota.getGrade());
			pStatement.setInt(4,  nota.getIdGrade());
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
}
