package easyui;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import easyui.iyunmai.mapper.queryMapper;
import easyui.iyunmai.module.menu;
import easyui.iyunmai.module.restaurant;
import easyui.iyunmai.module.user;

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public static void main(String[] args) {
    	insertDakaRetention();
    }

    public static void insertDakaRetention() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
        	//int count = userMapper.queryFirstEmpty(); System.out.println("原有用户首次打卡记录："+count);
        	queryMapper querymapper = sqlSession.getMapper(queryMapper.class);
        	int me = querymapper.queryUsersInfoCounts();
        	logger.info(JSON.toJSONString(me));
        	//user loginuser = querymapper.queryuserBynameAndword("xieyupeng", "123");
        	//logger.info(JSON.toJSONString(loginuser));
		}finally {
            sqlSession.close();
        }
    }

}
