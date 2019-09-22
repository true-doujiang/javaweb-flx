<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<% 
    	String path = application.getRealPath("/1.jpg");
    	String filename = path.substring(path.lastIndexOf("\\")+1);
    	response.setHeader("content-disposition","attachment;filename=" + filename);
    	
    	FileInputStream in = new FileInputStream(path);
    	int len = 0;
    	byte buffer[] = new byte[1024];
    	OutputStream sout =  response.getOutputStream();
    	while((len=in.read(buffer))>0){
    		sout.write(buffer,0,len);
    	}
    	sout.close();
    	in.close();
%>