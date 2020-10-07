package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {
	private String namespace = "order.model.Order";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertDate(String id) {
		sqlSessionTemplate.insert(namespace+".insert",id);
	}

	public int getMaxoid() {
		int maxoid = sqlSessionTemplate.selectOne(namespace+".getMaxoid");
		return maxoid;
	}
}
