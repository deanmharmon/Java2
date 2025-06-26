//Dean Mason
//Unit 3

import org.junit.Test;
import org.junit.Assert;

/**
 * Test
 */
public class VenusTest {
    @Test
    public void testVFT(){
        VenusFlyTraps vft = new VenusFlyTraps("Magnoliopsida", "Caryophyllales",
                "Droseraceae", "Dionaea", "muscipula",
                "Venus Fly Trap", false, "Anthophyta", 40);
        Assert.assertEquals("Magnoliopsida", vft.getClassName());
        Assert.assertEquals("Caryophyllales", vft.getOrder());
        Assert.assertEquals("Droseraceae", vft.getFamily());
        Assert.assertEquals("Dionaea", vft.getGenus());
        Assert.assertEquals("muscipula", vft.getSpecies());
        Assert.assertEquals("Venus Fly Trap", vft.getName());
        Assert.assertFalse(vft.isExtinct());
        Assert.assertEquals("Anthophyta", vft.getDivision());
        Assert.assertEquals(40, vft.getTrapSize());
    }

}
