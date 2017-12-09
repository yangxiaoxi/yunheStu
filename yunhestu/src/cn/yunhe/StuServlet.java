package cn.yunhe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.yunhe.biz.RecordManager;
import cn.yunhe.biz.ScoreManager;
import cn.yunhe.biz.StudentManager;
import cn.yunhe.biz.impl.RecordManagerImpl;
import cn.yunhe.biz.impl.ScoreManagerimpl;
import cn.yunhe.biz.impl.StudentManagerImpl;
import cn.yunhe.entity.Record;
import cn.yunhe.entity.Score;
import cn.yunhe.entity.Student;
 
@WebServlet("/stuServlet")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentManager stuManager = new StudentManagerImpl();
    private ScoreManager scoreManger = new ScoreManagerimpl();
    private RecordManager  recordManager = new RecordManagerImpl();
    
    public StuServlet() {
        super();
        
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 String mehtod = request.getParameter("method");
		 if("stuInfo".equals(mehtod)){
			 interfanceStuInfo(request,response);
		 }else if("stuScore".equals(mehtod)){
			 interfanceStuScore(request,response);
		 }else if("stuRecord".equals(mehtod)){
			 interfanceStuRecord(request,response);
		 }
	}

	
	/**
	 * ��ѧ���򿨼�¼�����json�ַ�
	 * @param request
	 * @param response
	 */
	private void interfanceStuRecord(HttpServletRequest request,
			HttpServletResponse response) {
		String stu_id = request.getParameter("stu_id");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("PageSize");
		JSONObject jsonObject = new JSONObject();
		if(stu_id==null||"".equals(stu_id)){//���ѧ��idΪ��
			jsonObject.put("status", 500);
			
		}else{//���ѧ��id��Ϊ��
			if(currentPage==null||"".equals(currentPage)||pageSize==null||"".equals(pageSize)){
				List<Record> listRecord = 	recordManager.query(Integer.parseInt(stu_id));
				jsonObject.put("status", 200);
				jsonObject.put("stuRecore", listRecord);
			}else{
				jsonObject.put("status", 200);
				List<Record> pageRecord = recordManager.queryByIdPage(Integer.parseInt(stu_id), Integer.parseInt(currentPage), Integer.parseInt(pageSize));
				jsonObject.put("stuRecord", pageRecord);
				
			}
		}
		
		try {
			response.getWriter().print(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * ��ѧ�����������json�ַ�
	 * @param request
	 * @param response
	 */
	private void interfanceStuScore(HttpServletRequest request,
			HttpServletResponse response) {
		String stu_id = request.getParameter("stu_id");
		JSONObject jo = new JSONObject();
		if(stu_id==null||"".equals(stu_id)){
			jo.put("status", 500);
		}else{
			List<Score> scoreList  = scoreManger.queryByStuid(Integer.parseInt(stu_id));
			jo.put("status", 200);
			jo.put("stuScore", scoreList);
			try {
				response.getWriter().print(jo.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		
	}

	/** 
	 * ��ѧ����Ϣ�����json�ַ�
	 * @param request
	 * @param response
	 */
	private void interfanceStuInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String stu_id = request.getParameter("stu_id");
		JSONObject jsonObejct  = new JSONObject();//����һ��JsonObject����
		if(stu_id==null||"".equals(stu_id)){
			   jsonObejct.put("status",500);
			try {
				response.getWriter().print(jsonObejct.toString());
			} catch (IOException e) {
			   	e.printStackTrace();
			}
		}else{
			 Student stu = stuManager.querystuBystuid(Integer.parseInt(stu_id));
			 jsonObejct.put("status", 200);
			 jsonObejct.put("stuInfo", stu);
			 try {
				response.getWriter().print(jsonObejct.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	   
		 	
	}

}
