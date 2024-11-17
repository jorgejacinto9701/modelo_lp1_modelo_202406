package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Pais;
import util.MySqlDBConexion;

public class ModelPais  {
	
	
	public List<Pais> lista() {
		List<Pais> salida = new ArrayList<Pais>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select * from pais order by nombre asc";
			pstm = conn.prepareStatement(sql);
			System.out.println("SQL => " + pstm);
			rs = pstm.executeQuery();
			Pais obj = null;
			while(rs.next()) {
				obj = new Pais();
				obj.setIdPais(rs.getInt(1));
				obj.setNombre(rs.getString(3));
				salida.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}
}

