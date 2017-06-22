package mybatis;

import mybatis.BandStepDetail;

public interface BandStepDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandStepDetail record);

    int insertSelective(BandStepDetail record);

    BandStepDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandStepDetail record);

    int updateByPrimaryKey(BandStepDetail record);
}