package fr.eni.projetEncheres.dal.jdbc;

import fr.eni.projetEncheres.dal.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Julian
 */

public class JdbcTools {
	
    static Connection connect() {
        Connection cnx = null;
        try {
            cnx = ConnectionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnx;
    }

}
