package ifpr.turma;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazyTurmaSorter implements Comparator<Turma>{
	private String sortField;

	private SortOrder sortOrder;

	public LazyTurmaSorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(Turma p1, Turma p2) {
		try {
			Object value1 = Turma.class.getField(this.sortField).get(p1);
			Object value2 = Turma.class.getField(this.sortField).get(p2);

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
