package ifpr.horario;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazyHorarioSorter implements Comparator<Horario>{
	private String sortField;

	private SortOrder sortOrder;

	public LazyHorarioSorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(Horario p1, Horario p2) {
		try {
			Object value1 = Horario.class.getField(this.sortField).get(p1);
			Object value2 = Horario.class.getField(this.sortField).get(p2);

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
