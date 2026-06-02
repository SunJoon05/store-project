package repository;

import model.entities.Market;

import java.sql.SQLException;

public interface MarketDao extends DaoBase<Market, Integer> {
    public Market findMarketById(int market_id) throws SQLException, ClassNotFoundException;
    public Market findMarketBySupervisorId(Integer supervisor_id) throws SQLException, ClassNotFoundException;
}
