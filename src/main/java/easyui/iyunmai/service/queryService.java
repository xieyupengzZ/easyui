package easyui.iyunmai.service;

import java.util.List;

import easyui.iyunmai.module.menu;
import easyui.iyunmai.module.restaurant;
import easyui.iyunmai.module.user;
import easyui.iyunmai.module.usersinfo;

public interface  queryService {
	
	public List<menu> queryMenu();
	public List <String> queryFood();
    public user queryuserBynameAndword(String name,String password);
    public List<restaurant> queryrestaurant();
    public List<menu> queryFoodByResid(Integer resid,int beginOffset,int rows);
    public int queryMenuCountByResid(Integer resid);
    public List<usersinfo> queryUsersInfo(int beginOffset,int rows);
    public int queryUsersInfoCounts();
}
