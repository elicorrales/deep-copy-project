package deepcopy.factorymethod.impl;

import deepcopy.factorymethod.Name;

public class NameImpl implements Name {

	private String first;
	private String last;
	
	private NameImpl(String f, String l) {
		this.first = f;
		this.last = l;
	}

	private NameImpl(Name n) {
		this.first = new String(n.getFirst());
		this.last = new String(n.getLast());
	}

	public static Name newInstance(String f,String l) {
		
		return new NameImpl(f, l);
	}

	public static Name newInstance(Name n) {
		
		return new NameImpl(n);
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Name#getFirst()
	 */
	@Override
	public String getFirst() {
		return first;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Name#setFirst(java.lang.String)
	 */
	@Override
	public void setFirst(String first) {
		this.first = first;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Name#getLast()
	 */
	@Override
	public String getLast() {
		return last;
	}

	/* (non-Javadoc)
	 * @see deepcopy.factorymethod.impl.Name#setLast(java.lang.String)
	 */
	@Override
	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NameImpl other = (NameImpl) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NameImpl [first=" + first + ", last=" + last + "]";
	}


}
