package easyui.iyunmai.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easyui.iyunmai.mapper.TestTrasactionMapper;

@Service
public class TestTrasactionServiceImpl {
private static final Logger logger = LoggerFactory.getLogger(TestTrasactionServiceImpl.class);
	@Autowired
	TestTrasactionMapper testTrasactionMapper;
	
	
		public boolean saveInfo(Integer id){
			try {
				testTrasactionMapper.saveInfo(id);
				int n = testTrasactionMapper.search();
				System.out.println(n);
				return testTrasactionMapper.saveInfo(id)>0;
			} catch (Exception e) {
				logger.error("{}",e);
				throw new RuntimeException();
			}
				
	}
}
