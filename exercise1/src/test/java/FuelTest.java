import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
    Repository-Link: https://github.com/SycSin/prog2-ss21-exercise1
*/
class FuelTest {

    /*
        Part 1: Testing getFuelConsumption() calculation with a mass
                of 12 and 14. Expecting a fuel consumption of 2.
    */
    @DisplayName("Part 1: Calculating Fuel Consumptions - Scenario 1")
    @ParameterizedTest(name = "{index} => mass =''{0}''")
    @Tag("Part1")
    @ValueSource(ints = {12,14})
    public void testGetFuelConsumption_Scenario1(int mass){
        Fuel fuel = buildFuelByMass(mass);

        int expected = 2;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    /*
        Part 1: Testing getFuelConsumption() calculation with a mass
                of 1969. Expecting a fuel consumption of 654.
    */
    @DisplayName("Part 1: Calculating Fuel Consumptions - Scenario 2")
    @Tag("Part1")
    @Test
    public void testGetFuelConsumption_Scenario2(){
        Fuel fuel = buildFuelByMass(1969);

        int expected = 654;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    /*
        Part 1: Testing getFuelConsumption() calculation with a mass
                of 100756. Expecting a fuel consumption of 33583.
    */
    @DisplayName("Part 1: Calculating Fuel Consumptions - Scenario 3")
    @Tag("Part1")
    @Test
    public void testGetFuelConsumption_Scenario3(){
        Fuel fuel = buildFuelByMass(100756);

        int expected = 33583;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    /*
        Part 1: Testing getFuelConsumption() calculation from a
                loaded "input.txt" file.
                Expecting a fuel consumption of 3412531.
    */
    @DisplayName("Part 1: Calculating Fuel Consumptions - Scenario 4")
    @Tag("Part1")
    @Test
    public void testGetFuelConsumption_Scenario4(){
        Fuel fuel = buildFuelByFile(new File("input.txt"));
        fuel.loadFromFile();
        int expected = 3412531;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    /*
        Part 1: Testing getFuelConsumption() calculation by first specifying
                a mass and then loading the masses from an input file.
                Expecting a fuel consumption of 3412531.
    */
    @DisplayName("Part 1: Calculating Fuel Consumptions - Scenario 5")
    @Tag("Part1")
    @Test
    public void testGetFuelConsumption_Scenario5(){
        Fuel fuel = buildFuelByMass(123);
        fuel.setInputFile(new File("input.txt"));
        fuel.loadFromFile();
        int expected = 3412531;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    /*
        Part 1: Testing getFuelConsumption() calculation by first loading
                the masses from an input file and then setting the mass to 100756.
                Expecting a fuel consumption of 33583.
    */
    @DisplayName("Part 1: Calculating Fuel Consumptions - Scenario 6")
    @Tag("Part1")
    @Test
    public void testGetFuelConsumption_Scenario6(){
        Fuel fuel = buildFuelByFile(new File("input.txt"));
        fuel.loadFromFile();
        fuel.setMass(100756);
        int expected = 33583;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    /*
        Part 2: Testing getFuelConsumption2() calculation with a mass
                of 12 and 14. Expecting a fuel consumption of 2.
    */
    @DisplayName("Part 2: Calculating Fuel Consumptions - Scenario 1")
    @ParameterizedTest(name = "{index} => mass =''{0}''")
    @Tag("Part2")
    @ValueSource(ints = {12,14})
    public void testGetFuelConsumption2_Scenario1(int mass){
        Fuel fuel = buildFuelByMass(mass);
        int expected = 2;
        int actual = fuel.getFuelConsumption2();

        assertEquals(expected, actual);
    }

    /*
        Part 2: Testing getFuelConsumption2() calculation with a mass
                of 1969. Expecting a fuel consumption of 966.
    */
    @DisplayName("Part 2: Calculating Fuel Consumptions - Scenario 2")
    @Tag("Part2")
    @Test
    public void testGetFuelConsumption2_Scenario2(){
        Fuel fuel = buildFuelByMass(1969);
        int expected = 966;
        int actual = fuel.getFuelConsumption2();

        assertEquals(expected, actual);
    }

    /*
        Part 2: Testing getFuelConsumption2() calculation with a mass
                of 100756. Expecting a fuel consumption of 50346.
    */
    @DisplayName("Part 2: Calculating Fuel Consumptions - Scenario 3")
    @Tag("Part2")
    @Test
    public void testGetFuelConsumption2_Scenario3(){
        Fuel fuel = buildFuelByMass(100756);
        int expected = 50346;
        int actual = fuel.getFuelConsumption2();

        assertEquals(expected, actual);
    }

    /*
        Part 2: Testing getFuelConsumption2() calculation from a
                loaded "input.txt" file.
                Expecting a fuel consumption of 5115927.
    */
    @DisplayName("Part 2: Calculating Fuel Consumptions - Scenario 4")
    @Tag("Part2")
    @Test
    public void testGetFuelConsumption2_Scenario4(){
        Fuel fuel = buildFuelByFile(new File("input.txt"));
        fuel.loadFromFile();
        int expected = 5115927;
        int actual = fuel.getFuelConsumption2();

        assertEquals(expected, actual);
    }

    /*
        Part 2: Testing getFuelConsumption2() calculation by first specifying
                a mass and then loading the masses from an input file.
                Expecting a fuel consumption of 5115927.
    */
    @DisplayName("Part 2: Calculating Fuel Consumptions - Scenario 5")
    @Tag("Part2")
    @Test
    public void testGetFuelConsumption2_Scenario5(){
        Fuel fuel = buildFuelByMass(123);
        fuel.setInputFile(new File("input.txt"));
        fuel.loadFromFile();
        int expected = 5115927;
        int actual = fuel.getFuelConsumption2();

        assertEquals(expected, actual);
    }

    /*
        Part 2: Testing getFuelConsumption2() calculation by first loading
                the masses from an input file and then setting the mass to 100756.
                Expecting a fuel consumption of 50346.
    */
    @DisplayName("Part 2: Calculating Fuel Consumptions - Scenario 6")
    @Tag("Part2")
    @Test
    public void testGetFuelConsumption2_Scenario6(){
        Fuel fuel = buildFuelByFile(new File("input.txt"));
        fuel.loadFromFile();
        fuel.setMass(100756);
        int expected = 50346;
        int actual = fuel.getFuelConsumption2();

        assertEquals(expected, actual);
    }

    /*
        Testing the setMass() method by passing a negative value to the method.
        Expecting a IllegalArgumentException.
    */
    @DisplayName("Setting Mass - Scenario 1")
    @Test
    public void testSetMass_Scenario1(){
        Fuel fuel = buildFuelByMass(123);
        assertThrows(IllegalArgumentException.class,  () -> fuel.setMass(-2));
    }

    /*
        Testing the setMass() method by passing a mass of 20 to the method.
        Expecting a mass value of 20.
    */
    @DisplayName("Setting Mass - Scenario 2")
    @Test
    public void testSetMass_Scenario2(){
        Fuel fuel = buildFuelByMass(100);
        fuel.setMass(20);

        int expected = 20;
        int actual = fuel.getMass();

        assertEquals(expected, actual);
    }

    /*
        Testing the loadFromFile() method by loading an "input.txt" text file
        with a list of masses.
        Expecting an ArrayList with elements from the content of the "input.txt" file.
    */
    @DisplayName("Loading input.txt into List")
    @Test
    public void testLoadFromFile_Scenario1(){

        Fuel fuel = buildFuelByFile(new File("input.txt"));

        ArrayList<Integer> expected = new ArrayList<>(
                List.of(
                        50572, 126330, 143503, 136703, 56987,
                        96737, 140243, 94427, 84262, 149323,
                        87398, 132344, 72187, 90878, 72897,
                        101305, 129483, 101148, 66349, 76719,
                        86437, 84937, 73911, 141051, 61464,
                        85350, 81774, 129191, 130129, 118366,
                        125825, 61781, 98459, 69024, 75886,
                        119434, 108929, 117387, 149625, 79378,
                        102582, 102368, 117177, 132105, 137278,
                        149187, 136653, 70074, 115885, 73901,
                        81922, 133232, 112929, 80009, 116895,
                        61248, 140251, 98003, 109610, 132775,
                        55781, 110809, 109799, 125071, 71734,
                        104973, 75610, 148974, 144173, 89235,
                        89438, 64901, 142674, 105446, 55287,
                        64438, 82269, 99903, 97079, 72708,
                        108177, 130830, 50393, 141354, 123264,
                        116302, 51119, 127287, 137515, 109285,
                        110750, 93770, 54926, 57131, 136897,
                        97693, 135531, 122858, 112089, 98599
                )
        );

        ArrayList<Integer> actual = fuel.loadFromFile();

        assertEquals(expected, actual);
    }

    /*
        Testing the loadFromFile() method by loading an "input_nonNumeric.txt" file
        where elements contain letters provoking a NumberFormatException.
        Expecting a NumberFormatException.
    */
    @DisplayName("Loading input_nonNumeric.txt into List")
    @Test
    public void testLoadFromFile_Scenario2(){
        Fuel fuel = buildFuelByFile(new File("input_nonNumeric.txt"));
        assertThrows(NumberFormatException.class, fuel::loadFromFile);
    }

    /*
        Testing the setInputFile() method by passing a null-reference to
        the setInputFile() method.
        Expecting a NullPointerException with the message "Input File cannot be null!"
    */
    @DisplayName("Pass null value to setInputFile method")
    @Test
    public void testSetInputFile_Scenario1(){
        Fuel fuel = buildFuelByFile(new File("input.txt"));
        assertThrows(NullPointerException.class, () -> fuel.setInputFile(null), "Input File cannot be null!");
    }

    /*
        private method to reduce redundant code duplicates
    */
    private Fuel buildFuelByMass(int mass) {
        return new Fuel(mass);
    }

    /*
        private method to reduce redundant code duplicates
    */
    private Fuel buildFuelByFile(File file) {
        return new Fuel(file);
    }
}