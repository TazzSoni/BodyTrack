package com.example.bodytrack;

import com.example.bodytrack.Model.Pessoa;

import junit.framework.TestCase;

public class TestPessoa extends TestCase {

    public void testPessoaNome() {
        Pessoa p = new Pessoa("Rodrigo", "rod", "123", 105, 1.74);
        boolean resultado = p.verificaNome();
        assertTrue(resultado);
    }

    public void testPessoaNomeErrado() {
        Pessoa p = new Pessoa("Rodr*go", "rod", "123", 105, 1.74);
        boolean resultado = p.verificaNome();
        assertFalse(resultado);
    }

    public void testPessoaPeso() {
        Pessoa p = new Pessoa("Rodrigo", "rod", "123", 105, 1.74);
        boolean resultado = p.verificarPeso();
        assertTrue(resultado);
    }

    public void testPessoaAltura() {
        Pessoa p = new Pessoa("Rodrigo", "rod", "123", 105, 1.74);
        boolean resultado = p.verificarAltura();
        assertTrue(resultado);
    }
}
