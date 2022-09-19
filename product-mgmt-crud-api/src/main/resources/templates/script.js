fetch("http://localhost:8080/products/").then((data)=>{
	//console.log(data);   //json format
	return data.json();  //convert to object
}).then((ObjectData)=>{
	//console.log(ObjectData[0].id);
	
	let tableData= "";
	
	ObjectData.map((values)=>{
		tableData+= ` <tr>
	      <td>${values.id}</td>
	      <td>${values.name}</td>
	      <td>${values.quantity}</td>
	      <td>${values.price}</td> 
	    </tr>`;
	});
	
	document.getElementById("table_body").innerHTML = tableData;
	
})

 
     
   