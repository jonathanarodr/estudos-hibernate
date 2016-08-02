package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMediaMovDao {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDao movimentacao = new MovimentacaoDao(manager);
		
		Conta conta = new Conta();
        conta.setId(3);
		
		System.out.println("Total saída...: R$ " + movimentacao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA));
	}

}
