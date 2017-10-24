package com.meecat.doctorapp.restcontroller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@RestController()
@Transactional
@RequestMapping("/api/image")
public class ImageRestController {

	@Autowired
	private Cloudinary cloudinary;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/upload")
	public Map upload(@RequestParam("file") MultipartFile file) throws IOException {

		Map params = ObjectUtils.asMap("folder", "doctoronline");

		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);

		return uploadResult;
	}

//	private static File multipartToFile(MultipartFile image) throws IllegalStateException, IOException {
//		//image.getBytes();
//		File convFile = new File("default.png"); //image.getOriginalFilename()
//		image.transferTo(convFile);
//		
//		return convFile;
//	}
}
