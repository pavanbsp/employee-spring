
//BUTTON ACTIONS
function addEmployee(event){
	//event.preventDefault();
	var $form = $("#employee-form");
	var json = toJson($form);

	$.ajax({
	   url: './api',
	   type: 'POST',
	   data: json,
	   success: function(response) {
	   		console.log("Employee created");	
	   		getEmployeeList();     //...
	   },
	   error: function(){
	   		alert("An error has occurred");
	   }
	});

	return false;
}


function getEmployeeList(){
	$.ajax({
	   url: './api',
	   type: 'GET',
	   success: function(data) {
	   		console.log("Employee data fetched");
	   		console.log(data);	
	   		displayEmployeeList(data);     //...
	   },
	   error: function(){
	   		alert("An error has occurred");
	   }
	});
}

function deleteEmployee(id){
	$.ajax({
	   url: './api?id='+id,
	   type: 'DELETE',
	   success: function(data) {
	   		console.log("Employee deleted");
	   		getEmployeeList();     //...
	   },
	   error: function(){
	   		alert("An error has occurred");
	   }
	});
}

//UI DISPLAY METHODS

function displayEmployeeList(data){
	console.log('Printing employee data');
	var $tbody = $('#employee-table').find('tbody');
	$tbody.empty();
	for(var i in data){
		var e = data[i];
		var buttonHtml = '<button onclick="deleteEmployee(' + e.id + ')">delete</button>'
		var row = '<tr>'
		+ '<td>' + e.id + '</td>'
		+ '<td>' + e.name + '</td>'
		+ '<td>'  + e.age + '</td>'
		+ '<td>' + buttonHtml + '</td>'
		+ '</tr>';
        $tbody.append(row);
	}
}

//HELPER METHOD

function toJson($form){
    var serialized = $form.serializeArray();
    console.log(serialized);
    var s = '';
    var data = {};
    for(s in serialized){
        data[serialized[s]['name']] = serialized[s]['value']
    }
    var json = JSON.stringify(data);
    console.log(json);
    return json;
}


//INITIALIZATION CODE
function init(){
	$('#add-employee').click(addEmployee);
	$('#refresh-data').click(getEmployeeList);
}
$(document).ready(init);
$(document).ready(getEmployeeList);

