package peaksoft.service.serviceImpl;

import peaksoft.dao.AddressDao;
import peaksoft.dao.AgencyDao;
import peaksoft.dao.daoImpl.AddressDaoImpl;
import peaksoft.dao.daoImpl.AgencyDaoImpl;
import peaksoft.entities.Address;
import peaksoft.entities.Agency;
import peaksoft.service.AgencyService;

import java.util.List;


public class AgencyServiceImpl implements AgencyService {
    private final AgencyDao agencyDao = new AgencyDaoImpl();
    private final AddressDao addressDao = new AddressDaoImpl();

    @Override
    public String saveAgency(Agency newAgency, Address newAddress) {
        List<Address> allAddresses = addressDao.findAllAddresses();
        for (Address allAddress : allAddresses) {
            if (allAddress.getStreet().equals(newAddress.getStreet())) {
                return newAddress.getStreet() + " already exist!!!";
            }
        }
        if (newAgency.getPhoneNumber().startsWith("+996") && newAgency.getPhoneNumber().length() == 13) {
            return agencyDao.saveAgency(newAgency, newAddress);
        }else {
            return "Fail to save!!!";
        }
    }

    @Override
    public Agency findAgencyById(Long agencyId) {
        Agency agency = null;
        try {
            agency = agencyDao.findAgencyById(agencyId)
                    .orElseThrow(() ->
                            new RuntimeException("Agency with id: "+agencyId+" not found!!!"));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return agency;
    }

    @Override
    public List<Agency> findAllAgencies() {
        return agencyDao.findAllAgencies();
    }

    @Override
    public String updateAgencyById(Long agencyId, Agency newAgency) {
        Agency findAgency = findAgencyById(agencyId);
        if (findAgency == null) {
            return "failed to update!!!";
        }
        if (newAgency.getPhoneNumber().startsWith("+996") && newAgency.getPhoneNumber().length() == 13) {
            return agencyDao.updateAgencyById(agencyId, newAgency);
        }else {
            return "Incorrect phone number!";
        }
    }

    @Override
    public String deleteAgencyById(Long agencyId) {
        Agency findAgency = findAgencyById(agencyId);
        if (findAgency != null){
            return agencyDao.deleteAgencyById(agencyId);
        } else return "Failed to delete agency with id: "+agencyId;
    }
}
