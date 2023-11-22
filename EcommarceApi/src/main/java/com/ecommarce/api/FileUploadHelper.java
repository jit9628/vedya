package com.ecommarce.api;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileUploadHelper {

	@Autowired
	ServletContext context;
	String Upload_Dir = "";
	String realPath = "";

	public boolean doFileUpload(MultipartFile file, HttpServletRequest request) {
		boolean issuccess = false;
		if (file.isEmpty()) {
			return issuccess;
		}
		try {
//			ServletUriComponentsBuilder fromCurrentContextPath = ServletUriComponentsBuilder.fromCurrentContextPath();
//			fromCurrentContextPath.path("/upload_file/").toUriString();
//			log.info("current context path is " + fromCurrentContextPath);
			// Upload_Dir =
			// "D:\\EcommarceApi\\EcommarceApi\\src\\main\\webapp\\resources\\upload_file";
			realPath = context.getRealPath(File.separator + "resources" + File.separator + "upload_file");
			log.info("realPath context path is " + realPath);
			log.info("Upload Directory Is ::  " + file.getOriginalFilename());
			// get the bytes of image file
			byte[] bytes = file.getBytes();
			Path path = Paths.get(realPath + File.separator + file.getOriginalFilename());
			Files.write(path, bytes);
			log.info("original file name " + file.getOriginalFilename());
			log.info("file bytes ::" + bytes.toString());
			log.info("file Path" + path);
			log.info("file Path" + file.getSize());
			issuccess = true;
			return issuccess;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issuccess;
	}

	// delete file from folder
	public boolean deleteImageFromFolder(String filename) {
		try {
			
			//realPath = context.getRealPath(File.separator + "resources" + File.separator + "upload_file");
			//System.out.println("absolute path" + realPath);
			Path path = Paths.get(realPath + File.separator + filename);
			System.out.println("absolute path" + path);
			File file = new File(path.toString());
			System.out.println("absolute file" + file);
			System.out.println("File is Exists aor not " + file.getAbsolutePath());
			return (file.exists()) ? (file.delete()) ? true : false : false;
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}	
	}

}
