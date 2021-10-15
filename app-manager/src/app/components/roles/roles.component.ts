import { Component, OnInit } from '@angular/core';
import { RolesService } from 'src/app/services/roles.service';
import { Rol } from 'src/app/interfaces/manager';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css'],
})
export class RolesComponent implements OnInit {
  roles: Rol[];
  header = ['Id', 'Rol', 'Acciones'];
  display: boolean = false;

  rolForm: Rol = {
    id: 0,
    rol: '',
  };

  constructor(private rolService: RolesService) {}

  ngOnInit(): void {
    this.getAllRoles();
  }

  getAllRoles() {
    this.rolService.getRoles().subscribe(
      (resp) => {
        if (resp.code === 200) {
          // console.log(resp.response);
          this.roles = resp.response;
        }
      },
      (err) => console.log(err)
    );
  }

  popup(rol: Rol) {
    this.rolForm = rol;
    this.showDialog();
  }

  updateRol() {
    let { id, rol } = this.rolForm;
    this.rolService.putRol(id, rol).subscribe(
      (resp) => {
        if (resp.code === 200) {
          // console.log(resp.response);
        }
      },
      (err) => console.log(err)
    );
    this.display = false;
  }

  deleteRol(id: number) {
    this.rolService.deleteRol(id).subscribe(
      (resp) => {
        if (resp.code === 200) {
          // console.log(resp.response);
        }
      },
      (err) => console.log(err)
    );
  }

  showDialog() {
    this.display = true;
  }
}
