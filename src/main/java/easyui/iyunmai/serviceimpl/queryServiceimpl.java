package easyui.iyunmai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import easyui.iyunmai.mapper.queryMapper;
import easyui.iyunmai.module.menu;
import easyui.iyunmai.module.restaurant;
import easyui.iyunmai.module.user;
import easyui.iyunmai.module.usersinfo;
import easyui.iyunmai.service.queryService;

@Service
public class queryServiceimpl implements queryService {
		
	    @Autowired
		queryMapper querymapper;
	    public List<menu> queryMenu(){
	    	return querymapper.queryMenu();
	    }
		public List<String> queryFood() {
			return querymapper.queryFood();
		}
		public user queryuserBynameAndword(String name,String password) {
			return querymapper.queryuserBynameAndword(name, password);
		}
		public List<restaurant> queryrestaurant() {
			return querymapper.queryrestaurant();
		}
		public List<menu> queryFoodByResid(Integer resid,int beginOffset,int rows) {
			return querymapper.queryFoodByResid(resid,beginOffset,rows);
		}
		public int queryMenuCountByResid(Integer resid) {
			return querymapper.queryMenuCountByResid(resid);
		}
		public List<usersinfo> queryUsersInfo(int beginOffset, int rows) {
			return querymapper.queryUsersInfo(beginOffset,rows);
		}
		public int queryUsersInfoCounts() {
			return querymapper.queryUsersInfoCounts();
		}
}
