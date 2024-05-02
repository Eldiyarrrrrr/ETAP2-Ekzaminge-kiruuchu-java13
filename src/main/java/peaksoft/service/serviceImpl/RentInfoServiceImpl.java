package peaksoft.service.serviceImpl;


import peaksoft.dao.AgencyDao;
import peaksoft.dao.RentInfoDao;
import peaksoft.dao.daoImpl.AgencyDaoImpl;
import peaksoft.dao.daoImpl.RentInfoDaoImpl;
import peaksoft.entities.RentInfo;
import peaksoft.service.RentInfoService;

import java.time.LocalDate;
import java.util.List;


public class RentInfoServiceImpl implements RentInfoService {
    private final RentInfoDao rentInfoDao = new RentInfoDaoImpl();
    private final AgencyDao agencyDao = new AgencyDaoImpl();
    @Override
    public List<RentInfo> rentInfoBetweenDates(LocalDate fromDate, LocalDate toDate) {
        List<RentInfo> rentInfos = rentInfoDao.rentInfoBetweenDates(fromDate, toDate);
        try {
            if (rentInfos.isEmpty()){
                throw new RuntimeException("is empty");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return rentInfos;
    }

    @Override
    public String housesByAgencyIdAndDate(Long agencyId) {
        try {
            agencyDao.findAgencyById(agencyId)
                    .orElseThrow(() ->
                            new RuntimeException("Agency with id: "+agencyId+" not found!!!"));
        }catch (RuntimeException e){
            return e.getMessage();
        }
        Long count = rentInfoDao.housesByAgencyIdAndDate(agencyId);
        if (count <= 0){
            return "No houses for rent";
        }
        return "Houses for rent: "+count;
    }
}
