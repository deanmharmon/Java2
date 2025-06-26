//Dean Mason
//Unit 3

import org.junit.Assert;
import org.junit.Test;

/**
 * Test
 */
public class AardvarkTest {
    @Test
    public void testAardvark(){
        String classN = "Mammalia";
        String kingdom = "Animalia";
        String phylum = "Chordata";
        String order = "Tubulidentata";
        String genus = "Orycteropus";
        String species = "Orycteropus afer";
        String family = "Orycteropodidae";
        String name = "aardvark";
        Aardvarks aard = new Aardvarks(classN, order, family, genus,
                species, name, false, phylum, "Woodland");

        Assert.assertEquals(classN, aard.getClassName());
        Assert.assertEquals(order, aard.getOrder());
        Assert.assertEquals(family, aard.getFamily());
        Assert.assertEquals(genus, aard.getGenus());
        Assert.assertEquals(species, aard.getSpecies());
        Assert.assertEquals(name, aard.getName());
        Assert.assertFalse(aard.isExtinct());
        Assert.assertEquals("Woodland", aard.getHabitat());
        Assert.assertEquals(phylum, aard.getPhylum());
        aard.setHabitat("Fire");
        aard.setExtinct(true);
        aard.setClassName("New");
        aard.setGenus("New");
        Assert.assertEquals("Fire", aard.getHabitat());
        Assert.assertEquals("New", aard.getClassName());
        Assert.assertTrue(aard.isExtinct());
        Assert.assertEquals("New", aard.getGenus());
    }
}
