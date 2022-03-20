public class Fuel {

    private int mass;

    public Fuel(int mass){
        setMass(mass);
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass){
        if(mass >= 0){
            this.mass = mass;
        }
        else{
            throw new IllegalArgumentException("The mass cannot be negative!");
        }
    }

    public int getFuelConsumption(){
        return (this.getMass() / 3) - 2;
    }
}
