$(document).ready(function() {
  // on ready

});

async function registrarUsuario() {
    let datos = {};
    datos.username = document.getElementById('StringUsername').value;
    datos.telephone = document.getElementById('StringTelephone').value;
    datos.email = document.getElementById('StringEmail').value;
    datos.password = document.getElementById('StringPassword').value;

    let verifyPassword = document.getElementById('VerifyPassword').value;

    if (datos.password != verifyPassword) {
        alert('Las contraseñas no coinciden');
        return;
    }

     const request = await fetch('api/usuario/crear', {
             method: 'POST',
             headers: {
               'Accept': 'application/json',
               'Content-Type': 'application/json'
             },
             body: JSON.stringify(datos)
           });
}