package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.sql.*;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutages;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}

	public List<PowerOutages> getPowerOutages(Integer years, Integer hours, Nerc n) {
		String sql = "select *, DATEDIFF(p.`date_event_finished`, p.`date_event_began`) as dif "+
					"from `PowerOutages`as p "+
					"where p.`date_event_began`<= ? and DATEDIFF(p.`date_event_finished`, p.`date_event_began`)<=? and p.`nerc_id`=? ";
		List<PowerOutages> poList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			LocalDate start = LocalDate.of((2014-years), 12, 31);
			System.out.print(start+"\n");
			Date d = Date.valueOf(start);
			System.out.println(d+"\n");
			System.out.println(n.getId()+"\n");
			System.out.println(hours+"\n");
			st.setDate(1, d);
			st.setInt(3, n.getId());
			st.setInt(2, hours);
			
			ResultSet res = st.executeQuery();
			while (res.next()) {
				//Integer id, Nerc nerc, LocalDateTime inizio, LocalDateTime fine, Integer personeCoinvolte
				PowerOutages po = new PowerOutages (res.getInt(1), res.getDate(8).toLocalDate(), res.getDate(9).toLocalDate(), res.getInt(7), res.getInt("dif"));
				poList.add(po);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return poList;
	}
	

}
