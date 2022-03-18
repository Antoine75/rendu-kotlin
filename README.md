# Rendu IIM A3 - Android Kotlin

## Envoi

Envoyer un email à `thibaud[dot]bardin[at]gmail[dot]com`

Email :
* Envoyer le 1er Avril 2022 23h59 maximum
* Le code source doit être en zip dans le mail ou un lien vers le repository git

## Rendu

Une application composée de 2 activity :
1. MainActivity
2. MapsActivity

### MainActivity

L'activity MainActivity doit avoir 2 écrans sous la forme de 2 fragments.

Le premier fragment doit afficher un formulaire avec les champs suivants :
* Champs Email (avec validation)
* Champs Password (avec validation => minimum 8 caractères, 1 lettre | 1 chiffre | 1 caractère spécial minimum)
* Case à cocher (valider que la case soit cochée pour permettre le click sur le bouton du formulaire)
* Bouton d'envoi (mettre le text "Login" dessus)

Ne pas valider réellement les crédentials (pas d'appels API ou DB), il faut juste valider le formulaire localement.

Une fois la formulaire validé, passer sur un autre fragment qui écrit "Hello `email`" sur l'écran et demande d'écrire dans un champs libre le nom d'une ville (eg. `Paris`, `Sidney`, ...).

Mettre un bouton en dessous du champs libre pour la ville, au click passer le nom de la ville à l'activity MapsActivity.

### MapsActivity

Afficher une maps avec un marker sur une ville en dur dans le code (choisir la ville de `San Francisco`).

**Optionnel :**

Récupérer le nom de la ville passée à MapsActivity, il faudra faire du `geocoding` avec l'API de Google [Geocoding API](https://developers.google.com/maps/documentation/geocoding/start) ou tout autre API à disposition.

Une fois la latitude / longitude récupérée y déposer un marker (le mettre en `rose` pour +1pt) et changer la caméra de la maps pour la centrer sur le marker.  

