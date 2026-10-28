
# TP : Le pattern Strategy en Java

## 1. Présentation

Le pattern Strategy est un patron de conception comportemental qui permet de définir une famille d'algorithmes, d'encapsuler chaque algorithme dans une classe distincte et de les rendre interchangeables.

Il permet de modifier le comportement d'un programme sans changer le code de la classe qui utilise ces algorithmes.

## 2. Objectifs du TP

- Comprendre le fonctionnement du pattern Strategy.
- Appliquer les principes de la programmation orientée objet.
- Réduire le couplage entre les classes.
- Remplacer les structures conditionnelles complexes par des stratégies interchangeables.
- Faciliter l'évolution et la maintenance du code.

## 3. Structure du pattern

Le pattern Strategy repose sur trois composants principaux :

- **Strategy :** une interface qui définit une méthode commune aux différentes stratégies.
- **ConcreteStrategy :** des classes qui implémentent l'interface et définissent des algorithmes spécifiques.
- **Context :** une classe qui utilise une stratégie sans dépendre directement de son implémentation.

## 4. Exemple d'application en Java

L'exemple suivant illustre l'utilisation du pattern Strategy pour gérer différents modes de paiement.

### 4.1. Interface PaymentStrategy

Cette interface définit la méthode commune à toutes les stratégies de paiement.

```java
public interface PaymentStrategy {
    void payer(double montant);
}
```

### 4.2. Stratégie de paiement par carte bancaire

```java
public class PaiementCarte implements PaymentStrategy {
    @Override
    public void payer(double montant) {
        System.out.println(
            "Paiement par carte bancaire : " + montant + " DH"
        );
    }
}
```

### 4.3. Stratégie de paiement par PayPal

```java
public class PaiementPayPal implements PaymentStrategy {
    @Override
    public void payer(double montant) {
        System.out.println(
            "Paiement par PayPal : " + montant + " DH"
        );
    }
}
```

### 4.4. Classe de contexte

La classe `PaiementContext` utilise une stratégie de paiement définie par le programme.

```java
public class PaiementContext {
    private PaymentStrategy strategie;

    public PaiementContext(PaymentStrategy strategie) {
        this.strategie = strategie;
    }

    public void effectuerPaiement(double montant) {
        strategie.payer(montant);
    }

    public void setStrategie(PaymentStrategy strategie) {
        this.strategie = strategie;
    }
}
```

### 4.5. Classe principale

La classe `Main` permet de tester les différentes stratégies de paiement.

```java
public class Main {
    public static void main(String[] args) {
        PaiementContext contexte =
            new PaiementContext(new PaiementCarte());

        contexte.effectuerPaiement(500);

        contexte.setStrategie(new PaiementPayPal());
        contexte.effectuerPaiement(250);
    }
}
```

### Résultat attendu

```text
Paiement par carte bancaire : 500.0 DH
Paiement par PayPal : 250.0 DH
```

## 5. Explication du fonctionnement

1. L'interface `PaymentStrategy` définit la méthode `payer()`.
2. Les classes `PaiementCarte` et `PaiementPayPal` implémentent cette interface.
3. La classe `PaiementContext` utilise une référence de type `PaymentStrategy`.
4. La méthode `setStrategie()` permet de changer de mode de paiement à l'exécution.
5. La classe `Main` teste les différentes stratégies sans modifier la classe de contexte.

## 6. Avantages

- Réduction du couplage entre les classes.
- Amélioration de la lisibilité du code.
- Facilité d'ajout de nouvelles stratégies.
- Respect du principe Open/Closed : le comportement peut être étendu sans modifier le code existant du contexte.
- Possibilité de changer d'algorithme à l'exécution.

## 7. Conclusion

Ce TP permet de comprendre comment le pattern Strategy rend une application plus flexible en séparant les différents comportements dans des classes indépendantes.

Ce patron est particulièrement utile lorsque plusieurs algorithmes peuvent être utilisés pour réaliser une même opération et que le choix de l'algorithme doit pouvoir évoluer dynamiquement.
