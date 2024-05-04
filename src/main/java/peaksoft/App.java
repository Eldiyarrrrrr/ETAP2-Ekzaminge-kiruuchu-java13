package peaksoft;
import peaksoft.entities.*;
import peaksoft.enums.FamilyStatus;
import peaksoft.enums.Gender;
import peaksoft.enums.HouseType;
import peaksoft.service.serviceImpl.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AgencyServiceImpl agencyService = new AgencyServiceImpl();
        AddressServiceImpl addressService = new AddressServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        HouseServiceImpl houseService = new HouseServiceImpl();
        OwnerServiceImpl ownerService = new OwnerServiceImpl();
        RentInfoServiceImpl rentInfoService = new RentInfoServiceImpl();
        while (true) {
            try {
                System.out.println("""
                        1. Agency
                        2. Address
                        3. Customer
                        4. House
                        5. Owner
                        6. RentInfo
                        """);
                switch (new Scanner(System.in).nextInt()) {
                    case 1 -> {
                        boolean istrue1 = true;
                        while (istrue1) {
                            try {
                                System.out.println("""
                                                 Agency
                                        1. save with Address
                                        2. find
                                        3. find all
                                        4. update
                                        5. delete
                                        6. Exit
                                        """);
                                System.out.print("----->>>");
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        System.out.println("save with Address");
                                        System.out.println(agencyService.saveAgency(new Agency("mister agent 1", "+996500190407"), new Address("bishkek", "chui", "grazhdanski")));
                                    }
                                    case 2 -> {
                                        System.out.println("Find");
                                        System.out.println(agencyService.findAgencyById(1L));
                                    }
                                    case 3 -> {
                                        System.out.println("Find All");
                                        System.out.println(agencyService.findAllAgencies());
                                    }
                                    case 4 -> {
                                        System.out.println("Update");
                                        Agency agency = new Agency("mister agent 2", "+996995002331");
                                        Address address = new Address("kara-balta", "jalal-abad", "filarmoniya");
                                        agency.setAddress(address);
                                        address.setAgency(agency);
                                        System.out.println(agencyService.updateAgencyById(1L, agency));
                                    }
                                    case 5 -> {
                                        System.out.println("Delete");
                                        agencyService.deleteAgencyById(1L);
                                    }
                                    case 6 -> {
                                        System.out.println("Exit");
                                        istrue1 = false;
                                    }
                                    default -> System.out.println("Komanda tuura emes terildi");
                                }
                            } catch (RuntimeException e) {
                                System.out.println("Галдир Сан бер: " + e.getMessage());
                            }
                        }
                    }
                    case 2 -> {
                        boolean istrue2 = true;
                        while (istrue2) {
                            try {
                                System.out.println("""
                                                Address
                                        1. find
                                        2. find all
                                        3. update
                                        4. addresses with agency
                                        5. how many agency in city
                                        6. group by region
                                        7. Exit
                                                """);
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        System.out.println("Find");
                                        System.out.println(addressService.findAddressById(1L));
                                    }
                                    case 2 -> {
                                        System.out.println("Find All");
                                        System.out.println(addressService.findAllAddresses());
                                    }
                                    case 3 -> {
                                        System.out.println("Update");
                                        System.out.println(addressService.updateAddressById(1L, new Address("Paris", "ChaldoParis", "vostoc 5")));
                                    }
                                    case 4 -> {
                                        System.out.println("Addresses with agency");
                                        System.out.println(addressService.findAddressWithAgency());
                                    }
                                    case 5 -> {
                                        System.out.println("How many agency in city");
                                        System.out.println(addressService.countAgenciesInTheCity("Bishkek"));
                                    }
                                    case 6 -> {
                                        System.out.println("Group by region");
                                        System.out.println(addressService.groupByRegion());
                                    }
                                    case 7 -> {
                                        System.out.println("Exit");
                                        istrue2 = false;
                                    }
                                    default -> System.out.println("Komanda tuura emes terildi");
                                }
                            } catch (RuntimeException e) {
                                System.out.println("Галдир Сан бер: " + e.getMessage());
                            }
                        }
                    }
                    case 3 -> {
                        boolean istrue3 = true;
                        while (istrue3) {
                            try {
                                System.out.println("""
                                                Customer
                                        1. save
                                        2. save with rent
                                        3. find
                                        4. find all
                                        5. update
                                        6. delete
                                        7. rent
                                        8. Exit      
                                         """);
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        System.out.println("Save");
                                        System.out.println(customerService.saveCustomer(new Customer("Eldiyar", "Avazbekov", "eldiyar@gmail.com", LocalDate.of(2006, 4, 7), Gender.MALE, "KYRGYZ", FamilyStatus.SINGLE)));
                                    }
                                    case 2 -> {
                                        System.out.println("Save with rent");
                                        System.out.println(customerService.saveCustomerWithRent(new Customer("Beknazar", "Zholdoshbekov", "beknazar@gmail.com", LocalDate.of(2007, 8, 27), Gender.MALE, "KYRGYZ", FamilyStatus.SINGLE), 1L, 1L, LocalDate.of(2023, 04, 10), LocalDate.of(2024, 05, 2)));
                                    }
                                    case 3 -> {
                                        System.out.println("Find");
                                        System.out.println(customerService.findCustomerById(1L));
                                    }
                                    case 4 -> {
                                        System.out.println("Find All");
                                        System.out.println(customerService.findAllCustomers());
                                    }
                                    case 5 -> {
                                        System.out.println("Update");
                                        System.out.println(customerService.updateCustomerById(1L, new Customer("Nurmuhammed", "Akimbekov", "nurmuhammed@gmail.com", LocalDate.of(1998, 8, 28), Gender.MALE, "KYRGYZ", FamilyStatus.SINGLE)));
                                    }
                                    case 6 -> {
                                        System.out.println("Delete");
                                        System.out.println(customerService.deleteCustomerById(1L));
                                    }
                                    case 7 -> {
                                        System.out.println("Rent");
                                        System.out.println(customerService.rentingHouseByCustomer(1L, 1L, 1L, LocalDate.of(2023, 5, 5), LocalDate.of(2024, 5, 5)));
                                    }
                                    case 8 -> {
                                        System.out.println("Exit");
                                        istrue3 = false;
                                    }
                                    default -> System.out.println("Komanda tuura emes terildi");
                                }
                            } catch (RuntimeException e) {
                                System.out.println("Галдир Сан бер: " + e.getMessage());
                            }
                        }
                    }
                    case 4 -> {
                        boolean istrue4 = true;
                        while (istrue4) {
                            try {
                                System.out.println("""
                                                House
                                        1. save
                                        2. find
                                        3. find all
                                        4. update
                                        5. delete
                                        6. houses in region
                                        7. all houses by agency
                                        8. all houses by owner
                                        9. between dates
                                        10. Exit      
                                         """);
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        System.out.println("Save");
                                        System.out.println(houseService.saveHouse(1L, new House(HouseType.APARTMENT, new BigDecimal(15000), 5.5, "Zynk", 120, true)));
                                    }
                                    case 2 -> {
                                        System.out.println("Find");
                                        System.out.println(houseService.findHouseById(1L));
                                    }
                                    case 3 -> {
                                        System.out.println("Find All");
                                        System.out.println(houseService.findAllHouse());
                                    }
                                    case 4 -> {
                                        System.out.println("Update");
                                        System.out.println(houseService.updateHouseById(1L, new House(HouseType.VIP, new BigDecimal(25000), 10.0, "10 zvezda", 220, true)));
                                    }
                                    case 5 -> {
                                        System.out.println("Delete");
                                        houseService.deleteHouseById(1L);
                                    }
                                    case 6 -> {
                                        System.out.println("House in region");
                                        System.out.println(houseService.getHousesInRegion("Osh"));
                                    }
                                    case 7 -> {
                                        System.out.println("All houses by agency");
                                        System.out.println(houseService.allHousesByAgencyId(1L));
                                    }
                                    case 8 -> {
                                        System.out.println("All houses by owner");
                                        System.out.println(houseService.allHousesByOwnerId(1L));
                                    }
                                    case 9 -> {
                                        System.out.println("Between dates");
                                        System.out.println(houseService.housesBetweenDates(LocalDate.of(2023, 3, 23), LocalDate.of(2024, 5, 5)));
                                    }
                                    case 10 -> {
                                        System.out.println("Exit");
                                        istrue4 = false;
                                    }
                                    default -> System.out.println("Komanda tuura emes terildi");
                                }
                            } catch (RuntimeException e) {
                                System.out.println("Галдир Сан бер: " + e.getMessage());
                            }
                        }
                    }
                    case 5 -> {
                        boolean istrue5 = true;
                        while (istrue5) {
                            try {
                                System.out.println("""
                                               Owner
                                        1. save
                                        2. save with house
                                        3. find
                                        4. find all
                                        5. update
                                        6. delete
                                        7. assign owner to agency
                                        8. owners by agency
                                        9. owners only name and age
                                        10. Exit
                                        """);
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        System.out.println("Save 1");
                                        System.out.println(ownerService.saveOwner(new Owner("Beka", "Bekavich", "beka@gmail.com", LocalDate.of(2006, 5, 19), Gender.MALE)));
                                    }
                                    case 2 -> {
                                        System.out.println("Save 2");
                                        ownerService.saveOwner(new Owner("Jigit", "Jigitovich", "jigit@gmail.com", LocalDate.of(2002, 4, 29), Gender.MALE), new House(HouseType.VIP, new BigDecimal(200000), 5.5, "soonun", 230, true));
                                    }
                                    case 3 -> {
                                        System.out.println("Find");
                                        System.out.println(ownerService.findOwnerById(1L));
                                    }
                                    case 4 -> {
                                        System.out.println("Find All");
                                        System.out.println(ownerService.findAllOwners());
                                    }
                                    case 5 -> {
                                        System.out.println("Update");
                                        System.out.println(ownerService.updateOwnerById(1L, new Owner("Yzat", "Yzatovich", "yzat@gamil.com", LocalDate.of(2005, 4, 17), Gender.MALE)));
                                    }
                                    case 6 -> {
                                        System.out.println("Delete");
                                        System.out.println(ownerService.deleteOwnerById(1L));
                                    }
                                    case 7 -> {
                                        System.out.println("Assign owner to agency");
                                        System.out.println(ownerService.assignOwnerToAgency(1L, 1L));
                                    }
                                    case 8 -> {
                                        System.out.println("Owners by agency");
                                        System.out.println(ownerService.getOwnersByAgencyId(1L));
                                    }
                                    case 9 -> {
                                        System.out.println("Owners only name and age");
                                        System.out.println(ownerService.getOwnerOnlyNameAndAge());
                                    }
                                    case 10 -> {
                                        System.out.println("Exit");
                                        istrue5 = false;
                                    }
                                    default -> System.out.println("Komanda tuura emes terildi");
                                }
                            } catch (RuntimeException e) {
                                System.out.println("Галдир Сан бер: " + e.getMessage());
                            }
                        }
                    }
                    case 6 -> {
                        boolean istrue6 = true;
                        while (istrue6) {
                            try {
                                System.out.println("""
                                                RentInfo
                                        1. renting between dates
                                        2. how many house in agency
                                        3. Exit
                                                                """);
                                switch (new Scanner(System.in).nextInt()) {
                                    case 1 -> {
                                        System.out.println("renting between dates");
                                        System.out.println(rentInfoService.rentInfoBetweenDates(LocalDate.of(2015, 4, 9), LocalDate.of(2024, 5, 5)));
                                    }
                                    case 2 -> {
                                        System.out.println("how many house in agency");
                                        System.out.println(rentInfoService.housesByAgencyIdAndDate(1L));
                                    }
                                    case 3 -> {
                                        System.out.println("Exit");
                                        istrue6 = false;
                                    }
                                    default -> System.out.println("Команда туура эмес");

                                }
                            } catch (RuntimeException e) {
                                System.out.println("Галдир Сан бер: " + e.getMessage());
                            }
                        }
                    }
                    default -> System.out.println("Komanda tuura emes terildi");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
