package c3po.iyunmai;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3poUtil {
	private static final Logger logger = LoggerFactory.getLogger(c3poUtil.class);
	private static final ComboPooledDataSource COMBOPOOLED_DATASOURCE = new ComboPooledDataSource();

	static {
		try {
			COMBOPOOLED_DATASOURCE.setDriverClass(c3poConfig.JDBC_DRIVER);
			COMBOPOOLED_DATASOURCE.setJdbcUrl(c3poConfig.URL);
			COMBOPOOLED_DATASOURCE.setUser(c3poConfig.USER);
			COMBOPOOLED_DATASOURCE.setPassword(c3poConfig.PASSWORD);
			COMBOPOOLED_DATASOURCE.setMaxStatements(180);
		} catch (PropertyVetoException e) {
			logger.error("{}", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		logger.info("打开连接");
		return COMBOPOOLED_DATASOURCE.getConnection();
	}

	public static Connection getConnection(String driveName, String url, String username, String password) {
		try {
			Class.forName(driveName);// 指定连接类型
			return DriverManager.getConnection(url, username, password);// 获取连接
		} catch (Exception e) {
			logger.error("{}", e);
		}
		return null;
	}

	public static void close(Connection connection, Statement statement, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("异常：{}", e);
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error("异常：{}", e);
			}
		}
		if (connection != null) {
			try {
				logger.info("关闭连接");
				connection.close();
			} catch (SQLException e) {
				logger.error("异常：{}", e);
			}
		}
	}

	public static void close(PreparedStatement statement, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("异常：{}", e);
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error("异常：{}", e);
			}
		}
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				logger.info("关闭连接");
				connection.close();
			} catch (SQLException e) {
				logger.error("异常：{}", e);
			}
		}
	}

	public static int executeUpdate(Connection connection, String sql, Object... params) throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		int value = 0;
		try {
			prepareStatement = connection.prepareStatement(sql);
			int i = 1;
			for (Object param : params) {
				prepareStatement.setObject(i++, param);
			}
			value = prepareStatement.executeUpdate();
		} finally {
			c3poUtil.close(prepareStatement, rs);
		}
		return value;
	}

	public static int executeUpdateGenerateKey(Connection connection, String sql, Object... params)
			throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		int value = 0;
		try {
			prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int i = 1;
			for (Object param : params) {
				prepareStatement.setObject(i++, param);
			}
			prepareStatement.executeUpdate();
			rs = prepareStatement.getGeneratedKeys();
			if (rs.next()) {
				value = rs.getInt(1);
			}
		} finally {
			c3poUtil.close(prepareStatement, rs);
		}
		return value;
	}

	public static Object executeQueryObject(Connection connection, String sql, Object... params) throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			int i = 1;
			for (Object param : params) {
				prepareStatement.setObject(i++, param);
			}
			rs = prepareStatement.executeQuery();
			if (rs.next()) {
				obj = rs.getObject(1);
			}
		} finally {
			c3poUtil.close(prepareStatement, rs);
		}
		return obj;
	}

	public static List<Object> executeQueryList(Connection connection, String sql, Object... params)
			throws SQLException {
		List<Object> list = new ArrayList<Object>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			int i = 1;
			for (Object param : params) {
				prepareStatement.setObject(i++, param);
			}
			rs = prepareStatement.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			if (rs.next()) {
				for (i = 1; i <= columnCount; ++i) {
					Object td = rs.getObject(i);
					if (td == null) {
						td = 0;
					}
					list.add(td);
				}
			}
		} finally {
			c3poUtil.close(prepareStatement, rs);
		}
		return list;
	}

	public static List<List<Object>> executeQueryRowList(Connection connection, String sql, Object... params)
			throws SQLException {
		List<List<Object>> rowList = new ArrayList<List<Object>>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			int i = 1;
			for (Object param : params) {
				prepareStatement.setObject(i++, param);
			}
			rs = prepareStatement.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			List<Object> row = null;
			while (rs.next()) {
				row = new ArrayList<Object>();
				for (i = 1; i <= columnCount; ++i) {
					Object td = rs.getObject(i);
					if (td == null) {
						td = 0;
					}
					row.add(td);
				}
				rowList.add(row);
			}
		} finally {
			c3poUtil.close(prepareStatement, rs);
		}
		return rowList;
	}

	public static List<Object> executeQueryOneColumnList(Connection connection, String sql, Object... params)
			throws SQLException {
		List<Object> rowList = new ArrayList<Object>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			int i = 1;
			for (Object param : params) {
				prepareStatement.setObject(i++, param);
			}
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				rowList.add(rs.getObject(1));
			}
		} finally {
			c3poUtil.close(prepareStatement, rs);
		}
		return rowList;
	}

	public static int[] executeBatchUpdate(Connection connection, String sql, List<List<Object>> paramsList)
			throws SQLException {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		int[] counts = null;
		try {
			//connection.setAutoCommit(false);
			prepareStatement = connection.prepareStatement(sql);
			for (List<Object> params : paramsList) {
				int i = 1;
				for (Object param : params) {
					prepareStatement.setObject(i++, param);
				}
				prepareStatement.addBatch();
			}
			counts = prepareStatement.executeBatch();
			//connection.commit();
			//connection.setAutoCommit(true);
		} finally {
			c3poUtil.close( prepareStatement, rs);
		}
		return counts;
	}

	public static List<Object[]> queryList(Connection connection,String sql, Object... params) {
		QueryRunner queryRunner = new QueryRunner();
		try {
			connection = COMBOPOOLED_DATASOURCE.getConnection();
			List<Object[]> result = queryRunner.query(connection, sql, new ArrayListHandler(), params);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return Collections.emptyList();
	}

	public static <T> List<T> queryList(String sql, Class<T> type, Object... params) {
		Connection conn = null;
		QueryRunner queryRunner = new QueryRunner();
		try {
			conn = COMBOPOOLED_DATASOURCE.getConnection();
			List<T> result = queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("{}", e);
				}
			}
		}
		return Collections.emptyList();
	}

	public static List<Map<String, Object>> queryMapList(String sql, Object... params) {
		Connection conn = null;
		QueryRunner queryRunner = new QueryRunner();
		try {
			conn = COMBOPOOLED_DATASOURCE.getConnection();
			List<Map<String, Object>> result = queryRunner.query(conn, sql, new MapListHandler(), params);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("{}", e);
				}
			}
		}
		return Collections.emptyList();
	}

}
