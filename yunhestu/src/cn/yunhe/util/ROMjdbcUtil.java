package cn.yunhe.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ROMjdbcUtil {



	/**
	 * @param sql
	 *            可以查询任何数据的sql语句
	 * @param clazz
	 *            将要查询的数据库所对应的实体类（该实体类的字段和数据库表里面的字段名一致）;
	 * @return
	 */
	public static List query(String sql, Class clazz) {
		List list = new ArrayList();
		try {
			JDBCutil.connection();
			ResultSet set = JDBCutil.query(sql, null);
			while (set.next()) {
				// ClassInfo classInfo = new ClassInfo();
				Object classInfo = clazz.newInstance();
				Method[] methods = clazz.getDeclaredMethods();
				for (Method method : methods) {
					String mathodName = method.getName();
					String fieldName = mathodName.substring(3);
					if (mathodName.startsWith("set")) {
						Class[] fielType = method.getParameterTypes();
						
						if (isExitCloum(set,fieldName)) {// 判断数据库中是否含有该字段，如有没有该字段
							String paramType=method.getParameterTypes()[0].getSimpleName();
//							System.out.println("javaBean中的数据类型："+paramType);
							Object value = set.getObject(fieldName);
							
							if(value!=null){
								String dbParamType=value.getClass().getSimpleName();
//								System.out.println("数据库中的数据类型："+dbParamType);
								if ("Date".equals(dbParamType)) {
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
									String dateStr=sdf.format(value);
									method.invoke(classInfo, dateStr);
								}else{
									method.invoke(classInfo, value);
								}
							}
							
						}
					}
				}
				list.add(classInfo);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   finally {
			try {
				JDBCutil.closeSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private static boolean isExitCloum(ResultSet set, String cloum) {
		boolean flag = false;
		try {
			int isExits = set.findColumn(cloum);
			if (isExits >0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}