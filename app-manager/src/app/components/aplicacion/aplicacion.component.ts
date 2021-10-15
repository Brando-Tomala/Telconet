import { Component, OnInit } from '@angular/core';
import { Aplicacion, Rol } from 'src/app/interfaces/manager';
import { AplicacionService } from 'src/app/services/aplicacion.service';
import { RolesService } from 'src/app/services/roles.service';

@Component({
  selector: 'app-aplicacion',
  templateUrl: './aplicacion.component.html',
  styleUrls: ['./aplicacion.component.css'],
})
export class AplicacionComponent implements OnInit {
  apps: Aplicacion[];
  header = ['Id', 'Aplicacion', 'Roles', 'Acciones'];
  display: boolean = false;

  appForm: Aplicacion = {
    id: 0,
    aplicacion: '',
    roles: [],
  };
  rols: Rol[];
  rolInput: Rol[];

  constructor(
    private appService: AplicacionService,
    private rolService: RolesService
  ) {}

  ngOnInit(): void {
    this.getAllRoles();
    this.getRoles();
  }

  getRoles() {
    this.rolService.getRoles().subscribe((resp) => {
      if (resp.code === 200) {
        this.rols = resp.response;
      }
    });
  }

  getAllRoles() {
    this.appService.getApp().subscribe((resp) => {
      if (resp.code === 200) {
        console.log(resp.response);
        this.apps = resp.response;
      }
    });
  }

  popup(app: Aplicacion) {
    this.appForm = app;
    this.showDialog();
  }

  updateApp() {
    this.appForm.roles = this.rolInput;
    const { id, aplicacion, roles } = this.appForm;

    this.appService.putApp(id, aplicacion)
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
    this.appService.deleteApp(id).subscribe(
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
