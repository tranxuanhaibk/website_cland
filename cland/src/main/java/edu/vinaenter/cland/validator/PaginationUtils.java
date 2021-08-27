package edu.vinaenter.cland.validator;

import edu.vinaenter.cland.constants.GlobalsConstant;

public class PaginationUtils {
	public static int getOffset(int currentPage) {
		return (currentPage - 1) * GlobalsConstant.LIMIT_PAGE;
	}
	
	public static int getOffset(int currentPage, int limit) {
		return (currentPage - 1) * limit;
	}
}
