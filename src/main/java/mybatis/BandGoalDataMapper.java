package mybatis;

import mybatis.BandGoalData;

public interface BandGoalDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandGoalData record);

    int insertSelective(BandGoalData record);

    BandGoalData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandGoalData record);

    int updateByPrimaryKey(BandGoalData record);
}