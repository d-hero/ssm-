package DISimple;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ��������Ϊ����������ν���di
 * @author Administrator
 *
 */
public class CollectionDI {
	private List<String> strs;
	private Map<Integer,String> map;
	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public List<String> getStrs() {
		return strs;
	}

	public void setStrs(List<String> strs) {
		this.strs = strs;
	}
	/**
	 * �鿴ע��ɹ�
	 */
	public void show(){
		for(String s:strs){
			System.out.println(s);
		}
	}
	public void showMap(){
		//�õ�key�ļ��ϣ�ͨ��key��ȡvalue
		/*Set<Integer> set = map.keySet();
		for(Integer i:set){
			System.out.println(map.get(i));
		}*/
		Set<Entry<Integer,String>> entrys = map.entrySet();
		for(Entry<Integer,String> entry:entrys){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
