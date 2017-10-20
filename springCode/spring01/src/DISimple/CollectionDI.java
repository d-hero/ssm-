package DISimple;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 讲解属性为集合类型如何进行di
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
	 * 查看注入成果
	 */
	public void show(){
		for(String s:strs){
			System.out.println(s);
		}
	}
	public void showMap(){
		//得到key的集合，通过key获取value
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
