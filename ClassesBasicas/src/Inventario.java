import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item, int Quant) {
        Item i = ProcurarItens(item);
        if(i != null) {
        	i.addQuantidade(Quant)
        }
        else {
        	item.addQuantidade(Quant);
        	this.itens.add(item);
        }
    }

    public void removerItem(Item item) {
        this.itens.remove(item);
    }
    public Item ProcurarItens(Item item) {
    	for(Item i : this.Itens) {
    		if(item.Nome == i.Nome) {
    			return i;
    		}
    	}
    	return null;
    }
}
