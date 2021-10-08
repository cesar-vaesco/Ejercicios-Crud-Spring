// Call the dataTables jQuery plugin
$(document).ready(function () {
    cargarUsuarios();
    $('#usuarios').DataTable();
});

async function cargarUsuarios() {

    const request = await fetch('usuarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });
    const usuarios = await request.json();

    console.log(usuarios);

    let usuario = '<tr><td>150</td><td>César Vargas</td><td>correo@correo.com</td><td>5568000916</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr >';

    document.querySelector('#usuarios tbody').outerHTML = usuario;
}
