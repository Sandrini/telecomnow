package br.com.telecomnow.repository.empresavendedora;

import br.com.telecomnow.geradordados.GeradorDeDadosDeEmpresaVendedoras;
import br.com.telecomnow.model.EmpresaVendedora;
import br.com.telecomnow.sorteioempresasvendedoras.SorteioEmpresaVendedorasService;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class EmpresaVendedoraRepositoryImpl implements  EmpresaVendedoraRepository {

    private Collection<EmpresaVendedora> empresas;

    public EmpresaVendedoraRepositoryImpl() {
        empresas = new GeradorDeDadosDeEmpresaVendedoras().gerarDados();
    }

    @Override
    public Collection<EmpresaVendedora> sortearEmpresas() {
        return  new SorteioEmpresaVendedorasService(empresas).sortear();
    }
}
