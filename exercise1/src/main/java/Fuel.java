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
        if(this.getInputFile() == null){
            return (this.getMass() / 3) - 2;
        }
        else{
            ArrayList<Integer> massCollectionCalculated = new ArrayList<>();
            for(int i : massCollection) {
                massCollectionCalculated.add((i / 3) - 2);
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
