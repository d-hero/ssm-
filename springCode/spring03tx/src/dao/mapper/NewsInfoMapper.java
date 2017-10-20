package dao.mapper;
import org.apache.ibatis.annotations.Insert;

import dao.inter.INewsDao;

import model.*;
public interface NewsInfoMapper {	
	@Insert("insert into newsinfo(typeid,title) values(#{newsType.id},#{title})")
	public void add(NewsInfo ni);
}
