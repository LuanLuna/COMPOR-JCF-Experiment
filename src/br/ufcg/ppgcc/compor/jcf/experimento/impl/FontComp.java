package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.LinkedList;
import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;

public class FontComp extends Component{
	List<FontePagadora> fontes = new LinkedList<>();

	public FontComp() {
		super("Fonte Pagadora");
	}
	
	@Service(name="Adicionar Fonte")
	public void adicionarFont(FontePagadora fonte){
		fontes.add(fonte);
	}
	
	@Service(name="Retornar Fonte")
	public List<FontePagadora> retornarFontes(){
		return this.fontes;
	}

}
