package com.jsp.controller;

import java.io.File;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ServletFileUploadBuilder {

	public static ServletFileUpload build(int memory_threshold, int max_file_size, int max_request_size) {
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(memory_threshold);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(max_file_size);

		upload.setSizeMax(max_request_size);

		return upload;
	}
}
