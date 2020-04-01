import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TestBoek {

    @Test
    void testGetISBN() {
        Boek b = new Boek("Erebos", "BOEK");
        String isbn = b.getISBN();
        String verwacht = "BOEK";
        Assertions.assertEquals(verwacht, isbn);

        //null
        Boek bn = new Boek(null, null);
        String isbnNull = bn.getISBN();
        Assertions.assertNull(isbnNull);
    }

    @Test
    void testGetAuteurs() {
        Boek b = new Boek("Erebos", "BOEK");
        List<Auteur> auteurs = b.getAuteurs();
        Auteur a1 = new Auteur();
        Auteur a2 = new Auteur();
        b.addAuteur(a1);
        b.addAuteur(a2);
        List<Auteur> verwacht = new ArrayList<>();
        verwacht.add(a1);
        verwacht.add(a2);
        Assertions.assertEquals(verwacht, auteurs);

        //null
        Boek bn = new Boek("Erebos", "BOEK");
        List<Auteur> auteursn = bn.getAuteurs();
        bn.addAuteur(null);
        List<Auteur> verwachtn = new ArrayList<>();
        verwachtn.add(null);
        Assertions.assertEquals(verwachtn, auteursn);
    }

    @Test
    void testGetTitel() {
        Reeks r = new Reeks("Poznanski");
        Boek b = new Boek("Erebos", r, "BOEK");
        String titel = b.getTitel();
        String verwacht = "Erebos";
        Assertions.assertEquals(verwacht, titel);
    }

    @Test
    void testGetReeks() {
        Reeks r = new Reeks("Balahama");
        Boek b = new Boek("Alabama", r, "BOEKSKE");
        Assertions.assertEquals(r, b.getReeks());

        //null
        Boek bn = new Boek("Alabama", null, "BOEKSKE");
        Assertions.assertNull(bn.getReeks());
    }

    @Test
    void testSetReeks() {
        Reeks r = new Reeks("Balahama");
        Boek b = new Boek("Alabama", "BOEKSKE");
        b.setReeks(r);
        Assertions.assertEquals(r, b.getReeks());
        Assertions.assertNotNull(b.getReeks());

        //null
        b.setReeks(null);
        Assertions.assertNull(b.getReeks());
    }

    @Test
    void testAddAuteur() {
        Boek b = new Boek("Erebos", "BOEK");
        Auteur a = new Auteur();
        b.addAuteur(a);
        List<Auteur> auteurs = b.getAuteurs();
        List<Auteur> verwacht = new ArrayList<>();
        verwacht.add(a);
        Assertions.assertEquals(verwacht, auteurs);
        Assertions.assertNotNull(auteurs);
    }

    @Test
    void testHeeftAuteur() {
        Boek b = new Boek("Erebos", "BOEK");
        Auteur a1 = new Auteur();
        Auteur a2 = new Auteur();
        b.addAuteur(a1);
        b.addAuteur(a2);
        Assertions.assertTrue(b.heeftAuteur(a1));

        //fout
        Assertions.assertFalse(b.heeftTitel("JK Rowling"));
    }

    @Test
    void testHeeftTitel() {
        Boek b = new Boek("Erebos", "BOEK");
        Assertions.assertTrue(b.heeftTitel("Erebos"));

        //fout
        Assertions.assertFalse(b.heeftTitel("Harry Potter"));
    }

    @Test
    void testBehoortTotReeks() {
        Reeks r = new Reeks("Game of Thrones");
        Boek b = new Boek("Winter", r, "GOTBOEK");
        Assertions.assertTrue(b.behoortTotReeks(r));

        //fout
        Assertions.assertFalse(b.behoortTotReeks(new Reeks("Harry Potter")));
    }

    @Test
    void testToString() {
        Boek b = new Boek("Harry Potter zingt", new Reeks("Harry Potter"), "BOEK");
        Auteur a = new Auteur("Bob");
        b.addAuteur(a);
        String toString = b.toString();
        String verwacht = "Boek [ISBN=BOEK, auteurs=[Bob]]Medium [titel=Harry Potter zingt, reeks=Harry Potter]";
        Assertions.assertEquals(verwacht, toString);
        Assertions.assertNotNull(toString);

        //fout
        Boek bf = null;
        Assertions.assertThrows(NullPointerException.class, () -> bf.toString());
    }

    @Test
    void testHashCode() {
        Reeks r = new Reeks("Karelserie");
        Boek b1 = new Boek("Karel De Grootte", r, "BOEKK");
        Boek b2 = new Boek("Karel De Grootte", r, "BOEKK");
        Assertions.assertEquals(b1.hashCode(), b2.hashCode());
        Assertions.assertNotNull(b1.hashCode());

        //test met null
        Boek bn1 = new Boek(null, null, null);
        Boek bn2 = new Boek(null, null, null);
        Assertions.assertEquals(bn1.hashCode(), bn2.hashCode());
        Assertions.assertNotNull(b1.hashCode());

        //fout
        Boek bf1 = null;
        Assertions.assertThrows(NullPointerException.class, () -> bf1.hashCode());

    }

    @Test
    void testEquals() {
        Reeks r = new Reeks("Karelserie");
        Boek b1 = new Boek("Karel De Grootte", r, "BOEKK");
        Boek b2 = new Boek("Karel De Grootte", r, "BOEKK");
        Boek b3 = new Boek("Karel De Kleine", r, "BOEK");
        Assertions.assertEquals(b1.equals(b2), b2.equals(b1));
        Assertions.assertFalse(b1.equals(b3));

        //null
        Boek bn1 = new Boek(null, r, null);
        Boek bn2 = new Boek(null, r, null);
        Assertions.assertEquals(bn1.equals(bn2), bn2.equals(bn1));

        //fout
        Boek bf1 = null;
        Boek bf2 = null;
        Assertions.assertThrows(NullPointerException.class, () -> bf1.equals(bf2));
    }

}