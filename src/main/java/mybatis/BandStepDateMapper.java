package mybatis;

import mybatis.BandStepDate;

public interface BandStepDateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandStepDate record);

    int insertSelective(BandStepDate record);

    BandStepDate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandStepDate record);

    int updateByPrimaryKey(BandStepDate record);
}