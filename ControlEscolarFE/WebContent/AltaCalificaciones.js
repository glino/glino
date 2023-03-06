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

async function getMaterias() {
    let url = 'http://localhost:8091/materias';
    try {
        let res = await fetch(url);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

async function renderMaterias() {
    let jsonMaterias = await getMaterias();
    var domMaterias= document.getElementById('inputMateria');

    jsonMaterias.forEach(materia => {
       	
       	var option = document.createElement("option");
       	option.text = materia.nombre;
       	option.value =materia.id_materia;
       	domMaterias.add(option);
        
    });

}

function funcionesFormulario() {
    var form= document.getElementById('form');

	form.addEventListener ('submit', event =>{ 
        event.preventDefault();
		let datos = {
			id_alumno: document.querySelector('#inputAlumno').value,
			id_materia: document.querySelector('#inputMateria').value,
			calificacion: document.querySelector('#inputCalificacion').value			
		}
		fetch ('http://localhost:8091/calificacion',{ 
			method:'POST',    
			headers: {
			    "Content-Type": "application/json",
			},
			body: JSON.stringify(datos)})
			.then(res=> res.json())
			.then(data => console.log(data))
			.catch(error=> console.log(error));
		});

}




async function cargarFormulario(){
	
	
	await renderAlumnos();
	await renderMaterias();
	funcionesFormulario();

}

cargarFormulario();
