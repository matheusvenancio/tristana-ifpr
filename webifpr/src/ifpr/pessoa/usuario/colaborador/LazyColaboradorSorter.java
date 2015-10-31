package ifpr.pessoa.usuario.colaborador;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazyColaboradorSorter implements Comparator<Colaborador>{
	private String sortField;

	private SortOrder sortOrder;

	public LazyColaboradorSorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(Colaborador p1, Colaborador p2) {
		try {
			Object value1 = Colaborador.class.getField(this.sortField).get(p1);
			Object value2 = Colaborador.class.getField(this.sortField).get(p2);

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
