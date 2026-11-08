# Réponses — Évaluation POO : héritage, polymorphisme, transtypage

- Matricule : 47468202619
- Nom et prénom : MARONE Mouhamed
- N (deux derniers chiffres du matricule) : 19

> Rédigez vos justifications **avec vos propres mots**. Elles serviront de base à l'échange oral.

## Exercice 1 — A. Affichage prédit

Écrivez ci-dessous, entre les deux lignes de trois accents graves, **une ligne par ligne affichée**, dans l'ordre.
Ne modifiez pas les lignes de trois accents graves.

```
A vehicule
F null 0
E moto 119
Moto2
vehicule
moto
C3
C2
D-vehicule
A vehicule
F null 0
E moto 119
true false
true
A vehicule
B vehicule
3
```

## Exercice 1 — A. Justifications

1. **Ligne qui commence par « F »** : Lors de `new Moto()`, le constructeur de `Vehicule` s'exécute d'abord et appelle `demarrer()`. Par polymorphisme (liage dynamique), c'est la méthode redéfinie dans `Moto` qui s'exécute. Mais à cet instant, les champs d'instance de `Moto` (`nom` et `cylindree`) ne sont pas encore initialisés et ont leurs valeurs par défaut (`null` et `0`).
2. **Ligne « C3 »** : L'argument passé à `v.comparer(v)` a pour type statique `Vehicule`. Le compilateur sélectionne la signature `comparer(Vehicule)`. À l'exécution, l'objet réel étant une `Moto`, la méthode redéfinie dans `Moto` est exécutée et renvoie `"C3"`.
3. **Ligne « C2 »** : Le type déclaré de la variable `v` est `Vehicule`. Dans `Vehicule`, la méthode qui correspond à l'argument de type statique `Moto` est `comparer(Moto)`. Comme `Moto` ne redéfinit pas cette surcharge spécifique (elle n'a redéfini que `comparer(Vehicule)`), c'est la méthode héritée de `Vehicule` qui s'exécute et renvoie `"C2"`.
4. **Ligne qui commence par « D- »** : `categorie()` est une méthode statique (`static`). En Java, les méthodes statiques ne sont pas polymorphiques : l'appel est résolu à la compilation selon le type déclaré de la référence (`Vehicule`), affichant donc `"D-vehicule"`.
5. **Pourquoi des lignes « A », « F », « E » apparaissent avant « true false »** : L'expression `(o == new Moto())` instancie un nouvel objet `Moto`. L'exécution du constructeur de cette nouvelle `Moto` (qui affiche `A ...`, `F ...`, `E ...`) se produit avant que la ligne contenant `true false` ne soit imprimée.

## Exercice 1 — B. Transtypage

Colonne « Compile ? » : `oui` ou `non`. Colonne « Exécution » : `OK`, `exception` (en précisant laquelle), ou `-` si le code ne compile pas.

| n° | Compile ? | Exécution | Justification |
|----|-----------|-----------|---------------|
| 1  | oui | OK | Upcasting implicite : une `Moto` est un `Vehicule`. |
| 2  | non | - | Le type statique de `a` est `Vehicule`, la conversion vers la sous-classe `Moto` nécessite un cast explicite. |
| 3  | oui | OK | Cast explicite valide car `Moto` hérite de `Vehicule`, et à l'exécution `a` contient bien une `Moto`. |
| 4  | oui | ClassCastException | Le cast explicite depuis `Object` compile, mais à l'exécution `b` est un `Camion` (pas une `Moto`). |
| 5  | non | - | `c` est de type statique `Moto`. `Moto` et `Camion` sont deux branches disjointes : le compilateur sait que c'est impossible. |
| 6  | oui | ClassCastException | Cast explicite depuis `Object` accepté à la compilation, mais à l'exécution `b` n'est pas une `String`. |
| 7  | non | - | La méthode `type()` n'est pas définie dans la classe `Object` (type statique de `b`). |
| 8  | oui | OK | `((Vehicule) b)` donne accès à la méthode `type()`, et à l'exécution `Camion` hérite bien de cette méthode. |

