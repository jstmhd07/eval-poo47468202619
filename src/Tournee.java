public class Tournee {

    public static void trierFusion(Colis[] t) {
        if (t == null || t.length <= 1) {
            return;
        }
        trierFusionRec(t, 0, t.length - 1);
    }

    private static void trierFusionRec(Colis[] t, int gauche, int droite) {
        if (gauche < droite) {
            int milieu = gauche + (droite - gauche) / 2;
            trierFusionRec(t, gauche, milieu);
            trierFusionRec(t, milieu + 1, droite);
            fusionner(t, gauche, milieu, droite);
        }
    }

    private static void fusionner(Colis[] t, int gauche, int milieu, int droite) {
        int n1 = milieu - gauche + 1;
        int n2 = droite - milieu;

        Colis[] g = new Colis[n1];
        Colis[] d = new Colis[n2];

        for (int i = 0; i < n1; i++) {
            g[i] = t[gauche + i];
        }
        for (int j = 0; j < n2; j++) {
            d[j] = t[milieu + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = gauche;

        while (i < n1 && j < n2) {
            if (g[i].compareTo(d[j]) <= 0) {
                t[k] = g[i];
                i++;
            } else {
                t[k] = d[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            t[k] = g[i];
            i++;
            k++;
        }

        while (j < n2) {
            t[k] = d[j];
            j++;
            k++;
        }
    }

    public static Colis[] chargementOptimal(Colis[] t, int capacite) {
        if (t == null || t.length == 0 || capacite <= 0) {
            return new Colis[0];
        }

        int n = t.length;
        long[][] meilleur = new long[n + 1][capacite + 1];

        for (int i = 1; i <= n; i++) {
            int poidsI = t[i - 1].getPoids();
            long tarifI = t[i - 1].tarif();

            for (int cap = 0; cap <= capacite; cap++) {
                if (poidsI > cap) {
                    meilleur[i][cap] = meilleur[i - 1][cap];
                } else {
                    long sans = meilleur[i - 1][cap];
                    long avec = meilleur[i - 1][cap - poidsI] + tarifI;
                    meilleur[i][cap] = (avec > sans) ? avec : sans;
                }
            }
        }

        // Retrouver les colis choisis
        boolean[] pris = new boolean[n];
        int count = 0;
        int cap = capacite;

        for (int i = n; i >= 1; i--) {
            if (meilleur[i][cap] != meilleur[i - 1][cap]) {
                pris[i - 1] = true;
                count++;
                cap -= t[i - 1].getPoids();
            }
        }

        Colis[] selection = new Colis[count];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (pris[i]) {
                selection[idx++] = t[i];
            }
        }

        return selection;
    }

    public static void main(String[] args) {
        Colis[] lot = {
            new ColisStandard("C01", 4, false),
            new ColisExpress("C02", 3, true),
            new ColisFragile("C03", 5, false, 120_000),
            new ColisStandard("C04", 7, true),
            new ColisExpress("C05", 2, false),
            new ColisFragile("C06", 6, true, 45_000),
            new ColisStandard("C07", 1, true),
            new ColisExpress("C08", 8, false),
            new ColisFragile("C09", 3, false, 300_000),
            new ColisStandard("C10", 5, false),
        };

        trierFusion(lot);

        for (int i = 0; i < lot.length; i++) {
            System.out.println(lot[i]);
        }

        Colis[] choisis = chargementOptimal(lot, Parametres.CAPACITE);
        long sommeTarifs = 0;
        for (int i = 0; i < choisis.length; i++) {
            sommeTarifs += choisis[i].tarif();
        }

        System.out.println("Recette optimale : " + sommeTarifs + " FCFA (capacite " + Parametres.CAPACITE + " kg)");
    }
}

