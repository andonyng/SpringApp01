$(document).ready(function() {
  // on ready

});

async function iniciarSesion() {
    let datos = {};
    datos.email = document.getElementById('StringEmail').value;
    datos.password = document.getElementById('StringPassword').value;

     const request = await fetch('api/login', {
             method: 'POST',
             headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
             },
             body: JSON.stringify(datos)
           });
     const response = await request.text();

     if (response == 'true') {
        window.location.href = 'usuarios.html';
     } else {
        alert('Las credenciales son incorrectas.');
     }
}