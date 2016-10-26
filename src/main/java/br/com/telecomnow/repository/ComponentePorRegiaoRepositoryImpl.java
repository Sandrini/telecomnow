package br.com.telecomnow.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.telecomnow.model.ComponenteRegiao;

/**
 * Created by Leonardo on 25/10/2016.
 */
@Repository
public class ComponentePorRegiaoRepositoryImpl implements ComponentePorRegiaoRepository {

    private Map<String, ComponenteRegiao> componentes = new HashMap<>();

    @Autowired
    public ComponentePorRegiaoRepositoryImpl(Perguntas perguntas) {
    	ComponenteRegiao filialRJ = new ComponenteRegiao();
    	filialRJ.setComponente("FILIAL");
    	filialRJ.setRegiao("NORTE");
    	filialRJ.setQuatidadeAderente(100L);
    	filialRJ.setQuatidadeNaoAderente(80L);
    
    	ComponenteRegiao filialRS = new ComponenteRegiao();
    	filialRJ.setComponente("FILIAL");
    	filialRJ.setRegiao("SUL");
    	filialRJ.setQuatidadeAderente(300L);
    	filialRJ.setQuatidadeNaoAderente(70L);
    	
    	ComponenteRegiao chatRS = new ComponenteRegiao();
    	chatRS.setComponente("CHAT");
    	chatRS.setRegiao("SUL");
    	chatRS.setQuatidadeAderente(300L);
    	chatRS.setQuatidadeNaoAderente(70L);
    	
    	componentes.put(gerarChave(filialRJ), filialRJ);
    	componentes.put(gerarChave(filialRS), filialRS);
    	componentes.put(gerarChave(chatRS), chatRS);
    }


	private String gerarChave(ComponenteRegiao filialRJ) {
		return filialRJ.getComponente()+filialRJ.getRegiao();
	}


	@Override
    public void incrementarComponente(String componente, String regiao, boolean aderente) {
    	String chave = componente+regiao;
		ComponenteRegiao componenteRegiao = componentes.get(chave);
    	if (componenteRegiao == null) {
    		componenteRegiao = new ComponenteRegiao(); 
    		componenteRegiao.setComponente(componente);
    		componenteRegiao.setRegiao(regiao);
    		componenteRegiao.setQuatidadeAderente(aderente ? 1L : 0L);
    		componenteRegiao.setQuatidadeNaoAderente(!aderente ? 1L : 0L);
    		componentes.put(chave, componenteRegiao);
    	}
    }
}
