package service;

import model.entities.Market;
import repository.MarketRepo;

import java.sql.SQLException;

public class MarketService {

    private final MarketRepo DAO;

    public MarketService(MarketRepo DAO) {
        this.DAO = DAO;
    }

    public Market getMarketBySupervisorId(Integer supervisor_id) throws SQLException, ClassNotFoundException {
        return this.DAO.findMarketBySupervisorId(supervisor_id);
    }

    public Market getMarketById(Integer market_id) throws SQLException, ClassNotFoundException {
        return this.DAO.findMarketById(market_id);
    }
}
