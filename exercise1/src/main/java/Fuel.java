import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fuel {

    private int mass;
    private File inputFile;
    private ArrayList<Integer> massCollection;

    public Fuel(int mass){
        setMass(mass);
    }

    public Fuel(File inputFile){
        setInputFile(inputFile);
        massCollection = new ArrayList<>();
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

    /*
        Part One
    */
    public int getFuelConsumption(){
        if(isInputFileNull()){
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
        if(isInputFileNull()){
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

    private int calculateFuel(int mass){
        return mass / 3 - 2;
    }

    private boolean isInputFileNull(){
        return inputFile == null;
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
            if(massCollection.isEmpty()){
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
}
