package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;

public class TitularesComp extends Component{
	Map<Titular, List<FontePagadora>> relacionamentoComFontes = new HashMap<>();
	Map<Titular, List<Dependente>> relacionamentoComDependentes = new HashMap<>();
	

	public TitularesComp() {
		super("Titulares");
	}
	
	@Service(name="Adicionar Titular")
	public void addTitular(Titular titular) {
		LinkedList<FontePagadora> fontes = new LinkedList<>();
		this.relacionamentoComFontes.put(titular,fontes);
	}
	
	@Service(name="Listar Titulares")
	public List<Titular> listarTitulares(){
		return new ArrayList<>(relacionamentoComFontes.keySet());
	}
	
	@Service(name="Adicionar Titular com Fonte")
	public void addTitularComFonte(Titular titular, FontePagadora fonte) {		
			this.relacionamentoComFontes.get(titular).add(fonte);
	}
	
	@Service(name="Retornar Mapa de Fontes")
	public Map<Titular, List<FontePagadora>> retornarMap(){
		return this.relacionamentoComFontes;
	}
	
	@Service(name="Adicionar Titular com Dependente")
	public void addTitularComDependente(Titular titular, Dependente dependente) {		
			this.relacionamentoComDependentes.get(titular).add(dependente);
	}
	
	@Service(name="Retornar Mapa de Dependentes")
	public Map<Titular, List<Dependente>> retornarMapDependentes(){
		return this.relacionamentoComDependentes;
	}

}
