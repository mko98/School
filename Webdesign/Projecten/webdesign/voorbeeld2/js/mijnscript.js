

var student = {
	studentnummer: 	12345,
	voornaam: 		"Pieter",
	achternaam: 	"Paddestoel",
	naam: 			function() {
		console.log("De functie is aangeroepen.");
		return this.voornaam + ' ' + this.achternaam;
	}
}