package mybatis;

import mybatis.BandHeartRateDetail;

public interface BandHeartRateDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandHeartRateDetail record);

    int insertSelective(BandHeartRateDetail record);

    BandHeartRateDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandHeartRateDetail record);

    int updateByPrimaryKey(BandHeartRateDetail record);
}