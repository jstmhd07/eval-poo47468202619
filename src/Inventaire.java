public class Inventaire {

    public static long valeurAssuree(Object[] objets) {
        if (objets == null) {
            return 0;
        }
        long total = 0;
        for (int i = 0; i < objets.length; i++) {
            Object o = objets[i];
            if (o instanceof ColisFragile) {
                ColisFragile cf = (ColisFragile) o;
                total += cf.getValeurDeclaree();
            }
        }
        return total;
    }

    public static int[] compterParType(Object[] objets) {
        int[] compteurs = new int[4]; // {standard, express, fragile, autres}
        if (objets == null) {
            return compteurs;
        }
        for (int i = 0; i < objets.length; i++) {
            Object o = objets[i];
            if (o == null) {
                continue;
            } else if (o instanceof ColisFragile) {
                compteurs[2]++;
            } else if (o instanceof ColisStandard) {
                compteurs[0]++;
            } else if (o instanceof ColisExpress) {
                compteurs[1]++;
            } else {
                compteurs[3]++;
            }
        }
        return compteurs;
    }
}

