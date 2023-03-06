async function getAlumnos() {
    let url = 'http://localhost:8091/alumnos';
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

async function renderAlumnos() {
    let jsonAlumnos = await getAlumnos();
    var domAlumnos= document.getElementById('inputAlumno');

    jsonAlumnos.forEach(alumno => {
       	
       	var option = document.createElement("option");
       	option.text = alumno.nombre+" "+alumno.apellido_paterno;
       	option.value =alumno.id_alumno;
       	domAlumnos.add(option);
        
    });

}


function funcionesFormulario() {
   	var btnConsulta = document.getElementById('btn-buscar');   
    btnConsulta.addEventListener ('click', consulta);
    
   	var btnEliminar = document.getElementById('btn-eliminar');
   	btnEliminar.addEventListener("click", eliminarCalificacion);
   	
   	var btnModificar = document.getElementById('btn-modificar');
   	btnModificar.addEventListener("click", modificarCalificacion);
}



function consulta(){ 
	event.preventDefault();
    var idAlumno= document.querySelector('#inputAlumno').value;		
   
    renderCalificaciones( idAlumno);
    
}

async function getCalificaciones(idAlumno) {
    let url = 'http://localhost:8091'+ '/calificaciones/alumno/'+idAlumno;
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

async function renderCalificaciones( idAlumno) {
    let jsonCalificaciones = await getCalificaciones(idAlumno);
    
    var domPromedio = document.getElementById ('inputPromedio');
    if (jsonCalificaciones.promedio){
    	domPromedio.placeholder = jsonCalificaciones.promedio;
    }
    var domBodyCalificaciones= document.getElementById('contenidoTablaCalificaciones');
    if (domBodyCalificaciones){
    	domBodyCalificaciones.remove();
    }
    var domTablaCalificaciones = document.getElementById('tablaCalificaciones');
    domBodyCalificaciones = document.createElement('tbody');
    domBodyCalificaciones.id = "contenidoTablaCalificaciones";
    domTablaCalificaciones.appendChild(domBodyCalificaciones);
    
    

    jsonCalificaciones.calificaciones.forEach(calificacion => {
       	
    	var tr = document.createElement ("tr");
    	domBodyCalificaciones.appendChild (tr);

      	var tdRadio = document.createElement("td");
       	tr.appendChild (tdRadio);
       	var radio = document.createElement("input");
       	radio.type = "radio";
       	radio.name = "radioCalificacion";
       	radio.value = calificacion.id_calificacion;
       	tdRadio.appendChild(radio);
       	
       	
    	var tdAlumnoId = document.createElement("td");
       	tdAlumnoId.textContent = calificacion.id_alumno;
       	tdAlumnoId.id = "inputAlumno"+calificacion.id_calificacion;
       	tr.appendChild (tdAlumnoId);

    	var tdAlumno = document.createElement("td");
       	tdAlumno.textContent = calificacion.nombre+" "+calificacion.apellido_Paterno;
       	tdAlumno.id = "inputAlumno";
       	tr.appendChild (tdAlumno);
       	

    	var tdMateriaId = document.createElement("td");
       	tdMateriaId.textContent = calificacion.id_materia;
       	tdMateriaId.id = "inputMateria"+calificacion.id_calificacion;
       	tr.appendChild (tdMateriaId);
       	
    	var tdMateria = document.createElement("td");
       	tdMateria.textContent = calificacion.materia;
       	tdMateria.id = "inputMateria";
       	tdMateria.value = calificacion.id_materia;
       	tr.appendChild (tdMateria);
       	
      	var tdCalificacion = document.createElement("td");

      	var intputCalificacion = document.createElement("input");
      	intputCalificacion.type = "text";
      	intputCalificacion.id = "inputCalificacion"+calificacion.id_calificacion;
      	intputCalificacion.value = calificacion.calificacion;
       	tdCalificacion.appendChild(intputCalificacion);
        tr.appendChild (tdCalificacion);
       	

       	        
    });

}



async function cargarFormulario(){
	
	await renderAlumnos();
	funcionesFormulario();

}

async function eliminarCalificacion() {
    var getSelectedValue = document.querySelector('input[name="radioCalificacion"]:checked');  
    if(getSelectedValue != null) {   
   	
    	fetch ('http://localhost:8091/calificacion/'+getSelectedValue.value,{ 
    		method:'DELETE',    
    		headers: {
    		    "Content-Type": "application/json"
    		    }
    		})
    		.then(res=> res.json())
    		.then(data => console.log(data))
    		.catch(error=> console.log(error));
    }   
    else {   
        document.getElementById("error").innerHTML   
            = "No se selecciono ninguna calificación";   
    }  
	
}

async function modificarCalificacion() {
    var getSelectedValue = document.querySelector('input[name="radioCalificacion"]:checked');  
    if(getSelectedValue != null) {   
    	var querySelectorCalificacion = "inputCalificacion"+getSelectedValue.value;
    	var querySelectorAlumno = "inputMateria"+getSelectedValue.value;
    	var querySelectorMateria = "inputCalificacion"+getSelectedValue.value;
    	
    	var domAlumn=document.getElementById("inputAlumno"+getSelectedValue.value);
		var domMateria= document.getElementById("inputMateria"+getSelectedValue.value);
	    var domCalificacion= document.getElementById("inputCalificacion"+getSelectedValue.value);	
    	let datos = {
    			id_calificacion : getSelectedValue.value,
    			
    			id_alumno: document.getElementById("inputAlumno"+getSelectedValue.value).textContent,	
    			id_materia: document.getElementById("inputMateria"+getSelectedValue.value).textContent,	
    			calificacion: document.getElementById("inputCalificacion"+getSelectedValue.value).value			
    		}
    		fetch ('http://localhost:8091/calificacion',{ 
    			method:'PUT',    
    			headers: {
    			    "Content-Type": "application/json",
    			},
    			body: JSON.stringify(datos)})
    			.then(res=> res.json())
    			.then(data => console.log(data))
    			.catch(error=> console.log(error));
    }   
    else {   
        document.getElementById("error").innerHTML   
            = "No se selecciono ninguna calificación";   
    }  
	
}

cargarFormulario();
