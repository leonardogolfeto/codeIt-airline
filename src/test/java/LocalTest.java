import model.locais.Local;
import model.pessoas.cabine.ChefeServico;
import model.pessoas.cabine.Comissaria;
import model.pessoas.passageiros.Bandido;
import model.pessoas.passageiros.Policial;
import model.pessoas.tecnica.Oficial;
import model.pessoas.tecnica.Piloto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LocalTest {

    private Local local = new Local();
    private Piloto piloto = new Piloto();
    private Comissaria comissaria = new Comissaria();
    private Comissaria comissaria2 = new Comissaria();
    private ChefeServico chefeServico = new ChefeServico();
    private Oficial oficial = new Oficial();
    private Oficial oficial2 = new Oficial();
    private Policial policial = new Policial();
    private Bandido bandido = new Bandido();

    @Before
    public void setUp() {

        local.setPessoas(new ArrayList<>());
    }

    // PILOTO
    @Test
    public void adicinaPilotoNoLocalQuandoEstiverVazio() {

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test

    public void adicionaPilotoNoLocalQuandoSoTiverComissarias() {

        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);

        Assert.assertFalse(local.adicionaPessoa(piloto));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoSoTiverOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoTiverComissariasEOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(comissaria);

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoSoTiverBandido() {

        local.adicionaPessoa(bandido);

        Assert.assertFalse(local.adicionaPessoa(piloto));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoSoTiverPolicial() {

        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoTiverBandidoEPolicial() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoTiverChefeDeServico() {

        local.adicionaPessoa(chefeServico);

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicionaPilotoNoLocalQuandoTiverTodos() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);
        local.adicionaPessoa(chefeServico);
        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);
        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);

        Assert.assertTrue(local.adicionaPessoa(piloto));
        Assert.assertEquals(8, local.getPessoas().size());
    }

    //COMISSARIA
    @Test
    public void adicinaComissariaNoLocalQuandoEstiverVazio() {

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoSoTiverPiloto() {

        local.adicionaPessoa(piloto);
        Assert.assertFalse(local.adicionaPessoa(comissaria));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoSoTiverOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoTiverPilotoEOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoSoTiverChefeDeServico() {

        local.adicionaPessoa(chefeServico);

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoSoTiverBandido() {

        local.adicionaPessoa(bandido);

        Assert.assertFalse(local.adicionaPessoa(comissaria));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoSoTiverPolical() {

        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoTiverPolicalEBandido() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicionaComissariaNoLocalQuandoTiverTodos() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);
        local.adicionaPessoa(chefeServico);
        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(comissaria));
        Assert.assertEquals(7, local.getPessoas().size());
    }

    //CHEFE DE SERVICO

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoEstiverVazio() {

        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoSoTiverPiloto() {

        local.adicionaPessoa(piloto);
        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoSoTiverOficiais() {

        local.adicionaPessoa(oficial);

        Assert.assertFalse(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoSoTiverComissarias() {

        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);

        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoTiverPilotoEOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoSoTiverBandido() {

        local.adicionaPessoa(bandido);

        Assert.assertFalse(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoSoTiverPolical() {

        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoTiverPolicalEBandido() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaChefeDeServicoNoLocalQuandoTiverTodos() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);
        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);
        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(chefeServico));
        Assert.assertEquals(8, local.getPessoas().size());
    }

    //OFICIAL
    @Test
    public void adicinaOficialNoLocalQuandoEstiverVazio() {

        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoSoTiverPiloto() {

        local.adicionaPessoa(piloto);
        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoSoTiverComissarias() {

        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);

        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoTiverChefeDeServicoEComissaria() {

        local.adicionaPessoa(chefeServico);
        local.adicionaPessoa(comissaria);

        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoTiverChefeDeServico() {

        local.adicionaPessoa(chefeServico);

        Assert.assertFalse(local.adicionaPessoa(oficial));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoSoTiverBandido() {

        local.adicionaPessoa(bandido);

        Assert.assertFalse(local.adicionaPessoa(oficial));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoSoTiverPolical() {

        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoTiverPolicalEBandido() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaOficialNoLocalQuandoTiverTodos() {

        local.adicionaPessoa(bandido);
        local.adicionaPessoa(policial);
        local.adicionaPessoa(chefeServico);
        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);
        local.adicionaPessoa(oficial2);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(oficial));
        Assert.assertEquals(8, local.getPessoas().size());
    }

    //BANDIDO
    @Test
    public void adicinaBandidoNoLocalQuandoEstiverVazio() {

        Assert.assertTrue(local.adicionaPessoa(bandido));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaBandidoNoLocalQuandoSoTiverPiloto() {

        local.adicionaPessoa(piloto);
        Assert.assertFalse(local.adicionaPessoa(bandido));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaBandidoNoLocalQuandoSoTiverComissarias() {

        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);

        Assert.assertFalse(local.adicionaPessoa(bandido));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaBandidoNoLocalQuandoTiverChefeDeServicoEComissaria() {

        local.adicionaPessoa(chefeServico);
        local.adicionaPessoa(comissaria);

        Assert.assertFalse(local.adicionaPessoa(bandido));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaBandidoNoLocalQuandoTiverChefeDeServico() {

        local.adicionaPessoa(chefeServico);

        Assert.assertFalse(local.adicionaPessoa(bandido));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaBandidoNoLocalQuandoSoTiverPolical() {

        local.adicionaPessoa(policial);

        Assert.assertTrue(local.adicionaPessoa(bandido));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaBandidoNoLocalQuandoTiverTodos() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(policial);
        local.adicionaPessoa(chefeServico);
        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);
        local.adicionaPessoa(oficial2);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(bandido));
        Assert.assertEquals(8, local.getPessoas().size());
    }

    //POLICIAL
    @Test
    public void adicinaPolicialNoLocalQuandoEstiverVazio() {

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(1, local.getPessoas().size());
    }

    @Test
    public void adicinaPolicialNoLocalQuandoSoTiverPiloto() {

        local.adicionaPessoa(piloto);
        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaPolicialNoLocalQuandoSoTiverOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaPolicialNoLocalQuandoSoTiverChefeDeServico() {

        local.adicionaPessoa(chefeServico);

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(2, local.getPessoas().size());
    }

    @Test
    public void adicinaPolicialNoLocalQuandoSoTiverComissarias() {

        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaPolicialNoLocalQuandoTiverPilotoEOficiais() {

        local.adicionaPessoa(oficial);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(3, local.getPessoas().size());
    }

    @Test
    public void adicinaPolicialNoLocalQuandoSoTiverBandido() {

        local.adicionaPessoa(bandido);

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(2, local.getPessoas().size());
    }


    @Test
    public void adicinaPolicialNoLocalQuandoTiverTodos() {

        local.adicionaPessoa(policial);
        local.adicionaPessoa(comissaria);
        local.adicionaPessoa(comissaria2);
        local.adicionaPessoa(oficial);
        local.adicionaPessoa(oficial2);
        local.adicionaPessoa(piloto);

        Assert.assertTrue(local.adicionaPessoa(policial));
        Assert.assertEquals(7, local.getPessoas().size());
    }


}
