package edu.vinaenter.cland.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.cland.dto.LandDTO;
import edu.vinaenter.cland.models.Category;
import edu.vinaenter.cland.models.Land;

@Repository
public class LandDAO extends AbstractDAO{
	
	private static final String FIND_ALL = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY lid DESC";
	private static final String FIND_LAND_HOT = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY count_views DESC LIMIT 5";
	private static final String FIND_ALL_PAGINATE = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY lid DESC LIMIT ?,?";
	private static final String FIND_ALL_PAGINATE_STATUS = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid AND l.status = 1 ORDER BY lid DESC LIMIT ?,?";
	private static final String TOTAL_ROW = "SELECT COUNT(*) AS totalROW FROM lands";
	private static final String ADD_LAND = "INSERT INTO lands(lname, description, cid, picture, area, address, longitude, latitude) VALUES(?,?,?,?,?,?,?,?)";
	private static final String DEL_SQL = "DELETE FROM lands WHERE lid = ?";
	private static final String FIND_ONE = "SELECT lid, lname, description, address, date_create AS dateCreate, picture, count_views AS countViews, area, longitude, latitude FROM lands WHERE lid = ?";
	private static final String FIND_OF_CAT = "SELECT lid, status, lname, description, address, date_create AS dateCreate, picture, count_views AS countViews, area, longitude, latitude FROM lands WHERE cid = ? AND status = 1";
	private static final String FIND_ONE_SINGLE = "SELECT lid, lname, description, address,cid, date_create AS dateCreate, picture, count_views AS countViews, area, longitude, latitude FROM lands WHERE lid = ?";
	private static final String EDIT = "UPDATE lands SET lname = ?, description = ?, cid = ?, picture = ?, area = ?, address = ?, longitude = ?, latitude = ? WHERE lid = ?";
	private static final String VIEWS = "UPDATE lands SET count_views = count_views + 1 WHERE lid = ?";
	private static final String FIND_RELATED = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE l.cid= ? && l.lid != ? AND status = 1 ORDER BY lid DESC LIMIT ?";
	private static final String COUNT_ITEMS_BY_CAT = "SELECT COUNT(*) AS count FROM lands WHERE cid = ? AND status = 1";
	private static final String SEARCH = "SELECT * FROM lands l INNER JOIN categories c ON l.cid = c.cid WHERE lname LIKE ? OR cname LIKE ?";
	private static final String STATUS_BY_LID = "SELECT status FROM lands WHERE lid = ?";
	private static final String UPDATE_STATUS_LAND = "UPDATE lands SET status = ? WHERE lid = ?";
	private static final String DEL_SQL_CAT = "DELETE FROM lands WHERE cid = ?";
	
	public List<Land> findAll(){
		return getJdbcTemplate().query(FIND_ALL, new ResultSetExtractor<List<Land>>() {
			List<Land> landList = new ArrayList<Land>();
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Land land = new Land(rs.getInt("lid"), rs.getString("lname"),
							rs.getString("description"), rs.getTimestamp("date_create")
							, new Category(rs.getInt("cid"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"),rs.getInt("status"),
							rs.getFloat("longitude"),rs.getFloat("latitude"));
					landList.add(land);
				}
				return landList;
			}
		});
		
	}
	public List<Land> findLandHot() {
		return getJdbcTemplate().query(FIND_LAND_HOT, new ResultSetExtractor<List<Land>>() {
			List<Land> landList = new ArrayList<Land>();
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Land land = new Land(rs.getInt("lid"), rs.getString("lname"),
							rs.getString("description"), rs.getTimestamp("date_create")
							, new Category(rs.getInt("cid"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"),rs.getInt("status"),
							rs.getFloat("longitude"),rs.getFloat("latitude"));
					landList.add(land);
				}
				return landList;
			}
		});
	}
	public int totalRow() {
		return getJdbcTemplate().queryForObject(TOTAL_ROW, Integer.class);
	}
	
