package parkSystemPackge;

public class vehicleData {

    private String vehicleNumber ;
    private String vehicleType;
    private int maximumWight;
    private int numBerOfPassenger;

    public vehicleData() {

    }

    public vehicleData(String vehicleNumber, String vehicleType, int maximumWight, int numBerOfPassenger) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setMaximumWight(maximumWight);
        this.setNumBerOfPassenger(numBerOfPassenger);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getMaximumWight() {
        return maximumWight;
    }

    public void setMaximumWight(int maximumWight) {
        this.maximumWight = maximumWight;
    }

    public int getNumBerOfPassenger() {
        return numBerOfPassenger;
    }

    public void setNumBerOfPassenger(int numBerOfPassenger) {
        this.numBerOfPassenger = numBerOfPassenger;
    }

    @Override
    public String toString() {
        return vehicleNumber;
    }
}
