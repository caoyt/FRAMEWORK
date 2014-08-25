package com.caoyt.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-21 上午09:30:19
 * 
 * 文件操作
 * 
 */
public class FileHandlerUtils {
	/**
	 * 文件上传
	 * 
	 * @param srcFile 源文件
	 * @param srcFileName 源文件名
	 * @param targetFile 目标文件路径
	 * @return -1文件不存在; 1正常; 0异常
	 */
	public static String uploadFile(File srcFile, String srcFileName,
			String targetFilePath) {

		try {
			//如果文件不存在
			if(!srcFile.exists()){
				return "-1";
			}
			
			// 文件保存名称
			String fileName = UID.randomUUID();

			// 文件后缀名
			String suffix = getSuffix(srcFileName);

			File destFile = new File(targetFilePath, fileName + suffix);
			// 如果文件夹不存在就创建
			if (!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();

			FileUtils.copyFile(srcFile, destFile);
			
			//删除临时文件
			srcFile.delete();
			
			return targetFilePath + File.separator + fileName + suffix;

		} catch (IOException e) {
			e.printStackTrace();
			return "0";
		}

	}
	
	
	/**
	 * 文件下载
	 * 
	 * @param path 文件路径
	 * @return
	 */
	public static int downloadFile(String path){
		
		File file = new File(path);
		if(!file.exists()) return -1;
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		
		//文件名
		String fileName = UID.randomUUID();
		//扩展名
		String suffix = getSuffix(path);
		
		response.setHeader("Content-disposition", "attachment;filename="+fileName+suffix);
		
		
		byte[] buff = new byte[1024];
		
		int len = 0;
		
		InputStream in = null;
		OutputStream out = null;
		
		
		try {
			
			in = new FileInputStream(path);
			out = response.getOutputStream();
			
			while((len = in.read(buff)) != -1){
				out.write(buff, 0, len);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != in){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != out){
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return 1;
	}
	
	
	/**
	 * @param fileName 文件名称
	 * @return 文件扩展名
	 */
	public static String getSuffix(String fileName){
		
		return fileName.substring(fileName.lastIndexOf('.'));
		
	}
	
}
