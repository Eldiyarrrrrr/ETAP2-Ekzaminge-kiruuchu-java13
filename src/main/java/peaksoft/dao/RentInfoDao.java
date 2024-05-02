package peaksoft.dao;

import peaksoft.entities.RentInfo;

import java.time.LocalDate;
import java.util.List;


public interface RentInfoDao {
    List<RentInfo> rentInfoBetweenDates(LocalDate fromDate, LocalDate toDate);
    Long housesByAgencyIdAndDate(Long agencyId);
}
