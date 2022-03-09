// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios() {
      const request = await fetch('api/listado', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      const usuarios = await request.json();

      let listadoHtml = '';
      for (let usuario of usuarios) {

        let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

        let usuarioHtml = '<tr><td>'+usuario.username
        +'</td><td>'+usuario.telephone
        +'</td><td>'+usuario.email
        +'</td><td>'+usuario.id
        +'</td><td>'+botonEliminar
        +'</td></tr>';

        listadoHtml += usuarioHtml;

      }

      console.log(usuarios);
      document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

async function eliminarUsuario(id) {
    const request = await fetch('api/usuario/' + id, {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });
      alert(id);
}