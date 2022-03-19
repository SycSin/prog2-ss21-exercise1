import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FuelTest {

    @DisplayName("Calculating Fuel Consumptions")
    @ParameterizedTest(name = "{index} => mass =''{0}''")
    @ValueSource(ints = {12,14})
    void testGetFuelConsumption_Scenario1(int mass){
        Fuel fuel = new Fuel(mass);

        int expected = 2;
        int actual = fuel.getFuelConsumption();

        assertEquals(expected, actual);
    }
}