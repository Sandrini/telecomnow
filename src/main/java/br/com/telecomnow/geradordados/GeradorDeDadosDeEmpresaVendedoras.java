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
        empresas.add(new EmpresaVendedora("Google", PLATINUM, "http://www.google.com", "img/logo-empresa-1.png"));
        empresas.add(new EmpresaVendedora("Apple", GOLD, "http://www.apple.com", "img/logo-empresa-2.png"));
        empresas.add(new EmpresaVendedora("HP", GOLD, "http://www.hp.com", "img/logo-empresa-3.png"));
        empresas.add(new EmpresaVendedora("DELL", SILVER, "http://www.dell.com", "img/logo-empresa-4.png"));
        empresas.add(new EmpresaVendedora("NeoGrid", SILVER, "http://www.neogrid.com", "img/logo-empresa-5.png"));
        return empresas;
    }
}
