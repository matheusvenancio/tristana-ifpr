package ifpr.curso;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazyCursoSorter implements Comparator<Curso>{
	private String sortField;

	private SortOrder sortOrder;

	public LazyCursoSorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compare(Curso p1, Curso p2) {
		try {
			Object value1 = Curso.class.getField(this.sortField).get(p1);
			Object value2 = Curso.class.getField(this.sortField).get(p2);

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
