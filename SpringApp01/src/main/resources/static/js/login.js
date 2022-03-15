$(document).ready(function() {
  // on ready

});

async function iniciarSesion() {
    let datos = {}; //La variable que contendrá el email y la contraseña introducidos
    datos.email = document.getElementById('StringEmail').value;
    datos.password = document.getElementById('StringPassword').value;

    //Convertimos a JSON la variable datos y la mandamos en el body de la petición en la línea 18
    const request = await fetch('api/login', {
             method: 'POST',
             headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
             },
             body: JSON.stringify(datos)
           });
     const response = await request.text(); //La respuesta que recibimos tras hacer la petición al servidor

     if (response != 'null') { //Comprobamos que la respuesta no sea "null" al autenticar el usuario
        localStorage.token = response; //Almacenamos el token JWT en el navegador
        localStorage.email = datos.email; //Almacenamos el email del usuario en el navegador
        window.location.href = 'usuarios.html'; //Redireccionamos a la página "usuarios.html"
     } else {
        alert('Las credenciales son incorrectas.');
     }
}