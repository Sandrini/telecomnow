package br.com.telecomnow.repository.empresavendedora;

import br.com.telecomnow.geradordados.GeradorDeDadosDeEmpresaVendedoras;
import br.com.telecomnow.model.EmpresaVendedora;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Repository
public class EmpresaVendedoraRepositoryImpl implements  EmpresaVendedoraRepository {

    private Collection<EmpresaVendedora> empresas;

    public EmpresaVendedoraRepositoryImpl() {
        empresas = new GeradorDeDadosDeEmpresaVendedoras().gerarDados();
    }

    @Override
    public Collection<EmpresaVendedora> sortearEmpresas() {
        Collection<EmpresaVendedora> sorteadas = new ArrayList<>();
        Iterator<EmpresaVendedora> iterator = empresas.iterator();
        sorteadas.add(iterator.next());
        sorteadas.add(iterator.next());
        sorteadas.add(iterator.next());
        return sorteadas;
    }
}
