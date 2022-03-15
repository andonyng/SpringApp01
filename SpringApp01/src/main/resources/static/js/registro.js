$(document).ready(function() {
  // on ready

});

async function registrarUsuario() {
    let datos = {}; //Definimos la variable datos, que contendrá los datos que introduzca el usuario en el formulario

    //Obtenemos los valores del formulario mediante el ID de los campos y los introducimos en atributos del objeto datos
    datos.username = document.getElementById('StringUsername').value;
    datos.telephone = document.getElementById('StringTelephone').value;
    datos.email = document.getElementById('StringEmail').value;
    datos.password = document.getElementById('StringPassword').value;

    //Esta variable servirá para comprobar si el usuario ha introducido la contraseña 2 veces correctamente
    let verifyPassword = document.getElementById('VerifyPassword').value;

    //Hace la comprobación de la contraseña, en caso de ser incorrecta muestra mensaje indicandolo y detiene la función
    if (datos.password != verifyPassword) {
        alert('Las contraseñas no coinciden');
        return;
    }

    //Realizamos la petición al servidor
    const request = await fetch('api/usuario/crear', {
             method: 'POST',
             headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
             },
             body: JSON.stringify(datos) //Convertimos la variable datos a JSON y se lo mandamos en el body de la petición
           });
    //Informamos de que la cuenta ha sido creada exitosamente si la petición es satisfactoria
    alert('La cuenta ha sido creada existosamente.');
    //Redireccionamos a la pestaña login
    window.location.href = 'login.html';
}