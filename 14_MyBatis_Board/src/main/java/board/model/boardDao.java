package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myBoardDao") 
public class BoardDao {

	String namespace="board.BoardBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertBoard(BoardBean board) {
		
		sqlSessionTemplate.insert(namespace+".InsertBoard",board);
		    
	}  
	
	public List<BoardBean> getBoardList(Paging pageInfo, Map<String, String> map) {
		 List<BoardBean> lists = new ArrayList<BoardBean>();
		 RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".SelectBoard",map,rowBounds);
		return lists;   
	}

	public BoardBean getoneBoardList(int num) {
		BoardBean bean = sqlSessionTemplate.selectOne(namespace+".SelectoneNum" ,num);
		sqlSessionTemplate.update("board.boardBean.content",num);
		return bean;
	}

	public void deleteboard(int num) {
		int cnt = sqlSessionTemplate.delete(namespace+".DeleteBoard",num);
		System.out.println(cnt);
		
	}

	public void updateBoard(BoardBean board) {
		int cnt = sqlSessionTemplate.update(namespace+".UpdateBoard",board);
	}

	public int getTotalCount(Map<String, String> map) {
		
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
		
	}


}
