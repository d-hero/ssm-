package dao.mapper;
import org.apache.ibatis.annotations.Insert;

import model.*;
public interface NewsTypeInfoMapper {
	@Insert("insert into newstype(typename) values(#{typeName})")
	public void add(NewsTypeInfo nt);
}
