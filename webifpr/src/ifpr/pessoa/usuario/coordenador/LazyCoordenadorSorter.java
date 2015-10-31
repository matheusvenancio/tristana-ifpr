package ifpr.pessoa.usuario.coordenador;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazyCoordenadorSorter implements Comparator<Coordenador>{
	private String sortField;

	private SortOrder sortOrder;

	public LazyCoordenadorSorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(Coordenador p1, Coordenador p2) {
		try {
			Object value1 = Coordenador.class.getField(this.sortField).get(p1);
			Object value2 = Coordenador.class.getField(this.sortField).get(p2);

			int value = ((Comparable) value1).compareTo(value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public SortOrder getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}
}
