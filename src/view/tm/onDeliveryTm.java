package view.tm;

public class onDeliveryTm {

    private String vehicleNum;
    private String vehicleType;
    private String DriverName;
    private String leftTime;

    public onDeliveryTm() {
    }

    public onDeliveryTm(String vehicleNum, String vehicleType, String driverName, String leftTime) {
        this.setVehicleNum(vehicleNum);
        this.setVehicleType(vehicleType);
        setDriverName(driverName);
        this.setLeftTime(leftTime);
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString() {
        return "onDeliveryTm{" +
                "vehicleNum='" + vehicleNum + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", DriverName='" + DriverName + '\'' +
                ", leftTime='" + leftTime + '\'' +
                '}';
    }
}