	public List<Land> findAll(int offset,int limit){
		return getJdbcTemplate().query(FIND_ALL_PAGINATE, new ResultSetExtractor<List<Land>>() {
			List<Land> landList = new ArrayList<Land>();
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Land land = new Land(rs.getInt("lid"), rs.getString("lname"),
							rs.getString("description"), rs.getTimestamp("date_create")
							, new Category(rs.getInt("cid"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"),rs.getInt("status"),
							rs.getFloat("longitude"),rs.getFloat("latitude"));
					landList.add(land);
				}
				return landList;
			}
		}, new Object[] {offset,limit});
		
	}
	
	public List<Land> findAllByStatus(int offset,int limit){
		return getJdbcTemplate().query(FIND_ALL_PAGINATE_STATUS, new ResultSetExtractor<List<Land>>() {
			List<Land> landList = new ArrayList<Land>();
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Land land = new Land(rs.getInt("lid"), rs.getString("lname"),
							rs.getString("description"), rs.getTimestamp("date_create")
							, new Category(rs.getInt("cid"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"),rs.getInt("status"),
							rs.getFloat("longitude"),rs.getFloat("latitude"));
					landList.add(land);
				}
				return landList;
			}
		}, new Object[] {offset,limit});
		
	}

	public int add(Land land) {
		return getJdbcTemplate().update(ADD_LAND, new Object[] {land.getLname(), land.getDescription(),
				land.getCategory().getCid(), land.getPicture(), land.getArea(),
				land.getAddress(), land.getLongitude(), land.getLatitude()});
		}
	public int del(int landId) {
		return getJdbcTemplate().update(DEL_SQL, new Object[] {landId});
	}
	public LandDTO findOne(int landId) {
		return getJdbcTemplate().queryForObject(FIND_ONE, new Object[] {landId}, new BeanPropertyRowMapper<>(LandDTO.class));
	}

	public LandDTO findSingle(int lid) {
		return getJdbcTemplate().queryForObject(FIND_ONE_SINGLE, new Object[] {lid}, new BeanPropertyRowMapper<>(LandDTO.class));
	}

	public List<LandDTO> findOfCat(int cid) {
		return getJdbcTemplate().query(FIND_OF_CAT, new Object[] {cid}, new BeanPropertyRowMapper<>(LandDTO.class));
	}

	public int edit(Land land) {
		return getJdbcTemplate().update(EDIT, new Object[] {land.getLname(), land.getDescription(), land.getCategory().getCid(), land.getPicture(), land.getArea(), land.getAddress(), land.getLongitude(), land.getLatitude(), land.getLid()});
	}

	public int increaseView(int lid) {
		return getJdbcTemplate().update(VIEWS, new Object[] {lid});
	}

	public List<LandDTO> findRelated(LandDTO landDTO, int number) {
		return getJdbcTemplate().query(FIND_RELATED, new Object[] {landDTO.getCid(), landDTO.getLid(), number}, new BeanPropertyRowMapper<>(LandDTO.class));
	}
	
	public int countItemsByCat(int cid){
		return getJdbcTemplate().query(COUNT_ITEMS_BY_CAT, new Object[] {cid}, new ResultSetExtractor<Integer>() {
			Integer count = 0;
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					count = rs.getInt("count");
				}
				return count;
			}
		});
	}
	public List<Land> searchLand(String search){
		String sear = "%"+search+"%" ;
		return getJdbcTemplate().query(SEARCH, new Object[] {sear,sear}, new ResultSetExtractor<List<Land>>() {
			List<Land> listLand = new ArrayList<Land>();
			@Override
			public List<Land> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Land land = new Land(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), 
							rs.getTimestamp("date_create"), new Category(rs.getInt("cid"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"), rs.getInt("count_views"),rs.getInt("status"),
							rs.getFloat("longitude"),rs.getFloat("latitude"));
					listLand.add(land);
				}
				return listLand;
			}
		});
		
	}
	public int status(int aid) {
		return getJdbcTemplate().queryForObject(STATUS_BY_LID, new Object[] {aid}, Integer.class);
	}
	public int updateStatus(int status, int lid) {
		return getJdbcTemplate().update(UPDATE_STATUS_LAND, new Object[] {status, lid});
	}
	public int delCid(int cid) {
		return getJdbcTemplate().update(DEL_SQL_CAT, new Object[] {cid});
	}
		
}
