package filterutility;

import java.util.ArrayList;
import java.util.List;

import filterutility.testclasses.Car;
import filterutility.testclasses.Pet;

public class FilterTest {

	public static void main(String[] args) {

		FilterUtility filterUtil = new FilterUtility();
		
		List<Pet> petList = new ArrayList<Pet>();
		List<String> filters = new ArrayList<String>();
		
		
		petList.add(new Pet(Long.valueOf(1), "Nyx", 1, "Dog"));
		petList.add(new Pet(Long.valueOf(2), "Kiki", 2, "Cat"));
		petList.add(new Pet(Long.valueOf(3), "Chewy", 13, "Dog"));
		petList.add(new Pet(Long.valueOf(4), "Wicket", 12, "Dog"));

		filters.add("name:isEqualTo:Wicket");
		filters.add("name:isEqualTo:Kiki");
		
		
		List<Pet> filteredList = filterUtil.filter(petList, filters);
		for(Pet pet : filteredList) {
			System.out.println(pet.getName());
		}
		
		filters.clear();
		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car(Long.valueOf(1), "Rogue", "Nissan", "SUV"));
		carList.add(new Car(Long.valueOf(2), "740iL", "BMW", "Sedan"));
		carList.add(new Car(Long.valueOf(3), "528i", "BMW", "Sedan"));
		carList.add(new Car(Long.valueOf(4), "Dart", "Dodge", "Sedan"));
		carList.add(new Car(Long.valueOf(5), "GTI", "Volkswagen", "Hatchback"));
		carList.add(new Car(Long.valueOf(6), "Civic", "Honda", "Hatchback"));
		carList.add(new Car(Long.valueOf(7), "Soul", "Kia", "Hatchback"));
		carList.add(new Car(Long.valueOf(8), "CR-V", "Honda", "SUV"));
		carList.add(new Car(Long.valueOf(9), "Outback", "Subaru", "SUV"));
		carList.add(new Car(Long.valueOf(10), "Charger", "Dodge", "Sedan"));
		
		filters.add("manufacturer:isEqualTo:Dodge");
		filters.add("manufacturer:isEqualTo:BMW");
		
		List<Car> filteredCarList = filterUtil.filter(carList, filters);
		for(Car car : filteredCarList) {
			System.out.println(car.getManufacturer() + " " + car.getModel());
		}
	}

}
