import { Component, OnInit } from '@angular/core';
import { Rol, Usuario, UsuarioEdit } from 'src/app/interfaces/manager';
import { RolesService } from 'src/app/services/roles.service';

import { UsuariosService } from 'src/app/services/usuarios.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css'],
})
export class UsuariosComponent implements OnInit {
  usuarioForm: Usuario = {
    nombre: '',
    apellido: '',
    celular: '',
    correo: '',
    direccionDomicilio: '',
    fechaNacimiento: '',
    nombreUsuario: '',
    id: 0,
    roles: [],
  };
  usuarios: Usuario[];
  rols: Rol[];
  rolInput: Rol[];

  header = [
    'Nombre',
    'Apellido',
    'Correo',
    'Celular',
    'Direccion',
    'Fecha Nacimiento',
    'Rol',
    'Acciones',
  ];

  display: boolean = false;

  constructor(
    private usuarioServices: UsuariosService,
    private rolService: RolesService
  ) {}

  ngOnInit(): void {
    this.getAllUsuarios();
    this.getRoles();
  }

  getRoles() {
    this.rolService.getRoles().subscribe((resp) => {
      if (resp.code === 200) {
        this.rols = resp.response;
      }
    });
  }

  getAllUsuarios() {
    this.usuarioServices.getAllUsuarios().subscribe(
      (resp) => {
        if (resp.code === 200) {
          this.usuarios = resp.response;
        }
      },
      (err) => console.log(err)
    );
  }

  popup(usuario: Usuario) {
    this.rolInput = [];
    this.usuarioForm = usuario;
    this.showDialog();
  }

  updateUser() {
    this.usuarioForm.roles = this.rolInput;
    const { id, nombre, apellido, celular, direccionDomicilio, roles } =
      this.usuarioForm;

    this.usuarioServices
      .putActualizarUsuario(id, {
        nombre,
        apellido,
        celular,
        direccionDomicilio,
        roles,
      })
      .subscribe(
        (res) => {
          if (res.code === 200) {
          }
        },
        (err) => console.log(err)
      );
    this.display = false;
  }

  deleteUser(id: number) {
    this.usuarioServices.deleteEliminarUsuario(id).subscribe(
      (res) => {
        if (res.code === 200) {
        }
      },
      (err) => console.error(err)
    );
  }

  showDialog() {
    this.display = true;
  }
}
