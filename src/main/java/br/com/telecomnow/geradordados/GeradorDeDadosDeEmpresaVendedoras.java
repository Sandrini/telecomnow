package br.com.telecomnow.geradordados;

import br.com.telecomnow.model.EmpresaVendedora;

import java.util.ArrayList;
import java.util.Collection;

import static br.com.telecomnow.model.CategoriasEmpresasVendedoras.GOLD;
import static br.com.telecomnow.model.CategoriasEmpresasVendedoras.PLATINUM;
import static br.com.telecomnow.model.CategoriasEmpresasVendedoras.SILVER;

public class GeradorDeDadosDeEmpresaVendedoras {

    public Collection<EmpresaVendedora> gerarDados() {
        Collection<EmpresaVendedora> empresas = new ArrayList<>();
        empresas.add(new EmpresaVendedora("Google", PLATINUM, "http://www.google.com", "logo-empresa.png"));
        empresas.add(new EmpresaVendedora("Apple", GOLD, "http://www.apple.com", "logo-empresa.png"));
        empresas.add(new EmpresaVendedora("HP", GOLD, "http://www.hp.com", "logo-empresa.png"));
        empresas.add(new EmpresaVendedora("DELL", SILVER, "http://www.dell.com", "logo-empresa.png"));
        empresas.add(new EmpresaVendedora("NeoGrid", SILVER, "http://www.neogrid.com", "logo-empresa.png"));
        return empresas;
    }
}
