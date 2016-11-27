
function mijnfunctie_1() {
	// 5 keer herhalen, van 0 tot en met 4	
	for(var i = 0; i < 5; i++){
		// doe hier iets
		console.log("i is nu " + i);
	}
}


function mijnfunctie_2() {
	// 5 keer herhalen, van 1 tot en met 5
	for(var i = 1; i <= 5; i++){
		// doe hier iets
		console.log("i is nu " + i);
	}
}

function mijnfunctie_3() {
	// 5 keer herhalen, van 12 tot en met 16
	for(var i = 12; i < 17; i++){
		// doe hier iets
		console.log("i is nu " + i);
	}
}

function mijnfunctie_4( begin, eind ) {
	// x keer herhalen, van begin tot en met eind!
	for(var i = begin; i <= eind; i++){
		// doe hier iets
		console.log("i is nu " + i);
	}
}

function mijnfunctie_5( begin, eind ) {
	var resultaat = "";

	console.log(begin + " is van type '" + typeof begin + "'");
	console.log(eind + " is van type '" + typeof eind + "'");

	if((typeof begin !== 'number') || (typeof eind !== 'number')) {
		resultaat = "Alleen getallen zijn toegestaan!"
	} else {
		for(var i = begin; i <= eind; i++){
			resultaat += "<p>i is nu " + i + ".</p>";
		}
	}
	return resultaat;
}