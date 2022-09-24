package parkSystemPackge;

//super clz
abstract public class Vehicle {
    String vehicleNumber;
    String vehicleType;
    int maximumWeight;
    int numberOfPassenger;

    abstract public void park(String vehicleNumber,String vehicleType);

    abstract public void leavePark(String vehicleNumber,String vehicleType);

    abstract public String setSlot (String vehicleNumber,String vehicleType);

}
