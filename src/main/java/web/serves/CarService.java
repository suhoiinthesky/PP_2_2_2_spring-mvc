package web.serves;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarService {
    private List<Car> cars;
    private static int CARS_COUNT;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "Audi", "Black"));
        cars.add(new Car(++CARS_COUNT, "BMW", "White"));
        cars.add(new Car(++CARS_COUNT, "Mercedes", "Grey"));
        cars.add(new Car(++CARS_COUNT, "Volkswagen", "Red"));
        cars.add(new Car(++CARS_COUNT, "Nissan", "Blue"));
    }


    public List<Car> getCars() {
        return cars;
    }
    public Car getSomeCar(int id){
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }
}
