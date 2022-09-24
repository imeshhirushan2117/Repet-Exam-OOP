package parkSystemPackge;

//inharitun
public class Van extends Vehicle{

    int[] reservedSlotsVan = {1, 2, 3, 4, 12, 13};
    String[] parked = {"null","null","null","null","null","null"};
    int slot;
    String passValue;

    @Override
    public void park(String vehicleNumber, String vehicleType) {


        if (parked[slot].equals("null")) {
            parked[slot] = vehicleNumber;
            System.out.println("add...."+slot);
        } else {
            System.out.println("AllReady parked");
        }
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        for (int i=0; i < parked.length; i++){
            if (vehicleNumber.equals(parked[i])){
                System.out.println("Delivery : "+parked[i]);
                parked[i]="null";
                slot=i;
                break;
            }else{
                System.out.println("not leave");
            }
        }
    }

    @Override
    public String setSlot(String vehicleNumber, String vehicleType) {
        /*for (int i=0; i<reservedSlotsVan.length; i++){
            if (parked[i].equals(vehicleNumber)){
                passValue="Parked";
                System.out.println("Parked..slot");
                break;
            }
            else{
                if (parked[i].equals("null")){
                    System.out.println("view "+reservedSlotsVan[i]);
                    slot=i;
                    passValue=Integer.toString(reservedSlotsVan[slot]);
                    break;
                }
            }
        }
        return passValue;*/

        for (int i = 0; i < reservedSlotsVan.length; i++) {

            for (int j = 0; j < reservedSlotsVan.length; j++) {
                if (parked[j].equals(vehicleNumber)) {
                    passValue = "Parked";
                    System.out.println("Parked..slot");
                    return passValue;
                }
                System.out.println("loop :" + j);
                if (j == 5) {
                    break;
                }
            }

            if (parked[i].equals("null")) {
                System.out.println("view slot " + reservedSlotsVan[i]);
                slot = i;
                passValue = Integer.toString(reservedSlotsVan[slot]);
                break;
            }

        }
        return passValue;
    }
}