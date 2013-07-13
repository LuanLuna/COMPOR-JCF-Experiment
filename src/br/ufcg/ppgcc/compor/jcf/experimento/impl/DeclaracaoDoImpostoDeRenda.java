package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import net.compor.frameworks.jcf.api.ComporFacade;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FachadaExperimento;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.GastoDedutivel;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Pessoa;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class DeclaracaoDoImpostoDeRenda extends ComporFacade implements FachadaExperimento {
	List<FontePagadora> fontes = new LinkedList<>();

	/**
	 * @param args
	 */
	public DeclaracaoDoImpostoDeRenda() {
		add(new TitularesComp());
		//add(new FontComp());
	}
	
	@Override
	public void criarNovoTitular(Titular titular) {
		requestService("Adicionar Titular", titular);
		
	}

	@Override
	public List<Titular> listarTitulares() {
		// TODO Auto-generated method stub
		return (ArrayList<Titular>) requestService("Listar Titulares");
	}

	@Override
	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		requestService("Adicionar Titular com Fonte", titular, fonte);
	}

	@Override
	public Resultado declaracaoCompleta(Titular titular) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void criarDependente(Titular titular, Dependente dependente) {
		// TODO Auto-generated method stub
		requestService("Adicionar Titular com Dependente", titular, dependente);
		
	}

	@Override
	public List<FontePagadora> listarFontes(Titular titular) {
		Map<Titular, List<FontePagadora>> map = (Map<Titular, List<FontePagadora>>) requestService("Retornar Mapa de Fontes");
		return map.get(titular);
	}

	@Override
	public List<Dependente> listarDependentes(Titular titular) {
		// TODO Auto-generated method stub
		Map<Titular, List<Dependente>> map = (Map<Titular, List<Dependente>>) requestService("Retornar Mapa de Dependentes");
		return map.get(titular);
	}


}
