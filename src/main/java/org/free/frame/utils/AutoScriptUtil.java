package org.free.frame.utils;

import java.io.IOException;

public class AutoScriptUtil {
	private static String autoItExecutablePath;
	
	private static String autoItScriptPath;
	
	public void FileLoading(String filepath,int timeTowait,boolean isUpLoad) {
		try {				
			String[] scriptcmd = new String[] { autoItExecutablePath, autoItScriptPath, filepath };
			Runtime.getRuntime().exec(scriptcmd);
			// 等待AutoIt脚本开始执行
			Thread.sleep(timeTowait);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
