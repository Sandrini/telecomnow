package br.com.telecomnow.sorteioempresasvendedoras;

import br.com.telecomnow.model.CategoriasEmpresasVendedoras;
import br.com.telecomnow.model.EmpresaVendedora;
import org.springframework.util.Assert;

import java.util.*;

public class SorteioEmpresaVendedorasService {

    private Map<CategoriasEmpresasVendedoras, List<EmpresaVendedora>> emprestasPorCategoriaMap;

    public SorteioEmpresaVendedorasService(Collection<EmpresaVendedora> empresas) {
        Assert.notEmpty(empresas);
        emprestasPorCategoriaMap = new HashMap<>();
        for (EmpresaVendedora empresa : empresas) {
            List<EmpresaVendedora> emprestasCategoria = emprestasPorCategoriaMap.getOrDefault(empresa.getCategoria(), new ArrayList<>());
            emprestasCategoria.add(empresa);
            emprestasPorCategoriaMap.put(empresa.getCategoria(), emprestasCategoria);
        }
    }

    public Collection<EmpresaVendedora> sortear() {
        Collection<EmpresaVendedora> empresasSorteadas = new ArrayList<>();
        while (empresasSorteadas.size() < 3) {
            int sorteioCategoria = new Random().nextInt(100);
            if (sorteioCategoria <= 10 && emprestasPorCategoriaMap.containsKey(CategoriasEmpresasVendedoras.SILVER)){
                empresasSorteadas.add(sortearEmpresaNaCategoria(CategoriasEmpresasVendedoras.SILVER));
            } else if (sorteioCategoria > 10 && sorteioCategoria <= 40 && emprestasPorCategoriaMap.containsKey(CategoriasEmpresasVendedoras.GOLD)){
                empresasSorteadas.add(sortearEmpresaNaCategoria(CategoriasEmpresasVendedoras.GOLD));
            } else if (emprestasPorCategoriaMap.containsKey(CategoriasEmpresasVendedoras.PLATINUM)){
                empresasSorteadas.add(sortearEmpresaNaCategoria(CategoriasEmpresasVendedoras.PLATINUM));
            }
        }
        return empresasSorteadas;
    }

    private EmpresaVendedora sortearEmpresaNaCategoria(CategoriasEmpresasVendedoras categoria) {
        List<EmpresaVendedora> empresasNaCategoria = emprestasPorCategoriaMap.get(categoria);
        int sorteioEmpresaNaCategoria = new Random().nextInt(empresasNaCategoria.size());
        return empresasNaCategoria.get(sorteioEmpresaNaCategoria);
    }
}
