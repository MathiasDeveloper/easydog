package fr.easydog.unit.boTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import fr.easydog.bo.Dog;

public class DogTest {

    private Dog dog;

    @Before
    public void setUp() {
        dog = new Dog();
    }

    @Test
    public void getId(){
        int attempt = 1;
        dog.setId(1);
        assertEquals(attempt, dog.getId());
    }

}
