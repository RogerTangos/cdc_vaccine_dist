/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Business;
import Business.Enterprise.CDC;
import Business.Enterprise.Distributor;
import Business.Enterprise.Manufacturer;
import Business.Enterprise.Network;
import Business.Enterprise.PHD;
import Business.Enterprise.ProgramSystem;
import Business.Enterprise.UserAccountDirectory;
import Business.IndyPackage.Disease;
import Business.IndyPackage.Person;
import Business.IndyPackage.UserAccount;
import Business.IndyPackage.Vaccine;
import Business.Organization.Location;
import Business.Providers.Clinic;
import Business.Providers.Hospital;
import Business.Providers.Pharmacy;
import Business.Roles.AdminRole;
import Business.Roles.Manager;

/**
 *
 * @author Albert Carter
 */
public class ConfigureABusiness {
    public static Business Initialize(String n){
        Business b = new Business (n);
        ProgramSystem s = new ProgramSystem(); // new system creates Network catalog
        b.setSystem(s); //make sure system is saved as *the* busienss system.
        
        Disease dis1 = s.getDiseaseCatalog().newDisease();
        dis1.setName("Swine Flu");
        
        Disease dis2 = s.getDiseaseCatalog().newDisease();
        dis2.setName("Malaria");
        
        Vaccine v1 = s.getVaccineCatalog().newVaccine();
        v1.setName("H1N1 Nasal Spray");
        v1.setLifespan(90);
        v1.setDisease(dis1);
        v1.setProviderPercent(20);
        v1.setPhdPercent(40);
        v1.setCdcPercent(40);
        v1.setPrice(5.00);
        
        Vaccine v2 = s.getVaccineCatalog().newVaccine();
        v2.setName("H1N1 injection");
        v2.setLifespan(365*2);
        v2.setDisease(dis1);
        v2.setProviderPercent(25);
        v2.setPhdPercent(30);
        v2.setCdcPercent(45);
        v2.setPrice(6.00);
        
        Vaccine v3 = s.getVaccineCatalog().newVaccine();
        v3.setName("RTS,S");
        v3.setLifespan(365*10);
        v3.setDisease(dis2);
        v3.setProviderPercent(0);
        v3.setPhdPercent(10);
        v3.setCdcPercent(90);
        v3.setPrice(8.00);
        
        UserAccountDirectory uad = b.getUserAccountDirectory();
        
        Network network1 = s.getNetwork().newNetwork(); //creates a network1 and adds to the networkCatalog
        network1.setName("USA Network");
        network1.setOrgName("USA Network");
        network1.getEnterpriseList().add(network1); //network1 needs to be added to the network list, because otherwise, there's no way to log in.
        network1.setSystem(s);
        
                //The first person!
        Person p1 = new Person();
        p1.setFirstName("Joe");
        p1.setLastName("Smith");
        p1.setDob("11/11/11");
        p1.setSsn("111-11-1111");
        network1.getPersonDirectory().addPerson(p1);
        
        UserAccount uaBIG = uad.newUserAccount();
        network1.getUserAccountDirectory().addUserAccount(uaBIG);
        uaBIG.setEnterprise(network1);
        uaBIG.setPerson(p1);
        uaBIG.setRole(new AdminRole());
        uaBIG.setUserName("networkadmin");
        uaBIG.setPassword("networkadmin");
        uaBIG.setStatus("Active");
                
        
//        DEFINING THE CDC
        //start by creating a location
        Location l_1 = new Location();
        l_1.setAddress1("1600 Clifton Rd.");
        l_1.setCity("Atlanta");
        l_1.setState("GA");
        l_1.setPostal("30333");
        l_1.setCountry("USA");
        
        CDC cdc = new CDC(); //create the CDC
        cdc.setSystem(s);
        cdc.setOrgName("TheCDC"); //set its variables
        cdc.setLocation(l_1); //set its location
        network1.newEnterprise(cdc); //add it to the network list
        
        //add person to staff directory
        cdc.getPersonDirectory().addPerson(p1);
//        cdc.getStaffDirectory().newStaff(p1);
        
        //UserAccount for this person!
        UserAccount ua1 = uad.newUserAccount();
        cdc.getUserAccountDirectory().addUserAccount(ua1); //this is a separate UAD under the CDC, so I use the add method.
        ua1.setEnterprise(cdc);
        ua1.setPerson(p1);
        ua1.setUserName("cdcadmin");
        ua1.setPassword("cdcadmin");
        ua1.setRole(new AdminRole());
        ua1.setStatus("Active");
        
        UserAccount ua11 = uad.newUserAccount();
        cdc.getUserAccountDirectory().addUserAccount(ua11); //this is a separate UAD under the CDC, so I use the add method.
        ua11.setEnterprise(cdc);
        ua11.setPerson(p1);
        ua11.setUserName("cdcmanager");
        ua11.setPassword("cdcmanager");
        ua11.setRole(new Manager());
        ua11.setStatus("Active");
        
        //Mass PHD
        Location l_2 = new Location();
        l_2.setAddress1("250 Washington Street");
        l_2.setCity("Boston");
        l_2.setState("MA");
        l_2.setPostal("02109");
        l_2.setCountry("USA");
        
        PHD phd1 = cdc.newPHD(); //adding this to its appropriate CDC
        phd1.setOrgName("Mass PHD");
        phd1.setLocation(l_2);
        phd1.setCdc(cdc);
        network1.newEnterprise(phd1);
        
        
        //New England Distributor
        Location ld_1 = new Location();
        ld_1.setAddress1("1 Commonwealth Ave");
        ld_1.setCity("Boston");
        ld_1.setState("MA");
        ld_1.setPostal("02139");
        ld_1.setCountry("USA");
        
        Distributor d1 = new Distributor(); //this is added differently,
//        because it doesn't belong to a PHD. just is a provider because it has an inventory catelog.
        d1.setOrgName("New England Distributor");
        d1.setLocation(ld_1);
        //distributors don't have a PHD... I don't think.
        network1.newEnterprise(d1);
        cdc.setDistributor(d1);// this is the CDC's distributor
        
        //UserAccount for the distributor
        UserAccount ua2 = uad.newUserAccount();
        d1.getUserAccountDirectory().addUserAccount(ua2); //this is a separate UAD under the CDC, so I use the add method.
        ua2.setEnterprise(d1);
        ua2.setPerson(p1);
        ua2.setUserName("dadmin");
        ua2.setPassword("dadmin");
        ua2.setRole(new AdminRole());
        ua2.setStatus("Active");
        
        UserAccount ua12 = uad.newUserAccount();
        d1.getUserAccountDirectory().addUserAccount(ua12); //this is a separate UAD under the CDC, so I use the add method.
        ua12.setEnterprise(d1);
        ua12.setPerson(p1);
        ua12.setUserName("dadmanager");
        ua12.setPassword("dadmanager");
        ua12.setRole(new Manager());
        ua12.setStatus("Active");
        
        //new staff for the distributor
//        phd1.getStaffDirectory().newStaff(p1);
        phd1.getPersonDirectory().addPerson(p1);
        
        
        //Manufacturer location & creation
        Location lm_1 = new Location();
        lm_1.setAddress1("One Medimmune Way");
        lm_1.setCity("Gaithersburg");
        lm_1.setState("MD");
        lm_1.setPostal("20878");
        lm_1.setCountry("USA");
        
        Manufacturer m1 = new Manufacturer();
        m1.setOrgName("MedImmune");
        m1.setLocation(lm_1);
        m1.setDistributor(d1);//every manufacturer needs a distributor
        m1.setCdc(cdc);
        network1.newEnterprise(m1);
        cdc.setManufacturer(m1);
        
        //new staff for the Manufacturer
        m1.getPersonDirectory().addPerson(p1);
//        m1.getStaffDirectory().newStaff(p1);
        
        //new user accounts for manufacturer
        UserAccount ua15 = uad.newUserAccount();
        m1.getUserAccountDirectory().addUserAccount(ua15);
        ua15.setEnterprise(m1);
        ua15.setPerson(p1);
        ua15.setUserName("manufactureradmin");
        ua15.setPassword("manufactureradmin");
        ua15.setRole(new AdminRole());
        ua15.setStatus("Active");
        
        UserAccount ua16 = uad.newUserAccount();
        m1.getUserAccountDirectory().addUserAccount(ua16);
        ua16.setEnterprise(m1);
        ua16.setPerson(p1);
        ua16.setUserName("manufacturermanager");
        ua16.setPassword("manufacturermanager");
        ua16.setRole(new Manager());
        ua16.setStatus("Active");
        
        
        //new staff for the distributor
        d1.getPersonDirectory().addPerson(p1);
//        d1.getStaffDirectory().newStaff(p1);
        
        
        //UserAccount for the PHD
        UserAccount ua3 = uad.newUserAccount();
        phd1.getUserAccountDirectory().addUserAccount(ua3); 
        ua3.setEnterprise(phd1);
        ua3.setPerson(p1);
        ua3.setUserName("phdadmin");
        ua3.setPassword("phdadmin");
        ua3.setRole(new AdminRole());
        ua3.setStatus("Active");
        
        UserAccount ua10 = uad.newUserAccount();
        phd1.getUserAccountDirectory().addUserAccount(ua10); 
        ua10.setEnterprise(phd1);
        ua10.setPerson(p1);
        ua10.setUserName("phdmanager");
        ua10.setPassword("phdmanager");
        ua10.setRole(new Manager());
        ua10.setStatus("Active");
        
            //Mass Hospitals
        Location l_3 = new Location();
        l_3.setAddress1("55 Fruit Street");
        l_3.setCity("Boston");
        l_3.setState("MA");
        l_3.setPostal("02114");
        l_3.setCountry("USA");
        
        Hospital h1 = phd1.newHospital();//adding this to its appropriate PHD
        h1.setOrgName("Mass General");
        h1.setLocation(l_3);
        h1.setPhd(phd1);
        network1.newEnterprise(h1);
        
        //new staff for the hospital
//        h1.getStaffDirectory().newStaff(p1);
        h1.getPersonDirectory().addPerson(p1);
        
        //UserAccount for the distributor
        UserAccount ua4 = uad.newUserAccount();
        h1.getUserAccountDirectory().addUserAccount(ua4); 
        ua4.setEnterprise(h1);
        ua4.setPerson(p1);
        ua4.setUserName("massgeneral");
        ua4.setPassword("massgeneral");
        ua4.setRole(new AdminRole());
        ua4.setStatus("Active");
        
        //--//
        Location l_5 = new Location();
        l_5.setAddress1("330 Brookline Avenue");
        l_5.setCity("Boston");
        l_5.setState("MA");
        l_5.setPostal("02215");
        l_5.setCountry("USA");
        
        Hospital h2 = phd1.newHospital();
        h2.setOrgName("Beth Israel Deaconess");
        h2.setLocation(l_5);
        h2.setPhd(phd1);
        network1.newEnterprise(h2);
        
                //new clinic
        Location l_6 = new Location();
        l_6.setAddress1("500 Centre Street");
        l_6.setCity("Boston");
        l_6.setState("MA");
        l_6.setPostal("02130");
        l_6.setCountry("USA");
        
        Clinic c1 = h1.newClinic();
        c1.setOrgName("Beth Israel Jamaica Plain");
        c1.setLocation(l_6);
        network1.newEnterprise(c1);
        
                //new staff for the clinic
//        c1.getStaffDirectory().newStaff(p1);
        c1.getPersonDirectory().addPerson(p1);
        
        //UserAccount for the distributor
        UserAccount ua5 = uad.newUserAccount();
        c1.getUserAccountDirectory().addUserAccount(ua4);
        ua5.setEnterprise(c1);
        ua5.setPerson(p1);
        ua5.setUserName("clinicadmin");
        ua5.setPassword("clinicadmin");
        ua5.setRole(new AdminRole());
        ua5.setStatus("Active");
        
        UserAccount ua14 = uad.newUserAccount();
        c1.getUserAccountDirectory().addUserAccount(ua14);
        ua14.setEnterprise(c1);
        ua14.setPerson(p1);
        ua14.setUserName("clinicmanager");
        ua14.setPassword("clinicmanager");
        ua14.setRole(new AdminRole());
        ua14.setStatus("Active");
        
        //RI PHD
        Location l_4 = new Location();
        l_4.setAddress1("3 Capitol Hl");
        l_4.setAddress2("# 101");
        l_4.setCity("Providence");
        l_4.setState("RI");
        l_4.setPostal("02908");
        l_4.setCountry("USA");
        
        PHD phd2 = cdc.newPHD();
        phd2.setOrgName("RI PHD");
        phd2.setLocation(l_4);
        phd2.setCdc(cdc);
        network1.newEnterprise(phd2);
        
        //RI Hospital
        Location l_7 = new Location();
        l_7.setAddress1("593 Eddy Street");
        l_7.setCity("Providence");
        l_7.setState("RI");
        l_7.setPostal("02903");
        l_7.setCountry("USA");
        
        Hospital h3 = phd2.newHospital();
        h3.setOrgName("Rhode Island Hospital");
        h3.setLocation(l_7);
        h3.setPhd(phd2);
        network1.newEnterprise(h3);
        
        //CVS
        Location l_8 = new Location();
        l_8.setAddress1("291 Thayer Street");
        l_8.setCity("Providence");
        l_8.setState("RI");
        l_8.setPostal("02906");
        l_8.setCountry("USA");
        
        Pharmacy ph1 = phd1.newPharmacy();
        ph1.setOrgName("CVS/Pharmacy");
        ph1.setLocation(l_8);
        ph1.setPhd(phd1);
        network1.newEnterprise(ph1);
        
        UserAccount ua8 = uad.newUserAccount();
        ph1.getUserAccountDirectory().addUserAccount(ua8); 
        ua8.setEnterprise(ph1);
        ua8.setPerson(p1);
        ua8.setUserName("cvsadmin");
        ua8.setPassword("cvsadmin");
        ua8.setRole(new AdminRole());
        ua8.setStatus("Active");
        
        UserAccount ua9 = uad.newUserAccount();
        ph1.getUserAccountDirectory().addUserAccount(ua9); 
        ua9.setEnterprise(ph1);
        ua9.setPerson(p1);
        ua9.setUserName("cvsmanager");
        ua9.setPassword("cvsmanager");
        ua9.setRole(new Manager());
        ua9.setStatus("Active");
        
                        //new staff for the clinic
//        ph1.getStaffDirectory().newStaff(p1);
        ph1.getPersonDirectory().addPerson(p1);
        
        //UserAccount for the distributor
        UserAccount ua6 = uad.newUserAccount();
        ph1.getUserAccountDirectory().addUserAccount(ua4); 
        ua6.setEnterprise(ph1);
        ua6.setPerson(p1);
        ua6.setUserName("pharmacy");
        ua6.setPassword("pharmacy");
        ua6.setStatus("Active");
        
        
        
        
        return b;
    }
}
