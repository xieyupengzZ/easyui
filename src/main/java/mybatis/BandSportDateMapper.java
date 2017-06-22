package mybatis;

import mybatis.BandSportDate;

public interface BandSportDateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BandSportDate record);

    int insertSelective(BandSportDate record);

    BandSportDate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BandSportDate record);

    int updateByPrimaryKey(BandSportDate record);
}