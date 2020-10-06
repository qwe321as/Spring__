package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/*ProductDao  myProductDao = new ProductDao();*/

@Component("myProductDao")
public class ProductDao {
	
	private String namespace = "product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int getTotalCount(Map<String,String> map){
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	public List<Product> getDataList(Paging paging,Map<String,String> map){
		
		List<Product> lists = new ArrayList<Product>();
		RowBounds rowBounds = new RowBounds(paging.getOffset(),paging.getLimit()); // 10,5
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList",map,rowBounds);
		return lists;
	}
	public void insertData(Product product) {
		sqlSessionTemplate.insert(namespace+".insertData",product);	
		}
	public Product Content(String num) {
		Product product = new Product();
		product =sqlSessionTemplate.selectOne(namespace+".selectOne",num);
		return product;
	}
	public void update(Product product) {
		sqlSessionTemplate.update(namespace+".update",product);
	}
	public void delete(String num) {
		sqlSessionTemplate.delete(namespace+".delete",num);
	}
}










