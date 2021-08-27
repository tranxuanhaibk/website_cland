package edu.vinaenter.cland.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.cland.daos.LandDAO;
import edu.vinaenter.cland.dto.LandDTO;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.LandService;
@Service
public class LandServiceImpl implements LandService {

	@Autowired
	private LandDAO landDAO;
	@Override
	public List<Land> findAll() {
		return landDAO.findAll();
	}
	@Override
	public int totalRow() {
		return landDAO.totalRow();
	}
	@Override
	public List<Land> findAll(int offset, int limit) {
		return landDAO.findAll(offset, limit);
	}
	
	@Override
	public int add(Land land) {
		return landDAO.add(land);
	}
	
	@Override
	public int del(int landId) {
		return landDAO.del(landId);
	}
	
	@Override
	public LandDTO findOne(int landId) {
		return landDAO.findOne(landId);
	}
	@Override
	public LandDTO findSingle(int lid) {
		return landDAO.findSingle(lid);
	}
	@Override
	public List<LandDTO> findOfCat(int cid) {
		return landDAO.findOfCat(cid);
	}
	@Override
	public int edit(Land land) {
		return landDAO.edit(land);
	}
	@Override
	public int increaseView(int lid) {
		return landDAO.increaseView(lid);
	}
	@Override
	public List<LandDTO> findRelated(LandDTO landDTO,int number) {
		return landDAO.findRelated(landDTO,number);
	}
	@Override
	public List<Land> findLandHot() {
		return landDAO.findLandHot();
	}
	@Override
	public int countItemsByCat(int cid) {
		return landDAO.countItemsByCat(cid);
	}
	@Override
	public List<Land> searchLand(String search) {
		return landDAO.searchLand(search);
	}
	@Override
	public List<Land> findAllByStatus(int offset, int limit) {
		return landDAO.findAllByStatus(offset, limit);
	}
	@Override
	public int status(int aid) {
		return landDAO.status(aid);
	}
	@Override
	public int UpdateStatus(int status, int lid) {
		return landDAO.updateStatus(status, lid);
	}
	@Override
	public int delCid(int cid) {
		return landDAO.delCid(cid);
	}

}
