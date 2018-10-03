package com.acme.acmetrade.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.acme.acmetrade.domain.Sector;
import com.acme.acmetrade.domain.Security;

@Repository
public class SecurityRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public SecurityRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveSecurity(Security security) {
		return jdbcTemplate.update(
				"INSERT INTO SECURITIES(SYMBOL, COMPANY_NAME, COMPANY_DESC, SECTOR_ID) VALUES(?,?,?,?)",
				security.getSymbol(), security.getCompanyName(), security.getDescription(), security.getSectorId());
	}

	public int updateSecurity(Security security) {
		return jdbcTemplate.update("UPDATE SECURITIES SET SYMBOL = ?, COMPANY_NAME = ?, COMPANY_DESC = ? WHERE SECTOR_ID = ?",
				security.getSymbol(), security.getCompanyName(), security.getDescription(), security.getSectorId());
	}

	public int deleteSecurity(Security security) {
		return jdbcTemplate.update("DELETE SECURITIES WHERE SECTOR_ID = ?",
				security.getSectorId());
	}

	public List<Security> getAllSecurities() {
		return jdbcTemplate.query("SELECT * from SECURITIES", new SecurityRowMapper());
	}

	public Security getSecurityBySymbol(String symbol) {
		return (Security)jdbcTemplate.query("SELECT * from SECURITIES where SYMBOL = ?",new Object[] {symbol} , new SecurityRowMapper());
	}

	public List<Security> getSecuritiesBySectorId(Sector sector) {
		return jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con.prepareStatement("SELECT * from SECURITIES where SECTOR_ID = ?");
				stmt.setInt(1, sector.getId());
				return stmt;
			}
		}, new SecurityRowMapper());
	}

	class SecurityRowMapper implements RowMapper<Security> {

		@Override
		public Security mapRow(ResultSet rs, int rowNum) throws SQLException {
			Security security = new Security();
			security.setSymbol(rs.getString("SYMBOL"));
			security.setCompanyName(rs.getString("COMPANY_NAME"));
			security.setDescription(rs.getString("COMPANY_DESC"));
			security.setSectorId(rs.getInt("SECTOR_ID"));
			return security;
		}
	}

}
