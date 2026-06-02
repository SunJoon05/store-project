package repository;

import model.entities.Market;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static database.DataSource.getConnection;

public class MarketRepo implements MarketDao {

    UserService user_service;

    public MarketRepo() {
        UserRepo USER_DAO = new UserRepo();
        user_service = new UserService(USER_DAO);
    }

    @Override
    public Market findMarketById(int market_id) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM markets WHERE market_id = ?";
        Market market = null;

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, market_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    market = new Market();
                    market.setId(rs.getInt("market_id"));
                    market.setName(rs.getString("name"));
                    market.setSupervisor(this.user_service.getUserById(rs.getInt("supervisor_id")));
                }
            }
        }

        return market;
    }

    @Override
    public Market findMarketBySupervisorId(Integer supervisor_id) throws SQLException, ClassNotFoundException {
        String query = "SELECT id, name, supervisor_id FROM market WHERE supervisor_id = ?";
        Market market = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, supervisor_id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    market = new Market();
                    market.setId(rs.getInt("id"));
                    market.setName(rs.getString("name"));
                    market.setSupervisor(this.user_service.getUserById(rs.getInt("supervisor_id")));
                }
            }
        }

        return market;
    }

    @Override
    public List<Market> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public Boolean insert(Market entity) throws SQLException {
        return null;
    }

    @Override
    public Boolean update(Market entity) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) throws SQLException {
        return null;
    }
}
