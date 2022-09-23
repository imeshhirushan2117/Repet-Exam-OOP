package view.tm;

public class inParkingTm {

    private String vehicleNumber;
    private String vehicleType;
    private String vehicleParkingSlotNum;
    private String dateTime;

    public inParkingTm() {
    }

    public inParkingTm(String vehicleNumber, String vehicleType, String vehicleParkingSlotNum, String dateTime) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setVehicleParkingSlotNum(vehicleParkingSlotNum);
        this.setDateTime(dateTime);
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

    public String getVehicleParkingSlotNum() {
        return vehicleParkingSlotNum;
    }

    public void setVehicleParkingSlotNum(String vehicleParkingSlotNum) {
        this.vehicleParkingSlotNum = vehicleParkingSlotNum;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "inParkingTm{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleParkingSlotNum='" + vehicleParkingSlotNum + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}