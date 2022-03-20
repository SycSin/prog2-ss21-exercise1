import java.io.File;
import java.util.ArrayList;

public class Fuel {

    private int mass;
    private File inputFile;

    public Fuel(int mass){
        setMass(mass);
    }

    public Fuel(File inputFile){
        setInputFile(inputFile);
    }

    public int getMass(){
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

    public void setInputFile(File inputFile){
        this.inputFile = inputFile;
    }

    public ArrayList<Integer> loadFromFile(){
        return new ArrayList<>();
    }
}
