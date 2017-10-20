package mapperDao;
import model.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface INewsTypeMapper {
	@Select("select * from newstype")
	public List<NewsTypeInfo> getAll();
}
