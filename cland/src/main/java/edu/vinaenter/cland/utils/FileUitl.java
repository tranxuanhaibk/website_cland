package edu.vinaenter.cland.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import edu.vinaenter.cland.constants.GlobalsConstant;
@Component
public class FileUitl {
	
	@Autowired
	private ServletContext servletContext;
	
	public static String upload(MultipartFile mtf, 
			HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = mtf.getOriginalFilename();
		if (!"".equals(fileName)) {
			String webPath = request.getServletContext().getRealPath("");
			String dirPath = webPath + GlobalsConstant.DIR_UPLOAD;
			if(!new File(dirPath).exists()) {
				new File(dirPath).mkdir();
		}
			String pathFile = dirPath + File.separator + fileName;
			mtf.transferTo(new File(pathFile));
			System.out.println("pathFile" + pathFile);
		}
		
		return fileName;
	}
	public static void del(String picture, HttpServletRequest request) {
		if ("".equals(picture)) {
			String filePath = request.getServletContext().getRealPath("") + GlobalsConstant.DIR_UPLOAD + File.separator + picture;
			File file = new File(filePath);
			file.delete();
		}
	}
	public String getDirPath() {
		return servletContext.getRealPath("") + GlobalsConstant.DIR_UPLOAD;
	}
	public static String rename(String fileName) {
		String fileNameNew = "";
		if (!"".equals(fileName)) {
			fileNameNew = FilenameUtils.getBaseName(fileName) + "-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
		}
		System.out.println("fileNameNew" + fileNameNew);
		return fileNameNew;
	}
}
