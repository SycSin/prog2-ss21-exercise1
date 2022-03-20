import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FuelTest {

    @DisplayName("Calculating Fuel Consumptions - Scenario 1")
    @ParameterizedTest(name = "{index} => mass =''{0}''")
    @ValueSource(ints = {12,14})
    void testGetFuelConsumption_Scenario1(int mass){
        Fuel fuel = new Fuel(mass);

        int expected = 2;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    @DisplayName("Calculating Fuel Consumptions - Scenario 2")
    @Test
    void testGetFuelConsumption_Scenario2(){
        Fuel fuel = new Fuel(1969);

        int expected = 654;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    @DisplayName("Calculating Fuel Consumptions - Scenario 3")
    @Test
    void testGetFuelConsumption_Scenario3(){
        Fuel fuel = new Fuel(100756);

        int expected = 33583;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }

    @DisplayName("Setting Mass - Scenario 1")
    @Test
    void testSetMass_Scenario1(){
        assertThrows(IllegalArgumentException.class,  () -> new Fuel(-2));
    }

    @DisplayName("Setting Mass - Scenario 2")
    @Test
    void testSetMass_Scenario2(){
        Fuel fuel = new Fuel(20);

        int expected = 20;
        int actual = fuel.getMass();

        assertEquals(expected, actual);
    }

    @DisplayName("Loading input.txt into List")
    @Test
    void testLoadFromFile_Scenario1(){

        Fuel fuel = new Fuel(new File("input.txt"));

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
}