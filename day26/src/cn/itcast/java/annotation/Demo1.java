package cn.itcast.java.annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
  /*��ʾannotation����������ע��*/
	//overrideע���ʾע��ķ��������صģ�������������صĹ淶���ͻᱨ��
	@Override
	public String toString(){
		return null;
	};
	//deprecated��ʾ�����ǹ�ʱ��
	@Deprecated
	public void run(){
		
	};
	//supperssWarnings��ʾ�Ա������Ծ�����Ϣ��һ���������
	@SuppressWarnings("all")
	public void show(){
		List list = new ArrayList();
	}
}
