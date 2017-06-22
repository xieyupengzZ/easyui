package mybatis;

import mybatis.BandSleepDate;

public interface BandSleepDateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandSleepDate record);

    int insertSelective(BandSleepDate record);

    BandSleepDate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandSleepDate record);

    int updateByPrimaryKey(BandSleepDate record);
}