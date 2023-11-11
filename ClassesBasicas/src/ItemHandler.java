
public class ItemHandler extends Events{

	private Item item;
	private int Quant;
	
	public ItemHandler (Item i, int quantidade) {
		this.item = i;
		this.Quant = quantidade;
	}
	@Override
	public void StartEvent() {
		Player.Inventario.adicionarItem(item, Quant);
	}
}
