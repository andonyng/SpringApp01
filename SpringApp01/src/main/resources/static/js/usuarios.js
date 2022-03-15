// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

//Función que se encarga de realizar las peticiones necesarias e inyectar el html para mostrar el listado de usuarios
async function cargarUsuarios() {
      const request = await fetch('api/usuario/listado', {
        method: 'GET',
        headers: getHeaders() //Los headers los obtenemos de la función getHeaders()
      });
      const usuarios = await request.json(); //La variable usuarios recibe la respuesta de la petición en formato JSON
      //y la almacena

      let listadoHtml = ''; //Definimos la variable listadoHtml (El html a inyectar con el listado de usuarios)
      for (let usuario of usuarios) {

        //Para cada boton de eliminar, el html contendrá la llamada a la función eliminarUsuario() con el id del usuario correspondiente
        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        //Para cada usuario, comprobaremos si el teléfono está vacío o lo ha proporcionado y lo trataremos
        //de la manera que querramos para que en la tabla no aparezca null
        let telefono = usuario.telephone;

        if (telefono == null) {
            telefono = '';
        }

        //El html para cada usuario
        let usuarioHtml = '<tr><td>'+usuario.username
        +'</td><td>'+telefono
        +'</td><td>'+usuario.email
        +'</td><td>'+usuario.id
        +'</td><td>'+botonEliminar
        +'</td></tr>';

        //Vamos añadiendo cada HTML de cada usuario a la variable listado, que contendrá el HTML de todos los usuarios
        listadoHtml += usuarioHtml;

      }

      //Sacamos en consola los datos recibidos en la petición
      console.log(usuarios);
      //Inyectamos el HTML con los Usuarios (listadoHtml) en este caso, en la tabla con el id #usuarios dentro de la
      //etiqueta "tbody"
      document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

//Función para eliminar el usuario correspondiente recibiendo su ID
async function eliminarUsuario(id) {
    //Muestra mensaje de confirmación
    if (!confirm('¿Eliminar el usuario ' + id + '?')) {
        return;
    }
    //Realiza la petición al servidor, llamando a la API mandando el ID en la URL
    const request = await fetch('api/usuario/' + id, {
        method: 'POST',
        headers: getHeaders()
      });
      //Recargamos el documento para ver los cambios
    location.reload();
}

//La función que devuelve los headers necesarios para la petición
function getHeaders() {
    return {
                     'Accept': 'application/json',
                     'Content-Type': 'application/json',
                     'Authorization': localStorage.token
                   };
}