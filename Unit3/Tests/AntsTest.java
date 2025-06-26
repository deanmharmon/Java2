//Dean Mason
//Unit 3

import org.junit.Assert;
import org.junit.Test;

/**
 * Test
 */
public class AntsTest {
    @Test
    public void testAardvark() {
        String classN = "Insecta";
        String kingdom = "Animalia";
        String phylum = "Anthropoda";
        String order = "Hymenoptera";
        String genus = "Whatever";
        String species = "Specific";
        String family = "Ant-like";
        String name = "Fire Ants";
        Ants ant = new Ants(classN, order, family, genus,
                species, name, false, phylum, "Worker");

        Assert.assertEquals(classN, ant.getClassName());
        Assert.assertEquals(order, ant.getOrder());
        Assert.assertEquals(family, ant.getFamily());
        Assert.assertEquals(genus, ant.getGenus());
        Assert.assertEquals(species, ant.getSpecies());
        Assert.assertEquals(name, ant.getName());
        Assert.assertFalse(ant.isExtinct());
        Assert.assertEquals("Worker", ant.getCasteLevel());
        Assert.assertEquals(phylum, ant.getPhylum());
    }

}