import java.util.Objects;

public abstract class Colis implements Comparable<Colis> {
    private String code;
    private int poids;
    private boolean horsDakar;

    public Colis(String code, int poids, boolean horsDakar) {
        if (poids <= 0) {
            throw new IllegalArgumentException("Le poids doit être strictement supérieur à 0.");
        }
        this.code = code;
        this.poids = poids;
        this.horsDakar = horsDakar;
    }

    public String getCode() {
        return code;
    }

    public int getPoids() {
        return poids;
    }

    public boolean isHorsDakar() {
        return horsDakar;
    }

    public long tarif() {
        long t = (long) poids * Parametres.TARIF_KG;
        if (horsDakar) {
            t += Parametres.SURCHARGE_HORS_DAKAR;
        }
        return t;
    }

    public abstract String sigle();

    public abstract int priorite();

    @Override
    public String toString() {
        return "[" + sigle() + "] " + code + " " + poids + "kg " + (horsDakar ? "hors-Dakar" : "Dakar") + " " + tarif() + " FCFA";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Colis autre = (Colis) o;
        return Objects.equals(code, autre.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), code);
    }

    @Override
    public int compareTo(Colis autre) {
        if (this.priorite() != autre.priorite()) {
            return Integer.compare(autre.priorite(), this.priorite());
        }
        if (this.tarif() != autre.tarif()) {
            return Long.compare(autre.tarif(), this.tarif());
        }
        return this.code.compareTo(autre.code);
    }
}

