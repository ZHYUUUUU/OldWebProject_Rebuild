package com.xuebo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xuebo.bean.Expert;
import com.xuebo.bean.Student;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.impl.ExpertControllerImpl;
import com.xuebo.controller.impl.StudentControllerImpl;

/**
 * Servlet implementation class UploadAction
 */
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IStudentController studentController = new StudentControllerImpl();
	private IExpertController expertController = new ExpertControllerImpl();
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "images";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 5;  // 5MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		int type_int = Integer.parseInt(type);
		
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
 
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = "D:\\javaWorkSpaceLjb\\xuebo\\WebContent" + File.separator + UPLOAD_DIRECTORY;
        String uploadPath_tomcat = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
        //如果该工程已被搬至其他电脑，请以真实的地址修改以上uploadPath
        System.out.println(uploadPath);
         
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        File uploadDir_tomcat = new File(uploadPath_tomcat);
        if (!uploadDir_tomcat.exists()) {
            uploadDir_tomcat.mkdir();
        }
 
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        String filePath_tomcat = uploadPath_tomcat + File.separator + fileName;
                        File storeFile = new File(filePath);
                        File stortFile_tomcat = new File(filePath_tomcat);
                        // 在控制台输出文件的上传路径
                        String imagePath = "images/" + fileName;
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        item.write(stortFile_tomcat);
//                        request.setAttribute("message",
//                            "文件上传成功!");
                        
                        if(type_int == 0){//学员头像修改
                        	
                        	Student student = new Student();
                        	student.setStudentid(id);
                        	student.setStudentimage(imagePath);
                        	studentController.StudentUpdateImage(student);
                        	
                        	PrintWriter out = response.getWriter();
                			out.print("<script>alert('修改头像成功！'); window.location='PersonalActionForStudent?id=" + id + "' </script>");
                			out.flush();
                			out.close();
                        	
                        }else if(type_int == 1){//专家头像修改
                        	
                        	Expert expert = new Expert();
                        	expert.setExpertid(id);
                        	expert.setExpertimage(imagePath);
                        	expertController.ExpertUpdateImage(expert);
                        	
                        	PrintWriter out = response.getWriter();
                			out.print("<script>alert('修改头像成功！'); window.location='PersonalActionForExpert?id=" + id + "' </script>");
                			out.flush();
                			out.close();
                        	
                        }
                        
                    }
                }
            }
        } catch (Exception ex) {
        	
            if(type_int == 0){
            	
            	PrintWriter out = response.getWriter();
    			out.print("<script>alert('错误信息：" + ex.getMessage() + "'); window.location='PersonalActionForStudent?id=" + id + "' </script>");
    			out.flush();
    			out.close();
            	
            }else if(type_int == 1){
            	
            	PrintWriter out = response.getWriter();
    			out.print("<script>alert('错误信息：" + ex.getMessage() + "'); window.location='PersonalActionForExpert?id=" + id + "' </script>");
    			out.flush();
    			out.close();
            	
            }
//            request.setAttribute("message",
//                    "错误信息: " + ex.getMessage());
        }
		
	}

}
