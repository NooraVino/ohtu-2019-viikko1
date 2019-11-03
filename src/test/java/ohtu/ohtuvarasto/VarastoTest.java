package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void uudellaVarastollaTilavuusPositiivinen() {
        varasto = new Varasto(-2);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaTilavuusJaAlkusaldoPositiivisia() {
        varasto = new Varasto(-2, 8);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void uudellaVarastollaAlkuSaldoOIkein() {
        varasto = new Varasto(8, 3);
        assertEquals(3, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void uudellaVarastollaAlkusaldoPositiivinen() {
        varasto = new Varasto(8, -33);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    
    @Test
    public void alkuSaldoEiYlitaTilavuutta() {
        varasto = new Varasto(8, 10);
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaVarastoonVainPlussaa() {
        varasto.lisaaVarastoon(-88);

        // saldon pitäisi olla edelleen nolla, mitään ei lisätty.
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void OtaVarastostaVainPlussaa() {
        varasto.otaVarastosta(-88);

        // saldon pitäisi olla edelleen nolla, mitään ei oleotettu.
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void tilavuudenYlittävätLisäyksetHylätään() {
        varasto.lisaaVarastoon(12);
  
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void voiOttaaVainSaldonVerran() {
        varasto.lisaaVarastoon(10);
        double a = varasto.otaVarastosta(12);
  
        assertEquals(10, a, vertailuTarkkuus);
    }
    
    @Test
public void konstruktoriAsettaaSaldonOikein() {
    
    String vastaus = varasto.toString(); 

    assertEquals("saldo = 0.0, vielä tilaa 10.0", vastaus);
}
    
  
    

}