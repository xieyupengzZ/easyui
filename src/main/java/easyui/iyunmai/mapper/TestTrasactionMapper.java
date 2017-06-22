package easyui.iyunmai.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TestTrasactionMapper {
	
	@Insert("insert into test_trasaction(id)values(#{id})")
	int saveInfo(@Param("id")Integer id);
	
	@Select("select count(*)from test_trasaction")
	int search();
	
	@Insert("insert into test_trasaction(id)values(#{id})")
	int saveInfoT(@Param("id")Integer id);
}
