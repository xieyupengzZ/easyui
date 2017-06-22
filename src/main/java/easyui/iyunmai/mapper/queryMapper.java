package easyui.iyunmai.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import easyui.iyunmai.module.menu;
import easyui.iyunmai.module.restaurant;
import easyui.iyunmai.module.user;
import easyui.iyunmai.module.usersinfo;

public interface queryMapper {
	public List<menu> queryMenu();
	public List<String> queryFood();
	public user queryuserBynameAndword(@Param (value = "name") String name,@Param (value = "word") String word);//有多个参数时，使用@Param指定别名
	public List<restaurant> queryrestaurant();
	public List<menu> queryFoodByResid(@Param(value="resid")Integer resid,@Param(value="beginOffset")int beginOffset,@Param(value="rows")int rows);
	public int queryMenuCountByResid(@Param(value="resid")Integer resid);
	public List<usersinfo> queryUsersInfo(@Param(value="beginOffset")int beginOffset,@Param(value="rows")int rows);
	public int queryUsersInfoCounts();
}
