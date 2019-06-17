package br.cascuda.forum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.cascuda.forum.model.Publicacao;

public class PublicacaoDao extends Dao<Publicacao> {

	@Override
	void create(Publicacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update(Publicacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void delete(Publicacao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	List<Publicacao> registry() {
		List<Publicacao> publicacoes = null;
		ResultSet resultado;
		try {
			stat = conn.prepareStatement("select * from publicacoes");
			resultado = stat.executeQuery();
			while (resultado.next()) {
				Publicacao publicacao = new Publicacao();
				publicacao.setDescricao(resultado.getString("descricao"));
				publicacao.getTipo().setValue(resultado.getInt("typePublicacao"));
				publicacoes.add(publicacao);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return publicacoes;
	}
	
}
