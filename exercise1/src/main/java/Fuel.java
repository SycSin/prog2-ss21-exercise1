import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fuel {

    private int mass;
    private File inputFile;
    private final ArrayList<Integer> massCollection = new ArrayList<>();

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
            if (!isMassCollectionEmpty()) {
                massCollection.clear();
            }
            this.mass = mass;
        }
        else{
            throw new IllegalArgumentException("The mass cannot be negative!");
        }
    }

    /*
        Part One
    */
    public int getFuelConsumption(){
        if(isMassCollectionEmpty()){
            return calculateFuel(this.getMass());
        }
        else{
            ArrayList<Integer> massCollectionCalculated = new ArrayList<>();
            for(int mass : massCollection) {
                massCollectionCalculated.add(calculateFuel(mass));
            }
            return massCollectionCalculated.stream().mapToInt(Integer::intValue).sum();
        }
    }

    /*
        Part Two
    */
    public int getFuelConsumption2(){
        int fuel;
        int fuelSum;
        if(isMassCollectionEmpty()){
            fuel = calculateFuel(this.getMass());
            fuelSum = fuel;
            while(fuel > 0){
                fuel = calculateFuel(fuel);
                if(fuel > 0){
                    fuelSum += fuel;
                }
            }
            return fuelSum;
        }
        else{
            ArrayList<Integer> massCollectionCalculated = new ArrayList<>();
            for(int mass : massCollection){
                fuel = calculateFuel(mass);
                fuelSum = fuel;
                while(fuel > 0){
                    fuel = calculateFuel(fuel);
                    if(fuel > 0){
                        fuelSum += fuel;
                    }
                }
                massCollectionCalculated.add(fuelSum);
            }
            return massCollectionCalculated.stream().mapToInt(Integer::intValue).sum();
        }
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile){
        if(inputFile != null){
            this.inputFile = inputFile;
        }
        else{
            throw new NullPointerException("Input File cannot be null!");
        }
    }

    public ArrayList<Integer> loadFromFile(){
        try {
            if(isMassCollectionEmpty()){
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.getInputFile().getName());
                BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
                String line;
                while ((line = reader.readLine()) != null) {
                    massCollection.add(Integer.parseInt(line));
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Fuel.class.getName()).log(Level.SEVERE, null, e);
        }
        return massCollection;
    }

    private int calculateFuel(int mass){
        return mass / 3 - 2;
    }

    private boolean isMassCollectionEmpty(){
        return massCollection.isEmpty();
    }
}
