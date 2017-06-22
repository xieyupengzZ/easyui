package mybatis;

import mybatis.BandSleepDetail;

public interface BandSleepDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandSleepDetail record);

    int insertSelective(BandSleepDetail record);

    BandSleepDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandSleepDetail record);

    int updateByPrimaryKey(BandSleepDetail record);
}