package Calebsthings;

import org.springframework.stereotype.Repository;
import com.Exceptional.Objects.ApartmentComplex;

@Repository
public interface ApartmentComplexDAO {
	
	public void createApartmentComplex(ApartmentComplex Apt) throws Exception;
	public ApartmentComplex readApartmentComplex(int id) throws Exception;
	public void updateApartmentComplex(ApartmentComplex Apt) throws Exception;
	public void deleteApartmentComplex(ApartmentComplex Apt) throws Exception;
	
	//Add any other methods to use to manipulate the data
}
