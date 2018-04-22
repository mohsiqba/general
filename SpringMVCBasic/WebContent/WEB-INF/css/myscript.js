function myFunction(ele) {
	document.getElementById("myselecttext").value = ele.value;
}

function show_page(ele){
	switch(ele){
		case 'login':	document.getElementById('content').innerHTML="<form action='#'><label>Username</label>&nbsp;<input type='text' name='username' placeholder='name' /><br><br><label>Password</label>&nbsp;&nbsp;<input type='password' name='password' placeholder='password'/><br><br><input type='submit' value='submit'/></form>";
						document.querySelector("#content").style.cssText = "padding: 120px;";
						break;
		
		case 'list':	document.getElementById('content').innerHTML="<h2>Hello World</h2><ul><li>This is First Row</li><li>This is Second Row</li><li>This is Third Row</li></ul>";	
						document.querySelector("#content").style.cssText = "Margin-left:30px;";
						break;
		
		case 'pic':		document.getElementById('content').innerHTML="";
						document.querySelector("#content").style.cssText = "";
						break;
		
		case 'choice':	document.getElementById('content').innerHTML="<select id='myselect' onchange='myFunction(this)'><option value=''>-- Select an Option --</option><option value='volvo'>Volvo</option><option value='saab'>Saab</option><option value='mercedes'>Mercedes</option><option value='audi'>Audi</option></select> <br><br><br><br><br><br><br><br><br><br><br> <input type='text' id='myselecttext'	placeholder='Selected Text Here!!!' />";
						document.querySelector("#content").style.cssText = "margin-left: 180px; margin-top: 90px;";
						break;
	}
}
