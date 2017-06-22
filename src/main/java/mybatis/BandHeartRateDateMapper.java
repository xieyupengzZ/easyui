package mybatis;

import mybatis.BandHeartRateDate;

public interface BandHeartRateDateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandHeartRateDate record);

    int insertSelective(BandHeartRateDate record);

    BandHeartRateDate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandHeartRateDate record);

    int updateByPrimaryKey(BandHeartRateDate record);
}