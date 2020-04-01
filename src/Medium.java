
public abstract class Medium {
	private String titel;
	private Reeks reeks;

	//constructors
	public Medium(String titel) {
		this.titel = titel;
		this.reeks = null;
	}
	public Medium(String titel, Reeks reeks) {
		this.titel = titel;
		this.reeks = reeks;
	}

	//getters en setters
	public String getTitel() {
		return titel;
	}
	public Reeks getReeks() {
		return reeks;
	}
	public void setReeks(Reeks reeks) {
		this.reeks = reeks;
	}

	//methodes
	public boolean heeftTitel(String t) {
		return titel.toUpperCase().equals(t.toUpperCase());
	}
	public boolean behoortTotReeks(Reeks reeks) {
		return this.reeks.equals(reeks);
	}

	//extra's
	public String toString() {
		return "Medium [titel=" + titel + ", reeks=" + reeks + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medium other = (Medium) obj;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}
}
