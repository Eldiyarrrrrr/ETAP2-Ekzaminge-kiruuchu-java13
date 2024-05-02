package peaksoft.service.serviceImpl;


import peaksoft.dao.AddressDao;
import peaksoft.dao.AgencyDao;
import peaksoft.dao.HouseDao;
import peaksoft.dao.OwnerDao;
import peaksoft.dao.daoImpl.AddressDaoImpl;
import peaksoft.dao.daoImpl.AgencyDaoImpl;
import peaksoft.dao.daoImpl.HouseDaoImpl;
import peaksoft.dao.daoImpl.OwnerDaoImpl;
import peaksoft.entities.Address;
import peaksoft.entities.House;
import peaksoft.service.HouseService;


import java.time.LocalDate;
import java.util.List;

public class HouseServiceImpl implements HouseService {
    private final HouseDao houseDao = new HouseDaoImpl();
    private final OwnerDao ownerDao = new OwnerDaoImpl();
    private final AddressDao addressDao = new AddressDaoImpl();
    private final AgencyDao agencyDao = new AgencyDaoImpl();

    @Override
    public String saveHouse(Long ownerId, House newHouse) {
        try {
            ownerDao.findOwnerById(ownerId)
                    .orElseThrow(() ->
                            new RuntimeException("Owner with id: " + ownerId + " not found!!!"));
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return houseDao.saveHouse(ownerId, newHouse);
    }

    @Override
    public House findHouseById(Long houseId) {
        House house = null;
        try {
            house = houseDao.findHouseById(houseId)
                    .orElseThrow(() ->
                            new RuntimeException("House with id: " + houseId + " not found!!!"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return house;
    }

    @Override
    public List<House> findAllHouse() {
        return houseDao.findAllHouse();
    }

    @Override
    public String updateHouseById(Long houseId, House newHouse) {
        House findHouse = findHouseById(houseId);
        if (findHouse == null) {
            return "Failed to update";
        }
        return houseDao.updateHouseById(houseId, newHouse);
    }

    @Override
    public String deleteHouseById(Long houseId) {
        House findHouse = findHouseById(houseId);
        if (findHouse == null) {
            return "Failed to delete";
        }
        return houseDao.deleteHouseById(houseId);
    }

    @Override
    public List<House> getHousesInRegion(String region) {
        List<Address> allAddresses = addressDao.findAllAddresses();
        try {
            for (Address allAddress : allAddresses) {
                if (!allAddress.getRegion().equalsIgnoreCase(region)) {
                    throw new RuntimeException("there is no such region");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return houseDao.getHousesInRegion(region);
    }

    @Override
    public List<House> allHousesByAgencyId(Long agencyId) {
        try {
            agencyDao.findAgencyById(agencyId)
                    .orElseThrow(() ->
                            new RuntimeException("Owner with id: " + agencyId + " not found!!!"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return houseDao.allHousesByAgencyId(agencyId);
    }

    @Override
    public List<House> allHousesByOwnerId(Long ownerId) {
        try {
            ownerDao.findOwnerById(ownerId)
                    .orElseThrow(() ->
                            new RuntimeException("Owner with id: " + ownerId + " not found!!!"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return houseDao.allHousesByOwnerId(ownerId);
    }

    @Override
    public List<House> housesBetweenDates(LocalDate fromDate, LocalDate toDate) {
        List<House> houses = houseDao.housesBetweenDates(fromDate, toDate);
        try {
            if (houses.isEmpty()){
                throw new RuntimeException("houses is empty in this date");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return houses;
    }
}
