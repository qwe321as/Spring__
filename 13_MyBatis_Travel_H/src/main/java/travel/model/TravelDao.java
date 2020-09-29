package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/*TravelDao myTravelDao = new TravelDao()*/

@Component("myTravelDao") 
public class TravelDao {
	
	String namespace = "travel.TravelBean";
	
	@Autowired // 객체를 아래 변수에 넣어라(객체는 root-context.xml에서 만들었다.)
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.insert(namespace + ".InsertTravel",travel);
		System.out.println("cnt : " + cnt);
	}
	
	public List<TravelBean> getTravelList(Paging pageInfo, Map<String,String> map){
		List<TravelBean> lists = new ArrayList<TravelBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace + ".GetTravelList",map,rowBounds);
		return lists;
	}
	
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	public void deleteTravel(int num){
		sqlSessionTemplate.delete(namespace +".DeleteTravel",num);
	}
	
	public int updateTravel(TravelBean bean) {
		int cnt = sqlSessionTemplate.update(namespace+".UpdateTravel",bean);
		return cnt;
	}
	public TravelBean getOneTravel(int num) {
		TravelBean travel = null;
		travel = sqlSessionTemplate.selectOne(namespace+".GetOneTravel",num);
		return travel;
		
	}
}






