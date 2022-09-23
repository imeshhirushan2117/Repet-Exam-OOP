package parkSystemPackge;

public class Driver {
     private String driverName;
     private String nicNo;
     private String driverLicenseNo;
     private String address;
     private int contactNo;

    public Driver(String driverName, String nicNo, String driverLicenseNo, String address, int contactNo) {
        this.setDriverName(driverName);
        this.setNicNo(nicNo);
        this.setDriverLicenseNo(driverLicenseNo);
        this.setAddress(address);
        this.setContactNo(contactNo);
    }

    public Driver() {
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return driverName;
    }

}
