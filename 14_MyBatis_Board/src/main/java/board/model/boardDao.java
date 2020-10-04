package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import board.utility.Paging;
@Component("myboardDao")
public class boardDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insertboard(boardBean board) {
		int cnt = sqlSessionTemplate.insert("board.boardBean.Insertboard",board);
		return cnt;
	}
	
	public List<boardBean> getboardList(Paging pageInfo ,Map<String,String> map) {
		List<boardBean> lists = new ArrayList<boardBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList("board.boardBean.Selectboard",map,rowBounds);
		return lists;
	}
	public int getboardCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne("board.boardBean.getboardCount",map);
		return cnt;
	}
	
	public boardBean getOneboard(int num) {
		boardBean board =  null;
		board = sqlSessionTemplate.selectOne("board.boardBean.GetOneboard",num);
		sqlSessionTemplate.update("board.boardBean.content",num);
		return board;
	}
	public int updateboard(boardBean board) {
		int cnt = sqlSessionTemplate.update("board.boardBean.Updateboard",board);
		return cnt;
	}
	
	public boardBean deletepasswd(String passwd ) {
		boardBean board =  null;
		board = sqlSessionTemplate.selectOne("board.boardBean.GetOnedelete",passwd);
		return board;
		}
	
	public int deleteboard(int num) {
		int cnt= sqlSessionTemplate.delete("board.boardBean.Deleteboard",num);
		return cnt;
	}

}
