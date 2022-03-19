public class Fuel {

    private int mass;

    public Fuel(int mass){
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }

    public int getFuelConsumption(){
        return (this.getMass() / 3) - 2;
    }
}
