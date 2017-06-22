package mybatis;

import mybatis.BandSportDetail;

public interface BandSportDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandSportDetail record);

    int insertSelective(BandSportDetail record);

    BandSportDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandSportDetail record);

    int updateByPrimaryKey(BandSportDetail record);
}