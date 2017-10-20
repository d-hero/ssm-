package mapperDao;

import org.apache.ibatis.annotations.Insert;

import model.NewsInfo;

public interface INewsMapper {
	@Insert("insert into newsinfo values(seqnews.nextval,#{newsType.id},#{title})")
	public void add(NewsInfo ni);
	
	public int getResultByTitle();
}
