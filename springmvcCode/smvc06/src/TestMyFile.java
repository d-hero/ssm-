import java.util.List;

import dao.MyFileDao;
import entity.MyFile;


public class TestMyFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFileDao dao =new MyFileDao();
		//List<MyFile> list = dao.select();
		MyFile m = dao.getById(1);
		System.out.println(m.getBcwjm());
	}

}
