package cn.wyc.tieba;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
//���Ѿ�������Ĳ���,���±��������
public class MyRequest extends  HttpServletRequestWrapper{
	
	private Map<String,String[]> params =new HashMap<String, String[]>();
	
	public MyRequest(HttpServletRequest request) {
		super(request);
	// �ڹ����л�÷�װ������map, ��map������������
	//-----------------------------------------------
		//1 ���map
		Map<String,String[]> map = super.getParameterMap();
		//2 ����map
		if(map!=null && map.size()>0){
			for(Entry<String, String[]> en : map.entrySet()){
				//3 ȡ��ÿ����ֵ��,�����ֵ������(���Ʒ�)
				String[] values = en.getValue();
				if(values!=null){
				String[] newValues = new String[values.length];
					for(int i = 0; i < values.length ;i++){
						try {
							newValues[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					//4 ������ļ�ֵ�� �����µ�map
					params.put(en.getKey(), newValues);
					}
			}
		}
		
	}

	@Override
	public String getParameter(String name) {
		String[] values = params.get(name);
		
		if(values==null){//��õĲ�����������
			return null;
		}
		
		return values[0];
	}

	@Override
	public Map<String,String[]> getParameterMap() {
		
		return params;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return params.get(name);
	}

	

}
