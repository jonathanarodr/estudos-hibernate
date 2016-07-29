package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Jonathan Rodrigues");
		conta.setBanco("CAIXA");
		conta.setNumero("01234");
		conta.setAgencia("0900");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setValor(new BigDecimal(2180.30));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("habitação");
		movimentacao.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();		
	}

}