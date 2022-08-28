package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;


@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

    @DisplayName("Testa a getValorTotal de um numero")
    @Test
    public void testGetValorTotal() {
        var prod1 = new Produto("Produto 1", 20.0);
        var prod2 = new Produto("Produto 2", 20.0);
        carrinho.addItem(prod1);
        carrinho.addItem(prod2);
        Assertions.assertEquals(carrinho.getValorTotal(), 40.0);
    }

    @DisplayName("Testa a adicao de um produto")
    @Test
    public void testAddItem() {
        var prod = new Produto("Produto 1", 20.0);
        carrinho.addItem(prod);
        Assertions.assertEquals(carrinho.getQtdeItems(), 1);
    }

    @DisplayName("Testa a remocao de um item")
    @Test
    public void testRemoveItem() {
        var prod = new Produto("Produto 1", 20.0);
        carrinho.addItem(prod);
        try {
            carrinho.removeItem(prod);
        } catch (Exception e) {
            Assertions.fail();
        }
        Assertions.assertEquals(carrinho.getQtdeItems(), 0);
    }

    @DisplayName("Testa a remocao de um item inexistente")
    @Test
    public void testRemoveItemFail() {
        var prod = new Produto("Produto 1", 20.0);
        try {
            carrinho.removeItem(prod);
            Assertions.fail("Nao lancou excecao ao remover item");
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
        Assertions.assertEquals(carrinho.getQtdeItems(), 0);
    }

    @DisplayName("Testa metodo getQtdeItems")
    @Test
    public void testGetQtdeItems() {
        var prod1 = new Produto("Produto 1", 20.0);
        var prod2 = new Produto("Produto 1", 20.0);
        var prod3 = new Produto("Produto 1", 20.0);

        carrinho.addItem(prod1);
        carrinho.addItem(prod2);
        carrinho.addItem(prod3);

        Assertions.assertEquals(carrinho.getQtdeItems(), 3);

        try {
            carrinho.removeItem(prod1);
            carrinho.removeItem(prod2);
        } catch (Exception e) {
            Assertions.fail("Could not remote item from carrinho");
        }

        Assertions.assertEquals(carrinho.getQtdeItems(), 1);
    }

    @DisplayName("Testa metodo esvazia")
    @Test
    public void testEsvazia() {
        var prod1 = new Produto("Produto 1", 20.0);
        var prod2 = new Produto("Produto 1", 20.0);
        var prod3 = new Produto("Produto 1", 20.0);

        carrinho.addItem(prod1);
        carrinho.addItem(prod2);
        carrinho.addItem(prod3);

        carrinho.esvazia();
        Assertions.assertEquals(carrinho.getQtdeItems(), 0);
    }
}
