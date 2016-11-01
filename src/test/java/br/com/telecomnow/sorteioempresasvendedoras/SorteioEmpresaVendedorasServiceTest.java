package br.com.telecomnow.sorteioempresasvendedoras;

import br.com.telecomnow.geradordados.GeradorDeDadosDeEmpresaVendedoras;
import br.com.telecomnow.model.EmpresaVendedora;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class SorteioEmpresaVendedorasServiceTest {

    @Test
    public  void deveSortearTresEmpresasComSucesso() {
        Collection<EmpresaVendedora> empresas = new GeradorDeDadosDeEmpresaVendedoras().gerarDados();
        SorteioEmpresaVendedorasService sorteioService = new SorteioEmpresaVendedorasService(empresas);
        Collection<EmpresaVendedora> emprestasSorteadas = sorteioService.sortear();
        Assert.assertEquals(emprestasSorteadas.size(), 3);
    }

}