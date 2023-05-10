public class Processus {
	private String name;

    public Processus(String n) throws ErreurSysteme {
        if (n == null ||  n.equals("")) {
          throw new ErreurSysteme("Nom de processus incorrect");
        } else { name = n; }
     }

	public String name() { 
		return name; 
	}

	public boolean equals(Object o) {
		if (o == null) { return false; }
		else if (o == this) { return true; }
		else {
			try { Processus p = (Processus) o;
			return p.name.equals(name);
			} catch (ClassCastException e) { return false; }
		}
	}

	public int hashCode() {
		return name.hashCode();
	}


}
