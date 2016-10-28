package br.com.telecomnow.geradordados;

import br.com.telecomnow.model.EmpresaVendedora;

import java.util.ArrayList;
import java.util.Collection;

public class GeradorDeDadosDeEmpresaVendedoras {

    public Collection<EmpresaVendedora> gerarDados() {
        Collection<EmpresaVendedora> empresas = new ArrayList<>();
        empresas.add(new EmpresaVendedora("Google", 50, "http://www.google.com"));
        empresas.add(new EmpresaVendedora("Apple", 10, "http://www.apple.com"));
        empresas.add(new EmpresaVendedora("HP", 10, "http://www.hp.com"));
        empresas.add(new EmpresaVendedora("DELL", 10, "http://www.dell.com"));
        empresas.add(new EmpresaVendedora("NeoGrid", 80, "http://www.neogrid.com"));
        return empresas;
    }
}
