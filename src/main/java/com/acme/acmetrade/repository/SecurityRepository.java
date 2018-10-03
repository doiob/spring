package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SecurityRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SecurityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveSecurity(Security security){
        jdbcTemplate.update("INSERT INTO SECURITIES(CURRENCY, AMOUNT, SIDE) VALUES(?,?,?,?)",
                security.getSymbol(), security.getCompanyName(), security.getSectorId(), security.getDescription());
    }

    public void getSectorId(String sectorName){
        jdbcTemplate.query("SELECT SECTOR_ID FROM MARKET_SECTOR WHERE SECTOR_NAME = ?",(new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String sectorId;
                sectorId = rs.getString("SECTOR_ID");

                return sectorId;
            }

        }),sectorName);
    }
}
