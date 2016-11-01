package br.com.telecomnow.repository.empresavendedora;

import br.com.telecomnow.model.EmpresaVendedora;

import java.util.Collection;

public interface EmpresaVendedoraRepository {
    Collection<EmpresaVendedora> sortearEmpresas();
}
