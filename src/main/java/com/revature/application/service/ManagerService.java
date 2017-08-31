package com.revature.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;*/

//import com.revature.application.domain.ApartmentResident;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;

//import com.revature.application.model.Manager;
import com.revature.application.model.Resident;
import com.revature.application.repository.ApartmentComplexRepository;
import com.revature.application.repository.ApartmentRepository;

//import com.revature.application.repository.ManagerRepository;
import com.revature.application.repository.ResidentRepository;

@Service
@Transactional
public class ManagerService {

	/*private ResidentRepository resident;
	private ApartmentRepository apartment;
	private ApartmentComplexRepository apartmentcomplex;
	private PlacementRepository placement;

	@Autowired
	public ManagerService(ResidentRepository resident, ApartmentRepository apartment,
			ApartmentComplexRepository apartmentcomplex, PlacementRepository placement) {
		this.resident = resident;
		this.apartment = apartment;
		this.apartmentcomplex = apartmentcomplex;
		this.placement = placement;
	}

	public List<ApartmentResident> getApartmentForResidentForDate(Date date) {
    	Iterable<Apartment> rooms = this.apartment.findAll();
    	Map<Long, ApartmentResident> ApartmentResidentMap = new HashMap<>();
        rooms.forEach(room->{
            ApartmentResident apartmentResident = new ApartmentResident();
            apartmentResident.setApartmentId(room.getApartmentId());
            apartmentResident.setComplex(room.getComplex());
            apartmentResident.setApartmentNumber(room.getApartmentNumber());
            //apartmentResident.setComplex(complex.getComplexId());
            //Above we have built the basics of our ApartmentResident object. Now placing that object into the map
            //Now we can populated that map as we move forward
            ApartmentResidentMap.put(room.getApartmentId(), apartmentResident);
        });
        //Going back to our repositories
        Iterable<Placement> living = (Iterable<Placement>) this.placement.findByDate(new java.sql.Date(date.getTime()));
            living.forEach(life -> {
            	//getting the resident id from the resident class
                Resident guest = this.resident.findOne((int) life.getResidentId());
                if(null!=guest){
                	//Use that data to pull from the map, the actual ApartmentResident using getId
                    ApartmentResident apartmentResident = ApartmentResidentMap.get(life.getApartmentId());
                    //Since we have the ApartmentResident from the map, we can go ahead and populated residents with the important information to complete the operation 
                    apartmentResident.setFirstName(guest.getFirstName());
                    apartmentResident.setLastName(guest.getLastName());
                    apartmentResident.setResidentId(guest.getResidentId());
                }
            });
        
        //This is so we can do other operations on this data, such as adding residents or modifying them. 
        //Return our list of rooms since we have built a map again
        List<ApartmentResident> apartmentResidents = new ArrayList<>();
        //This will contain the information of the resident that is staying in that room.
        for(Long residentId:ApartmentResidentMap.keySet()){
        	//Add one individually to the list
            apartmentResidents.add(ApartmentResidentMap.get(residentId));
        }
        return apartmentResidents;
    }*/
}
