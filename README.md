# Évaluation POO Java — Héritage, polymorphisme, transtypage (1 h)

ISEP Amadou Trawaré de Diamniadio · Département Informatique

Ce dépôt est **votre copie**. Tout ce que vous écrivez doit y être poussé avec Git pendant l'épreuve. Le sujet complet est distribué sur papier.

## 1. Avant de commencer (5 min, avant le top départ)

1. Votre dépôt s'appelle `eval-poo-<votre matricule>`. Il est **privé**, et `pape1283` y est ajouté comme collaborateur (Settings → Collaborators).
2. Clonez-le dans VS Code : `Cmd+Shift+P` (Mac) ou `Ctrl+Shift+P` (Windows/Linux) → **Git: Clone**.
3. Dans le terminal de VS Code, vérifiez votre identité Git :
   ```bash
   git config user.name "Prénom Nom"
   git config user.email "votre.email@exemple.com"
   ```

## 2. Checkpoint 0 — au top départ

1. Dans `src/Parametres.java`, remplacez `MATRICULE` et `N` (les **deux derniers chiffres** de votre matricule).
2. Dans `REPONSES.md`, remplissez les trois lignes d'identité.
3. Dans le terminal de VS Code, enregistrez la liste de vos extensions :
   ```bash
   code --list-extensions > extensions.txt
   ```
   Sur Mac, si la commande `code` est introuvable : `Cmd+Shift+P` → **Shell Command: Install 'code' command in PATH**, puis recommencez.
4. Commitez et poussez :
   ```bash
   git add -A
   git commit -m "checkpoint-0"
   git push
   ```

## 3. Pendant l'épreuve

L'enseignant annonce les checkpoints à voix haute. À chaque annonce, commitez **tout de suite**, même si votre code ne compile pas :

| Moment | Message de commit |
|--------|-------------------|
| Départ | `checkpoint-0` |
| + 15 min | `checkpoint-1` |
| + 35 min | `checkpoint-2` |
| + 50 min | `checkpoint-3` |
| + 60 min (fin) | `rendu-final` |

Commande à chaque fois (remplacez le message) :

```bash
git add -A && git commit -m "checkpoint-1" && git push
```

**Entre les checkpoints, commitez aussi après chaque question terminée** (message libre, par exemple `ex2 equals`). Plusieurs petits commits valent mieux qu'un seul gros.

## 4. Règles (leur non-respect est signalé automatiquement)

- **Aucun assistant IA** : ni Copilot, ni ChatGPT, ni Claude, ni Gemini, ni Codeium, etc. Les réglages du dossier `.vscode` désactivent les suggestions automatiques ; ne les modifiez pas.
- Pas de navigateur, sauf GitHub pour pousser. Téléphones rangés.
- Ne réécrivez jamais l'historique : **interdits** `git commit --amend`, `git rebase`, `git push --force`, et toute modification des dates.
- Pas de copier-coller depuis une autre source que ce README.
- **Tableaux statiques uniquement** (`Colis[]`, `int[]`, `long[][]`…) : `ArrayList`, `List`, `Vector`, `Map`, `Set`, `Arrays.asList`, `List.of` et les streams sont interdits dans tout votre code. Une méthode qui en utilise est notée 0.
- Toute la logique demandée doit être écrite par vous : `Arrays.sort`, `Collections.sort` et `sort()` sont interdits.
- Un **échange oral de 5 minutes** sur votre propre code peut être demandé à chacun après l'épreuve. Vous devez pouvoir expliquer et modifier chaque ligne que vous avez rendue.

## 5. Compiler et exécuter

Depuis la racine du dépôt :

```bash
javac -d bin src/*.java
java -cp bin Tournee
```

Le bouton **Run** de VS Code fonctionne aussi. Tant que les classes de l'exercice 2 n'existent pas, `src` ne contient que `Parametres.java` : c'est normal.

## 6. Jeu de données de l'exercice 3 (à recopier dans `Tournee.main`)

```java
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
```
