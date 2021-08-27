package edu.vinaenter.cland.services;

import java.util.List;

import edu.vinaenter.cland.dto.LandDTO;
import edu.vinaenter.cland.models.Land;

public interface LandService {

	List<Land> findAll();
	
	List<Land> searchLand(String search);
	
	List<LandDTO> findOfCat(int cid);
	
	List<Land> findAll(int offset, int limit);
	
	List<Land> findAllByStatus(int offset, int limit);
	
	int totalRow();
	
	int add(Land land);
	
	int edit(Land land);
	
	int del(int landId);
	
	int delCid(int cid);
	
	LandDTO findOne(int landId);
	
	LandDTO findSingle(int lid);
	// CLAND
	int increaseView(int lid);
	
	List<LandDTO> findRelated(LandDTO landDTO, int number);
	
	List<Land> findLandHot();
	
	int countItemsByCat(int cid);
	
	int status(int aid);
	
	int UpdateStatus(int status, int lid);
	
}
