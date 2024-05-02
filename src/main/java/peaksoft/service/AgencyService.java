package peaksoft.service;

import peaksoft.entities.Address;
import peaksoft.entities.Agency;

import java.util.List;

public interface AgencyService {
    String saveAgency(Agency newAgency, Address newAddress);
    Agency findAgencyById(Long agencyId);
    List<Agency> findAllAgencies();
    String updateAgencyById(Long agencyId, Agency newAgency);
    String deleteAgencyById(Long agencyId);
}
